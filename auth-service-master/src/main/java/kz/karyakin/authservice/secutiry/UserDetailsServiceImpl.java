package kz.karyakin.authservice.secutiry;

import kz.karyakin.authservice.secutiry.entity.Employee;
import kz.karyakin.authservice.secutiry.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        Optional<Employee> employee = employeeRepository.findById(Long.valueOf(id));
        if (employee.isEmpty())
            throw new UsernameNotFoundException("User with id: " + id + " is not found");

        return employee.get();
    }

}
