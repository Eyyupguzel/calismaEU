package helpers.ui;

import helpers.base.Logger;

public class UiConfigHelper {
    private final org.apache.log4j.Logger logger = Logger.getLogger(Logger.class);
    private final String browserNameDefault = "Chrome";
    private final int implicitWait = 10;
    private final int explicitWait = 5;
    private final int pageLoadWait = 30;
    private final String enuygunTestWebUrl = "https://www.enuygun.com/";




    /**
     * Belirtilen URL için ilgili yapılandırma verisini döndürür.
     *
     * @param specifiedUrl Belirli bir URL'nin yapılandırma verisi.
     * @return İlgili yapılandırma verisi.
     * @throws Exception Hata durumunda fırlatılır.
     */
    public String getUiConfigData(String specifiedUrl) throws Exception {
        try {
            switch (specifiedUrl) {
                case "enuygunTestWebUrl":
                    return enuygunTestWebUrl;
                default:
                    return null;
            }
        } catch (Exception e) {
            logger.error("\t The method causing the error: TestConfig - getUiConfigData");
            throw new Exception(e.getMessage());
        }
    }


    public String getEnuygunTestWebUrl() {
        return enuygunTestWebUrl;
    }

    public String getBrowserName() {
        return browserNameDefault;
    }

    public int getImplicitWait() {
        return implicitWait;
    }

    public int getExplicitWait() {
        return explicitWait;
    }


    public int getPageLoadWait() {
        return pageLoadWait;
    }


}
