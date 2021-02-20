package com.imdb8.wrapper.internal.request;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imdb8.wrapper.api.model.Title;
import com.imdb8.wrapper.api.model.request.FindTitleRequest;
import com.imdb8.wrapper.internal.client.ImdbApiClient;
import com.imdb8.wrapper.internal.client.ImdbApiRequestData;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class FindTitleRequestImpl implements FindTitleRequest {
  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
  private static final String RESULTS = "results";
  private static final String TITLE_PREFIX = "/title/";

  private static final String FIND_TITLE_ENDPOINT = "/title/find";
  private static final String QUERY_PARAM_NAME = "q";

  private final ImdbApiClient imdbApiClient;

  public FindTitleRequestImpl(ImdbApiClient imdbApiClient) {
    this.imdbApiClient = imdbApiClient;
  }

  public List<Title> execute(String query) {
    ImdbApiRequestData imdbApiRequestData = ImdbApiRequestData.builder()
        .path(FIND_TITLE_ENDPOINT)
        .addQueryParameter(QUERY_PARAM_NAME, query)
        .build();

    try {
      String response = imdbApiClient.get(imdbApiRequestData);

      JsonNode resultsNode = OBJECT_MAPPER.readTree(response).path(RESULTS);
      List<Title> titles = OBJECT_MAPPER.readerFor(new TypeReference<List<Title>>() {
      }).readValue(resultsNode);

      titles = titles.stream()
          .filter(title -> title.getId().startsWith(TITLE_PREFIX))
          .collect(Collectors.toList());

      for (Title title : titles) {
        String id = title.getId();
        id = id.replace(TITLE_PREFIX, "");
        id = id.substring(0, id.length() - 1);
        title.setId(id);
      }

      return titles;
    } catch (URISyntaxException | IOException e) {
      if (log.isErrorEnabled()) {
        log.error("Exception while executing find with query {}.", query, e);
      }

      return null;
    }
  }
}
