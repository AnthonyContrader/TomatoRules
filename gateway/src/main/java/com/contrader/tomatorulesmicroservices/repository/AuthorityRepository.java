package com.contrader.tomatorulesmicroservices.repository;

import com.contrader.tomatorulesmicroservices.domain.Authority;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the Authority entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
