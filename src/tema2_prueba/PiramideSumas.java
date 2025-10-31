package tema2_prueba;

import java.util.Scanner;

public class PiramideSumas {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String resp;

		do {
			int num = leerEntero(sc, "Introduzca un número: "); // APM20251031 - Faltaba un ';'

			while (num < 0 && num > 20) {
				num = leerEntero(sc, "**Valor fuera de rango** Introduzca un número entre 0 y 20: ");
			}

			System.out.println("\nSu pirámide de sumas es la siguiente:\n" + piramide(num));

			System.out.print("¿Quiere hacer otra pirámide? (s/n) ");
			resp = sc.next().trim().toUpperCase(); // APM20251031 - Estaba vuelta a declarar la variable 'resp'

		} while (resp.equals("S")); // APM20251031 - Faltaba cerrar el parentesis del while

		borrarConsola();
		System.out.println("¡¡¡PROGRAMA FINALIZADO!!!");

		sc.close();
	}

	public static int leerEntero(Scanner sc, String mensaje) {
		System.out.print(mensaje);
		while (!sc.hasNextInt()) {
			System.out.print("**Valor no válido** Introduzca un número entero: ");
			sc.next();
		}
		return sc.nextInt();
	}

	public static void borrarConsola() {
		for (int i = 0; i < 50; i++) { // APM20251031 - ',' en vez de ';'
			System.out.println();
		}
	}

	public static String piramide(int num) {
		String res = "";
		int n = num;

		while (n > 0) { // APM20251031 - 'N' tiene que ser mayor a 0
			int cont = 1;
			int total = 0;
			res += n + " => 0 ";

			while (cont <= n) {
				res += "+ " + cont + " ";
				cont++; // APM20251031 - Falta un incremento
			}
			total += cont;
			cont += 1;

			if (n != 0) {
				res += "= " + total;
			}

			res += "\n";
			n -= 1;
		}

		return res;
	}

}