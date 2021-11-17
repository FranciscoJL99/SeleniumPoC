package com.demoqa.automation.page;

import lombok.Getter;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@Getter
@DefaultUrl("http://automationpractice.com/index.php")
public class HomePage extends PageObject {
    By searchs = By.id("search_query_top");
    By buttonSearchs = By.name("submit_search");
    By alerta = By.xpath("//p[@class='alert alert-warning']");
    By buttonSubmit = By.name("Submit");
    By messageAdd = By.xpath("//*[@id='layer_cart']/div[1]/div[1]/h2[1]");

    public By product(String product){
        return By.xpath("//*[contains(text(), '"+ product + "')]");
    }
}
