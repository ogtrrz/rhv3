package wf.rh.service.mapper;

import org.mapstruct.*;
import wf.rh.domain.Course;
import wf.rh.domain.Job;
import wf.rh.service.dto.CourseDTO;
import wf.rh.service.dto.JobDTO;

/**
 * Mapper for the entity {@link Course} and its DTO {@link CourseDTO}.
 */
@Mapper(componentModel = "spring")
public interface CourseMapper extends EntityMapper<CourseDTO, Course> {
    @Mapping(target = "job", source = "job", qualifiedByName = "jobId")
    @Mapping(target = "course", source = "course", qualifiedByName = "courseId")
    CourseDTO toDto(Course s);

    @Named("courseId")
    @BeanMapping(ignoreByDefault = false)
    @Mapping(target = "id", source = "id")
    CourseDTO toDtoCourseId(Course course);

    @Named("jobId")
    @BeanMapping(ignoreByDefault = false)
    @Mapping(target = "id", source = "id")
    JobDTO toDtoJobId(Job job);
}
