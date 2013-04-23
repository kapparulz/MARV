package com.marv.ui.components.tests;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class InstitutionTest {

	@Before
	public void prepare() {
		setBaseUrl("http://localhost:8080/MARV/");
	}

	@Test
    public void testEditInstitution() {
        beginAt("?command=Institution&id=3");
        assertTitleEquals("Institution");
        setTextField("institutionName", 
        		"Institution #3 modified at " + Calendar.getInstance().getTime());
        submit();
        assertTitleEquals("MARV - home");
    }
}
