# [IMDB8](https://rapidapi.com/apidojo/api/imdb8) API Java Wrapper

### How to build locally
1. Clone the repository
1. mvn clean install

### How to develop without wasting API requests
You can set up a Mock Server in [Postman](https://www.postman.com/)

### Example Usage:
```
public class DemoApplication {
  public static void main(String[] args) {
    String apiKey = System.getenv("IMDB8_API_KEY");
    ImdbApi imdbApi = new ImdbApi(apiKey);

    FindTitleRequest findTitleRequest = imdbApi.newFindTitleRequest();
    
    List<Title> titles = findTitleRequest.execute("Honest Thief");
    
    Title title = titles.get(0);

    GetOverviewDetailsRequest getOverviewDetailsRequest = imdbApi.newGetOverviewDetailsRequest();

    OverviewDetails overviewDetails = getOverviewDetailsRequest.execute(title.getId());
  }
}
```