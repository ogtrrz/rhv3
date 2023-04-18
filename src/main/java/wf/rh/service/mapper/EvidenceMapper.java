package wf.rh.service.mapper;

import org.mapstruct.*;
import wf.rh.domain.Evidence;
import wf.rh.domain.Training;
import wf.rh.service.dto.EvidenceDTO;
import wf.rh.service.dto.TrainingDTO;

/**
 * Mapper for the entity {@link Evidence} and its DTO {@link EvidenceDTO}.
 */
@Mapper(componentModel = "spring")
public interface EvidenceMapper extends EntityMapper<EvidenceDTO, Evidence> {
    @Mapping(target = "training", source = "training", qualifiedByName = "trainingId")
    EvidenceDTO toDto(Evidence s);

    @Named("trainingId")
    @BeanMapping(ignoreByDefault = false)
    @Mapping(target = "id", source = "id")
    TrainingDTO toDtoTrainingId(Training training);
}
