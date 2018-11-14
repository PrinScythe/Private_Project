package decorator;

import java.util.Vector;

import model.Bille;

public abstract class DecoratorBilleCollisions extends DecoratorBille {

	public DecoratorBilleCollisions(Bille billeDécoré) {
		super(billeDécoré);
	}

	@Override
	public void gestionAccélération(Vector<Bille> billes) {
		super.gestionAccélération(billes);
	}
}
