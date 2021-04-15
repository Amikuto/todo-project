package uni.ami.todoproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uni.ami.todoproject.model.User;
import uni.ami.todoproject.model.UserAccount;
import uni.ami.todoproject.serviceImpl.UserAccoountServiceImpl;

import javax.validation.ReportAsSingleViolation;
import javax.validation.Valid;

@RestController
public class UserAccountController {

    @Autowired
    UserAccoountServiceImpl userAccoountService;

    @GetMapping("/user-accounts")
    public Page<UserAccount> getAllUserAccounts(Pageable pageable) {
        return userAccoountService.getAll(pageable);
    }

    @PostMapping("/user-accounts")
    public UserAccount createUserAccount(@Valid @RequestBody UserAccount userAccount) {
        return userAccoountService.save(userAccount);
    }

    @PutMapping("/user-accounts/{userAccountId}")
    public UserAccount updateUserAccount(@Valid @PathVariable Long userAccountId,
                                         @Valid @RequestBody UserAccount userAccount) {
        return userAccoountService.update(userAccountId, userAccount);
    }
}
