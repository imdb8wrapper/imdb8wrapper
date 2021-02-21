package io.github.imdb8wrapper.api;

import io.github.imdb8wrapper.api.model.request.GetUserReviewsRequest;
import io.github.imdb8wrapper.internal.client.ImdbApiClient;
import io.github.imdb8wrapper.internal.request.FindTitleRequestImpl;
import io.github.imdb8wrapper.internal.request.GetUserReviewsRequestImpl;
import io.github.imdb8wrapper.api.model.request.FindTitleRequest;
import io.github.imdb8wrapper.api.model.request.GetOverviewDetailsRequest;
import io.github.imdb8wrapper.internal.request.GetOverviewDetailsRequestImpl;

public class ImdbApi {
  private final ImdbApiClient imdbApiClient;

  public ImdbApi(String apiKey) {
    this.imdbApiClient = new ImdbApiClient(apiKey);
  }

  public FindTitleRequest newFindTitleRequest() {
    return new FindTitleRequestImpl(imdbApiClient);
  }

  public GetOverviewDetailsRequest newGetOverviewDetailsRequest() {
    return new GetOverviewDetailsRequestImpl(imdbApiClient);
  }

  public GetUserReviewsRequest newGetUserReviewsRequest() {
    return new GetUserReviewsRequestImpl(imdbApiClient);
  }
}
