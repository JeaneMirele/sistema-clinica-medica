package com.jeanemirele.UBS.controllers;

import com.jeanemirele.UBS.domain.entity.Medico;
import com.jeanemirele.UBS.dtos.MedicoCreateDTO;
import com.jeanemirele.UBS.dtos.MedicoResponseDTO;
import com.jeanemirele.UBS.mappers.MedicoMapper;
import com.jeanemirele.UBS.service.MedicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/medicos")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class MedicoController {
    private final MedicoService medicoService;
    private final MedicoMapper medicoMapper;


    @GetMapping
    public ResponseEntity<List<MedicoResponseDTO>> getMedicos() {
        List<Medico> medicos = medicoService.findAll();
        List<MedicoResponseDTO> medicosDto = medicos.stream()
                .map(medicoMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(medicosDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoResponseDTO> getMedicoById(@PathVariable Long id) {
        Medico medico = medicoService.findByID(id);
        MedicoResponseDTO medicoResponseDTO = medicoMapper.toDto(medico);
        return ResponseEntity.ok(medicoResponseDTO);
    }

    @PostMapping
    public ResponseEntity<MedicoResponseDTO> createMedico(@Valid @RequestBody MedicoCreateDTO medicoCreateDTO) {
        Medico medico = medicoMapper.toEntity(medicoCreateDTO);
        medicoService.save(medico);
        MedicoResponseDTO medicoResponseDTO = medicoMapper.toDto(medico);
        return new ResponseEntity<>(medicoResponseDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteMedico(@PathVariable Long id) {
        medicoService.delete(id);
    }
}
