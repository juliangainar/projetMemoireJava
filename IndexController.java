package application;

import java.time.LocalDateTime;

import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;

// ce controller va se charger de la gestion des actions des utilisateurs : il est en lien avec le modele et la vue

public class IndexController {
	
	@FXML
	private Button bouttonCommencer;
	@FXML
	private Label panneauTitre;
	@FXML
	private Label labelScore;
	@FXML
	private GridPane gridCartes;
	@FXML
	private Label labelTimer;
	@FXML
	private Pane mainPane;
	
	private int tempsRestant = 180;
	private int score = 0;
	
	@FXML
	private void commencerJeu(ActionEvent evt) {
		// on cache les labels
		this.bouttonCommencer.setVisible(false);
		this.panneauTitre.setVisible(false);
		
		
		// on affiche un message d'information
		Alert boiteAlerte = new Alert(AlertType.INFORMATION);
		boiteAlerte.setTitle("Allons-y !");
		boiteAlerte.setHeaderText("Jeu2Cartes");
		boiteAlerte.setContentText("Vous devez trouver toutes les paires de cartes dans le temps imparti.");
		boiteAlerte.showAndWait();
		
		// on affiche le "tableau" de jeu
		this.gridCartes.setVisible(true);
		this.labelScore.setVisible(true);
		
		// on initialise le score et le temps
		afficherScore();
		
		Timeline timer = new Timeline(new KeyFrame(Duration.millis(1000), ae -> afficherTimer()));
		timer.setCycleCount(Animation.INDEFINITE);
		timer.play();
		if (this.tempsRestant == 0) {
            timer.stop();
        }
		
	}
	
	private void afficherTimer() {
		this.tempsRestant--;
		this.labelTimer.setVisible(true);
		this.labelTimer.setText("Temps restant : " + this.tempsRestant + " secondes.");
	}
	
	private void afficherScore() {
		this.labelScore.setText("Score : " + this.score);
	}
}
