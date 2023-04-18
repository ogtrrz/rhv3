package wf.rh.service.mapper;

import org.mapstruct.*;
import wf.rh.domain.Employee;
import wf.rh.domain.ToDo;
import wf.rh.service.dto.EmployeeDTO;
import wf.rh.service.dto.ToDoDTO;

/**
 * Mapper for the entity {@link ToDo} and its DTO {@link ToDoDTO}.
 */
@Mapper(componentModel = "spring")
public interface ToDoMapper extends EntityMapper<ToDoDTO, ToDo> {
    @Mapping(target = "employee", source = "employee", qualifiedByName = "employeeId")
    ToDoDTO toDto(ToDo s);

    @Named("employeeId")
    @BeanMapping(ignoreByDefault = false)
    @Mapping(target = "id", source = "id")
    EmployeeDTO toDtoEmployeeId(Employee employee);
}
