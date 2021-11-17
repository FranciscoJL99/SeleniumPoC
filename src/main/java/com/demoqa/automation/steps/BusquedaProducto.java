package com.demoqa.automation.steps;

import com.demoqa.automation.page.HomePage;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.junit.Assert.fail;


public class BusquedaProducto{

    HomePage homePage;
    WebDriverWait wait = new WebDriverWait(getDriver(), 15);

    @Step
    public void openBrowser(){
        homePage.open();
    }

    @Step
    public void busquedaProducto(String producto){
        getDriver().findElement(homePage.getSearchs()).sendKeys(producto);
        getDriver().findElement(homePage.getButtonSearchs()).click();
    }

    @Step
    public void agregarProductoAlCarrito(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.getButtonSubmit())).click();
    }

    @Step
    public void productoAgregado(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.getMessageAdd()));
        Assert.assertEquals("Product successfully added to your shopping cart", getDriver().findElement(homePage.getMessageAdd()).getText());
    }

    @Step
    public void resultadoEnBusqueda(String producto){
        try
        {
            if((getDriver().findElements(homePage.getAlerta()).size() == 0)){
                wait.until(ExpectedConditions.presenceOfElementLocated(homePage.product(producto))).click();
            }
        }
        catch(Exception e)
        {
            fail("La busqueda a realizar no tienes resultados");
        }
    }

}
