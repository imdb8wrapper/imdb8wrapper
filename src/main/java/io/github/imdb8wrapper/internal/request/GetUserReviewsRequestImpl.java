package io.github.imdb8wrapper.internal.request;

import io.github.imdb8wrapper.api.request.GetUserReviewsRequest;
import io.github.imdb8wrapper.api.model.ReviewsPage;
import io.github.imdb8wrapper.internal.client.ImdbApiClient;
import io.github.imdb8wrapper.internal.client.ImdbApiRequestData;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static io.github.imdb8wrapper.internal.ApiConstants.GET_USER_REVIEWS;
import static io.github.imdb8wrapper.internal.ApiConstants.PAGINATION_KEY_PARAM_NAME;
import static io.github.imdb8wrapper.internal.ApiConstants.TT_CONST_PARAM_NAME;

@Slf4j
public class GetUserReviewsRequestImpl extends AbstractRequest implements GetUserReviewsRequest {
  public GetUserReviewsRequestImpl(ImdbApiClient imdbApiClient) {
    super(imdbApiClient);
  }

  @Override
  public ReviewsPage getFirstReviewsPage(String ttConst) {
    ImdbApiRequestData imdbApiRequestData = ImdbApiRequestData.builder()
        .path(GET_USER_REVIEWS)
        .addQueryParameter(TT_CONST_PARAM_NAME, ttConst)
        .build();

    try {
      return getReviewsPage(imdbApiRequestData);
    } catch (IOException | URISyntaxException e) {
      if (log.isErrorEnabled()) {
        log.error("Exception while executing get user reviews with ttConst {}.", ttConst, e);
      }

      return null;
    }
  }

  @Override
  public ReviewsPage getReviewsPage(String ttConst, String paginationKey) {
    ImdbApiRequestData imdbApiRequestData = ImdbApiRequestData.builder()
        .path(GET_USER_REVIEWS)
        .addQueryParameter(TT_CONST_PARAM_NAME, ttConst)
        .addQueryParameter(PAGINATION_KEY_PARAM_NAME, paginationKey)
        .build();
    try {
      return getReviewsPage(imdbApiRequestData);
    } catch (IOException | URISyntaxException e) {
      if (log.isErrorEnabled()) {
        log.error("Exception while executing get user reviews with ttConst {} and paginationKey {}.", ttConst, paginationKey, e);
      }

      return null;
    }
  }

  @Override
  public List<ReviewsPage> getAllReviewsPages(String ttConst) {
    ReviewsPage reviewsPage = getFirstReviewsPage(ttConst);

    List<ReviewsPage> reviews = new ArrayList<>();
    reviews.add(reviewsPage);

    while (reviewsPage.getPaginationKey() != null) {
      reviewsPage = getReviewsPage(ttConst, reviewsPage.getPaginationKey());
      reviews.add(reviewsPage);
    }

    return reviews;
  }

  private ReviewsPage getReviewsPage(ImdbApiRequestData imdbApiRequestData) throws IOException, URISyntaxException {
    String response = imdbApiClient.get(imdbApiRequestData);
    return objectMapper.readValue(response, ReviewsPage.class);
  }
}
