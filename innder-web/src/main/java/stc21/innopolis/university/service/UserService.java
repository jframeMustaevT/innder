package stc21.innopolis.university.service;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stc21.innopolis.university.domain.Registration;
import stc21.innopolis.university.entity.Authority;
import stc21.innopolis.university.entity.User;
import stc21.innopolis.university.entity.UserStatus;
import stc21.innopolis.university.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional // оборачивает все методы в транзакции
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
  private final UserRepository repository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    try {
      return repository.findByUsername(username);
    } catch (EmptyResultDataAccessException e) {
      throw new UsernameNotFoundException("Username not found");
    }
  }

  public void register(Registration data) {
    // 1. уникальный ли логин
    // 2. сравниваем пароли
    if (!data.getPassword().equals(data.getConfirm())) {
      throw new RuntimeException("Пароли не совпадают");
    }
    // 3. сохраняем
    User user = new User(
            0L,
            new ArrayList<Authority>(),
            "",
            data.getUsername(),
            passwordEncoder.encode(data.getPassword()),
            "",
            "",
            "",
            UserStatus.ACTIVE,
            "",
            "",
            true,
            true,
            true,
            true);
    repository.save(user);
  }
}
