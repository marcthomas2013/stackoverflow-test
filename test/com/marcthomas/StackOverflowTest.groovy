package com.marcthomas
import static org.junit.Assert.*

import org.junit.Before
import org.junit.After
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.firefox.FirefoxDriver

import java.util.concurrent.TimeUnit;

class StackOverflowTest {
	private def stackOverflowURL = "http://stackoverflow.com/"
	private def driver
	
	@Before
	def void setUp() {
		driver = new FirefoxDriver()
		driver.get stackOverflowURL
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	def void testWhenHomePageNavQuestionsLinkClickedReturnedPageDisplaysNewestQuestionsPageTitle() {
		def navQuestionsElement = driver.findElement By.id("nav-questions")
		navQuestionsElement.click()

		assertEquals("Newest Questions - Stack Overflow", driver.getTitle())
	}
	
	@After
	def void tidyUp() {
		driver.quit()
	}
}