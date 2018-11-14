package COR;

import maladroit.AnimationBilles;
/**
 * Permet de lancer une animation
 *
 */
public class ExeCmdStart extends ExeCmdCOR {

	public ExeCmdStart(ExeCmdCOR expersuivant) {
		super(expersuivant);
	}

	@Override
	protected boolean execute1(AnimationBilles animation, String commande) {
		if(!commande.equals("start"))
			return false;

		animation.lancerAnimation();
		return true;
		
	}

}
