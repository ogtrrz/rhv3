package wf.rh.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.Instant;
import javax.persistence.*;
import javax.validation.constraints.*;
import wf.rh.domain.enumeration.StateToDo;

/**
 * A ToDo.
 */
@Entity
@Table(name = "to_do")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ToDo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "date")
    private Instant date;

    @NotNull
    @Size(max = 100)
    @Column(name = "description", length = 100, nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private StateToDo state;

    @Column(name = "link")
    private String link;

    @ManyToOne
    @JsonIgnoreProperties(value = { "trainings", "todos", "historicData", "managers", "job", "employee" }, allowSetters = true)
    private Employee employee;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public ToDo id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return this.employeeId;
    }

    public ToDo employeeId(Long employeeId) {
        this.setEmployeeId(employeeId);
        return this;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Instant getDate() {
        return this.date;
    }

    public ToDo date(Instant date) {
        this.setDate(date);
        return this;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getDescription() {
        return this.description;
    }

    public ToDo description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StateToDo getState() {
        return this.state;
    }

    public ToDo state(StateToDo state) {
        this.setState(state);
        return this;
    }

    public void setState(StateToDo state) {
        this.state = state;
    }

    public String getLink() {
        return this.link;
    }

    public ToDo link(String link) {
        this.setLink(link);
        return this;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public ToDo employee(Employee employee) {
        this.setEmployee(employee);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ToDo)) {
            return false;
        }
        return id != null && id.equals(((ToDo) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ToDo{" +
            "id=" + getId() +
            ", employeeId=" + getEmployeeId() +
            ", date='" + getDate() + "'" +
            ", description='" + getDescription() + "'" +
            ", state='" + getState() + "'" +
            ", link='" + getLink() + "'" +
            "}";
    }
}
