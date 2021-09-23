package com.friendsapplication.gurukulam.repository;

import com.friendsapplication.gurukulam.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GurukulamRepo extends CrudRepository<Users, Integer> {
    public Optional<Users> findByUserid(String userid);
}
