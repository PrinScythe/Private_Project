package decorator.behaviour.acceleration;

import java.util.Vector;

import Observer.CadreObserverObservable;
import decorator.DecoratorBilleAcceleration;
import model.Bille;
import state.BilleState;

public class Piloted extends DecoratorBilleAcceleration {
	
	BilleState state;

    public Piloted(Bille bille, BilleState billeState) {
        super(bille);
        this.state = billeState;
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
