package com.learn.camunda;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.json.JSONObject;

@RestController
public class Controller {
    @GetMapping(value = "/getVariables")
    public ResponseEntity<Map<String, Object>> getVariablesOfProcessInstanceId(
            @RequestParam("processInstanceId") String processInstanceId) {
        return new ResponseEntity<>(new JSONObject(Utils.getVariables(processInstanceId)).toMap(), HttpStatus.OK);
    }

    @GetMapping(value = "/getVariable")
    public ResponseEntity<Object> getVariableOfProcessInstanceId(
            @RequestParam("processInstanceId") String processInstanceId,
            @RequestParam("variableName") String variableName) {
        Object variableValue = Utils.getVariable(processInstanceId, variableName);

        return null != variableValue ? new ResponseEntity<>(variableValue, HttpStatus.OK)
                : new ResponseEntity<>(Utils.generateErrorMessage(Integer.valueOf(HttpStatus.NOT_FOUND.value()),
                        HttpStatus.NOT_FOUND.getReasonPhrase(),
                        "[" + variableName + "] not found for the given processInstanceId [" + processInstanceId + "]")
                        .toMap(), HttpStatus.NOT_FOUND);
    }

    // @PostMapping

    @GetMapping("/migrate")
    public String migrateProcess() {
        String processInstanceId = "45962339-7d35-11ee-a31a-acde48001122";
        String sourceProcessDefinitionId = "UserDetailsProcess:2:8399fe01-7d35-11ee-9710-acde48001122";
        String targetProcessDefinitionId = "UserDetailsProcess:3:09a17c20-7d44-11ee-aad2-acde48001122";

        System.out.println("Migrating the process with: ");
        System.out.println("processInstanceId: " + processInstanceId);
        System.out.println("sourceProcessDefinitionId: " + sourceProcessDefinitionId);
        System.out.println("targetProcessDefinitionId: " + targetProcessDefinitionId);
        Utils.migrateProcessInstance(processInstanceId, sourceProcessDefinitionId, targetProcessDefinitionId);

        return "Success";
    }
}