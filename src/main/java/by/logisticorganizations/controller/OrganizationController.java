package by.logisticorganizations.controller;

import by.logisticorganizations.dto.OrganizationDto;
import by.logisticorganizations.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/organizations")
@Tag(name = "Контроллер для получения информации по организациям")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    @GetMapping
    @Operation(summary = "Получить информацию обо всех организациях")
    public Iterable<OrganizationDto> getAllOrganizations() {
        return organizationService.getAllOrganizations();
    }

    @GetMapping("/{name}")
    @Operation(summary = "Получить информацию об организации по названию")
    public OrganizationDto getOrganizationByName(@PathVariable String name) {
        return organizationService.getOrganizationByName(name);
    }

    @PostMapping("/new")
    @Operation(summary = "Создать новую организацию")
    public ResponseEntity<String> createContract(@RequestBody OrganizationDto organization) {
        organizationService.createOrganization(organization);
        return new ResponseEntity<>("Organization has been created", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить организацию по ID")
    public void deleteContract(@PathVariable UUID id) {
        organizationService.deleteOrganizationById(id);
    }
}
