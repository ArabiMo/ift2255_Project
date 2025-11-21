package com.diro.ift2255.service;

import com.diro.ift2255.model.Course;
import com.diro.ift2255.util.HttpClientApi;
import com.fasterxml.jackson.core.type.TypeReference;
import java.net.URI;
import java.util.*;

public class CourseService {

  private final HttpClientApi clientApi;
  private static final String BASE_URL =
    "https://planifium-api.onrender.com/api/v1/courses";

  public CourseService(HttpClientApi clientApi) {
    this.clientApi = clientApi;
  }

  /** Fetch all courses */
  public List<Course> getAllCourses(Map<String, String> queryParams) {
    Map<String, String> params = (queryParams == null)
      ? Collections.emptyMap()
      : queryParams;

    URI uri = HttpClientApi.buildUri(BASE_URL, params);
    List<Course> courses = clientApi.get(
      uri,
      new TypeReference<List<Course>>() {}
    );

    return courses;
  }

  /** Fetch a course by ID */
  public Optional<Course> getCourseById(String courseId) {
    return getCourseById(courseId, null);
  }

  /** Fetch a course by ID with optional query params */
  public Optional<Course> getCourseById(
    String courseId,
    Map<String, String> queryParams
  ) {
    Map<String, String> params = (queryParams == null)
      ? Collections.emptyMap()
      : queryParams;
    URI uri = HttpClientApi.buildUri(BASE_URL + "/" + courseId, params);

    try {
      Course course = clientApi.get(uri, Course.class);
      return Optional.of(course);
    } catch (RuntimeException e) {
      return Optional.empty();
    }
  }

  /** Fetch prerequisite courses by ID */
  public List<Course> getPrerequisitesCoursesById(String courseId) {
    return getPrerequisitesCoursesById(courseId, null);
  }

  public List<Course> getPrerequisitesCoursesById(
    String courseId,
    Map<String, String> queryParams
  ) {
    Map<String, String> params = (queryParams == null)
      ? Collections.emptyMap()
      : queryParams;

    URI uri = HttpClientApi.buildUri(
      BASE_URL + "/" + courseId + "/prerequisites",
      params
    );

    // This endpoint returns an array -> deserialize to List<Course>
    return clientApi.get(uri, new TypeReference<List<Course>>() {});
  }
}
