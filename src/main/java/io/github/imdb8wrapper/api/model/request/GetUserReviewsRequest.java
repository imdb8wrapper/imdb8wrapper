package io.github.imdb8wrapper.api.model.request;

import io.github.imdb8wrapper.api.model.ReviewsPage;

import java.util.List;

public interface GetUserReviewsRequest {
  ReviewsPage getFirstReviewsPage(String ttConst);

  ReviewsPage getReviewsPage(String ttConst, String paginationKey);

  List<ReviewsPage> getAllReviewsPages(String ttConst);
}
