import java.util.InputMismatchException;
import java.util.Scanner;

public class TankMain {

	public static void main(String[] args) {

		Tank tank = new Tank(100);
		Tank tank2 = new Tank(50);
		
		Scanner scanner = new Scanner(System.in);

		String dato = "";
		int litros = 0;

		do {
			try {
				System.out.print("�Desea a�adir o retirar litros? O quiz�s desee salir...");
				dato = scanner.next();

				if (dato.equals("a�adir")) {
					System.out.println("�Qu� cantidad desea introducir?");
					litros = scanner.nextInt();

					if (tank.getTank() + litros <= tank.getMaxTank()) {
						tank.setTank(tank.getTank() + litros);
						System.out.println("La operaci�n ha sido un �xito, el total es: " + tank.getTank());
					} else if (tank.getTank() + litros > tank.getMaxTank() + tank2.getMaxTank() || tank2.getTank() + litros > tank.getMaxTank() + tank2.getMaxTank() ) {
						System.out.println("No es posible. Capacidad total: 150 siendo la actual de " + tank.getTank());
					}
					if (tank.getTank() + litros > tank.getMaxTank() && tank.getTank() + litros <= tank.getMaxTank() + tank2.getMaxTank() ) {
						tank.setTank(tank.getTank() + litros);
						System.out.println(
								"�ALERTA! El tanque 1 est� lleno, procedemos a usar el tanque 2. el total actual es: "
										+ tank.getTank());
					}
				} else if (dato.equals("retirar")) {
					System.out.println("�Qu� cantidad desea retirar?");
					litros = scanner.nextInt();

					if (tank.getTank() - litros >= 0 && litros > 0) {
						tank.setTank(tank.getTank() - litros);
						System.out.println("Retirada realizada con �xito. Capacidad actual: " + tank.getTank());
					} else {
						System.out.println("Resulta imposible retirar " + litros
								+ ". Verifique que esta introduciendo un numero positivo y que no sea mayor a la capacidad actual: "
								+ tank.getTank());
					}
				}

			} catch (InputMismatchException errorDato) {
				System.out.println("Introduzca un digito no una letra.");
			}
		} while (!dato.equals("salir") || litros != 0);
		scanner.close();

	}
}
