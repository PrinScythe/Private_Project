package decorator.behaviour.acceleration.movement;

import java.util.Vector;

import decorator.DecoratorBilleAcceleration;
import model.Bille;
import model.OutilsBille;

public class MovementNewton extends DecoratorBilleAcceleration {

	public MovementNewton(Bille billeDécoré) {
		super(billeDécoré);
	}

	@Override
	public void gestionAccélération(Vector<Bille> billes) {
		super.gestionAccélération(billes);                              // remise à zéro du vecteur accélération
		this.getAccélération().ajoute(OutilsBille.gestionAccelerationNewton(this, billes));     // contribution de l'accélération due à l'attraction des autres billes		
	}
}
