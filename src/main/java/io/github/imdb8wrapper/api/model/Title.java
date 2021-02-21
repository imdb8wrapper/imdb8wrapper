package io.github.imdb8wrapper.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Title {
  private String id;
  private Image image;
  private int runningTimeInMinutes;
  private String title;
  private String titleType;
  private int year;
  private List<Principal> principals;
  private String ttConst;
}
