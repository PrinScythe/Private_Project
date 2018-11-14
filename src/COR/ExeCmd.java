package COR;

import maladroit.AnimationBilles;

/**
 * Classe qui permet d'executer une action sur l'animation *
 */
public interface ExeCmd {

	public boolean execute(AnimationBilles animation, String commande);
	
}
