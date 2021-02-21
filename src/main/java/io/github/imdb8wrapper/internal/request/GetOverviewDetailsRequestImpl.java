package io.github.imdb8wrapper.internal.request;

import io.github.imdb8wrapper.api.model.OverviewDetails;
import io.github.imdb8wrapper.api.request.GetOverviewDetailsRequest;
import io.github.imdb8wrapper.internal.ApiConstants;
import io.github.imdb8wrapper.internal.client.ImdbApiClient;
import io.github.imdb8wrapper.internal.client.ImdbApiRequestData;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URISyntaxException;

@Slf4j
public class GetOverviewDetailsRequestImpl extends AbstractRequest implements GetOverviewDetailsRequest {
  public GetOverviewDetailsRequestImpl(ImdbApiClient imdbApiClient) {
    super(imdbApiClient);
  }

  public OverviewDetails execute(String ttConst) {
    ImdbApiRequestData imdbApiRequestData = ImdbApiRequestData.builder()
        .path(ApiConstants.GET_OVERVIEW_DETAILS)
        .addQueryParameter(ApiConstants.TT_CONST_PARAM_NAME, ttConst)
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
