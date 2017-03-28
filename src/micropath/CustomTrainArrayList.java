/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package micropath;

/**
 *
 * @author ArinjayaKhare1
 */
public class CustomTrainArrayList {
    
private String TrainNo,Signal;

public  CustomTrainArrayList(String x,String y)
{
    TrainNo=x;
    Signal=y;
}

    CustomTrainArrayList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
public String getTrainNo()
{
    return TrainNo;
}
public String getSignal()
{
    return Signal;
}
@Override
public String toString() {
    return TrainNo;
}
}
