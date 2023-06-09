package wf.rh.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;
import wf.rh.domain.enumeration.TypeCourse;

/**
 * A Course.
 */
@Entity
@Table(name = "course")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "job_id")
    private Long jobId;

    @NotNull
    @Size(max = 20)
    @Column(name = "code", length = 20, nullable = false)
    private String code;

    @NotNull
    @Size(max = 100)
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "expiration_in_month")
    private Integer expirationInMonth;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_course")
    private TypeCourse typeCourse;

    @Size(max = 100)
    @Column(name = "autorization_by", length = 100)
    private String autorizationBy;

    @Column(name = "duration_authorization_in_month")
    private Integer durationAuthorizationInMonth;

    @Size(max = 500)
    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "link")
    private String link;

    @OneToMany(mappedBy = "course")
    @JsonIgnoreProperties(value = { "evidences", "course", "employee" }, allowSetters = true)
    private Set<Training> trainings = new HashSet<>();

    @OneToMany(mappedBy = "course")
    @JsonIgnoreProperties(value = { "course" }, allowSetters = true)
    private Set<Requirents> requirents = new HashSet<>();

    @OneToMany(mappedBy = "course")
    @JsonIgnoreProperties(value = { "trainings", "requirents", "reqCourses", "job", "course" }, allowSetters = true)
    private Set<Course> reqCourses = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "courses", "employees" }, allowSetters = true)
    private Job job;

    @ManyToOne
    @JsonIgnoreProperties(value = { "trainings", "requirents", "reqCourses", "job", "course" }, allowSetters = true)
    private Course course;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Course id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJobId() {
        return this.jobId;
    }

    public Course jobId(Long jobId) {
        this.setJobId(jobId);
        return this;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getCode() {
        return this.code;
    }

    public Course code(String code) {
        this.setCode(code);
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public Course name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getExpirationInMonth() {
        return this.expirationInMonth;
    }

    public Course expirationInMonth(Integer expirationInMonth) {
        this.setExpirationInMonth(expirationInMonth);
        return this;
    }

    public void setExpirationInMonth(Integer expirationInMonth) {
        this.expirationInMonth = expirationInMonth;
    }

    public TypeCourse getTypeCourse() {
        return this.typeCourse;
    }

    public Course typeCourse(TypeCourse typeCourse) {
        this.setTypeCourse(typeCourse);
        return this;
    }

    public void setTypeCourse(TypeCourse typeCourse) {
        this.typeCourse = typeCourse;
    }

    public String getAutorizationBy() {
        return this.autorizationBy;
    }

    public Course autorizationBy(String autorizationBy) {
        this.setAutorizationBy(autorizationBy);
        return this;
    }

    public void setAutorizationBy(String autorizationBy) {
        this.autorizationBy = autorizationBy;
    }

    public Integer getDurationAuthorizationInMonth() {
        return this.durationAuthorizationInMonth;
    }

    public Course durationAuthorizationInMonth(Integer durationAuthorizationInMonth) {
        this.setDurationAuthorizationInMonth(durationAuthorizationInMonth);
        return this;
    }

    public void setDurationAuthorizationInMonth(Integer durationAuthorizationInMonth) {
        this.durationAuthorizationInMonth = durationAuthorizationInMonth;
    }

    public String getDescription() {
        return this.description;
    }

    public Course description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return this.link;
    }

    public Course link(String link) {
        this.setLink(link);
        return this;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Set<Training> getTrainings() {
        return this.trainings;
    }

    public void setTrainings(Set<Training> trainings) {
        if (this.trainings != null) {
            this.trainings.forEach(i -> i.setCourse(null));
        }
        if (trainings != null) {
            trainings.forEach(i -> i.setCourse(this));
        }
        this.trainings = trainings;
    }

    public Course trainings(Set<Training> trainings) {
        this.setTrainings(trainings);
        return this;
    }

    public Course addTraining(Training training) {
        this.trainings.add(training);
        training.setCourse(this);
        return this;
    }

    public Course removeTraining(Training training) {
        this.trainings.remove(training);
        training.setCourse(null);
        return this;
    }

    public Set<Requirents> getRequirents() {
        return this.requirents;
    }

    public void setRequirents(Set<Requirents> requirents) {
        if (this.requirents != null) {
            this.requirents.forEach(i -> i.setCourse(null));
        }
        if (requirents != null) {
            requirents.forEach(i -> i.setCourse(this));
        }
        this.requirents = requirents;
    }

    public Course requirents(Set<Requirents> requirents) {
        this.setRequirents(requirents);
        return this;
    }

    public Course addRequirents(Requirents requirents) {
        this.requirents.add(requirents);
        requirents.setCourse(this);
        return this;
    }

    public Course removeRequirents(Requirents requirents) {
        this.requirents.remove(requirents);
        requirents.setCourse(null);
        return this;
    }

    public Set<Course> getReqCourses() {
        return this.reqCourses;
    }

    public void setReqCourses(Set<Course> courses) {
        if (this.reqCourses != null) {
            this.reqCourses.forEach(i -> i.setCourse(null));
        }
        if (courses != null) {
            courses.forEach(i -> i.setCourse(this));
        }
        this.reqCourses = courses;
    }

    public Course reqCourses(Set<Course> courses) {
        this.setReqCourses(courses);
        return this;
    }

    public Course addReqCourse(Course course) {
        this.reqCourses.add(course);
        course.setCourse(this);
        return this;
    }

    public Course removeReqCourse(Course course) {
        this.reqCourses.remove(course);
        course.setCourse(null);
        return this;
    }

    public Job getJob() {
        return this.job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Course job(Job job) {
        this.setJob(job);
        return this;
    }

    public Course getCourse() {
        return this.course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course course(Course course) {
        this.setCourse(course);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Course)) {
            return false;
        }
        return id != null && id.equals(((Course) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Course{" +
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
            "}";
    }
}
