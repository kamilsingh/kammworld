package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class contacts {
	
	Font f=new Font("Times New Roman",20);
	@FXML
	  private  AnchorPane pane;
	@FXML
	 private Button create,save,search;
	int count=0;
	

		
	  HashMap<Integer,Customer> hm= new HashMap<>();
      Label Id=new Label("GROUP ");
      Label Name=new Label("NAME");
      Label phone=new Label("MOBILE");
      TextField text1=new TextField();
      TextField text2=new TextField();
      ComboBox <Integer> ch=new ComboBox<>();
   
      
             public void create()
             { count++;
    	    ch.getItems().add(count);
    	    ch.setValue(count);
    	     text1.setText("");
    	     text2.setText("");
             } 
    	  
    
 
      
       public void save()
    	    {Customer c1= new Customer(ch.getValue(),text1.getText(),text2.getText());
    	    
    	    hm.put(count,c1);
    	    
    	    try {
    	    	   PrintStream pr= new PrintStream(new FileOutputStream("customer.txt"));
    	    	   String str="";
 	    	      for(Customer temp:hm.values())
 	    	      {
 	    	    	 pr.println(temp.get_id());
 	    	    	 pr.println(temp.getName());
 	    	    	 pr.println(temp.getPhone());
 	    	    	  
 	    	      }
    	       }
    	       catch(Exception ae)
    	       {
    	    	    System.out.println("select valid file!!!");
    	    	        System.out.println(ae);
    	       } 	       
    	    }
       
       
       
       
    	  
    	   try {
	    	   Scanner scan= new Scanner(new FileInputStream("customer.txt"));
	    	   int a;
	    	   String str;
	    	   String str2;
	    	   
	    	   
	    	   while(scan.hasNext())
	    	      {
	    	    	   a=scan.nextInt();
	    		   str=scan.next();
	    		   str2=scan.next();
	    		  Customer temp2=new Customer(a,str,str2);
	    		    if(a>count)
	    		    	count=a;
	    		   hm.put(a,temp2);
	    		   ch.getItems().add(a);
	    	    	  
	    	      }

	       }
	       catch(Exception ae)
	       {
	    	    System.out.println("choose right file");
	    	   System.out.println(ae);
	       } 	   
    	   
    
        
       HBox hb1=new HBox();hb1.setAlignment(Pos.CENTER);
       hb1.getChildren().addAll(Id,ch);
       HBox hb2=new HBox();hb2.setAlignment(Pos.CENTER);
       hb2.getChildren().addAll(Name,text1);
       HBox hb3=new HBox();hb3.setAlignment(Pos.CENTER);
       hb3.getChildren().addAll(phone,text2);
       HBox hb4=new HBox();hb4.setAlignment(Pos.CENTER);
       hb4.getChildren().addAll(create,save,delete,search);
       VBox vb=new VBox();
        vb.getChildren().addAll(hb1,hb2,hb3,hb4);
        vb.setAlignment(Pos.CENTER);
      
       
       ch.valueProperty().addListener(e->{
     	  int c=ch.getValue();   
     	Customer cm=hm.get(c);
     	try {	      
     	        text1.setText(cm.getName());
     		       text2.setText(cm.getPhone());
     	   }
     	   catch(Exception ae)
     	{
     		   System.out.println(ae);
     	}
     		   
        });
      
}
}