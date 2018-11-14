package main.java.maladroit.vues;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import main.java.outilsvue.Outils;
import maladroit.AnimationBilles;
import maladroit.EcouteurBoutonArreter;
import maladroit.EcouteurBoutonLancer;
import model.Bille;
import state.BilleState;

/**
 * Vue dessinant les billes et contenant les 3 boutons de controle (arret du
 * programme, lancer les billes, arreter les billes)
 * 
 * ICI : IL N'Y A RIEN A CHANGER
 * 
 */
public class CadreAngryBalls extends Frame implements VueBillard {
	public Billard billard;
	public Button lancerBilles, arreterBilles;

	public CadreAngryBalls(String titre, String message, Vector<Bille> billes) throws HeadlessException {
		super(titre);
		Outils.place(this, 0.33, 0.33, 0.5, 0.5);

		Panel haut = new Panel();
		haut.setBackground(Color.LIGHT_GRAY);
		this.add(haut, BorderLayout.NORTH);

		Panel centre = new Panel();
		this.add(centre, BorderLayout.CENTER);

		Panel bas = new Panel();
		bas.setBackground(Color.LIGHT_GRAY);
		this.add(bas, BorderLayout.SOUTH);

		TextField presentation = new TextField(message, 100);
		presentation.setEditable(false);
		haut.add(presentation);

		this.billard = new Billard(billes);
		this.add(this.billard);

		this.lancerBilles = new Button("Start");
		bas.add(this.lancerBilles);
		this.arreterBilles = new Button("Stop");
		bas.add(this.arreterBilles);
		
		// Close the app with the cross
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
	}

	public double largeurBillard() {
		return this.billard.getWidth();
	}

	public double hauteurBillard() {
		return this.billard.getHeight();
	}

	@Override
	public void miseAJour() {
		this.billard.repaint();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exodecorateur.vues.VueBillard#montrer()
	 */
	@Override
	public void montrer() {
		this.setVisible(true);
	}
}