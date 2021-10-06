package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.LoadException;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class controller {
private Stage s1;
private Scene sc;
@FXML
private AnchorPane  sp;
@FXML
private TextField user;
@FXML
private Label usr;
@FXML
private Label gender;
@FXML
private Label prefer;
@FXML
private Button logout;
@FXML
private Button back;
@FXML
private Button conti;
@FXML
private Button changed;
@FXML
private ImageView img;
@FXML
private RadioButton male;
@FXML
private RadioButton female;
@FXML
private CheckBox indian;
@FXML
private CheckBox overseas;
@FXML
private CheckBox nearby;
@FXML
private DatePicker date;
@FXML
private Label dob;
@FXML
private ColorPicker colorpick;
@FXML
private Pane pane;
@FXML
private Label foody;
@FXML
private ChoiceBox<String>  choice;
 private String[] food = {"pizza","burger","mommos"};

 
public void choice(ActionEvent event)
{  try {
	
	  ToggleGroup tg=new ToggleGroup();
      male.setToggleGroup(tg);
      female.setToggleGroup(tg);
      
	
	if(male.isSelected())
	{ gender.setText("male selected");
	  
	}
	if(female.isSelected())
	{
		gender.setText("female selected");
	}
	
	String str="";
	if(indian.isSelected())
	{  
		str=" INDIAN";
	}
	if(overseas.isSelected())
	{
		str=" OVERSEAS";
	}
	if(nearby.isSelected())
	{
		str=" NEARBY";
	}
	prefer.setText(str);
}
catch(Exception ae)
{
	System.out.println(ae);
}
	
}

public void display(String username )
{
	   usr.setText("WELCOME "+username);
}



public void friends(ActionEvent event ) 
{
	 try {
	Parent root=FXMLLoader.load(getClass().getResource("friends.fxml"));
     
    s1= (Stage)((Node)event.getSource()).getScene().getWindow();
        sc= new Scene(root);
       s1.setScene(sc);
       s1.show();
     }
		catch(LoadException e)
		{
			System.out.println("error :"+ e);
		}
	   
	    catch(Exception ae)
	{
	    	System.out.println("error :"+ ae);	
	}
}

public void messages(ActionEvent event ) 
{
	try {
	Parent root=FXMLLoader.load(getClass().getResource("messages.fxml"));
    s1= (Stage)((Node)event.getSource()).getScene().getWindow();
       sc= new Scene(root);
       s1.setScene(sc);
       s1.show();
}
	catch(LoadException e)
	{
		System.out.println("error :"+ e);
	}
   
    catch(Exception ae)
{
    	System.out.println("error :"+ ae);	
}

}

public void home(ActionEvent event) 
{ 
	try {
	Parent root=FXMLLoader.load(getClass().getResource("home.fxml"));
    s1= (Stage)((Node)event.getSource()).getScene().getWindow();
       sc= new Scene(root);
      
       s1.setScene(sc);
       s1.show();
	}
	catch(Exception ae)
	{
		System.out.println(ae);
	}
}
	
	
	 
	   
	 public void exiting(ActionEvent event)
	   {
	         Alert alert = new Alert(AlertType.CONFIRMATION);
	          alert.setTitle("exit");
	          alert.setContentText("Are you sure want to exit!!!");
	          
	          try{
	        	  if(alert.showAndWait().get()==ButtonType.OK)
		   {   System.out.println("you are logged out");
	        	 s1=(Stage) sp.getScene().getWindow();
		       s1.close(); }
	        	 }
	       catch(Exception ae)
	        	 {
	    	     System.out.println(ae);
	        	 }
		   
	   }
	  
	 public void notify(ActionEvent event ) throws IOException
	 {
		 try {
	 	Parent root=FXMLLoader.load(getClass().getResource("notify.fxml"));
	     s1= (Stage)((Node)event.getSource()).getScene().getWindow();
	        sc= new Scene(root);
	        s1.setScene(sc);
	        s1.show();
		 }
		catch(Exception e)
		{
			System.out.println("error :"+ e);
		}
	 }
	
	 public void more(ActionEvent event)
     {
    	 try{
    		 FXMLLoader fx1= new FXMLLoader(getClass().getResource("Testfile.fxml"));
         Parent root1=fx1.load(); 
           control2 control=fx1.getController();
         s1=(Stage)((Node)event.getSource()).getScene().getWindow();
         sc= new Scene(root1);
         sc.setOnKeyPressed(new EventHandler<KeyEvent>() {
				public void handle(KeyEvent event) {
					KeyCode str=event.getCode();
					control.keymagic(str);
			    // System.out.println(event.getCode());
				}	
				
			});
         s1.setScene(sc);
         s1.show();
    	 }
    	 catch(Exception ae)
    	 {
    		 System.out.println(ae);
    	 }
    	 
     }
	 public void out(ActionEvent event ) throws IOException
	 {
		 try {   Stage st;
			  Alert alert = new Alert(AlertType.CONFIRMATION);
	          alert.setTitle("log out");
	          alert.setContentText("Are you sure want to log out!!!");
	          if(alert.showAndWait().get()==ButtonType.OK)
			   {   
		        	 st=(Stage) sp.getScene().getWindow();
			       st.close(); 
	 	Parent root=FXMLLoader.load(getClass().getResource("logup.fxml"));
	     s1= (Stage)((Node)event.getSource()).getScene().getWindow();
	        sc= new Scene(root);
	        s1.setScene(sc);
	        s1.show();
		 }
		 }
			catch(Exception e)
			{
				System.out.println("error :"+ e);
			}
	        
	        
    
	 }
	 
	
	 
	 public void colour(ActionEvent event)
	 {
	 	Color mycolor=colorpick.getValue();
	 	 pane.setBackground(new Background(new BackgroundFill(mycolor, null, null)));	
	 }

	 public void Date(ActionEvent event)
	 {

	 LocalDate dat=date.getValue();
	 String format=dat.format(DateTimeFormatter.ofPattern("MMM-dd-yyyy"));
	 dob.setText(format);
	 }

	 public void change()
	 {
	 	System.out.println("i am in!!!!");
	 	try{Image image=new Image(getClass().getResourceAsStream("C:\\Users\\smarty\\Desktop\\virtual desktop\\Music Drive\\AlbumArt_{B5020207-474E-4720-0255-BD07311DB600}_Small.jpg"));
	 	img.setImage(image);}
	 	catch(Exception e)
	 	{
	 		System.out.println(e);
	 	}
	 }
	 
	 
	 public void files(ActionEvent event )
	 {
		 try {  
			 	Parent root=FXMLLoader.load(getClass().getResource("Testfile1.fxml"));
			    System.out.println("out"); 
			 	s1= (Stage)((Node)event.getSource()).getScene().getWindow();
			        sc= new Scene(root);
			        s1.setScene(sc);
			        s1.show();
				 }
				catch(Exception e)
				{
					System.out.println("error :"+ e);
				}
		 
		 
	 }
    

}
