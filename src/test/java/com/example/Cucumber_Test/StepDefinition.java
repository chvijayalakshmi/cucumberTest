package com.example.Cucumber_Test;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.util.List;
import static java.lang.Thread.sleep;

public class StepDefinition {
    ChromeDriver driver;
    @Given("SVT Play is available")
    public void svt_play_is_available() {

        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        co.addArguments("incognito");
        driver = new ChromeDriver(co);
        driver.get("https://www.svtplay.se/");

    }

    @When("User visits SVT Play")
    public void user_visits_svt_play() throws InterruptedException {
       driver.manage().window().maximize();
       sleep(2000);
        driver.findElement(By.cssSelector("#__next > div.sc-4f221cd2-1.fHHyBJ > div > div.sc-4f221cd2-8.bRFLbH > button.sc-5b00349a-2.fuGbXH.sc-4f221cd2-9.hEiUxP")).click();
        sleep(2000);


    }
    @Then("Title should be {string}")
    public void title_should_be(String string) {
    String s = driver.getTitle();
        Assertions.assertEquals("SVT Play", s, "Title is not same");
        driver.quit();
    }

    @Then("Logo should be visible")
    public void logo_should_be_visible() {
        Boolean display = driver.findElement(By.cssSelector("#__next > div > div.play_root-container > div > header > div.sc-5a076cf9-1.kyZyc > div > div > nav > a > svg")).isDisplayed();
        if (display==true)
        System.out.println("******************  Logo Is Displayed   ********************");
        driver.quit();
    }
    @Then("The link names in the main menu should be {string}")
    public void the_link_names_in_the_main_menu_should_be(String string) {
        //String x= driver.findElement(By.xpath("//li[@type=\"start\"]")).getText();
        String x = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/header/div[2]/div/div/nav/ul/li[1]")).getText();
        Assertions.assertEquals("START",x);
        //String y = driver.findElement(By.xpath("//li[@type=\"programs\"]")).getText();
        String y = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/header/div[2]/div/div/nav/ul/li[2]")).getText();
        Assertions.assertEquals("PROGRAM", y);
        String z= driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/header/div[2]/div/div/nav/ul/li[3]")).getText();
        Assertions.assertEquals("KANALER",z);
        driver.quit();
    }
    @Then("link text for Tillgänglighet i SVT Play should show the correct link text")
    public void link_text_for_tillgänglighet_i_svt_play_should_show_the_correct_link_text() throws InterruptedException {
        sleep(3000);
        String lt = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/footer/div/div[5]/div[2]/p[1]/a/span[2]")).getText();
        Assertions.assertEquals("Tillgänglighet i SVT Play",lt);
        driver.quit();
            }

    @When("User clicks on Program link")
    public void user_clicks_on_program_link() throws InterruptedException {
        driver.findElement(By.cssSelector("#__next > div > div.play_root-container > div > header > div.sc-5a076cf9-1.kyZyc > div > div > nav > ul > li:nth-child(2) > a")).click();
        sleep(3000);
    }
    @Then("Count the total number of programs")
    public void count_the_total_number_of_programs() throws InterruptedException {

        Thread.sleep(3000);
        List<WebElement> countOfAllPrograms = driver.findElements(By.className("hjlmUN"));
        Thread.sleep(3000);
        int c = countOfAllPrograms.size();
        Thread.sleep(3000);
        Assertions.assertEquals(17,c);
        driver.quit();
    }


    @When("User  click on Kanaler link")
    public void user_click_on_kanaler_link() {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/header/div[2]/div/div/nav/ul/li[3]/a")).click();
    }

    @When("User select particular date")
    public void user_select_particular_date() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"play_main-content\"]/div/section/div/div/a/span[2]")).click();
        driver.findElement(By.xpath("//a[@aria-label=\"27 mars\"]")).click();
    }

    @Then("URL has to update with selected date")
    public void url_has_to_update_with_selected_date() {
        //String url= driver.findElement(By.linkText("/kanaler?range=day&date=2023-03-27")).getText();
        String url= driver.findElement(By.xpath("//a[@aria-label=\"27 mars\"]")).getAttribute("href");
        Assertions.assertEquals("https://www.svtplay.se/kanaler?date=2023-03-27&range=day", url);
        driver.quit();
    }

    @Then("Count the total number of categories")
    public void count_the_total_number_of_categories() throws InterruptedException {
        sleep(3000);
   List<WebElement> CountOfCategories =  driver.findElements(By.className("sc-a3880b6b-3"));
   int COUNT = CountOfCategories.size();
   Assertions.assertEquals(18, COUNT, "Count of categories is not same");
   driver.quit();
    }

    @When("User clicks on Tillgänglighet i SVT Play link")
    public void user_clicks_on_tillgänglighet_i_svt_play_link() {
    driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/footer/div/div[5]/div[2]/p[1]/a/span[2]")).click();
    }

    @Then("the heading should be {string}")
    public void the_heading_should_be(String heading) {
    String s=driver.findElement(By.className("text-3xl")).getText();
    Assertions.assertEquals(heading,s);
    driver.quit();
    }
    @When("user clicks on om oss")
    public void user_clicks_on_om_oss() throws InterruptedException {
        driver.findElement(By.linkText("Om oss")).click();
        sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"topmenu\"]/ul/li[1]/a")).click();

    }
    @Then("Om Oss Heading should be match")
    public void om_oss_heading_should_be_match() throws InterruptedException {
        sleep(3000);
        String t = driver.findElement(By.cssSelector("#h-ValkommentillhelaSverigestelevision")).getText();
        driver.quit();
    }



}




