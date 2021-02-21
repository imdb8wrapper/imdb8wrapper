package com.imdb8.wrapper.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Review {
  private String id;
  private Author author;
  private int authorRating;
  private double helpfulnessScore;
  private int downVotes;
  private int upVotes;
  private String languageCode;
  private String reviewText;
  private String reviewTitle;
  private boolean spoiler;
  private String submissionDate;

  @JsonProperty("interestingVotes")
  private void unpackInterestingVotes(Map<String, Object> interestingVotes) {
    this.downVotes = (int) interestingVotes.get("down");
    this.upVotes = (int) interestingVotes.get("up");
  }
}
