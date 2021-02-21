package com.imdb8.wrapper.internal.request;

import com.imdb8.wrapper.api.model.OverviewDetails;
import com.imdb8.wrapper.api.model.request.GetOverviewDetailsRequest;
import com.imdb8.wrapper.internal.client.ImdbApiClient;
import com.imdb8.wrapper.internal.client.ImdbApiRequestData;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.imdb8.wrapper.internal.ApiConstants.GET_OVERVIEW_DETAILS;
import static com.imdb8.wrapper.internal.ApiConstants.TT_CONST_PARAM_NAME;

@Slf4j
public class GetOverviewDetailsRequestImpl extends AbstractRequest implements GetOverviewDetailsRequest {
  public GetOverviewDetailsRequestImpl(ImdbApiClient imdbApiClient) {
    super(imdbApiClient);
  }

  public OverviewDetails execute(String ttConst) {
    ImdbApiRequestData imdbApiRequestData = ImdbApiRequestData.builder()
        .path(GET_OVERVIEW_DETAILS)
        .addQueryParameter(TT_CONST_PARAM_NAME, ttConst)
        .build();

    try {
      String response = imdbApiClient.get(imdbApiRequestData);
      return objectMapper.readValue(response, OverviewDetails.class);
    } catch (URISyntaxException | IOException e) {
      if (log.isErrorEnabled()) {
        log.error("Exception while executing get overview details with ttConst {}.", ttConst, e);
      }

      return null;
    }
  }
}
