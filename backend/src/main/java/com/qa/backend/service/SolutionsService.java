package com.qa.backend.service;

import com.qa.backend.domain.Solutions;
import com.qa.backend.dto.SolutionsDTO;
import com.qa.backend.exceptions.SolutionNotFoundException;
import com.qa.backend.repo.SolutionsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SolutionsService {
    private final SolutionsRepository SolutionsRepository;
    private final ModelMapper mapper;
    @Autowired
    public SolutionsService(SolutionsRepository solutionsRepository, ModelMapper mapper) {
        SolutionsRepository = solutionsRepository;
        this.mapper = mapper;
    }
    private SolutionsDTO mapToDTO(Solutions solutions){
        return this.mapper.map(solutions, SolutionsDTO.class);
    }

    public List<SolutionsDTO> getSolutions(){
        return this.SolutionsRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public SolutionsDTO createSolution(Solutions solutions){
        return this.mapToDTO(this.SolutionsRepository.save(solutions));
    }

    public SolutionsDTO findSolutionById(Long id){
        return this.mapToDTO(this.SolutionsRepository.findById(id).orElseThrow(SolutionNotFoundException::new));
    }

    public SolutionsDTO updateSolution(Long id, Solutions solutions){
        Solutions update = this.SolutionsRepository.findById(id).orElseThrow(SolutionNotFoundException::new);
        update.setSolutionDesc(solutions.getSolutionDesc());
        return this.mapToDTO(this.SolutionsRepository.save(update));
    }

    public Boolean deleteSolution(Long id){
        if(!this.SolutionsRepository.existsById(id)){
            throw new SolutionNotFoundException();
        }
        this.SolutionsRepository.deleteById(id);
        return this.SolutionsRepository.existsById(id);
    }


}
