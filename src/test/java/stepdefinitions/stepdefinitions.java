package stepdefinitions;

import com.demoqa.automation.models.DatosProducto;
import com.demoqa.automation.steps.BusquedaProducto;
import cucumber.api.DataTable;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class stepdefinitions {
    @Steps
    BusquedaProducto busquedaProducto;

    public WebDriver driver;


    @Dado("^ingreso a la pagina de automation practice$")
    public void ingresoALaPaginaDeAutomationPractice() {
       busquedaProducto.openBrowser();
    }

    @Cuando("^realizo la busqueda de un producto$")
    public void realizoLaBusquedaDeUnProducto(List<DatosProducto> datosProductos) {
        busquedaProducto.busquedaProducto(datosProductos.get(0).getProducto());
    }

    @Y("^esta tiene algun resultado$")
    public void estaTieneAlgunResultado(List<DatosProducto> datosProductos) {
        busquedaProducto.resultadoEnBusqueda(datosProductos.get(0).getProducto());
    }

    @Y("^agrego el producto al carrito$")
    public void agregoElProductoAlCarrito() {
        busquedaProducto.agregarProductoAlCarrito();
    }

    @Entonces("^visualizo que se agrega correctamente$")
    public void visualizoQueSeAgregaCorrectamente() {
        busquedaProducto.productoAgregado();
    }


}
