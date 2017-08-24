package com.movieworld.MovieworldSpringApi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.movieworld.MovieworldSpringApi.entity.User;


@Repository
public class UserRepositoryImpl extends AbstractDao<Integer, User> implements UserRepository {

		
		@PersistenceContext
		private EntityManager em;
		
		@Override
		public List<User> findAll() {
			TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
			return query.getResultList();
		}
		
		@Override
		public User findByEmail(String email) {
			TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
			query.setParameter("pEmail", email);
			List<User> users = query.getResultList();
			if (users != null && users.size() == 1) {
				return users.get(0);
			}
			return null;
		}


		@Override
		public User create(User email) {
			em.persist(email);
			return email;
		}

		@Override
		public User update(User email) {
			return em.merge(email);
		}

		@Override
		public void delete(User email) {
			em.remove(email);
		}
		
		public User findById(int id) {
			return getByKey(id);
		}

		public User findBySSO(String sso) {
			Criteria crit = createEntityCriteria();
			crit.add(Restrictions.eq("ssoId", sso));
			return (User) crit.uniqueResult();
		}

}
