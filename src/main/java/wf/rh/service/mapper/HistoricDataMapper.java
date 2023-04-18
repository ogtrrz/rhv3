package wf.rh.service.mapper;

import org.mapstruct.*;
import wf.rh.domain.Employee;
import wf.rh.domain.HistoricData;
import wf.rh.service.dto.EmployeeDTO;
import wf.rh.service.dto.HistoricDataDTO;

/**
 * Mapper for the entity {@link HistoricData} and its DTO {@link HistoricDataDTO}.
 */
@Mapper(componentModel = "spring")
public interface HistoricDataMapper extends EntityMapper<HistoricDataDTO, HistoricData> {
    @Mapping(target = "employee", source = "employee", qualifiedByName = "employeeId")
    HistoricDataDTO toDto(HistoricData s);

    @Named("employeeId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    EmployeeDTO toDtoEmployeeId(Employee employee);
}
