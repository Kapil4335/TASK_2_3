package com.example.task2_3.HeadService.WriterService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.task2_3.Entity.EmployeeEntity;
import com.example.task2_3.HeadService.WriterService.DBWriterService.DBWriter;
import com.example.task2_3.HeadService.WriterService.FileWriterService.ExcelWriterService;
import com.example.task2_3.HeadService.WriterService.FileWriterService.PipeWriterService;
import com.example.task2_3.HeadService.WriterService.FileWriterService.XmlWriterService;
import com.example.task2_3.HeadService.WriterService.FileWriterService.CsvWriterService;

@Service
public class WriterServiceFactory {
	@Autowired
	private PipeWriterService pipeWriterService;
	@Autowired
	private CsvWriterService csvWriterService;
	@Autowired
	private ExcelWriterService excelWriterService;
	@Autowired
	private XmlWriterService xmlWriterService;
	@Autowired
	private DBWriter dbWriter;

	public WriterService getWriter(List<EmployeeEntity> employeeList, String writerCriteria) {
		switch (writerCriteria) {
		case "pipe": {
			return pipeWriterService;
		}
		case "csv": {
			return csvWriterService;
		}
		case "excel": {
			return excelWriterService;
		}
		case "xml": {
			return xmlWriterService;
		}
		case "dbwrite": {
			return dbWriter;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + writerCriteria);
		}
	}
}
