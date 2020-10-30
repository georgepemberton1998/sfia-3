package com.qa.backend.service;

import com.qa.backend.domain.Solutions;
import com.qa.backend.dto.SolutionsDTO;
import com.qa.backend.rest.SolutionsController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;


@RunWith(MockitoJUnitRunner.class)
public class SolutionsUnitTest {
    @InjectMocks
    private SolutionsController solutionsController;

    @Mock
    private SolutionsService solutionsService;

    private List<Solutions> solutionsList;

    private Solutions testSolutions;

    private long id = 1L;

    private Solutions testSolutionsWithID;

    private SolutionsDTO solutionsDTO;

    private final ModelMapper modelMapper = new ModelMapper();

    private SolutionsDTO mapToDTO(Solutions solutions) {
        return this.modelMapper.map(solutions, SolutionsDTO.class);
    }

    @Before
    public void setUp(){
        this.solutionsList = new ArrayList<>();
        this.testSolutions = new Solutions("nginx");
        solutionsList.add(testSolutions);
        this.testSolutionsWithID = new Solutions(testSolutions.getSolutionDesc());
        this.testSolutionsWithID.setId(id);
        this.solutionsDTO = this.mapToDTO(testSolutionsWithID);
    }


    @Test
    public void getAllSolutionsTest() {
        when(solutionsService.getSolutions())
                .thenReturn(this.solutionsList.stream().map(this::mapToDTO).collect(Collectors.toList()));
        assertFalse("Controller has found no solutions", this.solutionsController.getSolutions().getBody().isEmpty());
        verify(solutionsService, times(1)).getSolutions();
    }

    @org.junit.Test
    public void createSolutionsTest() {
        when(this.solutionsService.createSolution(testSolutions)).thenReturn(this.solutionsDTO);
        assertEquals(new ResponseEntity<SolutionsDTO>(this.solutionsDTO, HttpStatus.CREATED), this.solutionsController.createSolution(testSolutions));
        verify(this.solutionsService, times(1)).createSolution(this.testSolutions);
    }

    @Test
    public void deleteSolutionsTest() {
        this.solutionsController.deleteSolution(id);
        verify(this.solutionsService, times(1)).deleteSolution(id);
    }

    @Test
    public void findSolutionsByIDTest() {
        when(this.solutionsService.findSolutionById(this.id))
                .thenReturn(this.solutionsDTO);
        assertEquals(
                new ResponseEntity<SolutionsDTO>(this.solutionsDTO, HttpStatus.OK),
                this.solutionsController.getSolutionById(this.id)
        );
        verify(this.solutionsService, times(1)).findSolutionById(this.id);
    }

    @Test
    public void updateSolutionsTest() {
        Solutions newSolutions = new Solutions("nginx");
        Solutions updateSolutions = new Solutions(newSolutions.getSolutionDesc());
        updateSolutions.setId(this.id);
        when(this.solutionsService.updateSolution(this.id, newSolutions)).thenReturn(this.mapToDTO(updateSolutions));
        assertEquals(new ResponseEntity<SolutionsDTO>(this.mapToDTO(updateSolutions), HttpStatus.ACCEPTED), this.solutionsController.updateSolution(this.id, newSolutions));
        verify(this.solutionsService, times(1)).updateSolution(this.id, newSolutions);
    }



}