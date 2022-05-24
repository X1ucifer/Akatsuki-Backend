package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Series;

public interface SeriesRepo extends JpaRepository<Series, Long>{

}
