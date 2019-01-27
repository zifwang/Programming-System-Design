// Name: Zifan Wang 
// USC NetID: 9505587296
// CS 455 PA1
// Spring 2019

// we included the import statements for you
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * Bar class
 * A labeled bar that can serve as a single bar in a bar graph.
 * The text for the label is centered under the bar.
 * 
 * NOTE: we have provided the public interface for this class. Do not change
 * the public interface. You can add private instance variables, constants,
 * and private methods to the class. You will also be completing the
 * implementation of the methods given.
 * 
 */
public class Bar {
   // Private instance variables define here
   private int bottom;
   private int left;
   private int width;
   private int barHeight;
   private double scale;
   private Color color;
   private String label;
   private int labelWidth;
   private int labelHeight;


   /**
      Creates a labeled bar.  You give the height of the bar in application
      units (e.g., population of a particular state), and then a scale for how
      tall to display it on the screen (parameter scale). 
  
      @param bottom  location of the bottom of the label
      @param left  location of the left side of the bar
      @param width  width of the bar (in pixels)
      @param barHeight  height of the bar in application units
      @param scale  how many pixels per application unit
      @param color  the color of the bar
      @param label  the label at the bottom of the bar
   */
   public Bar(int bottom, int left, int width, int barHeight,
              double scale, Color color, String label, int labelHeight, int labelWidth) {
      this.bottom = bottom; 
      this.left = left;       // left side of bar. Get from bar width and windows size: (window's width)/4-(bar's width/2)
      this.width = width;     // bar width (fix value)
      this.barHeight = barHeight;
      this.scale = scale;
      this.color = color;
      this.label = label;
      this.labelHeight = labelHeight;
      this.labelWidth = labelWidth;
   }
   
   /**
      Draw the labeled bar. 
      @param g2  the graphics context
   */
   public void draw(Graphics2D g2) {
      // System.out.println(left);
      // System.out.println(bottom-barHeight-labelHeight*2);
      Rectangle bar = new Rectangle(left,bottom-barHeight-labelHeight,width,barHeight);  // Create a bar: upper-left y = bottom+10(font's size)+barHeight
      // Font font = new Font(label,Font.PLAIN,10);                   // Set font with style plain and size 10;

      g2.setColor(color);
      g2.fill(bar);
      g2.drawString(label,(left+width)-(labelWidth/2),bottom);
   }
}
