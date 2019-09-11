package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PaginaIngresoDatosEntradaOnboarding {

    @FindBy(how = How.XPATH, using = "/html/body/onboarding-root/div/main/div/cuenta-inicio/div/form/div/div/h2")
    private WebElement TituloPagina;

    @FindBy(how = How.ID, using = "rut-input")
    private WebElement InputRut;

    @FindBy(how = How.ID, using = "numero-de-serie-input")
    private WebElement InputNumeroDeSerie;

    @FindBy(how = How.XPATH, using = "//*[@id=\"continuar-btn\"]/div/button")
    private WebElement btnContinuar;

    @FindBy(how = How.ID, using = "rut-input-error-invalido")
    private WebElement msgRutInvalido;

    @FindBy(how = How.ID, using = "rut-input-error-requerido")
    private WebElement msgRutVacio;

    @FindBy(how = How.ID, using = "serie-input-error-formato")
    private WebElement msgNumeroDocumentoInvalido;

    @FindBy(how = How.ID, using = "serie-input-error-requerido")
    private WebElement msgNumeroDocumentoVacio;

    @FindBy(how = How.XPATH, using = "/html/body/onboarding-root/div/main/div/onboarding-steps/mat-horizontal-stepper/div[2]/div[1]/cuenta-verificacion-identidad/div/div/div[2]/mat-card/mat-card-header/div/mat-card-title/h2")
    private WebElement TituloPaginaPreguntasEquifax;

    public WebElement getTituloPagina() {
        return TituloPagina;
    }

    public WebElement getInputRut() {
        return InputRut;
    }

    public WebElement getInputNumeroDeSerie() {
        return InputNumeroDeSerie;
    }

    public WebElement getBtnContinuar() {
        return btnContinuar;
    }

    public WebElement getMsgRutInvalido() {
        return msgRutInvalido;
    }

    public WebElement getMsgRutVacio() {
        return msgRutVacio;
    }

    public WebElement getMsgNumeroDocumentoInvalido() {
        return msgNumeroDocumentoInvalido;
    }

    public WebElement getMsgNumeroDocumentoVacio() {
        return msgNumeroDocumentoVacio;
    }

    public WebElement getTituloPaginaPreguntasEquifax() {
        return TituloPaginaPreguntasEquifax;
    }



    }
