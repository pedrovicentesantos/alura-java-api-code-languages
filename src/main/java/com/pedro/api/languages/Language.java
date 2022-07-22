package com.pedro.api.languages;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "languages")
public class Language {

  @Id
  private String id;
  private String name;
  private String image;
  private Integer ranking;
  private long stars;

  public Language(String name, String image, Integer ranking) {
    this.name = name;
    this.image = image;
    this.ranking = ranking;
  }

  public String getName() {
    return name;
  }

  public String getImage() {
    return image;
  }

  public String getId() {
    return id;
  }

  public Integer getRanking() {
    return ranking;
  }

  public long getStars() {
    return stars;
  }
  
  public void setName(String name) {
    this.name = name;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public void addStar(){
    this.stars++;
  }
}
