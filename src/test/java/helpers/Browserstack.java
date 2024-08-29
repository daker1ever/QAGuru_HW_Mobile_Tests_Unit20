package helpers;

import config.BrowserstackConfiguration;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;


public class Browserstack {


    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);
        BrowserstackConfiguration config = ConfigFactory.create(BrowserstackConfiguration.class, System.getProperties());
        return given()
                .auth().basic(config.getUserName(), config.getUserKey())
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}