package decorator;

import java.awt.Graphics;
import java.util.Vector;
import mesmaths.geometrie.base.Vecteur;
import model.Bille;

public abstract class DecoratorBille implements Bille {

	protected Bille billeDécoré;
	
	public DecoratorBille(Bille billeDécoré){
		this.billeDécoré = billeDécoré;
	}

	@Override
	public Vecteur getPosition() {
		return billeDécoré.getPosition();
	}

	@Override
	public double getRayon() {
		return billeDécoré.getRayon();
	}

	@Override
	public Vecteur getVitesse() {
		return billeDécoré.getVitesse();
	}

	@Override
	public Vecteur getAccélération() {
		return billeDécoré.getAccélération();
	}

	@Override
	public int getClef() {
		return billeDécoré.getClef();
	}
	
	public Bille getBille()
	{
		return billeDécoré;
	}

	@Override
	public double masse() {
		return billeDécoré.masse();
	}
	
	public String toString()
	{
		return billeDécoré.toString();
	}

	@Override
	public void déplacer(double deltaT) {
		billeDécoré.déplacer(deltaT);
	}

	@Override
	public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
		return billeDécoré.gestionCollisionBilleBille(billes);
	}

	@Override
	public void dessine(Graphics g) {
		billeDécoré.dessine(g);
	}

	@Override
	public void gestionAccélération(Vector<Bille> billes) {
		billeDécoré.gestionAccélération(billes);
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur,
			double hauteur) {
		billeDécoré.collisionContour(abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
	}

}
