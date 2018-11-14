package decorator.behaviour.acceleration.friction;

import java.util.Vector;

import decorator.DecoratorBilleAcceleration;
import mesmaths.mecanique.MecaniquePoint;
import model.Bille;

public class Friction extends DecoratorBilleAcceleration {

	public Friction(Bille billeDécoré) {
		super(billeDécoré);
	}

	@Override
	public void gestionAccélération(Vector<Bille> billes) {
		super.gestionAccélération(billes);                              // remise à zéro du vecteur accélération
		this.getAccélération().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse()));      // contribution de l'accélération due au frottement dans l'air
	}

}
