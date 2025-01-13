import org.junit.Assert;
import org.junit.Test;
import service.SteganoService;
import service.impl.SteganoServiceImpl;
import static org.junit.Assert.*;

import java.io.File;

public class SteganoServiceTest {
    @Test
    public void testInsertAsecretFileToReceptacleFile() {
        //optional
        SteganoService service = new SteganoServiceImpl();
        File fileReceptacle = new File("wadah3.png");
        File fileSecret = new File("pesan.mp4");
        Integer[] result = service.insertAsecretFileToReceptacleFile(fileReceptacle, fileSecret);

        //jika lebih dari 1 maka berhasil
        System.out.println(result[0]);
        assertEquals(0, result[0].intValue());

        //panjang kunci
        System.out.println(result[1]);
    }

    @Test
    public void testExtractSecretFileFromReceptacleFile() {
        SteganoService service = new SteganoServiceImpl();
        File fileForExtractMessage = new File("stegano3.png");
        Integer[] result = service.extractSecretFileFromReceptacleFile(fileForExtractMessage, 3296451, "mp4");
        System.out.println(result[0]);
        assertEquals(0, result[0].intValue());
        System.out.println(result[1]);
    }


    @Test
    public void testInsertAsecretFileToReceptacleFileCustomDirectory() {
        //optional
        SteganoService service = new SteganoServiceImpl();

        service.setOutputPath(".");

        File fileReceptacle = new File("asset/wadah3.png");
        File fileSecret = new File("asset/pesan.mp4");
        Integer[] result = service.insertAsecretFileToReceptacleFile(fileReceptacle, fileSecret);

        //jika lebih dari 1 maka berhasil
        System.out.println(result[0]);
        assertEquals(1, result[0].intValue());

        //panjang kunci
        System.out.println(result[1]);
    }

    @Test
    public void testExtractSecretFileFromReceptacleFileCustomDirectory() {
        SteganoService service = new SteganoServiceImpl();
        //set custom directory
        service.setOutputMessage(".");

        File fileForExtractMessage = new File("asset/stegano3.png");
        Integer[] result = service.extractSecretFileFromReceptacleFile(fileForExtractMessage, 3296451, "mp4");
        System.out.println(result[0]);
        assertEquals(1, result[0].intValue());
        System.out.println(result[1]);
    }

}
