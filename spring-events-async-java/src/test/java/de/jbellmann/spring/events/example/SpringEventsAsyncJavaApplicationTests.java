package de.jbellmann.spring.events.example;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringEventsAsyncJavaApplicationTests {

	@Test
	public void contextLoads() throws InterruptedException {
	    TimeUnit.SECONDS.sleep(15);
	}

}
