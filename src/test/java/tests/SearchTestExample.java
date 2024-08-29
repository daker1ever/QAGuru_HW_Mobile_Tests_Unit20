package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;

public class SearchTestExample extends TestBase{

    @Test
    void wikiSearchTest() {
        $(id("org.wikipedia.alpha:id/search_container")).click();
        $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        $$(id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0));


/*
        // Test case for the BrowserStack sample Android app.
        // If you have uploaded your app, update the test case here.
        WebElement searchElement = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Search Wikipedia")));
        searchElement.click();
        WebElement insertTextElement = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.id("org.wikipedia.alpha:id/search_src_text")));
        insertTextElement.sendKeys("Appium");
        Thread.sleep(5000);
        List<WebElement> allProductsName = driver.findElements(AppiumBy.className(
                "android.widget.TextView"));
        assert (allProductsName.size() > 0);

*/

    }
}
