package com.diro.ift2255.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class Course {

  private String id;
  private String name;
  private double credits;
  private String description;

  @JsonProperty("available_terms")
  private AvailableTerms availableTerms;

  @JsonProperty("available_periods")
  private AvailablePeriods availablePeriods;

  private List<Object> schedules;

  @JsonProperty("requirement_text")
  private String requirementText;

  @JsonProperty("equivalent_courses")
  private List<String> equivalentCourses;

  @JsonProperty("prerequisite_courses")
  private List<String> prerequisiteCourses;

  @JsonProperty("concomitant_courses")
  private List<String> concomitantCourses;

  public Course() {}

  public Course(
    String id,
    String name,
    double credits,
    String description,
    AvailableTerms availableTerms,
    AvailablePeriods availablePeriods,
    List<Object> schedules,
    String requirementText,
    List<String> equivalentCourses,
    List<String> prerequisiteCourses,
    List<String> concomitantCourses
  ) {
    this.id = id;
    this.name = name;
    this.credits = credits;
    this.description = description;
    this.availableTerms = availableTerms;
    this.availablePeriods = availablePeriods;
    this.schedules = schedules;
    this.requirementText = requirementText;
    this.equivalentCourses = equivalentCourses;
    this.prerequisiteCourses = prerequisiteCourses;
    this.concomitantCourses = concomitantCourses;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getCredits() {
    return credits;
  }

  public void setCredits(double credits) {
    this.credits = credits;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public AvailableTerms getAvailableTerms() {
    return availableTerms;
  }

  public void setAvailableTerms(AvailableTerms availableTerms) {
    this.availableTerms = availableTerms;
  }

  public AvailablePeriods getAvailablePeriods() {
    return availablePeriods;
  }

  public void setAvailablePeriods(AvailablePeriods availablePeriods) {
    this.availablePeriods = availablePeriods;
  }

  public List<Object> getSchedules() {
    return schedules;
  }

  public void setSchedules(List<Object> schedules) {
    this.schedules = schedules;
  }

  public String getRequirementText() {
    return requirementText;
  }

  public void setRequirementText(String requirementText) {
    this.requirementText = requirementText;
  }

  public List<String> getEquivalentCourses() {
    return equivalentCourses;
  }

  public void setEquivalentCourses(List<String> equivalentCourses) {
    this.equivalentCourses = equivalentCourses;
  }

  public List<String> getPrerequisiteCourses() {
    return prerequisiteCourses;
  }

  public void setPrerequisiteCourses(List<String> prerequisiteCourses) {
    this.prerequisiteCourses = prerequisiteCourses;
  }

  public List<String> getConcomitantCourses() {
    return concomitantCourses;
  }

  public void setConcomitantCourses(List<String> concomitantCourses) {
    this.concomitantCourses = concomitantCourses;
  }

  @Override
  public String toString() {
    return (
      "Course{" +
      "id='" +
      id +
      '\'' +
      ", name='" +
      name +
      '\'' +
      ", credits=" +
      credits +
      ", description='" +
      description +
      '\'' +
      ", availableTerms=" +
      availableTerms +
      ", availablePeriods=" +
      availablePeriods +
      ", schedules=" +
      schedules +
      ", requirementText='" +
      requirementText +
      '\'' +
      ", equivalentCourses=" +
      equivalentCourses +
      ", prerequisiteCourses=" +
      prerequisiteCourses +
      ", concomitantCourses=" +
      concomitantCourses +
      '}'
    );
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class AvailableTerms {

    private boolean autumn;
    private boolean winter;
    private boolean summer;

    public AvailableTerms() {}

    public AvailableTerms(boolean autumn, boolean winter, boolean summer) {
      this.autumn = autumn;
      this.winter = winter;
      this.summer = summer;
    }

    public boolean isAutumn() {
      return autumn;
    }

    public void setAutumn(boolean autumn) {
      this.autumn = autumn;
    }

    public boolean isWinter() {
      return winter;
    }

    public void setWinter(boolean winter) {
      this.winter = winter;
    }

    public boolean isSummer() {
      return summer;
    }

    public void setSummer(boolean summer) {
      this.summer = summer;
    }

    @Override
    public String toString() {
      return (
        "AvailableTerms{" +
        "autumn=" +
        autumn +
        ", winter=" +
        winter +
        ", summer=" +
        summer +
        '}'
      );
    }
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class AvailablePeriods {

    private boolean daytime;
    private boolean evening;

    public AvailablePeriods() {}

    public AvailablePeriods(boolean daytime, boolean evening) {
      this.daytime = daytime;
      this.evening = evening;
    }

    public boolean isDaytime() {
      return daytime;
    }

    public void setDaytime(boolean daytime) {
      this.daytime = daytime;
    }

    public boolean isEvening() {
      return evening;
    }

    public void setEvening(boolean evening) {
      this.evening = evening;
    }

    @Override
    public String toString() {
      return (
        "AvailablePeriods{" +
        "daytime=" +
        daytime +
        ", evening=" +
        evening +
        '}'
      );
    }
  }
}
