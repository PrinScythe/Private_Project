package decorator.behaviour.acceleration.movement;

import java.util.Vector;

import decorator.DecoratorBilleAcceleration;
import model.Bille;

public class MovementRectilinearUniform  extends DecoratorBilleAcceleration {

	public MovementRectilinearUniform(Bille bille) {
		super(bille);
	}
	
	@Override
    public void gestionAccélération(Vector<Bille> billes) {
		super.gestionAccélération(billes);
    }

}
