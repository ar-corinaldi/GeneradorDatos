package Aleatorio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Timestamp;

public class Reservas {

	public static String[] generarNombresAleatorios(int cantidad, int indice) {
		String[] nombresAleatorios = new String[cantidad];

		long offset = Timestamp.valueOf("2019-01-01 00:00:00").getTime();
		long end = Timestamp.valueOf("2019-12-31 00:00:00").getTime();
		long diff = end - offset + 1;

		for (int i = 0; i < cantidad; i++) {


			

			
			Timestamp f1= new Timestamp(offset + (long)(Math.random() * diff));
			diff = end - f1.getTime();
			Timestamp f2 = new Timestamp(offset + (long)(Math.random() * diff));
			diff = end - offset + 1;



			int idHab = (int) (Math.random() * 180) + 1;
			int capacidad = darCapacidad(idHab);
			int idPlanConsumo = (int) (Math.random() * 4) + 1;

			nombresAleatorios[i] = (i+1) + "," + capacidad + "," + f2 + ","+ f1 + ",,,"  + + (indice++)+ "," + "cedula" + "," + idHab + "," + idPlanConsumo + "\n";
			System.out.println(nombresAleatorios[i]);
		}
		return nombresAleatorios;
	}

	public static int darCapacidad( int idHab ){

		if( idHab >= 131  ) return 4;
		if( idHab < 131 && idHab >= 81 ) return 3;
		if( idHab < 81 && idHab >=  31 ) return 2;
		if( idHab < 31 && idHab <= 11 ) return 5;
		if( idHab < 11 ) return 1;

		else return 1;
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
			File logFile = new File("./data/reservas"+archivo+".csv");
			writer = new BufferedWriter(new FileWriter(logFile));
			
			System.out.println(nombresGenerados[1]);
			System.out.println(nombresGenerados[2]);
			for (int i = 0; i < nombresGenerados.length; i++) {
//				writer.write(nombresGenerados[i]);
			}
		} 
		catch (Exception e) { e.printStackTrace();} 
		finally {

			try {
				// Close the writer regardless of what happens...
				writer.close();
			} 
			catch (Exception e) {}
		}

	}

	public static void main(String[] args) {
		int indiceMenor = 10001;
		imprimir(generarNombresAleatorios(50000, indiceMenor), 1);
//		imprimir(generarNombresAleatorios(50000, indiceMenor+2+50000), 2);

	}
}
