package com.gcu.data;

import java.util.List;

/**
 * Provides the methods to access data from the MySQL database.
 *
 * @param <T> Anonymous type (UserModel or ProductModel)
 */
public interface DataAccessInterface <T>
{
	/**
	 * Finds all entities.
	 * @return all entities found.
	 */
	public List<T> findAll();
	/**
	 * Finds an entity by Id number
	 * @param id Id being searched for.
	 * @return The entity that was found.
	 */
	public T findById(int id);
	/**
	 * Searches for entity by username
	 * @param username user name being searched for.
	 * @returns Entity that was found
	 */
	public T findByUsername(String username);
	/**
	 * Creates a new entity in.
	 * @param t entity being created.
	 * @return if an entity was successfully created or not.
	 */
	public boolean create(T t);
	/**
	 * Updates an entity's info.
	 * @param t the entity being updated.
	 * @return if an entity was successfully updated or not.
	 */
	public boolean update(T t);
	/**
	 * Deletes an entity.
	 * @param t The entity being deleted.
	 * @return if an entity was successfully deleted or not.
	 */
	public boolean delete(T t);

}
