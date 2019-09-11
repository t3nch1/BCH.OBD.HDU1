package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ReporteriaFotos {
    public static void captureScreen(String screenName, WebDriver driver, String RUN_ID) throws IOException {

        try {
            String PathFoto;
            PathFoto = System.getProperty("user.dir") + "/Fotos_RUN_" + RUN_ID + "/";

            File newFolder = new File(PathFoto);

            boolean created =  newFolder.mkdir();

            if(created)
                System.out.println("Folder was created !");
            else
                System.out.println("Unable to create folder");

            TakesScreenshot screen = (TakesScreenshot) driver;
            File src = screen.getScreenshotAs(OutputType.FILE);

            String dest = PathFoto + screenName + ".png"; //set any path where you want to save screenshot

            File target = new File(dest);
            FileUtils.copyFile(src, target);
        } catch (Exception e){
            System.out.println("WARNING!!!: No se están guardando las imagenes de evidencia en la carpeta compartida");
            e.printStackTrace();
        }
    }

    public static void assertTrueFoto(WebElement element) throws IOException {
        try{

            assertTrue(element.isDisplayed());
        }
        catch (AssertionError e){
            //takeScreenshot("ERROR", null);
            e.printStackTrace();
            fail("");
        }
    }

}
