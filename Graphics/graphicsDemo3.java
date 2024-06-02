import java.awt.*;
import javax.swing.*;
import java.awt.event.*;//Without this action listener will not work
public class graphicsDemo3 {

   public static void main(String[] args) {
       NameFrame frame = new NameFrame();
       frame.addWindowListener(new WindowAdapter(){
           public void windowClosing(WindowEvent e) {
               System.exit(0);
           }
       }
);//end of Window Listener declaration
   }//end of main

}//end of the class

class NameFrame extends JFrame implements ActionListener{
   private JTextField givenName;
   private JTextField familyName;
   private JTextField fullName;
   
   //Constructor special method - it ALWAYS has the same name as the class
   public NameFrame() {
       JPanel pane = (JPanel) getContentPane();
       pane.setLayout(new BorderLayout());
       
       //Create the fields for input and output
       givenName = new JTextField(10);
       familyName = new JTextField(10);
       fullName = new JTextField(10);
       fullName.setEditable(false);//NO USER CAN EDIT Field
       
       //Add Labels infront of the textfields
       JPanel inFieldPane = new JPanel();
       inFieldPane.setLayout(new GridLayout(2,2));
       //Add first field
       inFieldPane.add(new Label("Given Name"));
       inFieldPane.add(givenName);
       givenName.addActionListener(this);//OBJECTS talk to themselves in third person
       //adding second field
       inFieldPane.add(new JLabel("Family Name"));
       inFieldPane.add(familyName);
       givenName.addActionListener(this);
       pane.add(inFieldPane,BorderLayout.NORTH); //Take what we made add it to the original pane
       
       //Add middle panel
       JPanel submitPane= new JPanel();
       submitPane.setLayout(new FlowLayout());
       submitPane.add(new JLabel("Press Button to Enter Names"));
       JButton submitButton = new JButton("Submit");
       submitButton.addActionListener(this);
       submitPane.add(submitButton);
       pane.add(submitPane,BorderLayout.CENTER);
       
       //Output fields
       JPanel outFieldPane = new JPanel();
       outFieldPane.setLayout(new GridLayout(1,2));
       outFieldPane.add(new JLabel("Full Name: "));
       outFieldPane.add(fullName);
       pane.add(outFieldPane,BorderLayout.SOUTH);
       
       //Display the final product.
       pack();
       setVisible(true);
   }
   
   public void actionPerformed(ActionEvent e) {//ACTION LISTENER CODE
       //BACK END CODE GOES - THIS IS WHERE ALL THE LOGIC FROM THE COURSE GOES
       if(e.getActionCommand().equals("Submit")) {
           String fullNameString = familyName.getText().trim() + " ," + givenName.getText().trim();
           fullName.setText(fullNameString);
       }
   }
}