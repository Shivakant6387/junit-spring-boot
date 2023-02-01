package com.example.springboothibernateonetoonepr;

import com.example.springboothibernateonetoonepr.entity.Gender;
import com.example.springboothibernateonetoonepr.entity.User;
import com.example.springboothibernateonetoonepr.entity.UserProfile;
import com.example.springboothibernateonetoonepr.repository.UserProfileRepository;
import com.example.springboothibernateonetoonepr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class SpringBootHibernateOneToOnePrApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateOneToOnePrApplication.class, args);
	}
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserProfileRepository userProfileRepository;
	@Override
	public void run(String... args) throws Exception {
		User user=new User();
		user.setName("Shiva");
		user.setEmail("shiva@gmail.com");
		UserProfile userProfile=new UserProfile();
		userProfile.setAddress("Kharela");
		userProfile.setBirthOfDate(LocalDate.of(2002,01,10));
		userProfile.setGender(Gender.MALE);
		userProfile.setPhoneNumber("1234567899");
		user.setUserProfile(userProfile);
		userProfile.setUser(user);
		userRepository.save(user);
	}
}
