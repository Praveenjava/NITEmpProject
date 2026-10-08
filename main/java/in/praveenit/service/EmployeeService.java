package in.praveenit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.praveenit.entity.Employee;
import in.praveenit.repo.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	public List<Employee> getAll() {
		return repo.findAll();
	}

	public Employee save(Employee emp) {
		return repo.save(emp);
	}
}
