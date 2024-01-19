package stepdefs.project;


import com.beust.ah.A;
import helpers.base.Logger;
import helpers.ui.DriverHelper;
import helpers.ui.UiHelper;
import io.cucumber.core.cli.Main;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import stepdefs.ui.UiBaseStepDefs;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProjectStepDefs {
    public final org.apache.log4j.Logger logger = Logger.getLogger(Logger.class);
    private final DriverHelper driverHelper;
    private final UiBaseStepDefs uiBaseStepDefs;
    private final UiHelper uiHelper;

    public ProjectStepDefs(DriverHelper driverHelper, UiBaseStepDefs uiBaseStepDefs,UiHelper uiHelper) {
        this.driverHelper = driverHelper;
        this.uiBaseStepDefs = uiBaseStepDefs;
        this.uiHelper = uiHelper;
    }

    @Given("run scenario {}")
    public Thread runScenario(String scenarioName) throws Exception {
        try {
            String[] cucumberOptions = {
                    "--glue", "stepdefs",
                    //"--tags", "@all",
                    "--name", "^" + scenarioName + "$",
                    "src/test/resources/features"
            };
            Main.run(cucumberOptions, Thread.currentThread().getContextClassLoader());

            return Thread.currentThread();
        } catch (Exception e) {
            logger.error("The method causing the error : ProjectStepDefs - runScenario");
            throw new Exception(e.getMessage());
        }
    }

    public Thread runScenarioFor(String scenarioName, ClassLoader classLoader) throws Exception {
        try {
            String[] cucumberOptions = {
                    "--glue", "stepdefs",
                    //"--tags", "@all",
                    "--name", "^" + scenarioName + "$",
                    "src/test/resources/features"
            };
            Main.run(cucumberOptions, classLoader);
            return Thread.currentThread();
        } catch (Exception e) {
            logger.error("The method causing the error : ProjectStepDefs - runScenario");
            throw new Exception(e.getMessage());
        }
    }


    @Given("paralel run scenario with the following scenarios")
    public void paralelRunScenario(DataTable scenarioTable) throws Exception {
        List<String> scenarioList = scenarioTable.asList();

        ExecutorService executor = Executors.newFixedThreadPool(scenarioList.size());

        for (String scenario : scenarioList) {
            Runnable worker = new ScenarioRunner(scenario);
            executor.execute(worker);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }
    }

    class ScenarioRunner implements Runnable {
        private String scenario;

        public ScenarioRunner(String scenario) {
            this.scenario = scenario;
        }

        @Override
        public void run() {
            // Burada senaryoyu çalıştırabilirsiniz
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            try {
                runScenarioFor(scenario, classLoader);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @And("click on the desired date for departure {}")
    public void clickOnTheDesiredDate(String date) throws Exception {
        String[] dateParts = date.split("\\s+", 2);
try {


        while (true) {
            WebElement monthYear = driverHelper.getDriver().findElement(By.xpath("(//h3[@data-testid='enuygun-homepage-flight-departureDate-month-name-and-year'])[1]"));
            WebElement monthYear2 = driverHelper.getDriver().findElement(By.xpath("(//h3[@data-testid='enuygun-homepage-flight-departureDate-month-name-and-year'])[2]"));
            WebElement nextButton = driverHelper.getDriver().findElement(By.xpath("//button[@data-testid='enuygun-homepage-flight-departureDate-month-forward-button']"));

            if (Objects.equals(monthYear.getText(), dateParts[1])) {
                WebElement day = driverHelper.getDriver().findElement(By.xpath("(//button[@data-testid='datepicker-active-day' and @data-day='"+dateParts[0]+"'])[1]"));
                day.click();
                return;
            } else if (Objects.equals(monthYear2.getText(), dateParts[1])) {
                WebElement day2 = driverHelper.getDriver().findElement(By.xpath("(//button[@data-testid='datepicker-active-day' and @data-day='"+dateParts[0]+"'])[2]"));
                day2.click();
                return;
            }
            nextButton.click();
        }
}catch (Exception e) {
    throw new RuntimeException(e + "İlgili tarih bulunamadı.");
}
    }

    @And("click on the desired date for return {}")
    public void clickOnTheDesiredDateReturn(String date) throws Exception {
        String[] dateParts = date.split("\\s+", 2);
        try {

            uiHelper.independentWait(3);
            while (true) {
                WebElement monthYear = driverHelper.getDriver().findElement(By.xpath("(//h3[@data-testid='enuygun-homepage-flight-returnDate-month-name-and-year'])[1]"));
                WebElement monthYear2 = driverHelper.getDriver().findElement(By.xpath("(//h3[@data-testid='enuygun-homepage-flight-returnDate-month-name-and-year'])[2]"));
                WebElement nextButton = driverHelper.getDriver().findElement(By.xpath("//button[@data-testid='enuygun-homepage-flight-returnDate-month-forward-button']"));

                if (Objects.equals(monthYear.getText(), dateParts[1])) {
                    WebElement day = driverHelper.getDriver().findElement(By.xpath("(//button[@data-testid='datepicker-active-day' and @data-day='"+dateParts[0]+"'])[1]"));
                    day.click();
                    return;
                } else if (Objects.equals(monthYear2.getText(), dateParts[1])) {
                    WebElement day2 = driverHelper.getDriver().findElement(By.xpath("(//button[@data-testid='datepicker-active-day' and @data-day='"+dateParts[0]+"'])[2]"));
                    day2.click();
                    return;
                }
                nextButton.click();
            }
        }catch (Exception e) {
            throw new RuntimeException(e + "İlgili tarih bulunamadı.");
        }
    }

    @And("10:00-18:00 departure time and verify")
    public void departureTime() throws Exception {

        WebElement firstSlider = driverHelper.getDriver().findElement(By.xpath("(//div[@class='rc-slider-handle rc-slider-handle-1'])[1]"));
        WebElement secondSlider = driverHelper.getDriver().findElement(By.xpath("(//div[@class='rc-slider-handle rc-slider-handle-2'])[1]"));
        WebElement verifyText = driverHelper.getDriver().findElement(By.xpath("(//div[@class='filter-slider-content'])[1]"));
        Actions action = new Actions(driverHelper.getDriver());
        try {
            uiHelper.independentWait(2);
            action.dragAndDropBy(firstSlider,100,0).perform();
            uiHelper.independentWait(2);
            action.dragAndDropBy(secondSlider,-60,0).perform();
            if (Objects.equals(verifyText.getText(), "10:00 ile 18:00 arası")){
                System.out.println("Doğru saatler arası sıralama yapılmıştır");
            }else {
                throw new RuntimeException("Yanlış saatler arası sıralama yapılmıştır.");
            }

        }catch (Exception e) {
            throw new RuntimeException(e + "İlgili tarih bulunamadı.");
        }
    }

    @And("10:00-18:00 landing time and verify")
    public void landingTime() throws Exception {

        WebElement firstSlider = driverHelper.getDriver().findElement(By.xpath("(//div[@class='rc-slider-handle rc-slider-handle-1'])[2]"));
        WebElement secondSlider = driverHelper.getDriver().findElement(By.xpath("(//div[@class='rc-slider-handle rc-slider-handle-2'])[2]"));
        WebElement verifyText = driverHelper.getDriver().findElement(By.xpath("(//div[@class='filter-slider-content'])[2]"));
        Actions action = new Actions(driverHelper.getDriver());
        try {
            uiHelper.independentWait(2);
            action.dragAndDropBy(firstSlider,100,0).perform();
            uiHelper.independentWait(2);
            action.dragAndDropBy(secondSlider,-60,0).perform();
            if (Objects.equals(verifyText.getText(), "10:00 ile 18:00 arası")){
                System.out.println("Doğru saatler arası sıralama yapılmıştır");
                uiHelper.independentWait(2);
            }else {
                throw new RuntimeException("Yanlış saatler arası sıralama yapılmıştır.");
            }

        }catch (Exception e) {
            throw new RuntimeException(e + "İlgili tarih bulunamadı.");
        }
    }
    @And("Checking price list from smallest to largest")
    public void checkingPriceList() throws Exception {
        List<WebElement> pricesList = driverHelper.getDriver().findElements(By.xpath("//span[@class='money-int']"));

        List<Double> prices = new ArrayList<>();
        for (WebElement priceElement : pricesList) {
            String priceText = priceElement.getText().replace(",", ".");
            double price = Double.parseDouble(priceText);
            prices.add(price);

            // Tek tek yazdırmak için
            System.out.println("Price: " + price);
        }

        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) > prices.get(i + 1)) {
                throw new RuntimeException("Sıralama yanlıştır");
            }
        }
        System.out.println("Sıralama doğrudur");
    }

}