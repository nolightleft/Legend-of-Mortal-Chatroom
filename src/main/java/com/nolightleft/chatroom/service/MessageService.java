package com.nolightleft.chatroom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.nolightleft.chatroom.entity.Message;
import com.nolightleft.chatroom.repository.MessageRepository;

/**
 * <p>
 * Title: {@link MessageService}
 * </p>
 * <b>Description:</b>
 * <p>
 * Insert Description here
 * </p>
 *
 * @author lzu
 */
@Service
public class MessageService extends AbstractService<Message>{
	
	@Autowired
	private MessageRepository mMessageRepository;

	/* (non-Javadoc)
	 * @see com.nolightleft.chatroom.service.AbstractService#getRepository()
	 */
	@Override
	public JpaRepository<Message, Long> getRepository() {
		return mMessageRepository;
	}
}
