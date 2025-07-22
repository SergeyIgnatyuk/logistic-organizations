package by.logisticorganizations.mapper;

import by.logisticorganizations.dto.OrganizationDto;
import by.logisticorganizations.entity.Organization;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedSourcePolicy = IGNORE, unmappedTargetPolicy = IGNORE)
public interface OrganizationMapper {

    OrganizationDto toOrganizationDto(Organization organization);

    List<OrganizationDto> toOrganizationDtos(List<Organization> organizations);

    Organization toOrganization(OrganizationDto organizationDto);
}
