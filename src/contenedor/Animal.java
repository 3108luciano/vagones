package contenedor;

public class Animal implements Comparable<Animal> {

	private String nombre;
	private int cantAnimal;
	private int nivelAgresividad;

	public Animal(String nombre, int nivelAgresividad, int cantAnimal) {

		this.nombre = nombre;
		this.cantAnimal = cantAnimal;
		this.nivelAgresividad = nivelAgresividad;
	}

	public int getNivelAgresividad() {
		return nivelAgresividad;
	}

	public void setNivelAgresividad(int nivelAgresividad) {
		this.nivelAgresividad = nivelAgresividad;
	}

	public int compatible(Animal otro) {

		return Math.abs(this.nivelAgresividad - otro.nivelAgresividad);
	}

	@Override
	public int compareTo(Animal o) {
		if(this.nivelAgresividad>o.nivelAgresividad)
			return -1;
		else
			return 1;
	}

}
