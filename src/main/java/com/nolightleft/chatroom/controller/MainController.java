package com.nolightleft.chatroom.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.nolightleft.chatroom.entity.Message;
import com.nolightleft.chatroom.entity.User;
import com.nolightleft.chatroom.service.MainService;
import com.nolightleft.chatroom.util.CRProperties;

/**
 * <p>
 * Title: {@link MainController}
 * </p>
 * <b>Description:</b>
 * <p>
 * Insert Description here
 * </p>
 *
 * @author lzu
 */
@Controller
public class MainController {

	private static final String CURRENT_USER = "currentUser";
	private static final String OPPONENT_USER = "opponentUser";
	private static final String MESSAGES = "messages";
	private static final String FRIENDS = "friends";

	private User mCurrentUser;

	private final MainService mMainService;

	private final Map<String, Object> mAttributeMap = new HashMap<>();
	
	private final ChatModel mChatModel;

	/**
	 * @param pUserService
	 * @param pMessageService
	 */
	public MainController(MainService pMainService, ChatModel pChatModel) {
		super();

		mMainService = pMainService;
		mChatModel = pChatModel;
	}

	@GetMapping("/")
	public ModelAndView publishMain() {
		List<User> users = mMainService.getAllUsers();
		mAttributeMap.put(CURRENT_USER, users.get(0));
		
		User opponentUser =  (User) mAttributeMap.get(OPPONENT_USER);
		if (opponentUser == null || opponentUser.getId() == null) {
			// 夏侯蘭
			mAttributeMap.put(OPPONENT_USER, users.get(2));
		}
		opponentUser =  (User) mAttributeMap.get(OPPONENT_USER);
		
		mAttributeMap.put(MESSAGES, mMainService.getAllMessages());

		// 趙活
		mCurrentUser = users.get(0);
		List<User> friends = new ArrayList<>();
		for (int i = 1; i < users.size(); i++) {
			friends.add(users.get(i));
		}
		mAttributeMap.put(FRIENDS, friends);

		final ModelAndView mav = new ModelAndView("chat-room");

		mAttributeMap.put(MESSAGES, mMainService.getMessagesByUser(opponentUser));

		mav.addAllObjects(mAttributeMap);
		return mav;
	}

	@PostMapping("/update-chat")
	public String updateChat(@RequestBody Map<String, String> pRequestData, Model pModel) {
		Long friendId = Long.parseLong(pRequestData.get("friendId"));

		mAttributeMap.put(OPPONENT_USER, mMainService.getUserById(friendId));
		mAttributeMap.put(MESSAGES, mMainService.getMessagesByUserId(friendId));

		pModel.addAllAttributes(mAttributeMap);
		return "fragments/f-chat-room :: f-chat-room";
	}

	@PostMapping("/save-message")
	public String saveMessage(@RequestBody Map<String, String> pRequestData, Model pModel) {
		User opponentUser = mMainService.getUserById(Long.parseLong(pRequestData.get("friendId")));

		mMainService.saveMessage(new Message(mCurrentUser, opponentUser, pRequestData.get("messageContent")));

		if (Boolean.valueOf(pRequestData.get("isUseAi"))) {
			ChatResponse response = mChatModel.call(new Prompt(pRequestData.get("messageContent"),
					OllamaOptions.builder()
							.withModel(
									CRProperties.getInstance().getModel(opponentUser.getPictureName().replace(".png", "")))
							.withKeepAlive("10m")));

			mMainService
					.saveMessage(new Message(opponentUser, mCurrentUser, response.getResult().getOutput().getContent()));
		}
		
		mAttributeMap.put(OPPONENT_USER, opponentUser);
		mAttributeMap.put(MESSAGES, mMainService.getMessagesByUser(opponentUser));

		pModel.addAllAttributes(mAttributeMap);
		return "fragments/f-chat-room :: chat-history";
	}

	/**
	 * Endpoint for entertainment
	 * 
	 * @param  pRequestData
	 * @param  pModel
	 * @return
	 */
	@PostMapping("/save-opponent-message")
	public String saveOpponentMessage(@RequestBody Map<String, String> pRequestData, Model pModel) {
		Long friendId = Long.parseLong(pRequestData.get("friendId"));
		User opponentUser = mMainService.getUserById(friendId);

		mMainService.saveMessage(new Message(friendId, opponentUser, mCurrentUser, pRequestData.get("messageContent")));

		mAttributeMap.put(OPPONENT_USER, opponentUser);
		mAttributeMap.put(MESSAGES, mMainService.getMessagesByUser(opponentUser));

		pModel.addAllAttributes(mAttributeMap);
		return "fragments/f-chat-room :: chat-history";
	}
}
