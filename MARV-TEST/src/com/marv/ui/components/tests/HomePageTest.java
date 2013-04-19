package com.marv.ui.components.tests;

import org.junit.*;
import static net.sourceforge.jwebunit.junit.JWebUnit.*;

public class HomePageTest {

	@Before
	public void prepare() {
		setBaseUrl("http://localhost:8080/MARV");
	}
	
	@Test
    public void testHome() {
        beginAt("/");
        //clickLink("login");
        //assertTitleEquals("Login");
        //setTextField("username", "test");
       // setTextField("password", "test123");
        //submit();
        assertTitleEquals("MARV - home");
    }
	
	@Test
    public void testHomeCommand() {
        beginAt("/?command=Home");
        assertTitleEquals("MARV - home");
        assertTitleNotEquals("Home");
    }
	
	
}
