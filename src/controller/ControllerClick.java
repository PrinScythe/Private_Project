package controller;

import java.awt.event.MouseEvent;

import decorator.behaviour.acceleration.Piloted;
import mesmaths.geometrie.base.Vecteur;
import model.Bille;
import state.BilleState;

public class ControllerClick extends Controller {

    public ControllerClick(BilleState state, Controller suivant, Controller precedent) {
        super(state, suivant, precedent);
    }

	
	@Override
	public void onTraineLaBille(int x, int y) {}
	@Override
	public void onRelacheLaBille() {}

	@Override
	public void onCliqueSurLaBille(int x, int y, boolean b) {
		if (b)
		{
			state.setLastPositionMouse(new Vecteur(x, y));
			//System.out.println("Position Curseur : "+state.getLastPositionMouse());
			
			for (Bille bille : this.state.getBilles()) 
			{
				if(bille instanceof Piloted){
					
					Vecteur delta = bille.getPosition().difference(state.getLastPositionMouse());

					if (delta.normeCarrée() <= bille.getRayon() * bille.getRayon()){
						state.setBilleFocus(bille);
						this.state.setControllerCourant(next);
					}
				}
			}
		}
	}

	@Override
	public String getNomEtat() {
		return "Clique";
	}
}