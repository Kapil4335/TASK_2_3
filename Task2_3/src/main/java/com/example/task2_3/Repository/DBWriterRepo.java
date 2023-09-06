package com.example.task2_3.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.task2_3.Entity.DBWriterEntity;


@Repository
public interface DBWriterRepo extends JpaRepository<DBWriterEntity, Integer> {}




