package io.github.imdb8wrapper.internal;

public interface ApiConstants {
  String IMDB8_API_BASE = "https://4d99a418-fce9-485b-babc-7d9c5965266d.mock.pstmn.io";
  String IMDB8_API_KEY_HEADER = "x-rapidapi-key";
  String IMDB8_HOST_HEADER = "x-rapidapi-host";
  String IMDB8_HOST_VALUE = "imdb8.p.rapidapi.com";

  String FIND_TITLE = "/title/find";

  String GET_USER_REVIEWS = "/title/get-user-reviews";

  String GET_OVERVIEW_DETAILS = "/title/get-overview-details";

  String QUERY_PARAM_NAME = "q";

  String TT_CONST_PARAM_NAME = "tconst";

  String PAGINATION_KEY_PARAM_NAME = "paginationKey";
}
