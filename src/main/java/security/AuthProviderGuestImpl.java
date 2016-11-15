package security;

import entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import repository.GuestRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthProviderGuestImpl implements AuthenticationProvider {
    @Autowired
    private GuestRepository guestRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String phoneNumber = authentication.getName();
        String password = authentication.getCredentials().toString();

        Guest guest = guestRepository.findGuestByPhoneNumber(phoneNumber);
        List<GrantedAuthority> authorities = new ArrayList<>();
        UsernamePasswordAuthenticationToken person = null;

        if (guest != null && guest.getPassword() != null){
            if (!password.equals(guest.getPassword())) {
                throw new BadCredentialsException("invalid password");
            }
            authorities.add(new SimpleGrantedAuthority(guest.getRole().getName()));
            person = new UsernamePasswordAuthenticationToken(guest, null, authorities);
        }
        return person;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
