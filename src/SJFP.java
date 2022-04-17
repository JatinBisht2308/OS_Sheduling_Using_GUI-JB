import javax.swing.*;
//import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
public class SJFP {
    JFrame frame;// used to making the frame``
    JLabel output;//used for the heading of the frame
    JLabel sjfp; // used to tell that which algo is using at the top right side of the frame
    JLabel ganttChart;// used to write the gantChart above the gantt chart diagram
    //    JLabel Average;//used to find the average of tat and wt
    SJFP(int[] arrival,int[] burst)
    {
//        specify the number of rows and columns in the table and the gantt chart
//        int rowInTable = arrival.length;//row will be same for gantt chart and table
        int columnInGanttChart = arrival.length;
//        int column = 6;

//        Making the frame know
        frame = new JFrame();
        frame.setTitle("Shortest Job First Preemptive (SJF-P)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        first grid layout for gantt chart
        frame.setLayout(null);
//        Making panel for the gant chat
        JPanel gantChartPanel = new JPanel();
        gantChartPanel.setBounds(100,100,300,50);
        gantChartPanel.setLocation(200,100);
        gantChartPanel.setLayout(new GridLayout(1,columnInGanttChart,0,0));
        gantChartPanel.setBackground(new Color(215, 245, 255));
        gantChartPanel.setForeground(Color.BLACK);
//        making buttons in the gantt chart
        for(int i=0;i<columnInGanttChart;i++)
        {
            char ch = (char)(65+i);
            JButton button = new JButton(String.valueOf(ch));
            button.setBackground(new Color(215, 245, 255));
            button.setFont(new Font(null,Font.BOLD,20));
            button.setFocusable(false);
            gantChartPanel.add(button);
        }
//        making the label for the heading output
        output = new JLabel("Output");
        output.setForeground(Color.BLACK);
        output.setBounds(35,10,200,50);
        output.setFont(new Font(null,Font.BOLD,35));
//        writing gantt chart above the grid layout
        ganttChart = new JLabel("Gantt Chart");
        ganttChart.setBounds(270,65,200,30);
        ganttChart.setFont(new Font("Courier",Font.PLAIN,30));
//        adding panel for the algorithm
        sjfp = new JLabel("SJF-P");
        sjfp.setBounds(635,12,50,30);
        sjfp.setFont(new Font(null,Font.BOLD,15));
        sjfp.setForeground(new Color(40, 220, 255));

//        ------------------------------------------------------------------------
//        Now making the values for the finish time in the gant chart
        int[] finish = finishTime(arrival,burst);
        for(int i=0;i<=finish.length;i++)
        {
            if(i==0)
            {
                String str = Integer.toString(1);
//              str+="                                           ";
                JLabel ft = new JLabel(str);
                int start = 200;
                ft.setBounds(start,145,300,30);
                ft.setFont(new Font(null,Font.PLAIN,13));
                frame.add(ft);
            }
            else{
                int j = i-1;
                String str = Integer.toString(finish[j]);
//              str+="                                           ";
                JLabel ft = new JLabel(str);
                int start = 200 + (i*70);
                ft.setBounds(start,145,300,30);
                ft.setFont(new Font(null,Font.PLAIN,13));
                frame.add(ft);
            }
        }
//        ------------------------------------------------------------------------
//        Making the table format for final table
        JTable table = new JTable();
//          table.setBounds();
        table.setFont(new Font(null,Font.BOLD,15));
        table.setBackground(new Color(215, 245, 255));
        table.setBounds(100,100,700,480);
        table.setRowHeight(30);
        table.setFocusable(false);

//        table.setSize(600,500);
        JPanel tablePanel = new JPanel();
        int height = (arrival.length)*35;
        tablePanel.setBounds(35,250,600,height);
        tablePanel.setLocation(50,200);
//          tablePanel.setBackground(Color.BLACK);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(600,600));
//        scrollPane.setViewportView(table);
        DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
//        adding the column name
        tableModel.addColumn("Job");
        tableModel.addColumn("Arrival Time");
        tableModel.addColumn("Burst Time");
        tableModel.addColumn("Finish Time");
        tableModel.addColumn("Turnaround Time");
        tableModel.addColumn("Waiting Time");
//        Getting the values of turnaround array
        int[] turnAround = turnaroundTime(finish,arrival);
//        getting the values of waiting time
        int[] waiting = waitingTime(turnAround,burst);
//        Adding values to the column
        for(int i=0;i<arrival.length;i++)
        {
//            selecting the job
            char ch = (char)(65+i);
            String str1 = Character.toString(ch);
//            value of arrival time
            String str2 = Integer.toString(arrival[i]);
//            value of burst time
            String str3 = Integer.toString(burst[i]);
//           value of finish time
            String str4 = Integer.toString(finish[i]);
//            value of Turnaround Time
            String str5 = Integer.toString(turnAround[i]);
//            value of Waiting time
            String str6 = Integer.toString(waiting[i]);
            tableModel.addRow(new Object[0]);
            tableModel.setValueAt(str1,i,0);
            tableModel.setValueAt(str2,i,1);
            tableModel.setValueAt(str3,i,2);
            tableModel.setValueAt(str4,i,3);
            tableModel.setValueAt(str5,i,4);
            tableModel.setValueAt(str6,i,5);
        }
//        set the column width for each column
        table.getColumnModel().getColumn(0).setPreferredWidth(5);
        table.getColumnModel().getColumn(1).setPreferredWidth(20);
        table.getColumnModel().getColumn(2).setPreferredWidth(15);
        table.getColumnModel().getColumn(3).setPreferredWidth(17);
//        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
//        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
//        table.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
//         tablePanel.setFocusable(false);
//        scrollPane.add(table)
        frame.setSize(700,500);
        tablePanel.add(scrollPane);
        frame.add(tablePanel);
        frame.add(sjfp);
        frame.add(ganttChart);
        frame.add(output);
        frame.add(gantChartPanel);
        frame.setVisible(true);
    }
//    making a different class
    public class processMaker
{
        int pId;
        int bt;
        int art;
        public processMaker(int pId,int bt,int art)
        {
            this.pId = pId;
            this.art = art;
            this.bt = bt;
        }
}
class JatinSolutionBuilder
{
    static void findWaitingTime(Process proc[], int n,int wt[])
    {
        int rt[] = new int[n];

        // Copy the burst time into rt[]
        for (int i = 0; i < n; i++)
            rt[i] = proc[i].bt;

        int complete = 0, t = 0, minm = Integer.MAX_VALUE;
        int shortest = 0, finish_time;
        boolean check = false;

        // Process until all processes gets
        // completed
        while (complete != n) {

            // Find process with minimum
            // remaining time among the
            // processes that arrives till the
            // current time`
            for (int j = 0; j < n; j++)
            {
                if ((proc[j].art <= t) &&
                        (rt[j] < minm) && rt[j] > 0) {
                    minm = rt[j];
                    shortest = j;
                    check = true;
                }
            }

            if (check == false) {
                t++;
                continue;
            }

            // Reduce remaining time by one
            rt[shortest]--;

            // Update minimum
            minm = rt[shortest];
            if (minm == 0)
                minm = Integer.MAX_VALUE;

            // If a process gets completely
            // executed
            if (rt[shortest] == 0) {

                // Increment complete
                complete++;
                check = false;

                // Find finish time of current
                // process
                finish_time = t + 1;

                // Calculate waiting time
                wt[shortest] = finish_time -
                        proc[shortest].bt -
                        proc[shortest].art;

                if (wt[shortest] < 0)
                    wt[shortest] = 0;
            }
            // Increment time
            t++;
        }
    }

    // Method to calculate turn around time
    static void findTurnAroundTime(Process proc[], int n,
                                   int wt[], int tat[])
    {
        // calculating turnaround time by adding
        // bt[i] + wt[i]
        for (int i = 0; i < n; i++)
            tat[i] = proc[i].bt + wt[i];
    }

    // Method to calculate average time
    static void findavgTime(Process proc[], int n)
    {
        int wt[] = new int[n], tat[] = new int[n];
        int total_wt = 0, total_tat = 0;

        // Function to find waiting time of all
        // processes
        findWaitingTime(proc, n, wt);

        // Function to find turn around time for
        // all processes
        findTurnAroundTime(proc, n, wt, tat);

        // Display processes along with all
        // details
        System.out.println("Processes " +
                " Burst time " +
                " Waiting time " +
                " Turn around time");

        // Calculate total waiting time and
        // total turnaround time
        for (int i = 0; i < n; i++) {
            total_wt = total_wt + wt[i];
            total_tat = total_tat + tat[i];
            System.out.println(" " + proc[i].pid + "\t\t"
                    + proc[i].bt + "\t\t " + wt[i]
                    + "\t\t" + tat[i]);
        }

        System.out.println("Average waiting time = " +
                (float)total_wt / (float)n);
        System.out.println("Average turn around time = " +
                (float)total_tat / (float)n);
    }

}
}
