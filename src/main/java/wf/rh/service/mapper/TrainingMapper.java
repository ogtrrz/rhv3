package wf.rh.service.mapper;

import org.mapstruct.*;
import wf.rh.domain.Course;
import wf.rh.domain.Employee;
import wf.rh.domain.Training;
import wf.rh.service.dto.CourseDTO;
import wf.rh.service.dto.EmployeeDTO;
import wf.rh.service.dto.TrainingDTO;

/**
 * Mapper for the entity {@link Training} and its DTO {@link TrainingDTO}.
 */
@Mapper(componentModel = "spring")
public interface TrainingMapper extends EntityMapper<TrainingDTO, Training> {
    @Mapping(target = "course", source = "course", qualifiedByName = "courseId")
    @Mapping(target = "employee", source = "employee", qualifiedByName = "employeeId")
    TrainingDTO toDto(Training s);

    @Named("courseId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    CourseDTO toDtoCourseId(Course course);

    @Named("employeeId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    EmployeeDTO toDtoEmployeeId(Employee employee);
}
