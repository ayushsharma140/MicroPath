/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package micropath;

import java.awt.Color;
import java.awt.Component;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author ArinjayaKhare1
 */
public class TrainDataRenderer extends JLabel implements ListCellRenderer<CustomTrainArrayList> {
    
    int clicked=0;
    JTextField x = new JTextField(" ");
    JTextField y = new JTextField(" ");
    JPanel renderer = new JPanel();
    DefaultTreeCellRenderer defaultRenderer = new DefaultTreeCellRenderer();
    Color backgroundSelectionColor;
    Color backgroundNonSelectionColor;
    String name;

    public TrainDataRenderer(String p)
    {
        x.setHorizontalAlignment(JLabel.LEFT);
        renderer.add(x);
        renderer.add(y);
        renderer.setBorder(BorderFactory.createLineBorder(Color.gray));
        //renderer.setBackground(Color.gray);        //Background to be set later
        backgroundSelectionColor = defaultRenderer.getBackgroundSelectionColor();
        backgroundNonSelectionColor = defaultRenderer.getBackgroundNonSelectionColor();
        name=p;
    }
    @Override
    public Component getListCellRendererComponent(JList<? extends CustomTrainArrayList> list, CustomTrainArrayList TrainSignalData, int index,
        boolean isSelected, boolean cellHasFocus)
    {
        String signal=TrainSignalData.getSignal();
        String red="RED";
        String green="GREEN";
        x.setText(TrainSignalData.getTrainNo()+"                                ");
        //x.setBackground(Color.gray);                //Background to be set later
        if(signal.compareTo(red)==0)
        {
            y.setText("                                                         "+signal);
            y.setBackground(Color.RED);
        }
        else
        {
            y.setText("                                                   "+signal);
            y.setBackground(Color.GREEN);
        }
        if (isSelected) {
          clicked=1;  
          renderer.setBackground(backgroundSelectionColor);
          System.out.println(this.x.getText()+this.y.getText());
          if(this.y.getBackground()==Color.RED)
          {
              this.y.setText("                                                   "+green);
              this.y.setBackground(Color.GREEN);
              try
              {
                ResultSet rs;
                String SQL;
                PreparedStatement pstmt;
                Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
                java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?" + "user=root&password=root");
                SQL="UPDATE `demo`.`train_data_control_room` SET `signal`=? WHERE `train_no`=?";
                pstmt = conn.prepareStatement(SQL);
                pstmt.setString(1, "1");
                pstmt.setString(2, this.x.getText());
                pstmt.executeUpdate();
                pstmt.close();
                
                
              }
               catch(Exception e){
            e.printStackTrace();
                    }  
          }
          else
          {
              this.y.setText("                                                         "+red);
              this.y.setBackground(Color.RED);
              try
              {
                ResultSet rs;
                String SQL;
                PreparedStatement pstmt;
                Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
                java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?" + "user=root&password=root");
                SQL="UPDATE `demo`.`train_data_control_room` SET `signal`=? WHERE `train_no`=?";
                pstmt = conn.prepareStatement(SQL);
                pstmt.setString(1, "0");
                pstmt.setString(2, this.x.getText());
                pstmt.executeUpdate();
                pstmt.close();
                
                
              }
               catch(Exception e){
            e.printStackTrace();
                    }  
          }
        } 
        
        
        else {
          if(clicked==1)
          {
              try
              {
                ResultSet rs;
                String SQL;
                PreparedStatement pstmt;
                Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
                java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?" + "user=root&password=root");
                SQL="UPDATE `demo`.`train_data_control_room` SET `signal`=? WHERE `train_no`=?";
                pstmt = conn.prepareStatement(SQL);
                if(this.y.getText().compareTo(green)==0)
                {
                pstmt.setString(1, "1");
                }
                else
                {
                    pstmt.setString(1, "0");
                }
                
                pstmt.setString(2, this.x.getText());
                pstmt.executeUpdate();
                pstmt.close();
                clicked=0;
                
              }
               catch(Exception e){
            e.printStackTrace();
                    }  
              
          }
          
          renderer.setBackground(backgroundNonSelectionColor);
        }
        
        
        
        return renderer;
        
    }
}
