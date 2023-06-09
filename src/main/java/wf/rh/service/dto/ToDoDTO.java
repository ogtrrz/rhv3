package wf.rh.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import javax.validation.constraints.*;
import wf.rh.domain.enumeration.StateToDo;

/**
 * A DTO for the {@link wf.rh.domain.ToDo} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ToDoDTO implements Serializable {

    private Long id;

    private Long employeeId;

    private Instant date;

    @NotNull
    @Size(max = 100)
    private String description;

    private StateToDo state;

    private String link;

    private EmployeeDTO employee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StateToDo getState() {
        return state;
    }

    public void setState(StateToDo state) {
        this.state = state;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ToDoDTO)) {
            return false;
        }

        ToDoDTO toDoDTO = (ToDoDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, toDoDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ToDoDTO{" +
            "id=" + getId() +
            ", employeeId=" + getEmployeeId() +
            ", date='" + getDate() + "'" +
            ", description='" + getDescription() + "'" +
            ", state='" + getState() + "'" +
            ", link='" + getLink() + "'" +
            ", employee=" + getEmployee() +
            "}";
    }
}
