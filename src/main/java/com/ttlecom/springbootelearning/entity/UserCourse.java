package com.ttlecom.springbootelearning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "users_courses")
public class UserCourse {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)

  @Column(name = "user_id")
  private int userId;
  @Column(name = "course_id")
  private int courseId;

  @Column(name = "role_id")
  private int roleId;

  @ManyToOne
  @JoinColumn(name = "user_id", insertable = false, updatable = false)
  @JsonIgnore
  private User user;

  @ManyToOne
  @JoinColumn(name = "course_id", insertable = false, updatable = false)
  @JsonIgnore
  private Course course;

  public UserCourse() {
  }

  public UserCourse(int id, int userId, int courseId, int roleId) {
    this.id = id;
    this.userId = userId;
    this.courseId = courseId;
    this.roleId = roleId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getRoleId() {
    return roleId;
  }

  public void setRoleId(int roleId) {
    this.roleId = roleId;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getCourseId() {
    return courseId;
  }

  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }
}
