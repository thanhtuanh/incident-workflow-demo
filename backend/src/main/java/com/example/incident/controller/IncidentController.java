package com.example.incident.controller;

import com.example.incident.model.Incident;
import com.example.incident.model.Status;
import com.example.incident.service.IncidentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidents")
@CrossOrigin(origins = "*")
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    @PostMapping
    public Incident createIncident(@RequestBody Incident incident) {
        return incidentService.createIncident(incident);
    }

    @PutMapping("/{id}/status")
    public Incident updateStatus(@PathVariable Long id, @RequestParam Status status) {
        return incidentService.updateStatus(id, status);
    }

    @GetMapping
    public List<Incident> getAll() {
        return incidentService.getAllIncidents();
    }
}
