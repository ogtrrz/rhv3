package wf.rh.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A HistoricData.
 */
@Entity
@Table(name = "historic_data")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class HistoricData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "employee_id")
    private Long employeeId;

    @NotNull
    @Size(max = 100)
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "link")
    private String link;

    @ManyToOne
    @JsonIgnoreProperties(value = { "trainings", "todos", "historicData", "managers", "job", "employee" }, allowSetters = true)
    private Employee employee;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public HistoricData id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return this.employeeId;
    }

    public HistoricData employeeId(Long employeeId) {
        this.setEmployeeId(employeeId);
        return this;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return this.name;
    }

    public HistoricData name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return this.link;
    }

    public HistoricData link(String link) {
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

    public HistoricData employee(Employee employee) {
        this.setEmployee(employee);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HistoricData)) {
            return false;
        }
        return id != null && id.equals(((HistoricData) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "HistoricData{" +
            "id=" + getId() +
            ", employeeId=" + getEmployeeId() +
            ", name='" + getName() + "'" +
            ", link='" + getLink() + "'" +
            "}";
    }
}
