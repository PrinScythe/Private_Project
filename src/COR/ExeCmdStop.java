package COR;

import maladroit.AnimationBilles;

/**
 * Classe pour arrêter une Animation
 */
public class ExeCmdStop extends ExeCmdCOR {

	public ExeCmdStop(ExeCmdCOR expersuivant) {
		super(expersuivant);
	}

	@Override
	protected boolean execute1(AnimationBilles animation, String commande) {
		if(!commande.equals("stop"))
			return false;

		animation.arreterAnimation();
		return true;
	}

}
