package cucumber;

import com.equalexperts.managers.PageObjectManager;
import com.equalexperts.managers.WebDriverManager;
import com.equalexperts.utils.ConfigFileReader;

public class TestContext {
    private WebDriverManager webDriverManager;
    private PageObjectManager pageObjectManager;
    private ConfigFileReader configFileReader;
    private int numberOfBookings = 0;

    public TestContext() {
        webDriverManager = new WebDriverManager();
        pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
        configFileReader = new ConfigFileReader();
    }

    public ConfigFileReader getConfigFileReader() {
        return configFileReader;
    }

    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    public int getNumberOfBookings() {
        return numberOfBookings;
    }

    public void setNumberOfBookings(int numberOfBookings) {
        this.numberOfBookings = numberOfBookings;
    }
}
