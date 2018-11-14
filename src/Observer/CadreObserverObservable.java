package Observer;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import main.java.maladroit.vues.CadreAngryBalls;
import model.Bille;
/**
 * Classe qui regroupe Cadre et Animation
 * On rend Cadre 'Observable' par le biais d'ajout de ActionObservable
 * Et on rend l'animation 'Observer' des ActionObservable.
 *
 * Le principe : Lorsqu'on 'modifie' un bouton du cadre, 
 * on notifie l'animation de la commande à réaliser.
 */
public class CadreObserverObservable {
	
	public CadreAngryBalls cadre;
	public AnimationObserver animation;
	
	
	public CadreObserverObservable(String titre, String message, Vector<Bille> billes)
	{
		cadre = new CadreAngryBalls(titre, message, billes);
		animation = new AnimationObserver(billes, cadre);

		ActionObservable start = new ActionObservable("start");
		ActionObservable stop = new ActionObservable("stop");

		start.addObserver(animation);
		stop.addObserver(animation);
		

		cadre.lancerBilles.addActionListener(start);
		cadre.arreterBilles.addActionListener(stop);
	}
	
	public Vector<Bille> getBilles(){
		return cadre.billard.getBille();
	}

	public void montrer() {
		cadre.montrer();		
	}

	public double largeurBillard() {
		return cadre.largeurBillard();
	}

	public double hauteurBillard() {
		return cadre.hauteurBillard();
	}

	public void addMouseListener(MouseListener l) {
		cadre.billard.addMouseListener(l);
		
	}

	public void addMouseMotionListener(MouseMotionListener l) {
		cadre.billard.addMouseMotionListener(l);
	}

}
