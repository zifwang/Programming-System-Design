// Author: Zifan Wang
// ID: 9505587296
// CSCI455

/**
 * This class is responsible for setting up display window
 * Extends JComponent. 
 * Constructor initializes any necessary data and runs the simulation. 
 * Overrides paintComponent to draw the bar graph, using Bar objects for each bar in the graph. 
 * This class uses the CoinTossSimulator and Bar class.d
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class CoinSimComponent extends JComponent
{
    // Instance variable 
    private CoinTossSimulator coinToss; // Used to simulate coin toss
    private int windowHeight;           // Private int var displayed windows height
    private int windowWidth;            // Private int var displayed windows width
    private int spaceBetweenBar;        // Space between bars determined by windows width
    private double scale;               // Scale is windowsHeight/totaltrails
    private final int BARWIDTH = 20;    // Constant private var. Set barwidth to 20
    private final int VB = 20;          // Constant private var. set Vertical buffer to 20


    /**
     * This is the constructor of CoinSimComponent class. Input is number of trails 
     * @param numTrails is number of trails 
     */
    public CoinSimComponent(int numTrails){
        this.coinToss = new CoinTossSimulator();
        coinToss.run(numTrails);
    }


    public void paintComponent(Graphics g)
    {
        windowHeight = getHeight();
        windowWidth = getWidth();
        spaceBetweenBar = getWidth()/4;
        scale = (double)(getHeight()*0.7)/coinToss.getNumTrials();  // Scale is 70% of windowsHeight/totaltrails
        
        // System.out.println("Scale: " + scale);
        Graphics2D g2 = (Graphics2D) g;

        // Calculate barHeights
        double barHeight_bar1 = scale*coinToss.getTwoHeads();                      // Bar height = scale * number of two heads
        double barHeight_bar2 = scale*coinToss.getHeadTails();
        double barHeight_bar3 = scale * coinToss.getTwoTails();

        // Calculate lefttop position of bars
        int left_bar1 = windowWidth/2-spaceBetweenBar-BARWIDTH/2;
        int left_bar2 = windowWidth/2-BARWIDTH/2;
        int left_bar3 = windowWidth/2+spaceBetweenBar-BARWIDTH/2;

        // String label of bars 
        String label_bar1 = "Two Heads: " + coinToss.getTwoHeads()             
        + " (" + Math.round((double)coinToss.getTwoHeads()*100/coinToss.getNumTrials()) + "%)";
        String label_bar2 = "A Head and a Tail: " + coinToss.getHeadTails() 
        + " (" + Math.round((double)coinToss.getHeadTails()*100/coinToss.getNumTrials()) + "%)";
        String label_bar3 = "Two Tails: " + coinToss.getTwoTails() 
        + " (" + Math.round((double)coinToss.getTwoTails()*100/coinToss.getNumTrials()) + "%)";


        // left bar: Two head    
        Bar bar1 = new Bar(windowHeight-VB,left_bar1,BARWIDTH,(int)barHeight_bar1,scale,new Color(255, 0, 0),label_bar1);
        // middle bar: A head and a tail
        Bar bar2 = new Bar(windowHeight-VB,left_bar2,BARWIDTH,(int)barHeight_bar2,scale,new Color(0, 255, 0),label_bar2);
        // right bar: Two Tails
        Bar bar3 = new Bar(windowHeight-VB,left_bar3,BARWIDTH,(int)barHeight_bar3,scale,new Color(0, 0, 255),label_bar3);

        // Draw bars
        bar1.draw(g2);
        bar2.draw(g2);
        bar3.draw(g2);
    }
}