package com.shubham.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shubham.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Serializable> {

}
