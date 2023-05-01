/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handlers;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author josse
 */
public class JPEGtoBMPImage extends ImageHandler {
    String nombreCorto;
    BufferedImage jpg;
    BufferedImage bmp;
    File bmpTemporal;
    public File directorio = new File("./Temporal");
    
    public JPEGtoBMPImage(String filename) {
        super(filename);
        File file1 = new File( filename);
        this.nombreCorto=FilenameUtils.removeExtension(file1.getName());
    }

    @Override
    public void readFile() throws Exception {
       File file = new File(getFileName());
       jpg = ImageIO.read(file);
       bmpTemporal = new File("./bmpTemporal.bmp");
       ImageIO.write(jpg, "bmp", bmpTemporal);
       bmp = ImageIO.read(bmpTemporal);
    }

    @Override
    public void generateFiles() throws Exception {
         if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
        ImageIO.write(jpg, "bmp", new File("./Temporal/converted-"+nombreCorto+".bmp"));
        bmpTemporal.delete();
    }
    
}
