package controller;

import mesmaths.geometrie.base.Vecteur;
import model.Bille;
import state.BilleState;

public abstract class Controller {
	protected BilleState state;
	protected Controller next;
	protected Controller previous;

	protected boolean clicked;
	protected int buttonClick;
	

	public Controller(final BilleState state, final Controller suivant, final Controller precedent) {
		this.next = suivant;
		this.previous = precedent;
		this.state = state;
	}
	
	public abstract Vecteur acceleration();

	public abstract void onTraineLaBille(int x, int y);
	public abstract void onCliqueSurLaBille(int x, int y, boolean b);
	public abstract void onRelacheLaBille();
	

	public void setPrecedent(ControllerMove precedent) {
		this.previous = precedent;
	}

	public void setSuivant(ControllerMove suivant) {
		this.next = suivant;
	}

	public abstract String getNomEtat();

}