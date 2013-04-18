/**
 * 
 */
package com.marv.business.entities.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.marv.business.entities.Institution;

/**
 * @author valera
 *
 */
public class InstitutionTest {
	
	private Institution institution;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		institution = new Institution();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		institution = null;
	}

	/**
	 * Test method for {@link com.marv.business.entities.Institution#getName()}.
	 */
	@Test
	public void testGetName() {
		assertNull(institution.getName());
		institution.setName("KEA");
		assertEquals("KEA", institution.getName());
	}

	/**
	 * Test method for {@link com.marv.business.entities.Institution#setName(java.lang.String)}.
	 */
	@Test
	public void testSetName() {
		assertNull(institution.getName());
		institution.setName("KEA");
		assertEquals("KEA", institution.getName());
	}

	/**
	 * Test method for {@link com.marv.business.entities.DomainObject#getId()}.
	 */
	@Test
	public void testGetId() {
		assertEquals(-1L, institution.getId());
		institution.setId(2L);
		assertEquals(2L, institution.getId());
	}

	/**
	 * Test method for {@link com.marv.business.entities.DomainObject#setId(long)}.
	 */
	@Test
	public void testSetId() {
		assertEquals(-1L, institution.getId());
		institution.setId(2L);
		assertEquals(2L, institution.getId());
	}

	/**
	 * Test method for {@link com.marv.business.entities.DomainObject#isNew()}.
	 */
	@Test
	public void testIsNew() {
		assertTrue(institution.isNew());
		institution.setId(5L);
		assertFalse(institution.isNew());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetTooLongName() {
		String tooLongName = "respublika respublika respublika respublika" +
				"respublika respublika respublika respublika respublika" +
				"respublika respublika respublika respublika respublika " +
				"respublika respublika respublika respublika respublika " +
				"respublika respublika respublika respublika respublika " +
				"respublika "; //more than 255 chars
		institution.setName(tooLongName);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetNegativeId() {
		institution.setId(-2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetZeroId() {
		institution.setId(0);
	}
}
