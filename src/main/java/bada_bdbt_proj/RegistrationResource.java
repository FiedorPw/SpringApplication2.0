package bada_bdbt_proj;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class RegistrationResource {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // constructor ...

    @PostMapping("/registration")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void register(@RequestBody UserCredentialsDto userCredentialsDto) {
        UserCredentials user = UserCredentials.builder()
                .enabled(true)
                .username(userCredentialsDto.getUsername())
                .password(passwordEncoder.encode(userCredentialsDto.getPassword()))
                .roles(Set.of("USER"))
                .build();
        userRepository.save(user);
    }
}
