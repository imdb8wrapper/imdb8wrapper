package com.imdb8.wrapper.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Certificate {
  private String certificate;
  private int certificateNumber;
  private String ratingReason;
  private String ratingsBody;
}
