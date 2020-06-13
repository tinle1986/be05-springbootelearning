package com.ttlecom.springbootelearning.dto;

public class CourseDto {
  private int id;
  private String title;
  private String categoryTitle;
  private String content;
  private String description;
  private String image;
  private Integer hourCount;
  private Integer lectureCount;
  private Double price;
  private Integer discount;
  private Long viewCount;
  private Double promotionPrice;
  private String lastUpdate;

  public CourseDto() {}

  public CourseDto(int id, String title, String categoryTitle, String content, String description, String image, Integer hourCount, Integer lectureCount, Double price, Integer discount, Long viewCount, Double promotionPrice, String lastUpdate) {
    this.id = id;
    this.title = title;
    this.categoryTitle = categoryTitle;
    this.content = content;
    this.description = description;
    this.image = image;
    this.hourCount = hourCount;
    this.lectureCount = lectureCount;
    this.price = price;
    this.discount = discount;
    this.viewCount = viewCount;
    this.promotionPrice = promotionPrice;
    this.lastUpdate = lastUpdate;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCategoryTitle() {
    return categoryTitle;
  }

  public void setCategoryTitle(String categoryTitle) {
    this.categoryTitle = categoryTitle;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Integer getHourCount() {
    return hourCount;
  }

  public void setHourCount(Integer hourCount) {
    this.hourCount = hourCount;
  }

  public Integer getLectureCount() {
    return lectureCount;
  }

  public void setLectureCount(Integer lectureCount) {
    this.lectureCount = lectureCount;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Integer getDiscount() {
    return discount;
  }

  public void setDiscount(Integer discount) {
    this.discount = discount;
  }

  public Long getViewCount() {
    return viewCount;
  }

  public void setViewCount(Long viewCount) {
    this.viewCount = viewCount;
  }

  public Double getPromotionPrice() {
    return promotionPrice;
  }

  public void setPromotionPrice(Double promotionPrice) {
    this.promotionPrice = promotionPrice;
  }

  public String getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(String lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
