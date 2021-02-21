package io.github.imdb8wrapper.api.model.request;

import io.github.imdb8wrapper.api.model.Title;

import java.util.List;

public interface FindTitleRequest {
  List<Title> execute(String query);
}
