/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package micropath;

import java.awt.Color;
import java.awt.Component;
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
    
     
    JTextField x = new JTextField(" ");
    JTextField y = new JTextField(" ");
    JPanel renderer = new JPanel();
    DefaultTreeCellRenderer defaultRenderer = new DefaultTreeCellRenderer();
    Color backgroundSelectionColor;
    Color backgroundNonSelectionColor;

    public TrainDataRenderer()
    {
        x.setHorizontalAlignment(JLabel.LEFT);
        renderer.add(x);
        renderer.add(y);
        renderer.setBorder(BorderFactory.createLineBorder(Color.gray));
        //renderer.setBackground(Color.gray);        //Background to be set later
        backgroundSelectionColor = defaultRenderer.getBackgroundSelectionColor();
        backgroundNonSelectionColor = defaultRenderer.getBackgroundNonSelectionColor();
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
          renderer.setBackground(backgroundSelectionColor);
        } else {
          renderer.setBackground(backgroundNonSelectionColor);
        }
        
        
        return renderer;
        
    }
}
