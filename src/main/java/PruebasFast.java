import java.io.File;

public class PruebasFast {
    public static void main (String [ ] args) {
        String PathFoto;
        String RUN_ID;
        RUN_ID = "123";
        PathFoto = System.getProperty("user.dir") + "/Fotos_RUN_" + RUN_ID;
        File newFolder = new File(PathFoto);

        boolean created =  newFolder.mkdir();

        if(created)
            System.out.println("Folder was created !");
        else
            System.out.println("Unable to create folder");
    }
}
