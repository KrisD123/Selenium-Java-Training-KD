package ru.st.selenium.pages;

import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Class describing page for adding of a new movie
 * Created by Kristina Dodonova
 * Date: 15.12.2015
 */

public class FilmManagementPage extends InternalPage{

	public FilmManagementPage(PageManager pages) {
		super(pages);
	}
	
@FindBy(name = "name")
private WebElement titleField;

@FindBy(name = "year")
private WebElement yearField;

@FindBy(name = "submit")
private WebElement submitButton;

public String getTitleField() {
	return titleField.getAttribute("value");
}

public FilmManagementPage setTitleField(String text) {
    titleField.sendKeys(text);
    return this;
   
  } 

public String getYearField() {
	return yearField.getAttribute("value");
}

public FilmManagementPage setYearField(String text) {
    yearField.sendKeys(text);
    return this;
  } 

public FilmManagementPage clickSubmitButton() {
	submitButton.click();
	return this;
	
}

public FilmManagementPage ensurePageLoaded() {
    super.ensurePageLoaded();
    wait.until(presenceOfElementLocated(By.name("imdbid")));
    return this;
  }
}
