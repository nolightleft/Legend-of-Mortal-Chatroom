package com.nolightleft.chatroom.entity;

import java.time.LocalDate;

import com.nolightleft.chatroom.util.FileUtil;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * <p>
 * Title: {@link User}
 * </p>
 * <b>Description:</b>
 * <p>
 * Insert Description here
 * </p>
 *
 * @author lzu
 */
@Entity
@Table(name = "u_user")
public class User implements IEntity {
	
	public static final User EMPTY_OBJECT = new User();
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tweet_id_seq_generator")
	@SequenceGenerator(name = "user_id_seq_generator", sequenceName = "tweet_id_seq", allocationSize = 1)
	private Long mId;
	@Column(name = "name")
	private String mName;
	@Column(name = "password")
	private String mPassword;
	@Column(name = "age")
	private int mAge;
	@Column(name = "is_male")
	private boolean mIsMale;
	@Column(name = "birthday")
	private LocalDate mBirthday;
	@Column(name = "image")
	private byte[] mPicture;
	@Column(name = "picture_name")
	private String mPictureName;
	@Column(name = "descripion", length = 1000)
	private String mDescription;
	
	/**
	 * 
	 */
	public User() {
		this(null, null, null, 0, true, null, null, null, null);
	}
	
	/**
	 * @param pId
	 * @param pName
	 * @param pPassword
	 * @param pAge
	 * @param pIsMale
	 * @param pBirthday
	 * @param pPictureName
	 * @param pDescription
	 */
	public User(Long pId, String pName, String pPassword, int pAge, boolean pIsMale, LocalDate pBirthday,
			String pPictureName, String pDescription) {
		mId = pId;
		mName = pName;
		mPassword = pPassword;
		mAge = pAge;
		mIsMale = pIsMale;
		mBirthday = pBirthday;
		mPictureName = pPictureName;
		mDescription = pDescription;
	}
	
	/**
	 * @param pId
	 * @param pName
	 * @param pPassword
	 * @param pAge
	 * @param pIsMale
	 * @param pBirthday
	 * @param pPicture
	 * @param pPictureName
	 * @param pDescription
	 */
	public User(Long pId, String pName, String pPassword, int pAge, boolean pIsMale, LocalDate pBirthday,
			byte[] pPicture, String pPictureName, String pDescription) {
		super();
		mId = pId;
		mName = pName;
		mPassword = pPassword;
		mAge = pAge;
		mIsMale = pIsMale;
		mBirthday = pBirthday;
		mPicture = pPicture;
		mPictureName = pPictureName;
		mDescription = pDescription;
	}
	
	/**
	 * Method for JPA repository
	 * @param pId
	 * @return
	 */
	public static User of(Long pId) {
		return new User(pId, null, null, 0, false, null, null, null);
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
	 * @return the name
	 */
	public String getName() {
		return mName;
	}
	
	/**
	 * @param pName the name to set
	 */
	public void setName(String pName) {
		mName = pName;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return mPassword;
	}
	
	/**
	 * @param pPassword the password to set
	 */
	public void setPassword(String pPassword) {
		mPassword = pPassword;
	}
	
	/**
	 * @return the age
	 */
	public int getAge() {
		return mAge;
	}
	
	/**
	 * @param pAge the age to set
	 */
	public void setAge(int pAge) {
		mAge = pAge;
	}
	
	/**
	 * @return the isMale
	 */
	public boolean isIsMale() {
		return mIsMale;
	}
	
	/**
	 * @param pIsMale the isMale to set
	 */
	public void setIsMale(boolean pIsMale) {
		mIsMale = pIsMale;
	}
	
	/**
	 * @return the birthday
	 */
	public LocalDate getBirthday() {
		return mBirthday;
	}
	
	/**
	 * @param pBirthday the birthday to set
	 */
	public void setBirthday(LocalDate pBirthday) {
		mBirthday = pBirthday;
	}
	
	/**
	 * @return the image
	 */
	public byte[] getPicture() {
		return mPicture;
	}
	
	/**
	 * @param pPicture the image to set
	 */
	public void setPicture(byte[] pPicture) {
		mPicture = pPicture;
	}
	
	
	/**
	 * @return the pictureName
	 */
	public String getPictureName() {
		return mPictureName;
	}
	
	/**
	 * @return the uri to the icon
	 */
	public String getIconPath() {
		return FileUtil.ICON_DIR + mPictureName;
	}
	
	/**
	 * @return the uri to the icon
	 */
	public String getPicturePath() {
		return FileUtil.PICTURE_DIR + mPictureName;
	}
	
	/**
	 * @param pPictureName the pictureName to set
	 */
	public void setPictureName(String pPictureName) {
		mPictureName = pPictureName;
	}
	

	/**
	 * @return the description
	 */
	public String getDescription() {
		return mDescription;
	}
	
	/**
	 * @param pDescription the description to set
	 */
	public void setDescription(String pDescription) {
		mDescription = pDescription;
	}
	
	/**
	 * minimum info for creating 活俠傳女角色  
	 * @param pId
	 * @param pName
	 * @param pAge
	 * @param pPictureName
	 * @param pDescription
	 * @return
	 */
	public static User newHuoxiaFCharacter(Long pId, String pName, int pAge, String pPictureName, String pDescription) {
		return new User(pId, pName, "", pAge, false, LocalDate.of(1200, 6, 15), pPictureName, pDescription);
	}
}
