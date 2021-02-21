package io.github.imdb8wrapper.api.model.request;

import io.github.imdb8wrapper.api.model.OverviewDetails;

public interface GetOverviewDetailsRequest {
  OverviewDetails execute(String ttConst);
}
