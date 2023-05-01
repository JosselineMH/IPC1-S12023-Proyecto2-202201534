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
public class JPEGImageHandlerBN extends ImageHandler{
    String nombreCorto;
    BufferedImage jpg;
    BufferedImage bmp;
    File bmpTemporal;
    public File directorio = new File("./Temporal");

    public JPEGImageHandlerBN(String filename) {
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
        for (int x=0; x<bmp.getWidth(); x++) {
            for (int y=0; y<bmp.getHeight(); y++) {
               Color color = new Color(bmp.getRGB(x,y));
               int promedio = (color.getBlue()+color.getGreen()+color.getRed())/3;
               Color BlancoNegro = new Color(promedio, promedio, promedio);
               bmp.setRGB(x, y, BlancoNegro.getRGB());
            }
        }
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
        ImageIO.write(bmp, "jpg", new File("./Temporal/BN-"+nombreCorto+".jpg"));
        bmpTemporal.delete();
    }

}
