package wf.rh.service.mapper;

import org.mapstruct.*;
import wf.rh.domain.Job;
import wf.rh.service.dto.JobDTO;

/**
 * Mapper for the entity {@link Job} and its DTO {@link JobDTO}.
 */
@Mapper(componentModel = "spring")
public interface JobMapper extends EntityMapper<JobDTO, Job> {}
