package com.yash.transactional.controllers;

import com.yash.transactional.service.GenericService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/camunada")
public class CamundaController {

    private final GenericService genericService;

    public CamundaController(GenericService genericService) {
        this.genericService = genericService;
    }

    @PostMapping("/startProcess/{processDefinitionKey}")
    public String startProcess(@PathVariable String processDefinitionKey) {
        return genericService.startProcess(processDefinitionKey);
    }

    @PostMapping("/startProcessWithVariables/{processDefinitionKey}")
    public String startProcessWithVariables(@PathVariable String processDefinitionKey, Map<String, Object> variables) {
        return genericService.startProcess(processDefinitionKey, variables);
    }
}
