package decorator.behaviour.collision;

import decorator.DecoratorBilleCollisions;
import mesmaths.cinematique.Collisions;
import model.Bille;

public class CollisionThroughWalls extends DecoratorBilleCollisions {

	public CollisionThroughWalls(Bille bille) {
		super(bille);
		// TODO Auto-generated constructor stub
	}
	
    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {
    		Collisions.collisionBilleContourPasseMuraille(this.getPosition(), abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);
    }
}
