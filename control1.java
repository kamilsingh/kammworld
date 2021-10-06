package application;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class control1 {
	@FXML
	private TextField user;
	@FXML
	private PasswordField pass;
	private Stage s1;
	private Scene sc;
	private Parent root;
	@FXML
	private Label txt;
	
	

	
	
	
	public void login(ActionEvent event)
	{
	     try{
	    	   String username =user.getText();
	    	   int us=user.getText().length();
	    	   int password=pass.getText().length();
	    	//if(us==0)
	    	  // { txt.setText("invalid username!!!!!!");}
	    	   //else if(password<6)
	    	   //{txt.setText("invalid password!!!!!!");}
	    	   //else{
	    	  FXMLLoader fx1= new FXMLLoader(getClass().getResource("home.fxml"));
	    	  root=fx1.load();    
	          s1=(Stage)((Node)event.getSource()).getScene().getWindow();
	          // controller c2=fx1.getController();
	         // c2.display(username);
	          sc= new Scene(root);
	          s1.setScene(sc);
	          s1.show();
	    	 // }
	    	
	     }
	      catch(Exception ae)
	     {
	    	  //txt.setText("sorry !we are technically down right now!!!!!");
	    	  System.out.println(ae);
	     }
	  
	}
	}

    