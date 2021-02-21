package io.github.imdb8wrapper.api.model.request;

import io.github.imdb8wrapper.api.model.Title;

import java.util.List;

/**
 * FindTitleRequest is used to search for a movie title.
 * <p>
 * The request that is executed corresponds to /title/find
 */
public interface FindTitleRequest {
  /**
   * execute performs the find title request and retrieves the found movie titles.
   *
   * @param query the search query
   * @return a list of movie titles found with the search query
   */
  List<Title> execute(String query);
}
