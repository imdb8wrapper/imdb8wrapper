package io.github.imdb8wrapper.api.model.request;

import io.github.imdb8wrapper.api.model.ReviewsPage;

import java.util.List;


/**
 * GetUserReviewsRequest is used to get the user reviews of a movie.
 * <p>
 * The request that is executed corresponds to /title/get-user-reviews
 */
public interface GetUserReviewsRequest {
  /**
   * getFirstReviewsPage returns the first reviews page.
   *
   * @param ttConst the tt const id of the movie
   * @return the first reviews page
   */
  ReviewsPage getFirstReviewsPage(String ttConst);

  /**
   * getReviewsPage retrieves a reviews page given a paginationKey.
   *
   * @param ttConst       the tt const id of the movie
   * @param paginationKey the pagination key of the reviews page
   * @return the reviews page corresponding to the paginationKey
   */
  ReviewsPage getReviewsPage(String ttConst, String paginationKey);

  /**
   * getAllReviewsPages iterates over all the reviews pages and collects them in a list.
   *
   * @param ttConst the tt const id of the movie
   * @return a list containing all the reviews pages
   */
  List<ReviewsPage> getAllReviewsPages(String ttConst);
}
