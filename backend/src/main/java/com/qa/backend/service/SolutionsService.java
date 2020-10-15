package com.qa.backend.service;

import com.qa.backend.repo.SolutionsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class SolutionsService {
    private final SolutionsRepository SolutionsRepository;
    private final ModelMapper mapper;
    public SolutionsService(SolutionsRepository solutionsRepository, ModelMapper mapper) {
        SolutionsRepository = solutionsRepository;
        this.mapper = mapper;
    }


}
