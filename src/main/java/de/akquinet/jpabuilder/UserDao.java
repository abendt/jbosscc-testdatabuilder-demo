package de.akquinet.jpabuilder;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UserDao {
	@PersistenceContext
	private EntityManager entityManager;

	public User findBy(final String username, final String password) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);

		Root<User> user = query.from(User.class);

		query.where(
				builder.and(builder.equal(user.get(User_.username), username)),
				builder.equal(user.get(User_.password), password));

		return entityManager.createQuery(query).getSingleResult();
	}

	public List<User> findAll() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);

		return entityManager.createQuery(query).getResultList();
	}
}