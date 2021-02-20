# [IMDB8](https://rapidapi.com/apidojo/api/imdb8) API Java Wrapper

### Example Usage:
```
public class DemoApplication {
  public static void main(String[] args) {
    String apiKey = System.getenv("IMDB8_API_KEY");
    ImdbApi imdbApi = new ImdbApi(apiKey);

    FindTitleRequest findTitleRequest = imdbApi.newFindTitleRequest();
    
    List<Title> titles = findTitleRequest.execute("Honest Thief");
    
    Title title = foundTitles.get(0);

    GetOverviewDetailsRequest getOverviewDetailsRequest = imdbApi.newGetOverviewDetailsRequest();

    OverviewDetails overviewDetails = getOverviewDetailsRequest.execute(title.getId());
  }
}

```