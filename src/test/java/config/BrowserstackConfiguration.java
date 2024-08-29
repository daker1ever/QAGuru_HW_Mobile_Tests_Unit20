package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:data.properties"
})
public interface BrowserstackConfiguration extends Config {
    @Key("projectName")
    String getProjectName();

    @Key("buildName")
    String getBuildName();

    @Key("userName")
    String getUserName();

    @Key("userKey")
    String getUserKey();

    @Key("app")
    String getApp();

    @Key("deviceName")
    String getDeviceName();

    @Key("platformVersion")
    String getPlatformVersion();

    @Key("browserstackURL")
    String getBrowserstackURL();

}
