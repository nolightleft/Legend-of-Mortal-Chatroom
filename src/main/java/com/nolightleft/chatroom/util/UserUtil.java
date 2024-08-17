package com.nolightleft.chatroom.util;

import java.util.List;
import java.util.Objects;

import com.nolightleft.chatroom.entity.User;

/**
 * <p>
 * Title: {@link UserUtil}
 * </p>
 * <b>Description:</b>
 * <p>
 * Insert Description here
 * </p>
 *
 * @author lzu
 */
public class UserUtil {

	public static User findUserById(List<User> pUserList, Long pUserId) {
		return pUserList.stream().filter(user -> Objects.equals(user.getId(), pUserId)).findFirst().orElse(null);
	}
}
