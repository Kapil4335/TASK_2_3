package com.example.task2_3.HeadService.ReaderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.task2_3.HeadService.ReaderService.DBReaderService.DBReaderService;
import com.example.task2_3.HeadService.ReaderService.FileReaderService.ExcelReaderService;

@Service
public class ReaderServiceFactory  {
	
	@Autowired
	private DBReaderService dbReaderService;
	@Autowired
	private ExcelReaderService excelReaderService;

	public ReaderService dataReader(String readerCriteria) {
		
		switch (readerCriteria) {
		case "excelread": {
			return excelReaderService;
		}
		case "dbread":{
			return dbReaderService;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + readerCriteria);
		}
	}
}
