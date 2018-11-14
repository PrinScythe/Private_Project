package decorator.behaviour.collision;

import decorator.DecoratorBilleCollisions;
import mesmaths.cinematique.Collisions;
import model.Bille;

public class CollisionStop extends DecoratorBilleCollisions {

	public CollisionStop(Bille bille) {
		super(bille);
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {
        Collisions.collisionBilleContourAvecArretHorizontal(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, largeur);
        Collisions.collisionBilleContourAvecArretVertical(this.getPosition(), this.getRayon(), this.getVitesse(), ordonneeCoinHautGauche, hauteur);
        
    }
}
