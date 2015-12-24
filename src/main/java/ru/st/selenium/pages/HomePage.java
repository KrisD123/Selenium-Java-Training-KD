package ru.st.selenium.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.st.selenium.model.Film;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Class describing Home page
 * Created by Kristina Dodonova
 * Date: 15.12.2015
 */

public class HomePage extends InternalPage{
	public HomePage(PageManager pages) {
		super(pages);
	}
		
	//private static final String FILM_LINK_XPATH = "//div[@class='title'][text()='%s']";
@FindBy(css = "nav a[href $= '?go=add']")
private WebElement addMovieButton;

@FindBy(id = "q")
private WebElement searchField; 

@FindBy(id = "results")
private WebElement resultsForm;

@FindBy(css = ".title")
private List<WebElement> filmTitles;

@FindBy(xpath = "//div[@class='content'][text()='No movies where found.']")
private WebElement noMoviesFound;


private WebElement filmLink(String filmTitle) {
	//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(FILM_LINK_XPATH, "TestMovie1450874631780"))));
	return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='title'][text()='" + filmTitle + "']")));
			
}


public HomePage ensurePageLoaded() {
    super.ensurePageLoaded();
    wait.until(presenceOfElementLocated(By.id("results")));
    return this;
  }


public FilmManagementPage clickAddMovieButton() {
	addMovieButton.click();
	return pages.filmManagementPage;
	}

public String getSearchField() {
	return searchField.getAttribute("value");
}

  public void setSearchField(String text) {
	searchField.clear();
    searchField.sendKeys(text);
    searchField.sendKeys(Keys.RETURN);
  }
  

  /**
   * Method to get all films that are currently displayed
   * Created by Kristina Dododnova 
   * 16.12.2015
   */
 /* 
  public List<String> getAllFilmTitles() {
	  List<String> allFilmTitles = new ArrayList<String>();
	  for (WebElement filmTitle : filmTitles) {
		  allFilmTitles.add(filmTitle.getText());
	  }
	return allFilmTitles;
	  
  }*/
  
  public FilmDetailsPage goToFilmDetailsPage(String filmTitle) {
	  
	  filmLink(filmTitle).click();
	 return pages.filmDetailsPage;
  }
  

public void makeSearch(String text) {
	 if (filmTitles.isEmpty()) {
         setSearchField(text);
     } else {
         WebElement film = filmTitles.get(0);
         setSearchField(text);
         wait.until(ExpectedConditions.stalenessOf(film));
     }
     wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".title, .content")));
 }

public void deleteSearch() {
	pages.internalPage.ensurePageLoaded()
	.clickHomeLink()
	.ensurePageLoaded()
	.makeSearch("");
}

public boolean isFilmFound(Film film) {
	
	if (filmTitles.contains(filmLink(film.getTitle()))) {
		  return true;
	  }	else return false;
}

public boolean isFilmNotFound(Film film) {
	  
	if (noMoviesFound.isDisplayed()) {
		  return true;
	  }
	else return false;
}
}
