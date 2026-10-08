package in.praveenit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.praveenit.entity.Employee;
import in.praveenit.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
//@CrossOrigin("*")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping
	public List<Employee> getAll() {
		return service.getAll();
	}

	@PostMapping
	public Employee create(@RequestBody Employee emp) {
		return service.save(emp);
	}
}
