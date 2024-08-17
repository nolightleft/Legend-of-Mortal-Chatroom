package com.nolightleft.chatroom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nolightleft.chatroom.entity.Message;
import com.nolightleft.chatroom.entity.User;

/**
 * <p>
 * Title: {@link MessageRepository}
 * </p>
 * <b>Description:</b>
 * <p>
 * Insert Description here
 * </p>
 *
 * @author lzu
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{
	
	List<Message> findByMSenderOrMReceiver(User sender, User receiver);
}
