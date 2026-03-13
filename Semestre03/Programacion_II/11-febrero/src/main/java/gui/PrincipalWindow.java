package gui;

import javax.swing.ImageIcon;

import view.*;

public class PrincipalWindow {
	PanelProgress screen; 
	public PrincipalWindow() {
		inicioPantalla();
		screen.velocidadDeCarga();

	}

	private void inicioPantalla() {
		System.out.println("Entro al panel");
		ImageIcon myImage = new ImageIcon("uptc.jpg");
		screen = new PanelProgress(myImage);
		screen.setLocationRelativeTo(null);
		screen.setProgresoMax(100);
		screen.setVisible(true);
	}

	
	public void main(){
		login window = new login();
		window.setVisible(true);
	}
}

