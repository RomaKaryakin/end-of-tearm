package kz.karyakin.employeeservice.service;

import kz.karyakin.employeeservice.model.entity.Employee;
import kz.karyakin.employeeservice.repository.EmployeeRepository;
import kz.karyakin.employeeservice.model.dto.EmployeeDTO;
import kz.karyakin.employeeservice.util.ExceptionUtils;
import kz.karyakin.employeeservice.util.MessageCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService implements UserDetailsService {

    private final EmployeeRepository employeeRepository;
    private final ExceptionUtils exceptionUtils;

    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setSalary(employeeDTO.getSalary());
        employee.setBirthDate(employeeDTO.getBirthDate());
        employee.setPassword(passwordEncoder().encode(employeeDTO.getPassword()));

        employee = employeeRepository.save(employee);
        employeeDTO.setId(employee.getId());

        return employeeDTO;

    }

    public Employee getEmployee(Long id){
        if(!employeeRepository.existsById(id)){
            exceptionUtils.throwDefaultException(MessageCode.EMPLOYEE_DOES_NOT_EXISTS);
        }

        return employeeRepository.findById(id).get();

    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(Long.valueOf(id));

        if (employee.isEmpty())
            throw new UsernameNotFoundException("User with id: " + id + " is not found");

        return employee.get();
    }
}
