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
              double scale, Color color, String label) {
      this.bottom = bottom; 
      this.left = left;    
      this.width = width;    
      this.barHeight = barHeight;
      this.scale = scale;
      this.color = color;
      this.label = label;
   }
   
   /**
      Draw the labeled bar. 
      @param g2  the graphics context
   */
   public void draw(Graphics2D g2) {
      // get label height and width
      Font font_bar = g2.getFont();
      FontRenderContext context_bar = g2.getFontRenderContext();
      Rectangle2D labelBounds_bar = font_bar.getStringBounds(label,context_bar);
      int widthOfLabel_bar = (int)labelBounds_bar.getWidth();
      int heightOfLabel_bar = (int)labelBounds_bar.getHeight();

      // Create a bar: upper-left corner (left, bottom-barHeight-heightOfLabel_bar)
      Rectangle bar = new Rectangle(left,bottom-barHeight-heightOfLabel_bar*2,width,barHeight);  
      g2.setColor(color);                                      // Set Color
      g2.fill(bar);                                            // Draw bar
      g2.drawString(label,(left+width/2)-widthOfLabel_bar/2,bottom-heightOfLabel_bar); // Draw label
   }
}
