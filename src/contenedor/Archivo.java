package contenedor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivo {

	
	public static Vagon leer(String path) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File(path));
		
		ArrayList<Animal>vAnimal = new ArrayList<Animal>();
		
		int cantAnimal= sc.nextInt();
		int limiteAgresividad =sc.nextInt();
		
		for(int i=0;i<cantAnimal;i++) {
			vAnimal.add(new Animal(sc.next(), sc.nextInt(), sc.nextInt()));
			
		}
		
		return new Vagon(vAnimal,limiteAgresividad);
		
	}
	
	public static void escribir(Vagon vagon,String path) throws FileNotFoundException {
		
		PrintWriter salida = new PrintWriter(new File(path));
		
		salida.print(vagon.getCantVagon()+" "+vagon.getAgresividadTotal());
		
		
		salida.close();
	}
}
