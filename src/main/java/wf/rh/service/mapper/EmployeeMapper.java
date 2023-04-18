package wf.rh.service.mapper;

import org.mapstruct.*;
import wf.rh.domain.Employee;
import wf.rh.domain.Job;
import wf.rh.service.dto.EmployeeDTO;
import wf.rh.service.dto.JobDTO;

/**
 * Mapper for the entity {@link Employee} and its DTO {@link EmployeeDTO}.
 */
@Mapper(componentModel = "spring")
public interface EmployeeMapper extends EntityMapper<EmployeeDTO, Employee> {
    @Mapping(target = "job", source = "job", qualifiedByName = "jobId")
    @Mapping(target = "employee", source = "employee", qualifiedByName = "employeeId")
    EmployeeDTO toDto(Employee s);

    @Named("employeeId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    EmployeeDTO toDtoEmployeeId(Employee employee);

    @Named("jobId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    JobDTO toDtoJobId(Job job);
}
