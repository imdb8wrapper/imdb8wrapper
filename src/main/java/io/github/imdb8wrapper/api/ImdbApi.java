package io.github.imdb8wrapper.api;

import io.github.imdb8wrapper.api.model.OverviewDetails;
import io.github.imdb8wrapper.api.model.ReviewsPage;
import io.github.imdb8wrapper.api.model.Title;
import io.github.imdb8wrapper.api.request.GetUserReviewsRequest;
import io.github.imdb8wrapper.internal.client.ImdbApiClient;
import io.github.imdb8wrapper.internal.request.FindTitleRequestImpl;
import io.github.imdb8wrapper.internal.request.GetUserReviewsRequestImpl;
import io.github.imdb8wrapper.api.request.FindTitleRequest;
import io.github.imdb8wrapper.api.request.GetOverviewDetailsRequest;
import io.github.imdb8wrapper.internal.request.GetOverviewDetailsRequestImpl;

import java.util.List;

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

  /**
   * Searches for a movie.
   *
   * @param query the string query to search for
   * @return a list of found titles
   */
  public List<Title> findTitle(String query) {
    return new FindTitleRequestImpl(imdbApiClient).execute(query);
  }

  /**
   * Retrieves the overview details of a movie.
   *
   * @param ttConst the tt const id of the movie
   * @return the overview details of the movie
   */
  public OverviewDetails getOverviewDetails(String ttConst) {
    return new GetOverviewDetailsRequestImpl(imdbApiClient).execute(ttConst);
  }

  /**
   * Retrieves the first page of user reviews for a movie.
   *
   * @param ttConst the tt const id of the movie
   * @return the first page of user reviews
   */
  public ReviewsPage getFirstUserReviewsPage(String ttConst) {
    return new GetUserReviewsRequestImpl(imdbApiClient).getFirstReviewsPage(ttConst);
  }

  /**
   * Retrieves a specific page of user reviews for a movie.
   *
   * @param ttConst       the tt const id of the movie
   * @param paginationKey the paginationKey of the requested page
   * @return the requested page of user reviews
   */
  public ReviewsPage getUserReviewsPage(String ttConst, String paginationKey) {
    return new GetUserReviewsRequestImpl(imdbApiClient).getReviewsPage(ttConst, paginationKey);
  }

  /**
   * Retrieves all the pages of user reviews for a movie.
   *
   * @param ttConst the tt const id of the movie
   * @return a list of all pages of user reviews
   */
  public List<ReviewsPage> getAllUserReviews(String ttConst) {
    return new GetUserReviewsRequestImpl(imdbApiClient).getAllReviewsPages(ttConst);
  }
}
