package com.LMS.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LMS.model.Bag;

public interface BagRepo extends JpaRepository<Bag, Long> {

    Bag findBagByBagId(String id);
}
