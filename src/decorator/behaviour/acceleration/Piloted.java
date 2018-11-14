package decorator.behaviour.acceleration;

import java.util.Vector;

import Observer.CadreObserverObservable;
import decorator.DecoratorBilleAcceleration;
import model.Bille;
import state.BilleState;

public class Piloted extends DecoratorBilleAcceleration {
	
    public Piloted(Bille bille) {
        super(bille);
    }

    /*public Piloted(Bille bille, CadreObserverObservable cadre) {
        super(bille);
        this.state = new BilleState(cadre.getBilles(), this);
        cadre.addMouseListener(state);
        cadre.addMouseMotionListener(state);
    }*/

    @Override
    public void gestionAccélération(Vector<Bille> billes) {
    	super.gestionAccélération(billes);
        //this.getAccélération().ajoute(state.acceleration());
    }
}
