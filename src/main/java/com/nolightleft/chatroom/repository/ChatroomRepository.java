package com.nolightleft.chatroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nolightleft.chatroom.entity.Chatroom;

/**
 * <p>
 * Title: {@link ChatroomRepository}
 * </p>
 * <b>Description:</b>
 * <p>
 * Insert Description here
 * </p>
 *
 * @author lzu
 */
@Repository
public interface ChatroomRepository extends JpaRepository<Chatroom, Long>{

}
