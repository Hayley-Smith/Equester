package com.example.FFTEquester.data;

import com.example.FFTEquester.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Integer> {

    boolean existsByGooglePrincipalName(String googlePrincipalName);
    User findByGooglePrincipalName(String googlePrincipalName);
}