package contenedor;

import java.util.ArrayList;
import java.util.Collections;

public class Vagon {
	private ArrayList<Animal> vAnimal;
	private int limiteAgresividad;
	private int cantVagon;
	private int agresividadTotal;

	public void setAgresividadTotal(int agresividadTotal) {
		this.agresividadTotal = agresividadTotal;
	}

	public Vagon(ArrayList<Animal> vAnimal, int limiteAgresividad) {
		this.vAnimal = vAnimal;
		this.limiteAgresividad = limiteAgresividad;
	}

	public void setCantVagon(int cantVagon) {
		this.cantVagon = cantVagon;
	}

	public int getCantVagon() {
		return cantVagon;
	}

	public int getAgresividadTotal() {
		return agresividadTotal;
	}

	public Vagon resolver() {

		Collections.sort(vAnimal);
		int i = 0, j = 0, max = 0, pos = 0, cantidad = 1, cantvagones = 0;
		int agresividad = 0, acumulador = 0;

		while (vAnimal.size() > 0) {

			j = i + 1;

			while (i < vAnimal.size() && j < vAnimal.size()) {

				while (j < vAnimal.size() && Math.abs((vAnimal.get(i).getNivelAgresividad()- vAnimal.get(j).getNivelAgresividad())) <= limiteAgresividad) {
					cantidad++;
					j++;
				}
				if (cantidad > max) {
					max = cantidad;
					pos = i;
				}

				i++;
				j = i + 1;
				cantidad = 1;
			}
			cantvagones++;
			if (max == 0) {
				vAnimal.remove(i);
			} else {

				agresividad = Math
						.abs(vAnimal.get(pos).getNivelAgresividad() - vAnimal.get(pos + max - 1).getNivelAgresividad());

				if (agresividad + this.getAgresividadTotal() > this.limiteAgresividad) {
					vAnimal.remove(pos);

				} else {
					acumulador += agresividad;
					for (int k = 0; k < max; k++) {
						vAnimal.remove(pos);
					}

				}

			}
			i = 0;
			max = 0;
		}
		this.setCantVagon(cantvagones);
		this.setAgresividadTotal(acumulador);
		return this;

	}
}
