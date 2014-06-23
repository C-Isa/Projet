package Midway;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	public static Scanner clavier = new Scanner(System.in);

	static void lireChoix() {

		int choix = 0;
		while (choix < 5) {
			choix = afficheMenu();
			switch (choix) {
			case 1: // deplacer(porteAvion pa, Avion avion);break;
			case 2:// decoller(Avion avion);break;
			case 3:// atterir(Avion avion); break;
			case 4: // rienFaire(); break;
			case 5:
				quitter();
				break;
			default:// On reste dans la boucle.
				choix = 0;
			}
		}
	}

	static int afficheMenu() {
		int choix = 0;
		System.out.println();
		System.out.println("1 : Déplacer le porte-avion");
		System.out.println("2 : Faire décoller un avion");
		System.out.println("3 : Faire attérir l'avion");// affiché si decoller
		System.out.println("4 : Ne rien faire");
		System.out.println("5 : Quitter");
		while ((choix != 1) && (choix != 2) && (choix != 3) && (choix != 4)
				&& (choix != 5)) {
			try {
				choix = clavier.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Veuillez saisir un chiffre :");
				clavier.nextLine();
			}
		}
		return choix;
	}

	public static void quitter() {
		System.out.println("Programme terminé");
	}
}