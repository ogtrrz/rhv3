package wf.rh.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import wf.rh.domain.enumeration.Kind;

/**
 * A Requirents.
 */
@Entity
@Table(name = "requirents")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Requirents implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "course_id")
    private Long courseId;

    @NotNull
    @Size(max = 20)
    @Column(name = "code", length = 20, nullable = false)
    private String code;

    @Column(name = "expiration_in_month")
    private Integer expirationInMonth;

    @Enumerated(EnumType.STRING)
    @Column(name = "kind")
    private Kind kind;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JsonIgnoreProperties(value = { "trainings", "requirents", "reqCourses", "job", "course" }, allowSetters = true)
    private Course course;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Requirents id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseId() {
        return this.courseId;
    }

    public Requirents courseId(Long courseId) {
        this.setCourseId(courseId);
        return this;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCode() {
        return this.code;
    }

    public Requirents code(String code) {
        this.setCode(code);
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getExpirationInMonth() {
        return this.expirationInMonth;
    }

    public Requirents expirationInMonth(Integer expirationInMonth) {
        this.setExpirationInMonth(expirationInMonth);
        return this;
    }

    public void setExpirationInMonth(Integer expirationInMonth) {
        this.expirationInMonth = expirationInMonth;
    }

    public Kind getKind() {
        return this.kind;
    }

    public Requirents kind(Kind kind) {
        this.setKind(kind);
        return this;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    public String getDescription() {
        return this.description;
    }

    public Requirents description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return this.course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Requirents course(Course course) {
        this.setCourse(course);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Requirents)) {
            return false;
        }
        return id != null && id.equals(((Requirents) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Requirents{" +
            "id=" + getId() +
            ", courseId=" + getCourseId() +
            ", code='" + getCode() + "'" +
            ", expirationInMonth=" + getExpirationInMonth() +
            ", kind='" + getKind() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
