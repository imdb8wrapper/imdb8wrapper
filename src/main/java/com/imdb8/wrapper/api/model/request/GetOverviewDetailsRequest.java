package com.imdb8.wrapper.api.model.request;

import com.imdb8.wrapper.api.model.OverviewDetails;

public interface GetOverviewDetailsRequest {
  OverviewDetails execute(String ttConst);
}
