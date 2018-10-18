package contenedor;

import java.io.FileNotFoundException;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		
		Vagon vagon = Archivo.leer("vagones.in");
		vagon =vagon.resolver();
		Archivo.escribir(vagon,"vagones.out");
		
	}
	
}
