# IMDB8 API Java Wrapper
Open source java wrapper of [IMDB8 API](https://rapidapi.com/apidojo/api/imdb8)

# Usage
To use it, you need the following Maven dependency:
```xml
<dependency>
  <groupId>io.github.imdb8wrapper</groupId>
  <artifactId>imdb8wrapper</artifactId>
  <version>${project.version}</version>
</dependency>
```

Example application:

```java
public class DemoApplication {
  public static void main(String[] args) {
    String apiKey = System.getenv("IMDB8_API_KEY");
    ImdbApi imdbApi = new ImdbApi(apiKey);

    FindTitleRequest findTitleRequest = imdbApi.newFindTitleRequest();

    List<Title> titles = findTitleRequest.execute("Honest Thief");

    Title title = titles.get(0);

    GetOverviewDetailsRequest getOverviewDetailsRequest = imdbApi.newGetOverviewDetailsRequest();

    OverviewDetails overviewDetails = getOverviewDetailsRequest.execute(title.getTtConst());

    GetUserReviewsRequest getUserReviewsRequest = imdbApi.newGetUserReviewsRequest();
    ReviewsPage reviewsPage = getUserReviewsRequest.getFirstReviewsPage(title.getTtConst());
  }
}
```

# Contributing

## Build locally
1. Clone the repository
1. mvn clean install

## Develop without wasting API requests
You can set up a Mock Server in [Postman](https://www.postman.com/)
