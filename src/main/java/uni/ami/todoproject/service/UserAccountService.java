package uni.ami.todoproject.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import uni.ami.todoproject.model.UserAccount;

public interface UserAccountService {

    UserAccount save(UserAccount userAccount);

    ResponseEntity<?> delete(Long id);

    UserAccount update(Long id, UserAccount userAccount);

    Page<UserAccount> getAll(Pageable pageable);
}
