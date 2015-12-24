package ru.st.selenium.applogic2;
import ru.st.selenium.applogic.FilmHelper;
import ru.st.selenium.model.Film;
import ru.st.selenium.pages.FilmDetailsPage;
import ru.st.selenium.pages.FilmManagementPage;
import ru.st.selenium.pages.HomePage;

public class FilmHelper2 extends DriverBasedHelper implements FilmHelper {

  public FilmHelper2(ApplicationManager2 manager) {
    super(manager.getWebDriver());
  }

  /**
   * Method to create new Film
   * Created by Kristina Dododnova 
   * 16.12.2015
   */
  @Override
  public FilmManagementPage createFilm(Film film) {
    pages.internalPage.ensurePageLoaded()
    .clickHomeLink().ensurePageLoaded()
    .clickAddMovieButton().ensurePageLoaded()
    .setTitleField(film.getTitle())
    .setYearField(film.getYear())
    .clickSubmitButton();
    return pages.filmManagementPage;
  }
  

    
  /**
   * Method to delete film from application
   * Created by Kristina Dodonova
   * Date: 19.12.2015
   */
  
  @Override
  public HomePage deleteFilm(Film film) {
	  pages.internalPage.ensurePageLoaded()
	  .clickHomeLink().ensurePageLoaded();
	  
	  search(film.getTitle());
	  goToFilmDetailsPage(film.getTitle()).ensurePageLoaded()
	  .clickRemoveButton();
	  return pages.homePage;
  }
  
  public FilmDetailsPage goToFilmDetailsPage(String title) {
	return pages.homePage.goToFilmDetailsPage(title);
}

/**
   * Method to find films on Home page using search field
   * Created by Kristina Dododnova 
   * 16.12.2015
   */
  @Override
  public void search(String title) {
	
	 pages.internalPage.ensurePageLoaded()
	.clickHomeLink().ensurePageLoaded()
    .makeSearch(title);
    pages.homePage.ensurePageLoaded();
      
  }

@Override
 public boolean isFilmFound(Film film) {
	 return pages.homePage.isFilmFound(film);
	 
 }

@Override
public boolean isFilmNotFound(Film film) {
	 return pages.homePage.isFilmNotFound(film);
	 
}
  

/**
   * Method to delete previous search and to show all existing films
   * Created by Kristina Dodonova
   * Date: 19.12.2015
   */
  
@Override
public void deleteSearch() {
	pages.internalPage.ensurePageLoaded()
	.clickHomeLink()
	.ensurePageLoaded()
	.makeSearch("");
	
}
/*
@Override
public String getFilmID() {
	return pages.filmDetailsPage.ensurePageLoaded().getFilmID();
}
*/





}
