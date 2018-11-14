package Observer;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import COR.CmdException;
import COR.ExeCmdCOR;
import COR.ExeCmdStart;
import COR.ExeCmdStop;
import main.java.maladroit.vues.VueBillard;
import maladroit.AnimationBilles;
import model.Bille;

/**
 * Il s'agit de la Classe rendant Animation Observer d'ActionObservable
 *
 */
public class AnimationObserver implements Observer {
	
	// Animation thing
	private AnimationBilles animationBilles;
	
	/**
	 * Chaine de responsabilité qui permet "d'executer une commande" de l'animation
	 */
	public ExeCmdCOR exe;

	public AnimationObserver(Vector<Bille> billes, VueBillard cadre) {
		super();
		this.animationBilles = new AnimationBilles(billes, cadre);
		exe = new ExeCmdStart(null);
		exe = new ExeCmdStop(exe);
	}

	public void update1(Observable arg0, Object arg1) throws CmdException {
		String cmd = (String)arg1;
		if (!exe.execute(animationBilles, cmd))
			throw new CmdException();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		try
		{
			update1(arg0, arg1);
		}
		catch(CmdException e)
		{
			//La COR n'a pas pu executer une commade envoyé par l'Observable
			System.out.println("Erreur CmdCOR");
		}
		
	}

}
