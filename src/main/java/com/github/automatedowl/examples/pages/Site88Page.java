package com.github.automatedowl.examples.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Site88Page {

	/** Default timeout of waiting for web elements in the page. */
	private final int DEFAULT_ELEMENT_TIMEOUT = 30;
	private final String XPATH_CHILD_ELEMENTS_LOCATOR = ".//*";
	private final String URL = "http://testjs.epizy.com/";

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Constructor /////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	public Site88Page(WebDriver driver) {
		PageFactory.initElements(
				new AjaxElementLocatorFactory(
				        driver, DEFAULT_ELEMENT_TIMEOUT), this);
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Web Elements ////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	/** Define the web element of title image by class name. */
	@FindBy(className = "title-image")
	private WebElement imageTitle;

	/** Define the web element of title image by class name. */
	@FindBy(className = "topnav")
	private WebElement navBar;
	
	/** Define the web element of title image by class name. */
	@FindBy(className = "form-control")
	private WebElement textBox;
	
	@FindBy(name = "testClickButton")
	private WebElement testButton;
	
	@FindBy(name = "submitEnabled")
	private WebElement submitButton;
	
	@FindBy(className = "smile-image")
	private WebElement smileImage;
	
        @FindBy(id = "amazingText")
	private WebElement feedbackText;
	
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Getters /////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	public WebElement getTestButton() {
		return testButton;
	}

	public WebElement getImageTitle() {
		return imageTitle;
	}
	
	public WebElement getNewsLink() {
		List<WebElement> navLinks = 
				navBar.findElements(By.xpath(XPATH_CHILD_ELEMENTS_LOCATOR));
		return navLinks
				.stream()
				.filter(link -> link.getAttribute("href")
				.contains("news"))
				.findFirst()
				.orElse(null);
	}

	public WebElement getTextBox() {
		return textBox;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getSmileImage() {
		return smileImage;
	}

	public WebElement getTextAfterSubmit() {
		return feedbackText;
	}

        public String getURL() {
                return URL;
        }
}
