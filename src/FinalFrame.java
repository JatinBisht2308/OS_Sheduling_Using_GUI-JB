import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class FinalFrame {
    FinalFrame(int index,String arrival,String burst)
    {
        if(index == 0)
        {
//            converting the arrival string to arrival integer array - jatin bisht
            String[] arrivalStringArray = arrival.split(" ");
            int[] arrivalArray = new int[arrivalStringArray.length];
            for(int i=0;i<arrivalArray.length;i++)
            {
                arrivalArray[i] = Integer.parseInt(arrivalStringArray[i]);
            }
//            converting the burst string to burst array - jatin bisht
            String[] burstStringArray = burst.split(" ");
            int[] burstArray = new int[burstStringArray.length];
            for(int i=0;i<burstArray.length;i++)
            {
                burstArray[i] = Integer.parseInt(burstStringArray[i]);
            }
//        Calling fcfs class
          FCFS fcfs = new FCFS(arrivalArray,burstArray);
        }
        else if(index == 1) {//            converting the arrival string to arrival integer array - jatin bisht
            String[] arrivalStringArray = arrival.split(" ");
            int[] arrivalArray = new int[arrivalStringArray.length];
            for (int i = 0; i < arrivalArray.length; i++) {
                arrivalArray[i] = Integer.parseInt(arrivalStringArray[i]);
            }
//            converting the burst string to burst array - jatin bisht
            String[] burstStringArray = burst.split(" ");
            int[] burstArray = new int[burstStringArray.length];
            for (int i = 0; i < burstArray.length; i++) {
                burstArray[i] = Integer.parseInt(burstStringArray[i]);
            }
//            calling SJF-P
            SJFP sjfp = new SJFP(arrivalArray,burstArray);
        }
        else
        {
            // converting the arrival string to arrival integer array - jatin bisht
            String[] arrivalStringArray = arrival.split(" ");
            int[] arrivalArray = new int[arrivalStringArray.length];
            for(int i=0;i<arrivalArray.length;i++)
            {
                arrivalArray[i] = Integer.parseInt(arrivalStringArray[i]);
            }
//            converting the burst string to burst array - jatin bisht
            String[] burstStringArray = burst.split(" ");
            int[] burstArray = new int[burstStringArray.length];
            for(int i=0;i<burstArray.length;i++)
            {
                burstArray[i] = Integer.parseInt(burstStringArray[i]);
            }
//        Calling SJFNP class
            SJFNP sjfnp = new SJFNP(arrivalArray,burstArray);
        }
    }
}
