package com.imdb8.wrapper.api;

import com.imdb8.wrapper.api.model.request.FindTitleRequest;
import com.imdb8.wrapper.api.model.request.GetOverviewDetailsRequest;
import com.imdb8.wrapper.api.model.request.GetUserReviewsRequest;
import com.imdb8.wrapper.internal.client.ImdbApiClient;
import com.imdb8.wrapper.internal.request.FindTitleRequestImpl;
import com.imdb8.wrapper.internal.request.GetOverviewDetailsRequestImpl;
import com.imdb8.wrapper.internal.request.GetUserReviewsRequestImpl;

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
