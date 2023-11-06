// package com.learn.camunda;

// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.List;
// import org.camunda.bpm.engine.RepositoryService;
// import org.camunda.bpm.engine.repository.DeploymentWithDefinitions;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.web.multipart.MultipartFile;

// @Service
// public class CamundaDeployServiceImpl implements CamundaDeployService {

//     @Autowired
//     private RepositoryService repositoryService;

//     @Override
//     public CamundaDeployResponse deploy(MultipartFile file) {
//         CamundaDeployResponse camundaDeployResponse = new CamundaDeployResponse();
//         String orgFileName = file.getOriginalFilename();
//         System.out.println("Camunda file to be deployed " + orgFileName);
//         if (orgFileName.endsWith(".bpmn") || orgFileName.endsWith(".dmn")) {
//             try {
//                 System.out.println("Camunda Deployment START : " + orgFileName);
//                 DeploymentWithDefinitions d = null;
//                 d = repositoryService.createDeployment().addInputStream(orgFileName, file.getInputStream())
//                         .name(orgFileName).deployWithResult();
//                 camundaDeployResponse.setSuccessMessage(
//                         "Camunda Deployment SUCCESS [" + orgFileName + "] : Deployment ID [" + d.getId() + "]");
//                 System.out.println("Camunda Deployment SUCCESS " + orgFileName + " : Deployment ID " + d.getId());
//             } catch (IOException e) {
//                 camundaDeployResponse.setErrorMessage("Camunda Deployment FAILED : " + e.getMessage());
//                 System.out.println("Camunda Deployment FAILED " + orgFileName + " : " + e.getMessage());
//                 e.printStackTrace();
//             }
//         } else {
//             camundaDeployResponse.setErrorMessage("Not a valid Camunda file (BPMN/DMN)");
//             System.out.println("Not a valid Camunda file (BPMN/DMN)");
//         }
//         return camundaDeployResponse;
//     }
// }
