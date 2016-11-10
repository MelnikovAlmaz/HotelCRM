package security;

import entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthProviderImpl implements AuthenticationProvider {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String phoneNumber = authentication.getName();
        String password = authentication.getCredentials().toString();

        Employee employee = employeeRepository.findEmployeeByPhoneNumber(phoneNumber);
        List<GrantedAuthority> authorities = new ArrayList<>();
        UsernamePasswordAuthenticationToken person = null;

        if (employee != null && employee.getPassword() != null){
            if (!password.equals(employee.getPassword())) {
                throw new BadCredentialsException("invalid password");
            }
            authorities.add(new SimpleGrantedAuthority(employee.getRole().getName()));
            person = new UsernamePasswordAuthenticationToken(employee, null, authorities);
        }
        return person;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
