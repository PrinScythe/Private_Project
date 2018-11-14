package Observer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

/**
 * Il s'agit de la partie 'Observable'
 * On instantie l'objet avec une commande à éxecuter, commande qui sera notifié à l'Observer
 */
public class ActionObservable extends Observable implements ActionListener {

	private String commande;

	public ActionObservable(String commande) {
		super();
		this.commande = commande;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.setChanged();
		this.notifyObservers(commande);
	}

}
