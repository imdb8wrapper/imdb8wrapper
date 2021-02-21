package io.github.imdb8wrapper.api;

import io.github.imdb8wrapper.api.model.request.GetUserReviewsRequest;
import io.github.imdb8wrapper.internal.client.ImdbApiClient;
import io.github.imdb8wrapper.internal.request.FindTitleRequestImpl;
import io.github.imdb8wrapper.internal.request.GetUserReviewsRequestImpl;
import io.github.imdb8wrapper.api.model.request.FindTitleRequest;
import io.github.imdb8wrapper.api.model.request.GetOverviewDetailsRequest;
import io.github.imdb8wrapper.internal.request.GetOverviewDetailsRequestImpl;

/**
 * ImdbApi is the entry point for the IMDB8 API Wrapper implementation.
 * <p>
 * It is responsible for handling the API Key and provides methods for creating new API requests.
 */
public class ImdbApi {
  private final ImdbApiClient imdbApiClient;

  public ImdbApi(String apiKey) {
    this.imdbApiClient = new ImdbApiClient(apiKey);
  }

  /**
   * Creates a new API request corresponding to /title/find.
   *
   * @return a new Find Title request
   */
  public FindTitleRequest newFindTitleRequest() {
    return new FindTitleRequestImpl(imdbApiClient);
  }

  /**
   * Creates a new API request corresponding to /title/get-overview-details.
   *
   * @return a new Get Overview Details request
   */
  public GetOverviewDetailsRequest newGetOverviewDetailsRequest() {
    return new GetOverviewDetailsRequestImpl(imdbApiClient);
  }

  /**
   * Creates a new API request corresponding to /title/get-user-reviews.
   *
   * @return a new Get Overview User Reviews request
   */
  public GetUserReviewsRequest newGetUserReviewsRequest() {
    return new GetUserReviewsRequestImpl(imdbApiClient);
  }
}
