package com.example.task2_3.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;

import com.example.task2_3.HeadService.HeadService;

@Controller
@RequestMapping("/api/v2_3/employee")
public class EmployeeController {

	@Autowired
	private HeadService headService;// head service

	@GetMapping("/process/{readerCriteria}/{writerCriteria}")
	public void processEmployees(@PathVariable String readerCriteria, @PathVariable String writerCriteria)
			throws Exception {
		headService.process(readerCriteria, writerCriteria);
	}

}
