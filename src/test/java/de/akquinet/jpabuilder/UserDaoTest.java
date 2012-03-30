package de.akquinet.jpabuilder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import de.akquinet.jbosscc.needle.annotation.ObjectUnderTest;
import de.akquinet.jbosscc.needle.db.transaction.Runnable;
import de.akquinet.jbosscc.needle.junit.DatabaseRule;
import de.akquinet.jbosscc.needle.junit.NeedleRule;

public class UserDaoTest {

	@Rule
	public DatabaseRule databaseRule = new DatabaseRule();

	@Rule
	public NeedleRule needleRule = new NeedleRule(databaseRule);

	@ObjectUnderTest
	private UserDao userDao;

	@Test
	public void userTestdataBuilderExists() throws Exception {
		Class<?> clazz = Class.forName("de.akquinet.jpabuilder.UserBuilder");

		assertThat(clazz, notNullValue());
	}

	@Test
	public void testFindByUsername() throws Exception {
		final User user = createAndSaveUser();

		User findBy = userDao.findBy(user.getUsername(), user.getPassword());

		assertThat(user.getId(), equalTo(findBy.getId()));
	}

	@Test
	@Ignore
	public void testFindAll() throws Exception {
		createAndSaveUser();

		List<User> all = userDao.findAll();

		assertThat(all, hasSize(1));
	}

	private User createAndSaveUser() throws Exception {
		return databaseRule.getTransactionHelper().executeInTransaction(
				new Runnable<User>() {

					@Override
					public User run(EntityManager entityManager)
							throws Exception {
						final User user = new UserBuilder().build();

						entityManager.persist(user);

						// TODO Auto-generated method stub
						return user;
					}
				});
	}
}
