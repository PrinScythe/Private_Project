package maladroit;

import java.awt.Color;
import java.util.Vector;

import Observer.CadreObserverObservable;
import decorator.behaviour.collision.CollisionBounce;
import decorator.behaviour.collision.CollisionStop;
import decorator.behaviour.collision.CollisionThroughWalls;
import decorator.behaviour.acceleration.Piloted;
import decorator.behaviour.acceleration.friction.Friction;
import decorator.behaviour.acceleration.movement.MovementGravity;
import decorator.behaviour.acceleration.movement.MovementNewton;
import decorator.behaviour.acceleration.movement.MovementRectilinearUniform;
import decorator.behaviour.acceleration.movement.NoMovement;
import mesmaths.geometrie.base.Vecteur;
import model.Bille;
import model.SimpleBille;
import state.BilleState;

/**
 * Gestion d'une liste de billes en mouvement ayant toutes un comportement
 * diff�rent
 * 
 * Id�al pour mettre en place le DP decorator
 */
public class TestAngryBalls {
	public static void main(String[] args) {
		Vector<Bille> billes = new Vector<>();
		CadreObserverObservable cadre = new CadreObserverObservable("Angry balls", "Billes", billes);
		cadre.montrer();

		double xMax, yMax;
		double vMax = 0.01;
		xMax = cadre.largeurBillard();
		yMax = cadre.hauteurBillard();

		double rayon = 0.05 * Math.min(xMax, yMax);

		Vecteur p0, p1, p2, p3, p4, p5, v0, v1, v2, v3, v4, v5;

		// Vectors of the "billes"

		p0 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
		p1 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
		p2 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
		p3 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
		p4 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
		p5 = new Vecteur(cadre.largeurBillard()/2,cadre.hauteurBillard()/2);

		// Speed vectors

		v0 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
		v1 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
		v2 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
		v3 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
		v4 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
		v5 = new Vecteur(Vecteur.VECTEURNUL);

		// Billes
		
		Bille redBille = new SimpleBille(p0, rayon, v0, Color.red);
		redBille = new MovementRectilinearUniform(redBille);
		redBille = new CollisionBounce(redBille);
		
		Bille yellowBille = new SimpleBille(p1, rayon, v1, Color.yellow);
		yellowBille  = new MovementGravity(yellowBille);
		yellowBille  = new Friction(yellowBille);
		yellowBille  = new CollisionBounce(yellowBille);
		
		Bille greenBille = new SimpleBille(p2, rayon, v2, Color.green);
		greenBille = new MovementNewton(greenBille);
		greenBille = new Friction(greenBille);
		//greenBille = new CollisionBounce(greenBille);

		Bille cyanBille = new SimpleBille(p3, rayon, v3, Color.cyan);
		cyanBille = new MovementRectilinearUniform(cyanBille);
		cyanBille = new CollisionThroughWalls(cyanBille);

		Bille blackBille = new SimpleBille(p4, rayon, v4, Color.black);
		blackBille = new MovementNewton(blackBille);
		//blackBille = new CollisionStop(blackBille);
		//blackBille = new CollisionBounce(blackBille);
		blackBille = new Friction(blackBille);

		BilleState etatBille = new BilleState(billes);
		cadre.addMouseListener(etatBille);
		cadre.addMouseMotionListener(etatBille);

		Bille orangeBille = new SimpleBille(p5, rayon, v5, Color.orange);
		orangeBille = new Friction(orangeBille);
		orangeBille = new CollisionBounce(orangeBille);
		orangeBille = new Piloted(orangeBille);
		
		Bille roseBille = new SimpleBille(p4, rayon*3, new Vecteur(Vecteur.VECTEURNUL), Color.pink);
		roseBille = new CollisionBounce(roseBille);
		roseBille = new Friction(roseBille);
		roseBille = new Piloted(roseBille);
		
		
        // Adding them

        //billes.add(redBille);
        //billes.add(yellowBille);
        //billes.add(greenBille);
        //billes.add(cyanBille);
        //billes.add(blackBille);
        billes.add(orangeBille);
		billes.add(roseBille);
		
	}

}
