package com.qa.backend.rest;

import com.qa.backend.domain.Solutions;
import com.qa.backend.dto.SolutionsDTO;
import com.qa.backend.service.SolutionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SolutionsController {
    private final SolutionsService solutionsService;
    @Autowired
    public SolutionsController(SolutionsService solutionsService) {
        this.solutionsService = solutionsService;
    }

    @GetMapping("/solutions/getSolutions")
    public ResponseEntity<List<SolutionsDTO>> getSolutions(){
        return ResponseEntity.ok(this.solutionsService.getSolutions());
    }

    @PostMapping("/solutions/createSolution")
    public ResponseEntity<SolutionsDTO> createSolution(@RequestBody Solutions solutions){
        return new ResponseEntity<SolutionsDTO>(this.solutionsService.createSolution(solutions), HttpStatus.CREATED);
    }

    @PutMapping("/solutions/updateSolution/{id}")
    public ResponseEntity<SolutionsDTO> updateSolution(@PathVariable Long id, @RequestBody Solutions solutions){
        return new ResponseEntity<SolutionsDTO>(this.solutionsService.updateSolution(id, solutions), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/solutions/deleteSolution/{id}")
    public ResponseEntity<?> deleteSolution(@PathVariable Long id){
        return this.solutionsService.deleteSolution(id)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }

    @GetMapping("/solutions/getSolutionById/{id}")
    public ResponseEntity<SolutionsDTO> getSolutionById(@PathVariable Long id){
        return ResponseEntity.ok(this.solutionsService.findSolutionById(id));

    }

}
