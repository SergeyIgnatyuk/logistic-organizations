package by.logisticorganizations.service;

import by.logisticorganizations.dto.OrganizationDto;
import by.logisticorganizations.mapper.OrganizationMapper;
import by.logisticorganizations.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper organizationMapper;

    public List<OrganizationDto> getAllOrganizations() {
        return organizationMapper.toOrganizationDtos(organizationRepository.findAll());
    }

    public OrganizationDto getOrganizationById(UUID id) {
        return organizationRepository.findById(id).map(organizationMapper::toOrganizationDto).orElse(null);
    }

    public void createOrganization(OrganizationDto organizationDto) {
        organizationRepository.save(organizationMapper.toOrganization(organizationDto));
    }

    public void deleteOrganizationById(UUID id) {
        organizationRepository.deleteById(id);
    }
}
