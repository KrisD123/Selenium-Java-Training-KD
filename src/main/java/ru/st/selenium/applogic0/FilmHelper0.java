package ru.st.selenium.applogic0;

import java.util.List;

import ru.st.selenium.applogic.FilmHelper;
import ru.st.selenium.model.Film;
import ru.st.selenium.pages.FilmManagementPage;
import ru.st.selenium.pages.HomePage;

public class FilmHelper0 implements FilmHelper {

  @Override
  public FilmManagementPage createFilm(Film film) {
	return null;
    // TODO Auto-generated method stub

  }

  @Override
  public HomePage deleteFilm(Film film) {
	  return null;
    // TODO Auto-generated method stub

  }

  @Override
  public void search(String title) {
    // TODO Auto-generated method stub
  }
  @Override
 public boolean isFilmFound(Film film) {
	  return false;
	 // TODO Auto-generated method stub
  }

  @Override
  public boolean isFilmNotFound(Film film) {
  	// TODO Auto-generated method stub
  	return false;
  }

@Override
public void deleteSearch() {
	// TODO Auto-generated method stub
	
}


/*
@Override
public String getFilmID() {
	// TODO Auto-generated method stub
	return null;
}
*/
}
