package com.ducphong.user_service.repository;

import com.ducphong.user_service.model.User;
import com.ducphong.user_service.projections.UserProjection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    @Query(fields = "{ 'id' : 1, 'email' : 1, 'password' : 1, 'role' : 1 }")
    List<UserProjection> findAllBy();
}