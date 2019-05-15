package Aleatorio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Usuarios {
	/**
	 * este metodo genera nombres con apellidos. El proceso es aleatorio. Cada vez
	 * que se corra el programa mostrara nombres diferentes.
	 * 
	 * @param cantidad
	 *            Cantidad de nombres que se quieren generar.
	 * @return un arreglo de String con los nombres y apellidos generados. El
	 *         formato de salida es: Nombre Apellido
	 */
	public static String[] generarNombresAleatorios(int cantidad, int indice) {
		String[] nombresAleatorios = new String[cantidad];

		
		String[] nombres = { "Andrea", "David", "Baldomero", "Balduino", "Baldwin", "Baltasar", "Barry", "Bartolo",
				"Bartolomé", "Baruc", "Baruj", "Candelaria", "Cándida", "Canela", "Caridad", "Carina", "Carisa",
				"Caritina", "Carlota", "Baltazar", "Hansiain", "Laverna", "Skell", "Denna", "Harland", "Willie", "Milka", "Carolyne", "Elisha", "Gil"};
		String[] apellidos = { "Gomez", "Guerrero", "Cardenas", "Cardiel", "Cardona", "Cardoso", "Cariaga", "Carillo",
				"Carion", "Castiyo", "Castorena", "Castro", "Grande", "Grangenal", "Grano", "Grasia", "Griego",
				"Grigalva" };

		for (int i = 0; i < cantidad; i++) {
			System.out.println(indice);
			nombresAleatorios[i] = (indice++)+","+  "cedula" + "," +nombres[(int) (Math.floor(Math.random() * ((nombres.length - 1) - 0 + 1) + 0))] + ","
					+ apellidos[(int) (Math.floor(Math.random() * ((apellidos.length - 1) - 0 + 1) + 0))] + "," + 5 + "," + 0 + "\n";
		}
		return nombresAleatorios;
	}

	/**
	 * Imprime un arreglo de String
	 * 
	 * @param nombresGenerados
	 *            arreglo con los nombres generados
	 */
	public static void imprimir(String[] nombresGenerados, int archivo) {
		BufferedWriter writer = null;
        try {
            //create a temporary file
            File logFile = new File("./data/usuarios"+archivo+".csv");

            writer = new BufferedWriter(new FileWriter(logFile));
            for (int i = 0; i < nombresGenerados.length; i++) {
                writer.write(nombresGenerados[i]);
    		}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }
		
	}

	public static void main(String[] args) {
		int indiceMenor = 10001;
		imprimir(generarNombresAleatorios(50000, indiceMenor), 1);
		imprimir(generarNombresAleatorios(50000, indiceMenor+2+50000), 2);
	}
}