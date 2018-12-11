package controller;

import java.awt.MouseInfo;
import java.awt.Point;

import org.omg.CORBA.CODESET_INCOMPATIBLE;

import mesmaths.geometrie.base.Vecteur;
import mesmaths.geometrie.base.awt.VecteurAWT;
import model.Bille;
import state.BilleState;

public class ControllerMove extends Controller {
    
    private static double COEFFICIENT = 5;
    

    public ControllerMove(BilleState state, Controller suivant, Controller precedent) {
        super(state, suivant, precedent);
    }

	@Override
	public void onCliqueSurLaBille(int x, int y, boolean b) {}

	@Override
	public void onTraineLaBille(int x, int y) {
		
		Vecteur courant = new Vecteur(x, y);

		Vecteur delta = new Vecteur(courant);
		delta.retire(state.getLastPositionMouse());
		delta.multiplie(COEFFICIENT);
		delta.multiplie(1/state.getBilleFocus().masse());

		state.setLastPositionMouse(new Vecteur(courant));
		
		state.getBilleFocus().getAccélération().ajoute(delta);
	}
	
	@Override
	public void onRelacheLaBille() {
		//System.out.println("on relache");
		state.setControllerCourant(previous);
	}
	

	@Override
	public String getNomEtat() {
		return "Mouvement";
	}

}