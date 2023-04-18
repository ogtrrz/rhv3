package wf.rh.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A Training.
 */
@Entity
@Table(name = "training")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Training implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "employee_id")
    private Long employeeId;

    @NotNull
    @Size(max = 20)
    @Column(name = "code", length = 20, nullable = false)
    private String code;

    @Column(name = "date")
    private Instant date;

    @Column(name = "expiry")
    private Instant expiry;

    @OneToMany(mappedBy = "training")
    @JsonIgnoreProperties(value = { "training" }, allowSetters = true)
    private Set<Evidence> evidences = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "trainings", "requirents", "reqCourses", "job", "course" }, allowSetters = true)
    private Course course;

    @ManyToOne
    @JsonIgnoreProperties(value = { "trainings", "todos", "historicData", "managers", "job", "employee" }, allowSetters = true)
    private Employee employee;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Training id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseId() {
        return this.courseId;
    }

    public Training courseId(Long courseId) {
        this.setCourseId(courseId);
        return this;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getEmployeeId() {
        return this.employeeId;
    }

    public Training employeeId(Long employeeId) {
        this.setEmployeeId(employeeId);
        return this;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getCode() {
        return this.code;
    }

    public Training code(String code) {
        this.setCode(code);
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Instant getDate() {
        return this.date;
    }

    public Training date(Instant date) {
        this.setDate(date);
        return this;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Instant getExpiry() {
        return this.expiry;
    }

    public Training expiry(Instant expiry) {
        this.setExpiry(expiry);
        return this;
    }

    public void setExpiry(Instant expiry) {
        this.expiry = expiry;
    }

    public Set<Evidence> getEvidences() {
        return this.evidences;
    }

    public void setEvidences(Set<Evidence> evidences) {
        if (this.evidences != null) {
            this.evidences.forEach(i -> i.setTraining(null));
        }
        if (evidences != null) {
            evidences.forEach(i -> i.setTraining(this));
        }
        this.evidences = evidences;
    }

    public Training evidences(Set<Evidence> evidences) {
        this.setEvidences(evidences);
        return this;
    }

    public Training addEvidence(Evidence evidence) {
        this.evidences.add(evidence);
        evidence.setTraining(this);
        return this;
    }

    public Training removeEvidence(Evidence evidence) {
        this.evidences.remove(evidence);
        evidence.setTraining(null);
        return this;
    }

    public Course getCourse() {
        return this.course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Training course(Course course) {
        this.setCourse(course);
        return this;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Training employee(Employee employee) {
        this.setEmployee(employee);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Training)) {
            return false;
        }
        return id != null && id.equals(((Training) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Training{" +
            "id=" + getId() +
            ", courseId=" + getCourseId() +
            ", employeeId=" + getEmployeeId() +
            ", code='" + getCode() + "'" +
            ", date='" + getDate() + "'" +
            ", expiry='" + getExpiry() + "'" +
            "}";
    }
}
