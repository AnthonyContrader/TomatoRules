package com.contrader.tomatorulesmicroservices.repository;

import com.contrader.tomatorulesmicroservices.domain.Tool;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Tool entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ToolRepository extends JpaRepository<Tool, Long> {

}
