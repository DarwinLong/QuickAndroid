package com.hibernate.model;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.darwin.utils.Security;

public class UserTest {

	public static void main(String[] args) {
		Configuration config=new Configuration().configure();
		SessionFactory sf = config.buildSessionFactory();
		Session session = null;

		User user = new User();
		user.setUserName("ruoxingai");
		user.setName("Darwin");
		user.setEncryptedPassword(Security.md5("123"));
		user.setTell("13524699652");
		user.setEmail("abc@123");
		user.setCreateDate(new Date());
		user.setUpdateDate(new Date());

		try {
			session = sf.openSession();

			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();

		} finally {
			session.close();
			sf.close();
		}
		
		
		String mds="202cb962ac59075b964b07152d234b70";
		System.out.println(mds.length());

	}
}
