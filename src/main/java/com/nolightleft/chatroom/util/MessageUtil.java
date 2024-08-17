package com.nolightleft.chatroom.util;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.nolightleft.chatroom.entity.Message;

/**
 * <p>
 * Title: {@link MessageUtil}
 * </p>
 * <b>Description:</b>
 * <p>
 * Insert Description here
 * </p>
 *
 * @author lzu
 */
public class MessageUtil {
	/**
	 * @param pMessages
	 * @param userId
	 * @return
	 */
	public static List<Message> filterMessagesByUserId(List<Message> pMessages, Long userId) {
		return pMessages.stream()
	    		.filter(message -> Objects.equals(message.getSender().getId(), userId)
	    				|| Objects.equals(message.getReceiver().getId(), userId))
	    		.collect(Collectors.toList());
	}
}
