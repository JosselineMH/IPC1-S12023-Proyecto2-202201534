/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handlers;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author josse
 */
public class JPEGImageHandlerColors extends ImageHandler {
    String nombreCorto;
    BufferedImage jpg;
    BufferedImage bmp1,bmp2, bmp3,bmp4;
    File bmpTemporal1, bmpTemporal2, bmpTemporal3, bmpTemporal4;
    public File directorio = new File("./Temporal");
    
    public JPEGImageHandlerColors(String filename) {
        super(filename);
        File file1 = new File( filename);
        this.nombreCorto=FilenameUtils.removeExtension(file1.getName());
    }

    @Override
    public void readFile() throws Exception {
        File file = new File(getFileName());
       jpg = ImageIO.read(file);
       
       bmpTemporal1 = new File("./bmpTemporal.bmp");
       bmpTemporal2 = new File("./bmpTemporal.bmp");
       bmpTemporal3 = new File("./bmpTemporal.bmp");
       bmpTemporal4 = new File("./bmpTemporal.bmp");
       ImageIO.write(jpg, "bmp", bmpTemporal4);
       bmp1 = ImageIO.read(bmpTemporal1);
       bmp2 = ImageIO.read(bmpTemporal2);
       bmp3 = ImageIO.read(bmpTemporal3);
       bmp4 = ImageIO.read(bmpTemporal4);
       
    }

    @Override
    public void generateFiles() throws Exception {  
        for (int x=0; x<bmp1.getWidth(); x++) {
            for (int y=0; y<bmp1.getHeight(); y++) {
                int rgb = bmp1.getRGB(x, y);
                Color color = new Color(rgb,true);
                Color rojo = new Color((int)(color.getRed()),(int)(0), (int)(0));
                bmp1.setRGB(x,y, rojo.getRGB());
            }
        }
        for (int x=0; x<bmp2.getWidth(); x++) {
            for (int y=0; y<bmp2.getHeight(); y++) {
                int rgb = bmp2.getRGB(x, y);
                Color color = new Color(rgb,true);
                Color verde = new Color((int)(0),(int)(color.getGreen()), (int)(0));
                bmp2.setRGB(x,y, verde.getRGB());
            }
        }
        for (int x=0; x<bmp3.getWidth(); x++) {
            for (int y=0; y<bmp3.getHeight(); y++) {
                int rgb = bmp3.getRGB(x, y);
                Color color = new Color(rgb,true);
                Color verde = new Color((int)(0),(int)(0), (int)(color.getBlue()));
                bmp3.setRGB(x,y, verde.getRGB());
            }
        }
        for (int x=0; x<bmp4.getWidth(); x++) {
            for (int y=0; y<bmp4.getHeight(); y++) {
                int rgb = bmp4.getRGB(x, y);
                Color color = new Color(rgb,true);
                Color newColor = new Color((int)(0.40*color.getBlue()),(int)(0.23*color.getBlue()), (int)(0.16*color.getBlue()));
                bmp4.setRGB(x,y, newColor.getRGB());
            }
        }
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
        ImageIO.write(bmp1, "jpg", new File("./Temporal/red-"+nombreCorto+".jpg"));
        bmpTemporal1.delete();
        ImageIO.write(bmp2, "jpg", new File("./Temporal/green-"+nombreCorto+".jpg"));
        bmpTemporal2.delete();
        ImageIO.write(bmp3, "jpg", new File("./Temporal/blue-"+nombreCorto+".jpg"));
        bmpTemporal3.delete();
        ImageIO.write(bmp4, "jpg", new File("./Temporal/sepia-"+nombreCorto+".jpg"));
        bmpTemporal4.delete();
    }   
    
}
