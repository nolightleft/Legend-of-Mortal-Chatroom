package com.nolightleft.chatroom.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * <p>
 * Title: {@link Message}
 * </p>
 * <b>Description:</b>
 * <p>
 * Insert Description here
 * </p>
 *
 * @author lzu
 */
@Entity
@Table(name = "message")
public class Message implements IEntity{
	
	public static final Message EMPTY_OBJECT = new Message();
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tweet_id_seq_generator")
	@SequenceGenerator(name = "message_id_seq_generator", sequenceName = "tweet_id_seq", allocationSize = 1)
	private Long mId;
	
	@ManyToOne
	@JoinColumn(name = "sender_id")
	private User mSender;
	
	@ManyToOne
	@JoinColumn(name = "receiver_id")
	private User mReceiver;
	
	@Column(name = "content")
	private String mContent;
	
	@Column(name = "data")
	private byte[] mData;
	
	@Column(name = "creation_date")
	private Timestamp mCreationDate;
	
	/**
	 * 
	 */
	public Message() {
		this(null, null, null);
	}
	
	/**
	 * @param pSender
	 * @param pReceiver
	 * @param pContent
	 */
	public Message(User pSender, User pReceiver, String pContent) {
		this(0L, pSender, pReceiver, pContent);
	}
	
	/**
	 * @param pId
	 * @param pSender
	 * @param pReceiver
	 * @param pContent
	 */
	public Message(Long pId, User pSender, User pReceiver, String pContent) {
		this(pId, pSender, pReceiver, pContent, null);
	}
	
	/**
	 * @param pId
	 * @param pChatroom
	 * @param pSender
	 * @param pReceiver
	 * @param pContent
	 * @param pData
	 */
	public Message(Long pId, User pSender, User pReceiver, String pContent, byte[] pData) {
		this(pId, pSender, pReceiver, pContent, pData, new Timestamp(System.currentTimeMillis()));
	}
	
	/**
	 * @param pId
	 * @param pChatroom
	 * @param pSender
	 * @param pReceiver
	 * @param pContent
	 * @param pData
	 * @param pCreationDate
	 */
	public Message(Long pId, User pSender, User pReceiver, String pContent, byte[] pData, Timestamp pCreationDate) {
		super();
		mId = pId;
		mSender = pSender;
		mReceiver = pReceiver;
		mContent = pContent;
		mData = pData;
		mCreationDate = pCreationDate;
	}

	
	/**
	 * @return the id
	 */
	public Long getId() {
		return mId;
	}

	
	/**
	 * @param pId the id to set
	 */
	public void setId(Long pId) {
		mId = pId;
	}

	
	/**
	 * @return the content
	 */
	public String getContent() {
		return mContent;
	}

	
	/**
	 * @param pContent the content to set
	 */
	public void setContent(String pContent) {
		mContent = pContent;
	}

	
	/**
	 * @return the data
	 */
	public byte[] getData() {
		return mData;
	}

	
	/**
	 * @param pData the data to set
	 */
	public void setData(byte[] pData) {
		mData = pData;
	}

	
	/**
	 * @return the creationDate
	 */
	public Timestamp getCreationDate() {
		return mCreationDate;
	}

	
	/**
	 * @param pCreationDate the creationDate to set
	 */
	public void setCreationDate(Timestamp pCreationDate) {
		mCreationDate = pCreationDate;
	}

	
	/**
	 * @return the sender
	 */
	public User getSender() {
		return mSender;
	}

	
	/**
	 * @param pSender the sender to set
	 */
	public void setSender(User pSender) {
		mSender = pSender;
	}

	
	/**
	 * @return the receiver
	 */
	public User getReceiver() {
		return mReceiver;
	}

	
	/**
	 * @param pReceiver the receiver to set
	 */
	public void setReceiver(User pReceiver) {
		mReceiver = pReceiver;
	}

}
