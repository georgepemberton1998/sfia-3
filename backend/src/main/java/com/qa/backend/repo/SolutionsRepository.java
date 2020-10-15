package com.qa.backend.repo;

import com.qa.backend.domain.Solutions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolutionsRepository extends JpaRepository<Solutions, Long> {
}
