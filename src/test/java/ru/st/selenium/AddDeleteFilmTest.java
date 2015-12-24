package ru.st.selenium;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import ru.st.selenium.model.Film;
import ru.st.selenium.pages.TestBase;

/**
 * Tests for adding and deleting of a film
 * Created by Kristina Dodonova
 * Date: 15.12.2015
 */

public class AddDeleteFilmTest extends TestBase {
	@BeforeClass
	public void performLogin() {
	    
	    app.getUserHelper().loginAs(ADMIN);
	  }


	@Test
	public void testAddNewFilmOK() throws Exception {
		String title = "TestMovie" + System.currentTimeMillis();
		Film film = new Film()
		.setTitle(title).setYear("2015");
		
	    app.getFilmHelper().createFilm(film);
		app.getFilmHelper().search(film.getTitle());
	    assertTrue(app.getFilmHelper().isFilmFound(film));
	   
	  }
	
	@Test
	public void testAddNewFilmFailed() throws Exception {
		String title = "TestMovie" + System.currentTimeMillis();
		Film film = new Film()
		.setTitle(title);
		
		app.getFilmHelper().createFilm(film);
		app.getFilmHelper().search(film.getTitle());
		assertTrue(app.getFilmHelper().isFilmNotFound(film));
	}
	
	@Test
	public void testDeleteFilm() throws Exception {
		String title = "TestMovie" + System.currentTimeMillis();
		Film film = new Film()
				.setTitle(title)
				.setYear("2017");
		app.getFilmHelper().createFilm(film);
		app.getFilmHelper().deleteFilm(film);
		app.getFilmHelper().search(film.getTitle());
		assertTrue(app.getFilmHelper().isFilmNotFound(film));
	}

}
