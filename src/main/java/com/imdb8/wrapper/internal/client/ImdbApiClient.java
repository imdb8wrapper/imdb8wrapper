package com.imdb8.wrapper.internal.client;


import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
public class ImdbApiClient {
  private static final String IMDB8_API_BASE = "https://imdb8.p.rapidapi.com";
  private static final String IMDB8_API_KEY_HEADER = "x-rapidapi-key";
  private static final String IMDB8_HOST_HEADER = "x-rapidapi-host";
  private static final String IMDB8_HOST_VALUE = "imdb8.p.rapidapi.com";

  private final HttpGet httpGet;

  private final CloseableHttpClient httpClient;

  public ImdbApiClient(String apiKey) {
    this.httpGet = new HttpGet(IMDB8_API_BASE);
    httpGet.setHeader(IMDB8_HOST_HEADER, IMDB8_HOST_VALUE);
    httpGet.setHeader(IMDB8_API_KEY_HEADER, apiKey);

    this.httpClient = HttpClients.createDefault();
  }

  public String get(ImdbApiRequestData imdbApiRequest) throws URISyntaxException, IOException {
    URI uri = new URIBuilder(IMDB8_API_BASE)
        .setPath(imdbApiRequest.getPath())
        .setParameters(imdbApiRequest.getQueryParameters())
        .build();

    httpGet.setURI(uri);

    try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
      return EntityUtils.toString(response.getEntity());
    }
  }
}
