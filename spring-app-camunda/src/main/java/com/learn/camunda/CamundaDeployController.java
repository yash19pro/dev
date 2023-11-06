// package com.learn.camunda;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.MediaType;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.multipart.MultipartFile;

// @RestController("/camunda")
// public class CamundaDeployController {

//     private CamundaDeployService camundaDeployService;

//     @PostMapping(value = "/deploy", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//     public ResponseEntity<CamundaDeployResponse> deploy(@RequestParam("file") MultipartFile file) {
//         return ResponseEntity.ok(camundaDeployService.deploy(file));
//     }

// }
