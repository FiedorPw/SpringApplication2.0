package bada_bdbt_proj;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class DatabaseUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         throws UsernameNotFoundException {
//            UserCredentials userCredentials =
//                    userRepository.findByUsername(username);
//            return userDetailsMapper.toUserDetails(userCredentials);
        return null;
    }
}
