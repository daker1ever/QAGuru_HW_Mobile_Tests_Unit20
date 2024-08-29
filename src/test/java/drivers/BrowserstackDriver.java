package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfiguration;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;


public class BrowserstackDriver implements WebDriverProvider {
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        BrowserstackConfiguration config = ConfigFactory.create(BrowserstackConfiguration.class, System.getProperties());
        DesiredCapabilities caps = new DesiredCapabilities();

        // Specify device and os_version for testing and URL of the application under test
        caps.setCapability("appium:app", config.getApp());
        caps.setCapability("appium:deviceName", config.getDeviceName());
        caps.setCapability("appium:platformVersion", config.getPlatformVersion());


        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("projectName", config.getProjectName());
        browserstackOptions.put("buildName", config.getBuildName());  // CI/CD job or build name

        caps.setCapability("bstack:options", browserstackOptions);

        // Set your access credentials
        // Initialise the remote AndroidDriver using BrowserStack remote URL
        // and desired capabilities defined above

        try {
            return new AndroidDriver(
                    new URL(config.getBrowserstackURL()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }



/* OLD Version
MutableCapabilities caps = new MutableCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "bsuser_IVtmvM");
        caps.setCapability("browserstack.key", "DW8YBGqDMXznA45QyPJE");

        // Set URL of the application under test
        caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL("https://hub.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }*/
    }
}

