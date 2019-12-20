package stc21.innopolis.university.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import stc21.innopolis.university.entity.User;



@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    public User findByUsername(String username);

    public User findByTelegramName(String telegramName);
}