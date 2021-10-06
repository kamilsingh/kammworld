package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
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
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class control2 implements Initializable {
private Stage s1;
private Scene sc;
@FXML
private Button save;
@FXML
private Button back;
@FXML
private Slider slider;
@FXML
private Label textchoice;
@FXML
private Label labeltext;
@FXML
private ProgressBar progressbar;
@FXML
private Button buttonpress;
@FXML
private Label space;
@FXML
private Label progresstext;
@FXML
private Label spinnertext;
@FXML
private Label listtext;
@FXML
private Spinner<Integer> spinner;
@FXML
private ListView<String> listview;
@FXML
private TreeView<String> treeview;

String friends[]= {"rahul","anjali","rekha","ajay","ankit","ashish","vijay","lokesh"};
double progress;
String friend;

int textchange;
int current;
@FXML 
private ChoiceBox<String>  choice;
 private String[] food = {"pizza","burger","mommos"};
 

	 @Override
	 public void initialize(URL arg0, ResourceBundle arg1) {
			
	
		 listview.getItems().addAll(friends);
		listview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				friend=listview.getSelectionModel().getSelectedItem();        //property,previous value,new value;
				listtext.setText(friend);
				
			}	
			
		});
		 
		 
		 slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				textchange=(int) slider.getValue();
				labeltext.setText(Integer.toString(textchange));
				
			}
		 }); 
		 choice.getItems().addAll(food);
		 	choice.setOnAction(e->{
		 		String myfood=choice.getValue();
		 		textchoice.setText(myfood);
		 		
		 		
		 	});
		
		 progressbar.setStyle("-fx-accent: #00ff00");
		 SpinnerValueFactory<Integer> spinobj=new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100);
		  spinobj.setValue(10);
		    spinner.setValueFactory(spinobj);
		    current=spinner.getValue();
		    spinnertext.setText(Integer.toString(current));
		    spinner.valueProperty().addListener(new ChangeListener<Integer>() {

				@Override
				public void changed(ObservableValue<? extends Integer> arg0, Integer arg1, Integer arg2) {
					current=spinner.getValue();
				    spinnertext.setText(Integer.toString(current));
					
				}
		    	
		    	
		    	
		    });
		    
		 
		 
	 }
	 
	 public void press()
	 {
		 if(progress<1)
		 {progress+=0.1;
		 progressbar.setProgress(progress);
		 progresstext.setText(Double.toString(Math.round(progress)));
		 }
	 }
		 
		 
	 
	 public void save(ActionEvent event)
	 {

			try {
			Parent root=FXMLLoader.load(getClass().getResource("media.fxml"));
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
	 
	public void back(ActionEvent event)
	 {
		 

			try {
			Parent root=FXMLLoader.load(getClass().getResource("webservice.fxml"));
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
	 


public void keymagic(KeyCode event)
{
   System.out.println(event);
	
}

}
