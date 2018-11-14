package decorator.behaviour.collision;

import decorator.DecoratorBilleCollisions;
import mesmaths.cinematique.Collisions;
import model.Bille;

public class CollisionBounce extends DecoratorBilleCollisions {

	public CollisionBounce(Bille bille) {
		super(bille);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {
		Collisions.collisionBilleContourAvecRebond(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);
	}

}
