package decorator.behaviour.acceleration.movement;

import java.util.Vector;

import decorator.DecoratorBilleAcceleration;
import mesmaths.geometrie.base.Vecteur;
import model.Bille;

public class MovementGravity extends DecoratorBilleAcceleration {
	private Vecteur gravity;
	
	public MovementGravity(Bille bille) {
		super(bille);
		this.gravity = new Vecteur(0, 0.001);
	}

	public MovementGravity(Bille bille, Vecteur gravity) {
		super(bille);
		this.gravity = gravity;
	}

	@Override
	public void gestionAccélération(Vector<Bille> billes) {
		super.gestionAccélération(billes);          // remise à zéro du vecteur accélération
		this.getAccélération().ajoute(this.gravity);          // contribution du champ de pesanteur (par exemple)
	}

}
