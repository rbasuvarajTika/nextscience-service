package com.nextscience.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nextscience.entity.RxChecklist;

@Repository
public interface RxChecklistRepository extends JpaRepository<RxChecklist, Integer>{
	

}
