package app.Security;

import app.modules.Account;
import app.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    private final UserManager accountManager;

    @Autowired
    public UserDetailsServiceImp(UserManager accountManager) {
        this.accountManager = accountManager;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Account account = null;
        try {
            account = accountManager.getAccountByUsernameOrThrow(s);
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
        }
        assert account != null;
        return CustomerUserDetails.build(account);
    }
}
