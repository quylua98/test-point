package com.quylua98.repo;

import com.quylua98.entity.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepo extends CrudRepository<Detail, Long> {
}
