package com.app.cinema.controller;

import com.app.cinema.dto.TemplateDto;
import com.app.cinema.service.TemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/templates")
public class TemplateController {

    private final TemplateService templateService;

    @GetMapping("/{page}/{size}")
    public Page<TemplateDto> findAllTemplate(@PathVariable Integer page, @PathVariable Integer size) {
        return templateService.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public TemplateDto findOneTemplateById(@PathVariable Long id) {
        return templateService.findOne(id);
    }

    @PostMapping
    public TemplateDto addTemplate(@RequestBody TemplateDto templateDto) {
        return templateService.add(templateDto);
    }

    @PutMapping("/{id}")
    public TemplateDto updateTemplate(@PathVariable Long id, @RequestBody TemplateDto templateDto) {
        return templateService.update(id, templateDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTemplate(@PathVariable Long id) {
        templateService.deleteById(id);
    }

    @PostMapping("/download")
    public ResponseEntity<byte[]> downloadFile(@RequestBody TemplateDto templateDto) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/pdf");
        byte[] bytes = templateService.generateTicket(1L);
        httpHeaders.set("Content-Length", String.valueOf(bytes.length));
        httpHeaders.set("Content-Disposition", "attachment;filename=ticket.pdf");
        return new ResponseEntity<>(bytes, httpHeaders, HttpStatus.CREATED);
    }

}
