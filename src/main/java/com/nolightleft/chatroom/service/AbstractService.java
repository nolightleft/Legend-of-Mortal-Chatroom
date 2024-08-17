package com.nolightleft.chatroom.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nolightleft.chatroom.entity.IEntity;

import jakarta.persistence.EntityNotFoundException;

/**
 * <p>
 * Title: {@link AbstractService}
 * </p>
 * <b>Description:</b>
 * <p>
 * Insert Description here
 * </p>
 *
 * @author lzu
 */
public abstract class AbstractService<T extends IEntity> {
	
	public abstract JpaRepository<T, Long> getRepository();
	
	/**
	 * @return
	 */
	public List<T> getAll() {
		return getRepository().findAll();
	}
	
	/**
	 * @param pT
	 * @return
	 */
	public T save(T pT) {
		return getRepository().save(pT);
	}
	
	/**
	 * @param pId
	 * @return <b>NULL</b> if not found
	 */
	public T getById(Long pId) {
		Optional<T> optional = getRepository().findById(pId);
		
		return optional.isEmpty() ? null : optional.get();
	}
	
	/**
	 * @param pNewT
	 * @return
	 * @throws EntityNotFoundException
	 */
	public T update(T pNewT) throws EntityNotFoundException {
		T existingT = getRepository().findById(pNewT.getId())
				.orElseThrow(() -> new EntityNotFoundException(
						String.format("%s - %d entity not found", pNewT.getClass().getTypeName(), pNewT.getId())
						));
		
		for(Field field : pNewT.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			
			try {
				Object newValue = field.get(pNewT);
				
				if (Objects.nonNull(newValue)) {
					field.set(existingT, newValue);
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		return save(pNewT);
	}
	
	/**
	 * @param pId
	 */
	public void removeById(Long pId) {
		getRepository().deleteById(pId);
	}
}
