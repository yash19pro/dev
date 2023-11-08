package com.learn.camunda;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.migration.MigrationPlan;
import org.springframework.stereotype.Service;

import org.json.JSONObject;

@Service
public class Utils {

    private static RuntimeService runtimeService;

    public Utils(RuntimeService runtimeService) {
        Utils.runtimeService = runtimeService;
    }

    public static void migrateProcessInstance(String processInstanceId, String sourceProcessDefinitionId,
            String targetProcessDefinitionId) {

        System.out.println("Starting the migration process");

        MigrationPlan migrationPlan = runtimeService
                .createMigrationPlan(sourceProcessDefinitionId, targetProcessDefinitionId)
                .mapEqualActivities()
                .build();

        System.out.println(migrationPlan);

        runtimeService
                .newMigration(migrationPlan)
                .processInstanceIds(processInstanceId)
                .execute();

        System.out.println("Migration Completed!!");
    }

    public static Map<String, Object> getVariables(String processInstanceId) {
        return runtimeService.getVariables(processInstanceId);
    }

    public static Object getVariable(String processInstanceId, String variableName) {
        return runtimeService.getVariable(processInstanceId, variableName);
    }

    public static JSONObject generateErrorMessage(Object errorCode, String error, String errorMessage) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", errorCode);
        response.put("error", error);
        response.put("message", errorMessage);

        return new JSONObject(response);
    }
}

// UserDetailsProcess:3:09a17c20-7d44-11ee-aad2-acde48001122
// UserDetailsProcess:3:09a17c20-7d44-11ee-aad2-acde48001122