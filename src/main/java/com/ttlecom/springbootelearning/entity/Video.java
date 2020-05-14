package com.ttlecom.springbootelearning.entity;

import javax.persistence.*;

@Entity
@Table(name = "videos")
public class Video {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "title")
  private String title;

  @Column(name = "url")
  private String url;

  @Column(name = "time_count")
  private int timeCount;

  @Column(name = "order_index")
  private int orderIndex;

  @Column(name = "image")
  private String image;

  @Column(name = "course_id")
  private int courseId;

  @ManyToOne
  @JoinColumn(name = "course_id", insertable = false, updatable = false)
  private Course course;

  public Video() {}

  public Video(int id, String title, String url, int timeCount, int orderIndex, String image, int courseId) {
    this.id = id;
    this.title = title;
    this.url = url;
    this.timeCount = timeCount;
    this.orderIndex = orderIndex;
    this.image = image;
    this.courseId = courseId;
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

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public int getTimeCount() {
    return timeCount;
  }

  public void setTimeCount(int timeCount) {
    this.timeCount = timeCount;
  }

  public int getOrderIndex() {
    return orderIndex;
  }

  public void setOrderIndex(int orderIndex) {
    this.orderIndex = orderIndex;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public int getCourseId() {
    return courseId;
  }

  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }


}
