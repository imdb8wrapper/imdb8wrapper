package com.imdb8.wrapper.internal.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imdb8.wrapper.internal.client.ImdbApiClient;

public abstract class AbstractRequest {
  protected final static ObjectMapper objectMapper = new ObjectMapper();

  protected final ImdbApiClient imdbApiClient;

  protected AbstractRequest(ImdbApiClient imdbApiClient) {
    this.imdbApiClient = imdbApiClient;
  }
}
