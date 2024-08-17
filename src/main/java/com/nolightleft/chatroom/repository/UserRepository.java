package com.nolightleft.chatroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nolightleft.chatroom.entity.User;

/**
 * <p>
 * Title: {@link UserRepository}
 * </p>
 * <b>Description:</b>
 * <p>
 * Insert Description here
 * </p>
 *
 * @author lzu
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
