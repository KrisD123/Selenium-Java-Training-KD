package ru.st.selenium;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.st.selenium.model.Film;
import ru.st.selenium.pages.TestBase;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
/**
 * Tests for checking of search function
 * Created by Kristina Dodonova
 * Date: 15.12.2015
 */

public class SearchFilmTest extends TestBase {
	@BeforeClass
	public void performLogin() {
	    
	    app.getUserHelper().loginAs(ADMIN);
	  }
	/*
	@AfterMethod
	public void cleanSearch() {
		app.getFilmHelper().deleteSearch();
	    }
	    */
	
	@Test
	public void searchFilmsFound() throws Exception {
		String title = "TestMovie" + System.currentTimeMillis();
		Film film = new Film()
		.setTitle(title)
		.setYear("2015");
		
		app.getFilmHelper().createFilm(film);
		app.getFilmHelper().search(film.getTitle());
		assertTrue(app.getFilmHelper().isFilmFound(film));
		
	}
	
	@Test
	public void searchFilmsNotFound() throws Exception {
		String title = "TestMovie" + System.currentTimeMillis();
		Film film = new Film()
		.setTitle(title);
		
		app.getFilmHelper().createFilm(film);
		app.getFilmHelper().search(title);
		assertTrue(app.getFilmHelper().isFilmNotFound(film));
		
	}

}
