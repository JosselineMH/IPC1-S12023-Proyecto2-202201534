/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handlers;

import java.awt.Color;
import java.awt.image.*;
import java.io.File;
import javax.imageio.ImageIO;
import org.apache.commons.io.FilenameUtils;
/**
 *
 * @author josse
 */
public class BMPtoJPEGImage extends ImageHandler{
    String nombreCorto;
    BufferedImage jpg;
    BufferedImage bmp;
    File jpgTemporal;
    public File directorio = new File("./Temporal");

    public BMPtoJPEGImage(String filename) {
        super(filename);
        File file1 = new File( filename);
        this.nombreCorto=FilenameUtils.removeExtension(file1.getName());
    }
    
    @Override
    public void readFile() throws Exception {
       File file = new File(getFileName());
       bmp = ImageIO.read(file);
       jpgTemporal = new File("./jpgTemporal.jpg");
       ImageIO.write(bmp, "jpg", jpgTemporal);
       jpg = ImageIO.read(jpgTemporal);
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
        ImageIO.write(bmp, "jpg", new File("./Temporal/converted-"+nombreCorto+".jpg"));
        jpgTemporal.delete();
    }
    
}
