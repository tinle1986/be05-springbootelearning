package com.ttlecom.springbootelearning.admin.controller;

import com.ttlecom.springbootelearning.entity.Course;
import com.ttlecom.springbootelearning.entity.Video;
import com.ttlecom.springbootelearning.service.CourseService;
import com.ttlecom.springbootelearning.service.VideoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("video")
public class AdminVideoController {

  private final VideoService videoService;
  private final CourseService courseService;

  public AdminVideoController(VideoService videoService, CourseService courseService) {
    this.videoService = videoService;
    this.courseService = courseService;
  }

  @GetMapping()
  public String index(Model model) {
    model.addAttribute("videos", videoService.getAll());
    return "video/index";
  }

  @GetMapping("add")
  public String addGet(Model model) {
    List<Course> courseList = courseService.getAll();
    model.addAttribute("courses", courseList);
    model.addAttribute("video", new Video());
    return "video/add";
  }

  @PostMapping("add")
  public String addPost(Model model, @Valid @ModelAttribute("video") Video video, BindingResult errors) {
    /* check:
    1. title
    2. time
    3. url
    4. image
     */

    if (video.getTitle() == null || video.getTitle().isEmpty()) {
      errors.rejectValue("title", "video", "Please input a title");
    }
    if (video.getTimeCount() == null) {
      video.setTimeCount(0);
    }
    if (video.getUrl() == null || video.getUrl().isEmpty()) {
      errors.rejectValue("url", "video", "Please input an url");
    }
    if (video.getImage() == null || video.getImage().isEmpty()) {
      video.setImage("./assets/images/1.png");
    }
    if (errors.hasErrors()) {
      List<Course> courseList = courseService.getAll();
      model.addAttribute("courses", courseList);
      return "video/add";
    }

    videoService.add(video);
    return "redirect:/video";
  }

  @GetMapping("edit")
  public String edit(@RequestParam("id") int id, Model model) {
    List<Course> courseList = courseService.getAll();
    Video entity = videoService.getById(id);
    if (entity != null) {
      model.addAttribute("video", entity);
      model.addAttribute("courses", courseList);
    }
    return "video/edit";
  }

  @PostMapping("edit")
  public String edit(Model model, @Valid @ModelAttribute("video") Video video, BindingResult errors) {
    /* check:
        1. title
        2. time
        3. url
        4. image
         */

    if (video.getTitle() == null || video.getTitle().isEmpty()) {
      errors.rejectValue("title", "video", "Please input a title");
    }
    if (video.getTimeCount() == null) {
      video.setTimeCount(0);
    }
    if (video.getUrl() == null || video.getUrl().isEmpty()) {
      errors.rejectValue("url", "video", "Please input an url");
    }
    if (video.getImage() == null || video.getImage().isEmpty()) {
      video.setImage("./assets/images/1.png");
    }
    if (errors.hasErrors()) {
      List<Course> courseList = courseService.getAll();
      model.addAttribute("courses", courseList);
      return "video/add";
    }

    videoService.update(video);
    return "redirect:/video";
  }

  @GetMapping("delete")
  public String delete(@RequestParam("id") int id) {
    videoService.delete(id);
    return "redirect:/video";
  }
}
