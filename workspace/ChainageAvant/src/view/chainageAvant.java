package view;

import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import modele.ChainageAvant;

public class chainageAvant {

	   @FXML
	    private JFXListView<String> list;

	    @FXML
	    private JFXTextField regles;

	    @FXML
	    private JFXTextField faits;
	    
	    @FXML
	    private Label result;

	    @FXML
	    private JFXTextField proposition;

	    @FXML
	    private JFXButton execute;
	    
	    private Main main = new Main();
	    
	    static ObservableList<String> Result = FXCollections.observableArrayList();
	    
	    private ChainageAvant chainage;

	    @FXML
	    void handleChainageAvant(ActionEvent event) {

	    	if (regles.getText().equals(""))
	    	{
	    		Main.printError("Erreur lors de l'ex�cution ", null,"Veuillez remplir le champ des r�gles");
				return;
	    	}
	    	
	    	if(faits.getText().equals(""))
	    	{
	    		Main.printError("Erreur lors de l'ex�cution ", null,"Veuillez remplir le champ des faits");
				return;
	    	}
	    	
	    	if(proposition.getText().equals(""))
	    	{
	    		Main.printError("Erreur lors de l'ex�cution ", null,"Veuillez donner la proposition � d�montrer");
				return;
	    	}
	    	
	    	chainage = new ChainageAvant(regles.getText(), faits.getText(), proposition.getText());
	    	
	    	chainage.obtenirBaseRegle();
	    	
	    	if(chainage.chainageAvant())
	    	{
	    		result.setText("TRUE");
	    		chainage.result.add(regles.getText()+", "+faits.getText()+" ont pour cons�quence logique la proposition "+proposition.getText());
	    	}
	    	else
	    	{
	    		result.setText("FALSE");
	    		chainage.result.add(regles.getText()+", "+faits.getText()+" n'ont pas pour cons�quence logique la proposition "+proposition.getText());
	    	}
	    	
	    	Result.addAll(chainage.result);
	    	
	    	list.setItems(Result);
	    }
}
