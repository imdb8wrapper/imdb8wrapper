package com.imdb8.wrapper.api.model.request;

import com.imdb8.wrapper.api.model.ReviewsPage;

import java.util.List;

public interface GetUserReviewsRequest {
  ReviewsPage getFirstReviewsPage(String ttConst);

  ReviewsPage getReviewsPage(String ttConst, String paginationKey);

  List<ReviewsPage> getAllReviews(String ttConst);
}
