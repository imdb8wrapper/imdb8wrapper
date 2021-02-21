package io.github.imdb8wrapper.internal.client;

import lombok.Getter;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ImdbApiRequestData {
  private final String path;

  private final List<NameValuePair> queryParameters;

  public ImdbApiRequestData(Builder apiRequestBuilder) {
    this.path = apiRequestBuilder.pathBuilder.toString();
    this.queryParameters = apiRequestBuilder.queryParameters;
  }

  public static Builder builder() {
    return new Builder();
  }


  public static class Builder {
    private final StringBuilder pathBuilder;

    private final List<NameValuePair> queryParameters;

    private Builder() {
      queryParameters = new ArrayList<>();
      pathBuilder = new StringBuilder();
    }

    public Builder path(String path) {
      pathBuilder.append(getPath(path));
      return this;
    }

    private String getPath(String path) {
      return path.charAt(0) == '/' ? path : "/" + path;
    }

    public Builder addQueryParameter(String paramName, String paramValue) {
      queryParameters.add(new BasicNameValuePair(paramName, paramValue));
      return this;
    }

    public ImdbApiRequestData build() {
      return new ImdbApiRequestData(this);
    }
  }
}
