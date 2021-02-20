package com.imdb8.wrapper.internal.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imdb8.wrapper.api.model.request.GetOverviewDetailsRequest;
import com.imdb8.wrapper.internal.client.ImdbApiClient;
import com.imdb8.wrapper.internal.client.ImdbApiRequestData;
import com.imdb8.wrapper.api.model.OverviewDetails;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URISyntaxException;

@Slf4j
public class GetOverviewDetailsRequestImpl implements GetOverviewDetailsRequest {
  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  private static final String GET_OVERVIEW_DETAILS_ENDPOINT = "/title/get-overview-details";
  private static final String TCONST_PARAM_NAME = "tconst";

  private final ImdbApiClient imdbApiClient;

  public GetOverviewDetailsRequestImpl(ImdbApiClient imdbApiClient) {
    this.imdbApiClient = imdbApiClient;
  }

  public OverviewDetails execute(String tconst) {
    ImdbApiRequestData imdbApiRequestData = ImdbApiRequestData.builder()
        .path(GET_OVERVIEW_DETAILS_ENDPOINT)
        .addQueryParameter(TCONST_PARAM_NAME, tconst)
        .build();

    try {
      String response = imdbApiClient.get(imdbApiRequestData);
      return OBJECT_MAPPER.readValue(response, OverviewDetails.class);
    } catch (URISyntaxException | IOException e) {
      if (log.isErrorEnabled()) {
        log.error("Exception while executing get overview details with tconst {}.", tconst, e);
      }

      return null;
    }
  }
}
