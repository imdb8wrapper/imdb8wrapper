package com.imdb8.wrapper;

import com.imdb8.wrapper.api.model.Title;
import com.imdb8.wrapper.api.model.request.FindTitleRequest;
import com.imdb8.wrapper.api.model.request.GetOverviewDetailsRequest;
import com.imdb8.wrapper.api.ImdbApi;
import com.imdb8.wrapper.api.model.OverviewDetails;

import java.util.List;

public class DemoApplication {
  public static void main(String[] args) {
    String apiKey = System.getenv("IMDB8_API_KEY");
    ImdbApi imdbApi = new ImdbApi(apiKey);

    FindTitleRequest findTitleRequest = imdbApi.newFindTitleRequest();
    List<Title> foundTitles = findTitleRequest.execute("Honest Thief");

    System.out.println(foundTitles);

    Title title = foundTitles.get(0);

    GetOverviewDetailsRequest getOverviewDetailsRequest = imdbApi.newGetOverviewDetailsRequest();

    OverviewDetails overviewDetails = getOverviewDetailsRequest.execute(title.getId());

    System.out.println(overviewDetails);
  }
}
