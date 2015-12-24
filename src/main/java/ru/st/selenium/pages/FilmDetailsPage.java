package ru.st.selenium.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilmDetailsPage extends InternalPage {
	public FilmDetailsPage(PageManager pages) {
		super(pages);
	}

@FindBy(css = "img[alt=\"Remove\"]")
private WebElement removeButton;

//@FindBy(css = "#movie .maininfo_full h2" )
//private WebElement filmTitle;

public HomePage clickRemoveButton() {
	removeButton.click();
	wait.until(alertIsPresent()).accept();
	return pages.homePage;
}

/*public String getFilmID() {
	Pattern p = Pattern.compile("id=(\\d+)");
	Matcher m = p.matcher(driver.getCurrentUrl());
	return m.find() ? m.group(1) : "";
}*/

public FilmDetailsPage ensurePageLoaded() {
    super.ensurePageLoaded();
    wait.until(presenceOfElementLocated(By.id("movie")));
    return this;
  }

}
