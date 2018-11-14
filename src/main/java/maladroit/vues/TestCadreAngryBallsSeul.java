package main.java.maladroit.vues;

import java.awt.Frame;
import java.util.Vector;

import model.Bille;

public class TestCadreAngryBallsSeul {

	/**
	 * @param args
	 *            Args
	 */
	public static void main(String[] args) {
		Vector<Bille> billes = new Vector<Bille>();
		CadreAngryBalls cadre = new CadreAngryBalls("angry balls", "animation de billes marrantes", billes);
		cadre.montrer();
	}

}
