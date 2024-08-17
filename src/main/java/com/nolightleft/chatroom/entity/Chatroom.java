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
 * Title: {@link Chatroom}
 * </p>
 * <b>Description:</b>
 * <p>
 * Insert Description here
 * </p>
 *
 * @author lzu
 */
@Entity
@Table(name = "chatroom")
public class Chatroom implements IEntity {
	
	public static final Chatroom EMPTY_OBJECT = new Chatroom();
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tweet_id_seq_generator")
	@SequenceGenerator(name = "chatroom_id_seq_generator", sequenceName = "tweet_id_seq", allocationSize = 1)
	private Long mId;
	
	@ManyToOne
	@JoinColumn(name = "user_1_id")
	private User mUser1;
	
	@ManyToOne
	@JoinColumn(name = "user_2_id")
	private User mUser2;
	
	@Column(name = "creation_date")
	private Timestamp mCreationDate;

	/**
	 * 
	 */
	public Chatroom() {
		this(null, null, null, null);
	}
	
	/**
	 * @param pId
	 * @param pUser1
	 * @param pUser2
	 */
	public Chatroom(Long pId, User pUser1, User pUser2) {
		this(pId, pUser1, pUser2, new Timestamp(System.currentTimeMillis()));
	}
	
	/**
	 * @param pId
	 * @param pUser1
	 * @param pUser2
	 * @param pCreationDate
	 */
	public Chatroom(Long pId, User pUser1, User pUser2, Timestamp pCreationDate) {
		super();
		mId = pId;
		mUser1 = pUser1;
		mUser2 = pUser2;
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
	 * @return the user1
	 */
	public User getUser1() {
		return mUser1;
	}

	
	/**
	 * @param pUser1 the user1 to set
	 */
	public void setUser1(User pUser1) {
		mUser1 = pUser1;
	}

	
	/**
	 * @return the user2
	 */
	public User getUser2() {
		return mUser2;
	}

	
	/**
	 * @param pUser2 the user2 to set
	 */
	public void setUser2(User pUser2) {
		mUser2 = pUser2;
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
	
	
}
