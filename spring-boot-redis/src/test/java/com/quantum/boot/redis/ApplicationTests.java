package com.quantum.boot.redis;

import com.quantum.boot.redis.domain.User;
import com.quantum.boot.redis.domain.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTests {

	@Autowired
	private UserRepository userRepository;

//	@Autowired
//	private CacheManager cacheManager;

	@Before
	public void before() {
		userRepository.save(new User(10l, "AAA", 28  ));
	}

	@Test
	public void test() {

		User u1 = userRepository.findByName("AAA");
		System.out.println("第一次查询：" + u1.getAge());

		User u2 = userRepository.findByName("AAA");
		System.out.println("第二次查询：" + u2.getAge());

		u1.setAge(20);
		userRepository.save(u1);
		User u3 = userRepository.findByName("AAA");
		System.out.println("第三次查询：" + u3.getAge());

	}

}
