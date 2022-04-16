import javax.swing.*;
import javax.swing.border.*;
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
        gantChartPanel.setBounds(100,100,300,50);
        gantChartPanel.setLocation(145,100);
        gantChartPanel.setLayout(new GridLayout(1,columnInGanttChart,0,0));
        gantChartPanel.setBackground(new Color(215, 245, 255));
        gantChartPanel.setForeground(Color.BLACK);
//        making buttons in the gantt chart
        for(int i=0;i<columnInGanttChart;i++)
        {
            char ch = (char)(65+i);
            JButton button = new JButton(String.valueOf(ch));
            button.setBackground(new Color(215, 245, 255));
            button.setFocusable(false);
            gantChartPanel.add(button);
        }
//        making the label for the heading output
        output = new JLabel("Output");
        output.setForeground(Color.BLACK);
        output.setBounds(35,10,200,50);
        output.setFont(new Font(null,Font.BOLD,40));
//        writing gantt chart above the grid layout
        ganttChart = new JLabel("Gantt Chart");
        ganttChart.setBounds(220,65,200,30);
        ganttChart.setFont(new Font("Courier",Font.PLAIN,30));
//        adding panel for the algorithm
        fcfs = new JLabel("FCFS");
        fcfs.setBounds(535,12,50,30);
        fcfs.setFont(new Font(null,Font.BOLD,15));
        fcfs.setForeground(new Color(40, 220, 255));

//        ------------------------------------------------------------------------
//        Now making the values for the finish time in the gant chart

//        ------------------------------------------------------------------------
        frame.add(fcfs);
        frame.add(ganttChart);
         frame.add(output);
        frame.add(gantChartPanel);
        frame.setVisible(true);
    }
//    FIND FINISH TIME
    public void finishTime(int[] arrival,int[] burst)
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
