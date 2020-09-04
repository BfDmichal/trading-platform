package com.BfDmichal.tradingplatform.repositories;

import com.BfDmichal.tradingplatform.domain.User;
import com.BfDmichal.tradingplatform.domain.UserDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    @Override
    List<User> findAll();

    @Override
    User save(User user);

    @Override
    Optional<User> findById(Integer integer);

}
