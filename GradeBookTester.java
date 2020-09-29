import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {

	GradeBook gradeBook;
	GradeBook gradeBook2;
	
	@BeforeEach
	void setUp() throws Exception {
		gradeBook = new GradeBook(5);
		gradeBook.addScore(10);
		gradeBook.addScore(20);
		
		gradeBook2 = new GradeBook(5);
		gradeBook2.addScore(30);
		gradeBook2.addScore(40);
	}

	@AfterEach
	void tearDown() throws Exception {
		gradeBook = null;
		gradeBook2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(gradeBook.addScore(50));
		assertTrue(gradeBook.addScore(60));
		assertTrue(gradeBook.addScore(70));
		assertFalse(gradeBook.addScore(80));
		
		assertEquals("10.0 20.0 50.0 60.0 70.0", gradeBook.toString());
		
		assertTrue(gradeBook2.addScore(90));
		assertTrue(gradeBook2.addScore(100));
		assertTrue(gradeBook2.addScore(110));
		assertFalse(gradeBook2.addScore(120));
		
		assertEquals("30.0 40.0 90.0 100.0 110.0", gradeBook2.toString());
	}

	@Test
	void testSum() {
		assertEquals(30, gradeBook.sum());
		assertEquals(70, gradeBook2.sum());
	}

	@Test
	void testMinimum() {
		assertEquals(10, gradeBook.minimum());
		assertEquals(30, gradeBook2.minimum());
	}

	@Test
	void testFinalScore() {
		assertEquals(20, gradeBook.finalScore());
		assertEquals(40, gradeBook2.finalScore());
	}

}
