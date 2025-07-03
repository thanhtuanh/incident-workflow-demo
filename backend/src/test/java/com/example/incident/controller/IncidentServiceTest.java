package com.example.incident.controller;

import com.example.incident.model.Incident;
import com.example.incident.model.Priority;
import com.example.incident.model.Status;
import com.example.incident.repository.IncidentRepository;
import com.example.incident.service.IncidentService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class IncidentServiceTest {

    @Mock
    private IncidentRepository incidentRepository;

    @InjectMocks
    private IncidentService incidentService;

    @Test
    void testCreateIncident() {
        // Arrange
        Incident input = new Incident();
        input.setTitle("VPN Problem");
        input.setDescription("No VPN since morning");
        input.setPriority(Priority.HIGH);

        Incident saved = new Incident();
        saved.setId(1L);
        saved.setTitle(input.getTitle());
        saved.setDescription(input.getDescription());
        saved.setPriority(input.getPriority());
        saved.setStatus(Status.OPEN);

        when(incidentRepository.save(any(Incident.class))).thenReturn(saved);

        // Act
        Incident result = incidentService.createIncident(input);

        // Assert
        assertThat(result.getStatus()).isEqualTo(Status.OPEN);
        assertThat(result.getTitle()).isEqualTo("VPN Problem");
        verify(incidentRepository, times(1)).save(any(Incident.class));
    }
}
