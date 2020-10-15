package com.qa.backend.dto;

public class SolutionsDTO {
    private long id;
    private String solutionDesc;

    public SolutionsDTO() {

    }
    public SolutionsDTO(String solutionDesc) {
        super();
        this.solutionDesc = solutionDesc;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSolutionDesc() {
        return solutionDesc;
    }

    public void setSolutionDesc(String solutionDesc) {
        this.solutionDesc = solutionDesc;
    }

}
