// package com.learn.camunda;

// import org.camunda.bpm.engine.RepositoryService;
// import org.camunda.bpm.engine.repository.Deployment;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// public class DeploymentController {
//     @Autowired
//     private RepositoryService repositoryService;

//     @GetMapping("/deploy-bpmn")
//     public String deployBpmn() {
//         // Provide the path to your BPMN file
//         String bpmnFilePath = "/bpmn/process.bpmn";

//         // Deploy the BPMN file
//         Deployment deployment = repositoryService.createDeployment()
//                 .addClasspathResource(bpmnFilePath)
//                 .deploy();

//         return "BPMN file deployed with ID: " + deployment.getId();
//     }
// }