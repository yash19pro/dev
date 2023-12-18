package com.yash.transactional.controllers;

import com.yash.transactional.service.GenericService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    private final GenericService genericService;

    public TestController(GenericService genericService) {
        this.genericService = genericService;
    }

    @GetMapping("/testingScenario1")
    public void testingScenario1() {
        genericService.testingScenario1();
    }

    @GetMapping("/testingScenario2")
    public void testingScenario2() {
        genericService.testingScenario2();
    }
}
