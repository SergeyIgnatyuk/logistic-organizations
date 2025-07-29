package by.logisticorganizations.controller;

import by.logisticorganizations.service.OrganizationService;
import by.logisticspec.api.OrganizationApi;
import by.logisticspec.model.OrganizationDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/organizations")
@RequiredArgsConstructor
public class OrganizationController implements OrganizationApi {

    private final OrganizationService organizationService;

    @Override
    public ResponseEntity<List<OrganizationDto>> getOrganizations() {
        return new ResponseEntity<>(organizationService.getAllOrganizations(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrganizationDto> getOrganizationByName(String name) {
        return new ResponseEntity<>(organizationService.getOrganizationByName(name), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> createOrganization(OrganizationDto organization) {
        organizationService.createOrganization(organization);
        return new ResponseEntity<>("Organization has been created", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить организацию по ID")
    public void deleteContract(@PathVariable UUID id) {
        organizationService.deleteOrganizationById(id);
    }
}
