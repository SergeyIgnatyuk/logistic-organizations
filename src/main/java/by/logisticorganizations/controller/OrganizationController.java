package by.logisticorganizations.controller;

import by.logisticorganizations.service.OrganizationService;
import by.logisticspec.api.OrganizationApi;
import by.logisticspec.model.OrganizationDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<OrganizationDto> createOrganization(OrganizationDto organization) {
        return new ResponseEntity<>(organizationService.createOrganization(organization), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить организацию по ID")
    public void deleteContract(@PathVariable UUID id) {
        organizationService.deleteOrganizationById(id);
    }
}
