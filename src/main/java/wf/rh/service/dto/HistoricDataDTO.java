package wf.rh.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link wf.rh.domain.HistoricData} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class HistoricDataDTO implements Serializable {

    private Long id;

    private Long employeeId;

    @NotNull
    @Size(max = 100)
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(o instanceof HistoricDataDTO)) {
            return false;
        }

        HistoricDataDTO historicDataDTO = (HistoricDataDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, historicDataDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "HistoricDataDTO{" +
            "id=" + getId() +
            ", employeeId=" + getEmployeeId() +
            ", name='" + getName() + "'" +
            ", link='" + getLink() + "'" +
            ", employee=" + getEmployee() +
            "}";
    }
}
