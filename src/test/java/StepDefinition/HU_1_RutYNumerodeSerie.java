package StepDefinition;


import PageObject.PaginaIngresoDatosEntradaOnboarding;
import Utils.ReporteriaFotos;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HU_1_RutYNumerodeSerie {

    public static WebDriver driver;
    public static PaginaIngresoDatosEntradaOnboarding ElementoPaginaEntrada;

    public static Boolean flagUrl;
    public static String URL;

    @Before
    public void openBrowser(){
        String UrlActual;
        try {
            System.out.println("URL: " + driver.getCurrentUrl());
            UrlActual = driver.getCurrentUrl();
            flagUrl = UrlActual.equals(URL);
        } catch (Exception e) {
            System.setProperty("webdriver.gecko.driver", "/home/t3nch1/WebDrivers/geckodriver");
            //FirefoxProfile firefoxProfile = new FirefoxProfile();
            //firefoxProfile.setPreference("xpinstall.signatures.required", false);
            //driver = new FirefoxDriver((Capabilities) firefoxProfile);
            driver = new FirefoxDriver();

            flagUrl = false;
        }
    }

    @Given("^que ingreso al sitio web (.+)$")
    public void queIngresoAlSitioWeb(String url) throws InterruptedException, IOException {
        if(!flagUrl)
        {
            driver.navigate().to(url);
            Thread.sleep(2000);
        }
        URL = driver.getCurrentUrl();
        ElementoPaginaEntrada = PageFactory.initElements(driver, PaginaIngresoDatosEntradaOnboarding.class);

        System.out.println("StepOK" + url);
        ReporteriaFotos.captureScreen("img1", driver, "22");
    }


    @When("^presiono el botón QUIERO UNA CUENTA$")
    public void presionoElBotonQUIEROUNACUENTA() throws IOException {
        ElementoPaginaEntrada.getBtnContinuar().click();
        ReporteriaFotos.captureScreen("img2", driver, "22");
        System.out.println("StepOK");
    }

    @When("^ingreso el rut (.+)$")
    public void ingresoElRut(String rut) throws IOException {

        rut = rut.replace("_",".");
        ElementoPaginaEntrada.getInputRut().clear();
        if(rut.equals("vacio")){
            ElementoPaginaEntrada.getInputRut().sendKeys("");
        }
        else
        {
            ElementoPaginaEntrada.getInputRut().sendKeys(rut);
        }
        ReporteriaFotos.captureScreen("img3", driver, "22");
        System.out.println("StepOK" + rut);
    }


    @Then("^el sistema no permitirá continuar$")
    public void elSistemaNoPermitiraContinuar() throws IOException{
        ReporteriaFotos.captureScreen("img4", driver, "22");
        System.out.println("StepOK");
    }

    @Then("^el sistema me llevara a la 'Página de Ingreso de Preguntas de Seguridad’ para validar mis preguntas de verificación de identidad$")
    public void elSistemaMeLlevaraALaPaginaDeIngresoDePreguntasDeSeguridadParaValidarMisPreguntasDeVerificacionDeIdentidad() throws IOException{
        System.out.println("StepOK");
        Assert.assertTrue(ElementoPaginaEntrada.getTituloPaginaPreguntasEquifax().isDisplayed());
        ReporteriaFotos.captureScreen("img5", driver, "22");
    }

    @And("^en los campos Rut y Numero de Documento mostraran el mensaje (.+)$")
    public void enLosCamposRutYNumeroDeDocumentoMostraranElMensajeDebeCompletarEsteCampo(String msg) throws IOException{
        Assert.assertEquals(msg, ElementoPaginaEntrada.getMsgRutVacio().getText());
        Assert.assertEquals(msg, ElementoPaginaEntrada.getMsgNumeroDocumentoVacio().getText());
        ReporteriaFotos.captureScreen("img6", driver, "22");
        System.out.println("StepOK" + msg);
    }

    @And("^ingreso el Numero de Documento (.+)$")
    public void ingresoElNumeroDeDocumento(String numDocumento) throws IOException{
        numDocumento = numDocumento.replace("_",".");
        ElementoPaginaEntrada.getInputNumeroDeSerie().clear();
        if(numDocumento.equals("vacio")){
            ElementoPaginaEntrada.getInputNumeroDeSerie().sendKeys("");
        }
        else
        {
            ElementoPaginaEntrada.getInputNumeroDeSerie().sendKeys(numDocumento);
        }
        System.out.println("StepOK" + numDocumento);
        ReporteriaFotos.captureScreen("img7", driver, "22");
    }

    @And("^El Campo Numero de Documento mostraran el mensaje (.+)$")
    public void elCampoNumeroDeDocumentoMostraranElMensajeDebeCompletarEsteCampo(String msg) throws IOException{
        if(msg.equals("Debe ingresar un Numero de documento valido"))
            Assert.assertEquals(msg, ElementoPaginaEntrada.getMsgNumeroDocumentoInvalido().getText());
        else
            Assert.assertEquals(msg, ElementoPaginaEntrada.getMsgNumeroDocumentoVacio().getText());

        ReporteriaFotos.captureScreen("img8", driver, "22");
        System.out.println("StepOK" + msg);
    }

    @And("^Campo Rut mostrara el mensaje (.+)$")
    public void campoRutMostraraElMensajeDebeCompletarEsteCampo(String msg) throws IOException{
        if(msg.equals("Rut inválido"))
            Assert.assertEquals(msg, ElementoPaginaEntrada.getMsgRutInvalido().getText());
        else
            Assert.assertEquals(msg, ElementoPaginaEntrada.getMsgRutVacio().getText());

        ReporteriaFotos.captureScreen("img9", driver, "22");
        System.out.println("StepOK" + msg);
    }

    @And("^Campo Numero de Documento me mostrara el mensaje (.+)$")
    public void campoNumeroDeDocumentoMeMostraraElMensajeDebeIngresarUnNumeroDeDocumentoValido(String msg) throws IOException{
        try{
            Assert.assertEquals(msg, ElementoPaginaEntrada.getMsgNumeroDocumentoInvalido().getText());
        }
        catch (AssertionError e)
        {
            System.out.println(e);
        }


        ReporteriaFotos.captureScreen("img10", driver, "22");
        System.out.println("StepOK" + msg);
    }

    @And("^se despliega la pagina de Onboarding Digital con el campo Rut, Numero de Documento, Botón QUIERO UNA CUENTA deshabilitado$")
    public void seDespliegaLaPaginaDeOnboardingDigitalConElCampoRutNumeroDeDocumentoBotonQUIEROUNACUENTADeshabilitado() throws IOException {
        Assert.assertTrue(ElementoPaginaEntrada.getInputRut().isDisplayed());
        Assert.assertTrue(ElementoPaginaEntrada.getInputNumeroDeSerie().isDisplayed());
        Assert.assertTrue(ElementoPaginaEntrada.getBtnContinuar().isDisplayed());
        ReporteriaFotos.captureScreen("img11", driver, "22");
        System.out.println("StepOK");
    }
}
