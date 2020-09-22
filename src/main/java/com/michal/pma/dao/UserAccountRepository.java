package com.michal.pma.dao;

import com.michal.pma.entities.UserAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, Long> {
}
