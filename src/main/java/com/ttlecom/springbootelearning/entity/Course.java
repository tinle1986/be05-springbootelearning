package com.ttlecom.springbootelearning.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "title")
  private String title;

  @Column(name = "image")
  private String image;

  @Column(name = "lecture_count")
  private int lectureCount;

  @Column(name = "hour_count")
  private int hourCount;

  @Column(name = "view_count")
  private int viewCount;

  @Column(name = "price")
  private double price;

  @Column(name = "discount")
  private int discount;

  @Column(name = "promotion_price")
  private double promotionPrice;

  @Column(name = "description")
  private String description;

  @Column(name = "content")
  private String content;

  @Column(name = "last_update")
  private String lastUpdate;

  @Column(name = "category_id")
  private int categoryId;

  @ManyToOne
  @JoinColumn(name = "category_id", insertable = false, updatable = false)
  private Categories category;

  @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
  private List<Video> videoList;

  @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
  private List<Result> resultList;

  @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
  private List<UserCourse> userCourseList;

  public Course() {}

  public Course(int id, String title, String image, int lectureCount, int hourCount, int viewCount, double price, int discount, double promotionPrice, String description, String content, String lastUpdate, int categoryId) {
    this.id = id;
    this.title = title;
    this.image = image;
    this.lectureCount = lectureCount;
    this.hourCount = hourCount;
    this.viewCount = viewCount;
    this.price = price;
    this.discount = discount;
    this.promotionPrice = promotionPrice;
    this.description = description;
    this.content = content;
    this.lastUpdate = lastUpdate;
    this.categoryId = categoryId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public int getLectureCount() {
    return lectureCount;
  }

  public void setLectureCount(int lectureCount) {
    this.lectureCount = lectureCount;
  }

  public int getHourCount() {
    return hourCount;
  }

  public void setHourCount(int hourCount) {
    this.hourCount = hourCount;
  }

  public int getViewCount() {
    return viewCount;
  }

  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getDiscount() {
    return discount;
  }

  public void setDiscount(int discount) {
    this.discount = discount;
  }

  public double getPromotionPrice() {
    return promotionPrice;
  }

  public void setPromotionPrice(double promotionPrice) {
    this.promotionPrice = promotionPrice;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(String lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public int getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }

  public Categories getCategory() {
    return category;
  }

  public void setCategory(Categories category) {
    this.category = category;
  }

  public List<Video> getVideoList() {
    return videoList;
  }

  public void setVideoList(List<Video> videoList) {
    this.videoList = videoList;
  }

  public List<Result> getResultList() {
    return resultList;
  }

  public void setResultList(List<Result> resultList) {
    this.resultList = resultList;
  }

  public List<UserCourse> getUserCourseList() {
    return userCourseList;
  }

  public void setUserCourseList(List<UserCourse> userCourseList) {
    this.userCourseList = userCourseList;
  }
}