package uni.ami.todoproject.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uni.ami.todoproject.exceptions.ResourceNotFoundException;
import uni.ami.todoproject.model.UserAccount;
import uni.ami.todoproject.repository.UserAccountRepository;
import uni.ami.todoproject.service.UserAccountService;

@Service
public class UserAccoountServiceImpl implements UserAccountService {

    @Autowired
    UserAccountRepository userAccountRepository;

    @Override
    public UserAccount save(UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        if (userAccountRepository.findById(id).isPresent()) {
            userAccountRepository.delete(userAccountRepository.findById(id).get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public UserAccount update(Long id, UserAccount userAccount) {
        return userAccountRepository.findById(id)
                .map(userAccount_temp -> {
                    userAccount_temp.setSelfDescription(userAccount.getSelfDescription());
                    userAccount_temp.setFullName(userAccount.getFullName());
                    userAccount_temp.setBirthDate(userAccount.getBirthDate());
                    userAccount_temp.setAvatar(userAccount.getAvatar());

                    return userAccountRepository.save(userAccount_temp);
                }).orElseThrow(new ResourceNotFoundException("Аккаунта с таки ID не существует"));
    }

    @Override
    public Page<UserAccount> getAll(Pageable pageable) {
        return userAccountRepository.findAll(pageable);
    }
}
