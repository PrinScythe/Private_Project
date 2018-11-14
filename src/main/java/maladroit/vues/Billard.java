package main.java.maladroit.vues;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.Vector;

import model.Bille;

/**
 * responsable du dessin des billes
 * 
 * ICI : IL N'Y A RIEN A CHANGER
 * 
 * 
 */
public class Billard extends Canvas {
	private Vector<Bille> billes;

	Billard(Vector<Bille> billes) {
		this.billes = billes;
	}
	
	// Getter
	
	public Vector<Bille> getBille() {
		return this.billes;
	}

	// Paint
	
	@Override
	public void paint(Graphics graphics) {
		int i;
		for (i = 0; i < this.billes.size(); ++i)
			this.billes.get(i).dessine(graphics);
	}
}
