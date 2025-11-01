package com.pepperfryapp.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPage {

    AppiumDriver driver;

    // Locators
    By searchIcon = By.id("com.pepperfry:id/menu_search");
    By searchInput = By.id("com.pepperfry:id/search_edit_text");
    By firstResult = By.xpath("(//android.widget.TextView)[2]");

    public SearchPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void searchItem(String itemName) {
        driver.findElement(searchIcon).click();
        driver.findElement(searchInput).sendKeys(itemName + "\n");
    }

    public boolean isResultDisplayed() {
        return driver.findElements(firstResult).size() > 0;
    }
}
