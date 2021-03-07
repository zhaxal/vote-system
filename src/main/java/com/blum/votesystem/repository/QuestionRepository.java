package com.blum.votesystem.repository;

import com.blum.votesystem.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}
