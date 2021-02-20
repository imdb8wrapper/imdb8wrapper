package com.imdb8.wrapper.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Principal {
  private String disambiguation;
  private String id;
  private String legacyNameText;
  private String name;
  private int billing;
  private String category;
  private List<String> characters;
}
