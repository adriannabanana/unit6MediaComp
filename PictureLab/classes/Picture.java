import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments 
     */
    public Picture ()
    {
        /* not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor 
         */
        super();  
    }

    /**
     * Constructor that takes a file name and creates the picture 
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName)
    {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     * @param height the height of the desired picture
     * @param width the width of the desired picture
     */
    public Picture(int height, int width)
    {
        // let the parent class handle this width and height
        super(width,height);
    }

    /**
     * Constructor that takes a picture and creates a 
     * copy of that picture
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture)
    {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image)
    {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////

    /**
     * Method to return a string with information about this picture.
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString()
    {
        String output = "Picture, filename " + getFileName() + 
            " height " + getHeight() 
            + " width " + getWidth();
        return output;

    }

    /** Method to set the blue to 0 */
    public void zeroBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setBlue(0);
            }
        }
    }
    
    /** Method to set the green to 0 */
    public void zeroGreen()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setGreen(0);
            }
        }
    }

    /** Method to set red and green to 0 */
    public void keepOnlyBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setRed(0);
                pixelObj.setGreen(0);
            }
        }
    }

    /** Method to negate all the pixels in a picture */
    public void negate()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setRed(255-pixelObj.getRed());
                pixelObj.setGreen(255-pixelObj.getGreen());
                pixelObj.setBlue(255-pixelObj.getBlue());
            }
        }
    }

    /** Method to grayscale all the pixels in a picture */
    public void grayscale()
    {
        Pixel[][] pixels = this.getPixels2D();
        int avg = 0;
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                avg = (pixelObj.getRed()+pixelObj.getGreen()+pixelObj.getBlue())/3;
                pixelObj.setRed(avg);
                pixelObj.setGreen(avg);
                pixelObj.setBlue(avg);
            }
        }
    }
    
    /** Method to use a sepia filter */
    public void sepia()
    {
        Pixel[][] pixels = this.getPixels2D();
        int avg = 0;
        int originalRed = 0;
        int originalBlue = 0;
        int originalGreen = 0;
        
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                originalRed = pixelObj.getRed();
                originalBlue = pixelObj.getBlue();
                originalGreen = pixelObj.getGreen();
                avg = (pixelObj.getRed()+pixelObj.getGreen()+pixelObj.getBlue())/3;
                pixelObj.setRed(avg);
                pixelObj.setGreen(avg);
                pixelObj.setBlue(avg);
                if (pixelObj.getRed() < 60)
                {
                    pixelObj.setRed((int)(originalRed*.9));
                    pixelObj.setBlue((int)(originalBlue*.9));
                    pixelObj.setGreen((int)(originalGreen*.9));
                }
                else if (pixelObj.getRed() < 190)
                {
                    pixelObj.setBlue((int)(originalRed*.8));
                }
                else
                {
                    pixelObj.setBlue((int)(originalRed*.9));
                }
            }
        }
    }
    
    /** Method to posterize a picture */
    public void posterize()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                if (pixelObj.getRed() < 64)
                {
                    pixelObj.setRed(32);
                }
                else if (pixelObj.getRed() < 128)
                {
                    pixelObj.setRed(96);
                }
                else if (pixelObj.getRed() < 192)
                {
                    pixelObj.setRed(160);
                }
                else
                {
                    pixelObj.setRed(224);
                }
                
                if (pixelObj.getBlue() < 64)
                {
                    pixelObj.setBlue(32);
                }
                else if (pixelObj.getBlue() < 128)
                {
                    pixelObj.setBlue(96);
                }
                else if (pixelObj.getBlue() < 192)
                {
                    pixelObj.setBlue(160);
                }
                else
                {
                    pixelObj.setBlue(224);
                }
                
                if (pixelObj.getGreen() < 64)
                {
                    pixelObj.setGreen(32);
                }
                else if (pixelObj.getGreen() < 128)
                {
                    pixelObj.setGreen(96);
                }
                else if (pixelObj.getGreen() < 192)
                {
                    pixelObj.setGreen(160);
                }
                else
                {
                    pixelObj.setGreen(224);
                }
            }
        }
    }

    /** Method to see the fishies */
    public void fixUnderwater()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setGreen(pixelObj.getGreen()-100);
                pixelObj.setBlue(pixelObj.getBlue()-90);
            }
        }
    }

    /** Method that mirrors the picture around a 
     * vertical mirror in the center of the picture
     * from left to right */
    public void mirrorVertical()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        } 
    }

    /** Method that mirrors the picture around a 
     * vertical mirror in the center of the picture
     * from right to left */
    public void mirrorVerticalRightToLeft()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length/2; row++)
        {
            for (int col = 0; col < width; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                leftPixel.setColor(rightPixel.getColor());
            }
        } 
    }

    /** Method that mirrors the picture around a 
     * horizontal mirror in the center of the picture
     * from top to bottom */
    public void mirrorHorizontal()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int cols = pixels[0].length;
        int rows = pixels.length;
        for (int row = 0; row < rows/2; row++)
        {
            for (int col = 0; col < cols; col++)
            {
                topPixel = pixels[row][col];
                bottomPixel = pixels[rows-row-1][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        } 
    }

    /** Method that mirrors the picture around a 
     * horizontal mirror in the center of the picture
     * from bottom to top */
    public void mirrorHorizontalBotToTop()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int cols = pixels[0].length;
        int rows = pixels.length;
        for (int row = 0; row < rows/2; row++)
        {
            for (int col = 0; col < cols; col++)
            {
                topPixel = pixels[row][col];
                bottomPixel = pixels[rows-row-1][col];
                topPixel.setColor(bottomPixel.getColor());
            }
        } 
    }  

    /** Method that mirrors just a square part of the picture 
     * from bottom left to top right around a mirror placed
     * on the diagonal line */
    public void mirrorDiagonal()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel bottomLeftPixel = null;
        Pixel topRightPixel = null;
        int cols = pixels[0].length;
        int rows = pixels.length;
        int smallerSide = 0;

        if (rows < cols)
        {
            smallerSide = rows;
        }
        else if (cols < rows)
        {
            smallerSide = cols;
        }
        else
        {
            smallerSide = cols;
        }

        for (int row = 0; row < smallerSide; row++)
        {
            for (int col = 0; col < smallerSide; col++)
            {
                topRightPixel = pixels[row][col];
                bottomLeftPixel = pixels[col][row];
                topRightPixel.setColor(bottomLeftPixel.getColor());
            }
        } 
    }

    /** Mirror just part of a picture of a temple */
    public int mirrorTemple()
    {
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 27; row < 97; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 13; col < mirrorPoint; col++)
            {
                count ++;
                leftPixel = pixels[row][col];      
                rightPixel = pixels[row]                       
                [mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
        return count;
    }

    /** Mirror the arms of a snowman */
    public void mirrorArms()
    {
        int mirrorPoint = 204;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 156; row < 194; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 102; col < mirrorPoint; col++)
            {
                leftPixel = pixels[row][col];      
                rightPixel = pixels[row]                       
                [mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /** Mirror a seagull!!! */
    public void mirrorGull()
    {
        int mirrorPoint = 360;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 225; row < 328; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 233; col < mirrorPoint; col++)
            {
                leftPixel = pixels[row][col];      
                rightPixel = pixels[row]                       
                [mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
            }
        }

    }

    /** copy from the passed fromPic to the
     * specified startRow and startCol in the
     * current picture
     * @param fromPic the picture to copy from
     * @param startRow the start row to copy to
     * @param startCol the start col to copy to
     */
    public void copy(Picture fromPic, 
    int startRow, int startCol)
    {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int fromRow = 0, toRow = startRow; 
        fromRow < fromPixels.length &&
        toRow < toPixels.length; 
        fromRow++, toRow++)
        {
            for (int fromCol = 0, toCol = startCol; 
            fromCol < fromPixels[0].length &&
            toCol < toPixels[0].length;  
            fromCol++, toCol++)
            {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }   
    }

    /** 
     */
    public void cropAndCopy(Picture sourcePicture, int startSourceRow, int endSourceRow,
    int startSourceCol, int endSourceCol,int startDestRow, 
    int startDestCol)
    {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = sourcePicture.getPixels2D();
        for (int fromRow = startSourceRow, toRow = startDestRow; 
        fromRow < endSourceRow &&
        toRow < toPixels.length; 
        fromRow++, toRow++)
        {
            for (int fromCol = startSourceCol, toCol = startDestCol; 
            fromCol < endSourceCol &&
            toCol < toPixels[0].length;  
            fromCol++, toCol++)
            {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }  
    }

    /** Method to create a collage of several pictures */
    public void createCollage()
    {
        Picture forest = new Picture("forest2.jpg");
        this.copy(forest,0,0);
        
        Picture posterizedForest = new Picture(forest);
        posterizedForest.posterize();
        posterizedForest.mirrorVertical();
        this.copy(posterizedForest,332,500);
        
        Picture grayForest = new Picture(forest);
        grayForest.grayscale();
        grayForest.mirrorDiagonal();
        this.copy(grayForest,0,500);
        
        Picture sepiaForest = new Picture(forest);
        sepiaForest.sepia();
        sepiaForest.mirrorHorizontal();
        this.copy(sepiaForest,332,0);
        
        Picture noGreen = new Picture(forest);
        noGreen.zeroGreen();
        this.copy(noGreen,663,0);
        
        Picture negativeForest = new Picture(forest);
        negativeForest.negate();
        negativeForest.mirrorVerticalRightToLeft();
        this.copy(negativeForest,663,500);
        
        this.write("forest collage.jpg");
    }

    /** Method to show large changes in color 
     * @param edgeDist the distance for finding edges
     */
    public void edgeDetection(int edgeDist)
    {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; 
            col < pixels[0].length-1; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col+1];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor) > 
                edgeDist)
                    leftPixel.setColor(Color.BLACK);
                else
                    leftPixel.setColor(Color.WHITE);
            }
        }
    }
    
    /** scales a picture by 50% (width and height will halved)*/
    public Pixel[][] scaleByHalf()
    {
        Pixel[][] pixels = this.getPixels2D();
        int height = pixels.length;
        int width = pixels[0].length;
        int newHeight = height/2;
        int newWidth = width/2;
        Picture scaled = new Picture(newHeight,newWidth);
        Pixel[][] scaledPic = scaled.getPixels2D();
        for (int i = 0; i < height; i+=2)
        {
            for (int j = 0; j < width; j+=2)
            {
                scaledPic[i/2][j/2] = pixels[i][j];
            }
        }
        
        return scaledPic;

    }

    /** Main method for testing - each class in Java can have a main method */
    public static void main(String[] args) 
    {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();
    }

} // this } is the end of class Picture, put all new methods before this
