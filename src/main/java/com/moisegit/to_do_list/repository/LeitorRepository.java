package com.moisegit.to_do_list.repository;

import com.moisegit.to_do_list.model.LeitorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeitorRepository extends JpaRepository<LeitorEntity, Integer> {
}
