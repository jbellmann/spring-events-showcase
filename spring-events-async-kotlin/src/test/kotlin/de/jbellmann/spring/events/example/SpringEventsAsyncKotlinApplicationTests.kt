package de.jbellmann.spring.events.example

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.util.concurrent.TimeUnit

@RunWith(SpringRunner::class)
@SpringBootTest
class SpringEventsAsyncKotlinApplicationTests {

	@Test
	fun contextLoads() {
		TimeUnit.SECONDS.sleep(15)
	}

}
