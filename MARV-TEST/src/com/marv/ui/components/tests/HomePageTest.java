package com.marv.ui.components.tests;

import static org.junit.Assert.*;

import java.util.regex.Matcher;

import net.sourceforge.jwebunit.api.IElement;

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
        assertTitleEquals("MARV - home");
    }
	
	@Test
    public void testHomeCommand() {
        beginAt("/?command=Home");
        assertTitleEquals("MARV - home");
        assertTitleNotEquals("Home");
    }
	
	@Test
	public void testListInstitutionsLink() {
		beginAt("/?command=Home");
		assertLinkPresentWithExactText("Institutions");
		clickLinkWithExactText("Institutions");
		assertTitleEquals("List Institutions");
	}
	
	@Test
	public void testSignInLink() {
		beginAt("/?command=Home");
		assertLinkPresentWithExactText("Sign-In");
		assertElementPresent("janrainModal");

        IElement signInBox = getElementById("janrainModal");
        String signInBoxStyle = signInBox.getAttribute("style");
        // assert that sign in box is hidden
        assertTrue(signInBoxStyle.contains("display: none;"));
        
		clickLinkWithExactText("Sign-In");
		
        signInBox = getElementById("janrainModal");
        signInBoxStyle = signInBox.getAttribute("style");
        // assert that sign in box is visible
        assertTrue(signInBoxStyle.contains("display: block;"));
	}
}
