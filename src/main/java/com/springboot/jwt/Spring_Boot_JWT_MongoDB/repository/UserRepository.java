package com.springboot.jwt.Spring_Boot_JWT_MongoDB.repository;

import com.springboot.jwt.Spring_Boot_JWT_MongoDB.model.User;
//import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId>{
}
