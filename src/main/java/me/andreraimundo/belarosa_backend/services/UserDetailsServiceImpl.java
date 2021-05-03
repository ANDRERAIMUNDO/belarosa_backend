package me.andreraimundo.belarosa_backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import me.andreraimundo.belarosa_backend.domain.Registro;
import me.andreraimundo.belarosa_backend.repositories.RegistroRepository;
import me.andreraimundo.belarosa_backend.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private RegistroRepository registroRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       Registro reg = registroRepository.findByEmail(email);
       if (reg == null) {
           throw new UsernameNotFoundException(email);
       }
        return new UserSS(reg.getId(), reg.getEmail(), reg.getPassword(), reg.getPerfis());
    }
    
}
