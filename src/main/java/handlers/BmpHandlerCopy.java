/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handlers;
import java.io.*;
/**
 *
 * @author josse
 */
public class BmpHandlerCopy extends ImageHandler {

	/**
	*	Array of bytes that will allocate all header and data for original file
	**/
	protected byte[] filebytes;
	/**
	*	File name that will be given to the copy of the original file
	**/
	protected String copyname;
	
        public File fichero = new File("./Temporal");
	/**
	*	Builds and returns a BmpHandlerCopy object which handles the file 
	* 	represented by the given name
	*	@param imagename Name of the original file being handled by this object
	**/
	public BmpHandlerCopy(String imagename) {
		super(imagename);
                File archivo = new File(imagename);
                if (!fichero.exists()) {
                    if (fichero.mkdirs()) {
                        System.out.println("Directorio creado");
                    } else {
                        System.out.println("Error al crear directorio");
                    }
                }
		this.copyname = "./Temporal/copia-" + archivo.getName();
	}

	/**
	*	Reads handled file header and data in bytes
	**/
	public void readFile() throws Exception {
		FileInputStream input = new FileInputStream(this.handledFileName);
		filebytes = new byte[input.available()];
		input.read(filebytes);
		input.close();
		System.out.println("Imagen leida: " + this.handledFileName);
	}
	/**
	*	Generates a copy file from the original file. The name of the generated
	* 	file will be build by the same name preceeded of "copy-"
	**/	
	public void generateFiles() throws Exception {
		FileOutputStream output = new FileOutputStream(copyname);
		output.write(filebytes);
		output.close();
		System.out.println("Imagen generada: " + copyname);
	}
}