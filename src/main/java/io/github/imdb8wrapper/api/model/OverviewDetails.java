package io.github.imdb8wrapper.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OverviewDetails {
  private Title title;

  Map<String, List<Certificate>> certificates;

  private double rating;

  private int ratingCount;

  private List<String> genres;

  private String releaseDate;

  private String plotOutlineText;

  private String plotSummaryText;

  @JsonProperty("ratings")
  public void setRatingAndRatingCount(Map<String, Object> ratings) {
    Object object = ratings.get("rating");

    if (object instanceof Integer) {
      this.rating = (int) object;
    }

    if (object instanceof Double) {
      this.rating = (double) object;
    }

    this.ratingCount = (int) ratings.get("ratingCount");
  }

  @JsonProperty("plotOutline")
  public void setPlotOutlineText(Map<String, String> plotOutline) {
    this.plotOutlineText = plotOutline.get("text");
  }

  @JsonProperty("plotSummary")
  public void setPlotSummaryText(Map<String, String> plotSummary) {
    this.plotSummaryText = plotSummary.get("text");
  }
}
