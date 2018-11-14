package decorator.behaviour.acceleration.movement;

import java.util.Vector;

import decorator.DecoratorBilleAcceleration;
import mesmaths.geometrie.base.Vecteur;
import model.Bille;

public class NoMovement extends DecoratorBilleAcceleration {

	public NoMovement(Bille billeDécoré) {
		super(billeDécoré);

	}

	@Override
	public void déplacer(double deltaT) {
		System.out.println(billeDécoré.getVitesse());
	}

}
