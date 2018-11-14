package state;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import controller.Controller;
import controller.ControllerClick;
import controller.ControllerMove;
import mesmaths.geometrie.base.Vecteur;
import model.Bille;

public class BilleState implements MouseListener, MouseMotionListener {

	private final Vector<Bille> billes;


	private Controller controllerCourant;
	private ControllerClick controllerClick;
	private ControllerMove controllerMove;
	protected Bille billeFocus;

	protected Vecteur lastPositionMouse;

	public BilleState(Vector<Bille> billes) {

		this.controllerClick = new ControllerClick(this, null, null);
		this.controllerMove = new ControllerMove(this, null, this.controllerClick);
		this.controllerClick.setSuivant(this.controllerMove);
		this.billes = billes;	
		this.billeFocus = null;

		this.controllerCourant = this.controllerClick;
	}
	
	public BilleState(Vector<Bille> billes, Bille billeFocus){
		this(billes);
		this.setBilleFocus(billeFocus);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
			controllerCourant.onTraineLaBille(e.getX(), e.getY());
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
			controllerCourant.onCliqueSurLaBille(arg0.getX(), arg0.getY(), arg0.getButton()==MouseEvent.BUTTON1);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
			controllerCourant.onRelacheLaBille();
	}


	public void setControllerCourant(Controller controllerCourant) {
		//System.out.println("état : "+controllerCourant.getNomEtat());
		this.controllerCourant = controllerCourant;
	}

	public Vecteur acceleration() {
		return this.controllerCourant.acceleration();
	}

	public Vector<Bille> getBilles() {
		return billes;
	}

	public Bille getBilleFocus() {
		return billeFocus;
	}

	public void setBilleFocus(Bille billeFocus) {
		this.billeFocus = billeFocus;
	}

	public Vecteur getLastPositionMouse(){
		return lastPositionMouse;
	}

	public void setLastPositionMouse(Vecteur vecteur) {
		lastPositionMouse = vecteur;

	}


	@Override
	public void mouseClicked(MouseEvent arg0) {}
	@Override
	public void mouseMoved(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
}