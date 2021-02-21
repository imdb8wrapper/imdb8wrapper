package io.github.imdb8wrapper.api.request;

import io.github.imdb8wrapper.api.model.OverviewDetails;

/**
 * GetOverviewDetailsRequest is used to get the overview details of a movie.
 * <p>
 * The request that is executed corresponds to /title/get-overview-details
 */
public interface GetOverviewDetailsRequest {
  /**
   * execute performs the get overview details request and retrieves the information.
   *
   * @param ttConst the tt const id of the movie
   * @return an OverviewDetails object containing the information
   */
  OverviewDetails execute(String ttConst);
}
