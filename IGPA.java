import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

class SpecialPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int[][] jeu;
	Color blanc = Color.white;
	Color noir = new Color(150, 120, 120);
	private final HashMap<Integer, ImageIcon> images;

	SpecialPanel(int[][] je, HashMap<Integer, ImageIcon> im) {
		jeu = je;
		images = im;
		this.setForeground(Color.lightGray);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < jeu.length; i++) {
			g.drawString("" + i, i * 48 + 44, 15);
			g.drawString("" + i, i * 48 + 48, jeu[0].length * 48 + 40);
			for (int j = 0; j < jeu[0].length; j++) {
				g.drawString("" + j, 5, j * 48 + 48);
				g.drawString("" + j, jeu.length * 48 + 30, j * 48 + 48);
				images.get(jeu[i][j]).paintIcon(this, g, i * 48 + 24,
						j * 48 + 24);
			}
		}
	}
}

public class IGPA extends JFrame {
	/**
	 * La sérialisation consiste à écrire des données présentes en mémoire vers
	 * un flux de données binaires, ce procédé va donc permettre de rendre les
	 * objets persistants et permettre enr dans fichier sur DD par exemple.
	 * Fortement recommandé de déclarer explicitement le serialVersionUID et
	 * également de déclarer le serialVersionUID comme private.
	 */
	private static final long serialVersionUID = 1L;
	private final int[][] jeu;
	private final HashMap<Integer, ImageIcon> images;
	private SpecialPanel jpane;

	public IGPA(int x, int y) {
		jeu = new int[x][y];
		images = new HashMap<Integer, ImageIcon>();
	}

	public void creerFenetre() {
		if (!this.isVisible()) {
			this.setTitle("Midway");
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			jpane = new SpecialPanel(jeu, images);
			this.setContentPane(jpane);
			jpane.setPreferredSize(new Dimension(jeu.length * 48 + 48,
					jeu[0].length * 48 + 48));
			jpane.setBackground(Color.darkGray);
			this.pack();
			this.setVisible(true);
		}
	}

	public void definirTerrain(int[][] je) {
		if (jeu.length != je.length && jeu[0].length != je[0].length)
			throw new TailleErreur();
		for (int i = 0; i < je.length; i++) {
			for (int j = 0; j < je[0].length; j++) {
				jeu[i][j] = je[i][j];
			}
		}
	}

	public void declarerImage(int c, String s) {
		images.put(c, new ImageIcon("images/" + s));
	}

	public void modifierCase(int x, int y, int val) {
		jeu[x][y] = val;
	}

	public void reafficher() {
		jpane.repaint();
	}

	public void fermer() {
		this.dispose();
	}
}

class TailleErreur extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
