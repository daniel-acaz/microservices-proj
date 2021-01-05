package br.com.broscoder.hrworker.controller;

import br.com.broscoder.hrworker.model.Worker;
import br.com.broscoder.hrworker.repository.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

    private static Logger logger = LoggerFactory.getLogger(WorkerController.class);

    @Autowired
    private Environment env;

    @Autowired
    private WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> list = repository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/configs")
    public ResponseEntity<?> getConfig() {
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        logger.info("PORT = " + env.getProperty("local.server.port"));

        Optional<Worker> worker = repository.findById(id);
        if(worker.isPresent()) {
            return ResponseEntity.ok(worker.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
