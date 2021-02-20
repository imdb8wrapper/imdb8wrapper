package com.imdb8.wrapper.api.model.request;

import com.imdb8.wrapper.api.model.Title;

import java.util.List;

public interface FindTitleRequest {
  List<Title> execute(String query);
}
