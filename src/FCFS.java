import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class FCFS {
    JFrame frame;// used to making the frame
    JLabel output;//used for the heading of the frame
    JLabel fcfs; // used to tell that which algo is using at the top right side of the frame
    JLabel ganttChart;// used to write the gantChart above the gantt chart diagram
    FCFS(int[] arrival,int[] burst)
    {
//        specify the number of rows and columns in the table and the gantt chart
        int rowInTable = arrival.length;//row will be same for gantt chart and table
        int columnInGanttChart = arrival.length;
        int column = 6;

        int[] finishTimeArray = new int[arrival.length];
        int[] waitingTimeArray = new int[arrival.length];
        int[] turnaroundTimeArray = new int[arrival.length];

//        Making the frame know
        frame = new JFrame();
        frame.setSize(600,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        first grid layout for gantt chart
        frame.setLayout(null);
//        Making panel for the gant chat
        JPanel gantChartPanel = new JPanel();
        gantChartPanel.setBounds(100,40,150,50);
        gantChartPanel.setLayout(new GridLayout(1,columnInGanttChart,0,0));
//        making buttons in the gantt chart
        for(int i=0;i<columnInGanttChart;i++)
        {
            gantChartPanel.add(new JButton(String.valueOf(i+1)));
        }
//        frame.add(ganttChart);
        frame.add(gantChartPanel);
        frame.pack();
        frame.setVisible(true);
    }
//    FIND FINISH TIME
    public void finishTime()
    {

    }
//    FIND WAITING TIME
    public void waitingTime()
    {

    }
//    FIND TURNAROUND TIME
    public void turnaroundTime()
    {

    }
}
