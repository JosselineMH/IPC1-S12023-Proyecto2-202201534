/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handlers;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.apache.commons.io.FilenameUtils;


/**
 *
 * @author josse
 */
public class JPEGImageHandlerRotator extends ImageHandler {
    String nombreCorto;
    BufferedImage jpg;
    BufferedImage bmp1;
    File bmpTemporal1;
    public JPEGImageHandlerRotator(String filename) {
        super(filename);
        File file1 = new File( filename);
        this.nombreCorto=FilenameUtils.removeExtension(file1.getName());
    }

    @Override
    public void readFile() throws Exception {
       File file = new File(getFileName());
       jpg = ImageIO.read(file);
       bmpTemporal1 = new File("./bmpTemporal.bmp");
       ImageIO.write(jpg, "bmp", bmpTemporal1);
       bmp1 = ImageIO.read(bmpTemporal1);
    }

    @Override
    public void generateFiles() throws Exception {
        int width = bmp1.getWidth();
        int height = bmp1.getHeight();
        
          // Rotar horizontalmente
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width / 2; x++) {
                int temp = bmp1.getRGB(x, y);
                bmp1.setRGB(x, y, bmp1.getRGB(width - x - 1, y));
                bmp1.setRGB(width - x - 1, y, temp);
            }
        }
        ImageIO.write(bmp1, "jpg", new File("./Temporal/Vrotation-" + nombreCorto + ".jpg"));
        
           // Volver a leer la imagen original para rotarla verticalmente
        jpg = ImageIO.read(new File(getFileName()));
        bmpTemporal1 = new File("./bmpTemporal.bmp");
        ImageIO.write(jpg, "bmp", bmpTemporal1);
        bmp1 = ImageIO.read(bmpTemporal1);
        width = bmp1.getWidth();
        height = bmp1.getHeight();
        
        // Rotar verticalmente
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height / 2; y++) {
                int temp = bmp1.getRGB(x, y);
                bmp1.setRGB(x, y, bmp1.getRGB(x, height - y - 1));
                bmp1.setRGB(x, height - y - 1, temp);
            }
        }
        ImageIO.write(bmp1, "jpg", new File("./Temporal/Hrotation-" + nombreCorto + ".jpg"));
        // Eliminar archivo temporal
        bmpTemporal1.delete();
    

    }
    
}
