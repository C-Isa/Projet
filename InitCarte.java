package Midway;

public class InitCarte {

	public static void initialise() {

		IGPA carte = new IGPA(11, 9); // cree un objet IGPA avec 11 col. 9 lg
		// declaration des images utilises
		carte.declarerImage(5, "eau.png");
		carte.declarerImage(10, "sable.png");
		// declaration de la carte initiale

		int[][] init = { { 5, 5, 5, 5, 5, 5, 5, 5, 5 },
				{ 5, 5, 5, 5, 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5, 5, 5, 5, 5 },
				{ 5, 5, 5, 5, 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5, 5, 5, 5, 5 },
				{ 5, 5, 5, 5, 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5, 5, 5, 5, 10 },
				{ 5, 5, 5, 5, 5, 5, 5, 5, 10 }, { 5, 5, 5, 5, 5, 5, 5, 5, 10 },
				{ 5, 5, 5, 5, 5, 5, 5, 5, 10 }, { 5, 5, 5, 5, 5, 5, 5, 5, 10 } };
		carte.definirTerrain(init);
		carte.creerFenetre();
	}

}
