package com.example.task2_3.HeadService.ReaderService.DBReaderService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.task2_3.Entity.EmployeeEntity;
import com.example.task2_3.HeadService.ReaderService.ReaderService;
import com.example.task2_3.Repository.EmployeeRepo;

@Service
public class DBReaderService implements ReaderService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public List<EmployeeEntity> getData() {
		return employeeRepo.findAll();
	}

}
