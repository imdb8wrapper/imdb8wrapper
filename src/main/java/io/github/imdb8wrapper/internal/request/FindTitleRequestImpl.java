package io.github.imdb8wrapper.internal.request;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.imdb8wrapper.api.model.Title;
import io.github.imdb8wrapper.api.request.FindTitleRequest;
import io.github.imdb8wrapper.internal.client.ImdbApiClient;
import io.github.imdb8wrapper.internal.client.ImdbApiRequestData;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import static io.github.imdb8wrapper.internal.ApiConstants.FIND_TITLE;
import static io.github.imdb8wrapper.internal.ApiConstants.QUERY_PARAM_NAME;

@Slf4j
public class FindTitleRequestImpl extends AbstractRequest implements FindTitleRequest {
  private static final String RESULTS = "results";
  private static final String TITLE_PREFIX = "/title/";

  public FindTitleRequestImpl(ImdbApiClient imdbApiClient) {
    super(imdbApiClient);
  }

  public List<Title> execute(String query) {
    ImdbApiRequestData imdbApiRequestData = ImdbApiRequestData.builder()
        .path(FIND_TITLE)
        .addQueryParameter(QUERY_PARAM_NAME, query)
        .build();

    try {
      return getMovieTitles(imdbApiRequestData);
    } catch (URISyntaxException | IOException e) {
      log.error("Exception while executing find with query {}.", query, e);
      return null;
    }
  }

  private List<Title> getMovieTitles(ImdbApiRequestData imdbApiRequestData) throws IOException, URISyntaxException {
    String response = imdbApiClient.get(imdbApiRequestData);

    JsonNode resultsNode = objectMapper.readTree(response).path(RESULTS);
    List<Title> titles = objectMapper.readerFor(new TypeReference<List<Title>>() {
    }).readValue(resultsNode);

    return titles.stream()
        .filter(title -> title.getId().startsWith(TITLE_PREFIX))
        .peek(title -> {
          String ttConst = title.getId();
          ttConst = ttConst.replace(TITLE_PREFIX, "");
          ttConst = ttConst.substring(0, ttConst.length() - 1);
          title.setTtConst(ttConst);
        })
        .collect(Collectors.toList());
  }
}
