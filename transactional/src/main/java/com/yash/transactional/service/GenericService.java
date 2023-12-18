package com.yash.transactional.service;

import com.yash.transactional.models.User;
import com.yash.transactional.repository.UserRepository;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class GenericService {

    private final UserRepository userRepository;
    private final RuntimeService runtimeService;
    private final Boolean doFail = true;

    public GenericService(UserRepository userRepository, RuntimeService runtimeService) {
        this.userRepository = userRepository;
        this.runtimeService = runtimeService;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        Optional<User> fetchedUser = userRepository.findById(id);

        if (fetchedUser.isPresent()) {
            User existingUser = fetchedUser.get();
            existingUser.setName(user.getName());
            existingUser.setUsername(user.getUsername());

            return userRepository.save(existingUser);
        }

        System.out.println("User Not Found");
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public String startProcess(String processDefinitionKey) {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey);
        System.out.println("processInstance = " + processInstance.getProcessInstanceId());
        return processInstance.getProcessInstanceId();
    }

    public String startProcess(String processDefinitionKey, Map<String, Object> variables) {
        ProcessInstance processInstance = runtimeService.startProcessInstanceById(processDefinitionKey, variables);
        return processInstance.getProcessInstanceId();
    }

    private void createUsers() {
        User yash = new User("yash", "Yash Patel");
        User rutvik = new User("rutvik", "Rutvik Choudhari");

        userRepository.save(yash);
        userRepository.save(rutvik);
    }

    private void startingProcesses() {
        String process1 = startProcess("testProcess");
        String process2 = startProcess("testProcess");

        System.out.println("process1 = " + process1);
        System.out.println("process2 = " + process2);
    }

//    @Transactional
    public void testingScenario1() {
        // adding data in the custom table first and then in the camunda tables

        // adding users
        createUsers();

        // throwing exception
        if (doFail) {
            System.out.println("throwing exception");
            throw new RuntimeException();
        }

        // starting camunda process
        startingProcesses();
    }

//    @Transactional
    public void testingScenario2() {
        // adding data in the camunda tables first and then in the custom table

        // starting camunda process
        startingProcesses();


        // throwing exception
        if (doFail) {
            System.out.println("throwing exception");
            throw new RuntimeException();
        }

        // adding users
        createUsers();
    }
}
