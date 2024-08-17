package com.nolightleft.chatroom.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nolightleft.chatroom.entity.Message;
import com.nolightleft.chatroom.entity.User;
import com.nolightleft.chatroom.repository.MessageRepository;
import com.nolightleft.chatroom.repository.UserRepository;

/**
 * <p>
 * Title: {@link MainService}
 * </p>
 * <b>Description:</b>
 * <p>
 * Insert Description here
 * </p>
 *
 * @author lzu
 */
@Service
public class MainService {
	private UserRepository mUserRepository;
	private MessageRepository mMessageRepository;
	
	/**
	 * @param pUserRepository
	 * @param pMessageRepository
	 */
	public MainService(UserRepository pUserRepository, MessageRepository pMessageRepository) {
		mUserRepository = pUserRepository;
		mMessageRepository = pMessageRepository;
	}
	
	/**
	 * @return independent data (not connected with DB)
	 */
	public List<User> getAllUsers() {
		return new ArrayList<>(mUserRepository.findAll());
	}
	
	/**
	 * @param pId
	 * @return
	 */
	public User getUserById(Long pId) {
		return mUserRepository.findById(pId).orElse(null);
	}
	
	/**
	 * @return
	 */
	public List<Message> getAllMessages() {
		return mMessageRepository.findAll();
	}
	
	/**
	 * @param pUser
	 * @return messages that either sender or receiver that matches pUser
	 */
	public List<Message> getMessagesByUser(User pUser) {
		return mMessageRepository.findByMSenderOrMReceiver(pUser, pUser);
	}
	
	/**
	 * @param pUserId
	 * @return messages that either sender or receiver that matches pUserId
	 */
	public List<Message> getMessagesByUserId(Long pUserId) {
		return getMessagesByUser(User.of(pUserId));
	}
	
	/**
	 * @param pMessage
	 * @return
	 */
	public Message saveMessage(Message pMessage) {
		return mMessageRepository.save(pMessage);
	}
}
