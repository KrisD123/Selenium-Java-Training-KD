package ru.st.selenium.applogic;

import java.util.List;

import ru.st.selenium.model.Film;
import ru.st.selenium.pages.FilmManagementPage;
import ru.st.selenium.pages.HomePage;

public interface FilmHelper {

	FilmManagementPage createFilm(Film film);
	HomePage deleteFilm(Film film);
	void search(String title);
	void deleteSearch();
	//String getFilmID();
	boolean isFilmFound(Film film);
	boolean isFilmNotFound(Film film);

}
