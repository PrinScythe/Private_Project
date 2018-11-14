package COR;

import maladroit.AnimationBilles;
/**
 * Classe qui permet d'implémenter le design pattern Chain Of Responsability
 * Pour permettre d'executer une "commande"
 *
 */
public abstract class ExeCmdCOR implements ExeCmd {

	private ExeCmd suivant;
	
	public ExeCmdCOR(ExeCmdCOR 	expersuivant)
	{
		suivant = expersuivant;
	}

	@Override
	public boolean execute(AnimationBilles animation, String commande) {

		if (execute1(animation, commande))
			return true;
		else
		{
			if (suivant != null)
				return suivant.execute(animation, commande);
			else
				return false;
		}
		
	}

	protected abstract boolean execute1(AnimationBilles animation, String commande);
	
	
	
}
