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
import java.awt.event.ComponentListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.Font;
import javax.swing.JComponent;

public class CoinSimComponent extends JComponent
{
    private CoinTossSimulator coinToss;
    private int windowHeight;
    private int windowWidth;
    private int spaceBetweenBar;
    private double scale;              // Scale is windowsHeight/totaltrails
    private int barWidth = 20;
    private int bottom = 20;

    public CoinSimComponent(int i, int windowWidth, int windowHeight){
        this.windowHeight = windowHeight;
        this.windowWidth = windowWidth;
        this.spaceBetweenBar = windowWidth/4;
        this.coinToss = new CoinTossSimulator();
        coinToss.run(i);
        System.out.println("WindowHeight: " +  windowHeight);
        System.out.println(windowHeight-bottom*2-barWidth);
        this.scale = (double)(windowHeight-bottom*2-barWidth)/coinToss.getNumTrials();  // Scale is windowsHeight/totaltrails
    }

    public void componentResized(ComponentEvent e){

    }

    public void paintComponent(Graphics g)
    {

        // System.out.println("Scale: " + scale);
        Graphics2D g2 = (Graphics2D) g;
        // left bar: Two head    
        int left_bar1 = windowWidth/2-spaceBetweenBar-barWidth/2;
        double barHeight_bar1 = scale*coinToss.getTwoHeads();                      // Bar height = scale * number of two heads
        String label_bar1 = "Two Heads: " + coinToss.getTwoHeads()             
                            + " (" + Math.round((double)coinToss.getTwoHeads()*100/coinToss.getNumTrials()) + "%)";
        Font font_bar1 = g2.getFont();
        FontRenderContext context_bar1 = g2.getFontRenderContext();
        Rectangle2D labelBounds_bar1 = font_bar1.getStringBounds(label_bar1,context_bar1);
        int widthOfLabel_bar1 = (int)labelBounds_bar1.getWidth();
        int heightOfLabel_bar1 = (int)labelBounds_bar1.getHeight();
        
        Bar bar1 = new Bar(windowHeight-bottom-heightOfLabel_bar1,left_bar1,barWidth,(int)barHeight_bar1,scale,new Color(255, 0, 0),label_bar1,heightOfLabel_bar1,widthOfLabel_bar1);


        // middle bar: A head and a tail
        int left_bar2 = windowWidth/2-barWidth/2;
        double barHeight_bar2 = scale*coinToss.getHeadTails();
        String label_bar2 = "A Head and a Tail: " + coinToss.getHeadTails() 
                            + " (" + Math.round((double)coinToss.getHeadTails()*100/coinToss.getNumTrials()) + "%)";
        Font font_bar2 = g2.getFont();
        FontRenderContext context_bar2 = g2.getFontRenderContext();
        Rectangle2D labelBounds_bar2 = font_bar2.getStringBounds(label_bar2,context_bar2);
        int widthOfLabel_bar2 = (int)labelBounds_bar2.getWidth();
        int heightOfLabel_bar2 = (int)labelBounds_bar2.getHeight();  
    
        Bar bar2 = new Bar(windowHeight-bottom-heightOfLabel_bar2,left_bar2,barWidth,(int)barHeight_bar2,scale,new Color(0, 255, 0),label_bar2,heightOfLabel_bar2,widthOfLabel_bar2);
    

        // right bar: Two Tails
        int left_bar3 = windowWidth/2+spaceBetweenBar-barWidth/2;
        double barHeight_bar3 = scale * coinToss.getTwoTails();
        String label_bar3 = "Two Tails: " + coinToss.getTwoTails() 
                            + " (" + Math.round((double)coinToss.getTwoTails()*100/coinToss.getNumTrials()) + "%)";
        Font font_bar3 = g2.getFont();
        FontRenderContext context_bar3 = g2.getFontRenderContext();
        Rectangle2D labelBounds_bar3 = font_bar3.getStringBounds(label_bar3,context_bar3);
        int widthOfLabel_bar3 = (int)labelBounds_bar3.getWidth();
        int heightOfLabel_bar3 = (int)labelBounds_bar3.getHeight();
    
        Bar bar3 = new Bar(windowHeight-bottom-heightOfLabel_bar3,left_bar3,barWidth,(int)barHeight_bar3,scale,new Color(0, 0, 255),label_bar3,heightOfLabel_bar3,widthOfLabel_bar3);

        bar1.draw(g2);
        bar2.draw(g2);
        bar3.draw(g2);
    }
}