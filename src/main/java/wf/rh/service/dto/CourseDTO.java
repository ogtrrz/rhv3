package wf.rh.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;
import wf.rh.domain.enumeration.TypeCourse;

/**
 * A DTO for the {@link wf.rh.domain.Course} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CourseDTO implements Serializable {

    private Long id;

    private Long jobId;

    @NotNull
    @Size(max = 20)
    private String code;

    @NotNull
    @Size(max = 100)
    private String name;

    private Integer expirationInMonth;

    private TypeCourse typeCourse;

    @Size(max = 100)
    private String autorizationBy;

    private Integer durationAuthorizationInMonth;

    @Size(max = 500)
    private String description;

    private String link;

    private JobDTO job;

    private CourseDTO course;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getExpirationInMonth() {
        return expirationInMonth;
    }

    public void setExpirationInMonth(Integer expirationInMonth) {
        this.expirationInMonth = expirationInMonth;
    }

    public TypeCourse getTypeCourse() {
        return typeCourse;
    }

    public void setTypeCourse(TypeCourse typeCourse) {
        this.typeCourse = typeCourse;
    }

    public String getAutorizationBy() {
        return autorizationBy;
    }

    public void setAutorizationBy(String autorizationBy) {
        this.autorizationBy = autorizationBy;
    }

    public Integer getDurationAuthorizationInMonth() {
        return durationAuthorizationInMonth;
    }

    public void setDurationAuthorizationInMonth(Integer durationAuthorizationInMonth) {
        this.durationAuthorizationInMonth = durationAuthorizationInMonth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public JobDTO getJob() {
        return job;
    }

    public void setJob(JobDTO job) {
        this.job = job;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CourseDTO)) {
            return false;
        }

        CourseDTO courseDTO = (CourseDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, courseDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CourseDTO{" +
            "id=" + getId() +
            ", jobId=" + getJobId() +
            ", code='" + getCode() + "'" +
            ", name='" + getName() + "'" +
            ", expirationInMonth=" + getExpirationInMonth() +
            ", typeCourse='" + getTypeCourse() + "'" +
            ", autorizationBy='" + getAutorizationBy() + "'" +
            ", durationAuthorizationInMonth=" + getDurationAuthorizationInMonth() +
            ", description='" + getDescription() + "'" +
            ", link='" + getLink() + "'" +
            ", job=" + getJob() +
            ", course=" + getCourse() +
            "}";
    }
}
