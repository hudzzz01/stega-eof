import service.SteganoService;
import service.impl.SteganoServiceImpl;

import java.io.File;

public class App {
    public static void main(String[] args) {
        SteganoService service = new SteganoServiceImpl();

        File fileReceptacle = new File("wadah.jpg");
        File fileSecret = new File("pesan.mp4");

        service.insertAsecretFileToReceptacleFile(fileReceptacle,fileSecret);


    }

}
