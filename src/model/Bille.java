package model;

import java.awt.Graphics;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

public interface Bille {
	
	/**
	 * @return the position
	 */
	public Vecteur getPosition();

	/**
	 * @return the rayon
	 */
	public double getRayon();

	/**
	 * @return the vitesse
	 */
	public Vecteur getVitesse();


	/**
	 * @return the accélération
	 */
	public Vecteur getAccélération();

	/**
	 * @return the clef
	 */
	public int getClef();

	public double masse();


	/**
	 * mise à jour de position et vitesse à t+deltaT à partir de position et vitesse à l'instant t
	 * 
	 * modifie le vecteur position et le vecteur vitesse
	 * 
	 * laisse le vecteur accélération intact
	 *
	 * La bille subit par défaut un mouvement uniformément accéléré
	 * */
	public 	 void  déplacer( double deltaT);

	/**
	 * calcul (c-à-d mise à jour) éventuel  du vecteur accélération. 
	 * billes est la liste de toutes les billes en mouvement
	 * Cette méthode peut avoir besoin de "billes" si this subit l'attraction gravitationnelle des autres billes
	 * La nature du calcul du vecteur accélération de la bille  est définie dans les classes dérivées
	 * A ce niveau le vecteur accélération est mis à zéro (c'est à dire pas d'accélération)
	 * */
	public  void gestionAccélération(Vector<Bille> billes);

	/**
	 * gestion de l'éventuelle  collision de cette bille avec les autres billes
	 *
	 * billes est la liste de toutes les billes en mouvement
	 * 
	 * Le comportement par défaut est le choc parfaitement élastique (c-à-d rebond sans amortissement)
	 * 
	 * @return true si il y a collision et dans ce cas les positions et vecteurs vitesses des 2 billes impliquées dans le choc sont modifiées
	 * si renvoie false, il n'y a pas de collision et les billes sont laissées intactes 
	 * */
	public boolean gestionCollisionBilleBille(Vector<Bille> billes);




	/**
	 * gestion de l'éventuelle collision de la bille (this) avec le contour rectangulaire de l'écran défini par (abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur)
	 * 
	 * détecte si il y a collision et le cas échéant met à jour position et vitesse
	 * 
	 * La nature du comportement de la bille en réponse à cette collision est définie dans les classes dérivées
	 * */
	public abstract void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur);



	public void dessine (Graphics g);


	public String toString() ;
}
