/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test keepOnlyBlue */
  public static void testKeepOnlyBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.keepOnlyBlue();
    beach.explore();
  }
  
  /** Method to test negate */
  public static void testNegate()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.negate();
    beach.explore();
  }
  
  /** Method to test grayscale */
  public static void testGrayscale()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.grayscale();
    beach.explore();
  }
  
  /** Method to test fixUnderwater */
  public static void testFixUnderwater()
  {
    Picture beach = new Picture("water.jpg");
    beach.explore();
    beach.fixUnderwater();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorVerticalRightToLeft */
  public static void testMirrorVerticalRightToLeft()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVerticalRightToLeft();
    caterpillar.explore();
  }

  /** Method to test mirrorHorizontal */
  public static void testMirrorHorizontal()
  {
    Picture caterpillar = new Picture("redMotorcycle.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontal();
    caterpillar.explore();
  }
  
  /** Method to test mirrorHorizontalBotToTop */
  public static void testMirrorHorizontalBotToTop()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.mirrorHorizontalBotToTop();
    beach.explore();
  }
  
  /** Method to test mirrorDiagonal */
  public static void testMirrorDiagonal()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.mirrorDiagonal();
    beach.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
    System.out.println(temple.mirrorTemple());
  }
  
  /** Method to test mirrorArms */
  public static void testMirrorArms()
  {
    Picture temple = new Picture("seagull.jpg");
    temple.explore();
    temple.mirrorArms();
    temple.explore();
  }
  
  /** Method to test mirrorGull */
  public static void testMirrorGull()
  {
    Picture seagull = new Picture("seagull.jpg");
    seagull.explore();
    seagull.mirrorGull();
    seagull.explore();
  }
  
  /** Method to test cropAndCopy */
  public static void testCropAndCopy()
  {
      Picture katie = new Picture("KatieFancy.jpg");
      Picture beach = new Picture("beach.jpg");
      beach.explore();
      beach.cropAndCopy(katie, 25, 77, 85, 124, 97, 236);
      beach.explore();
  }
    
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("1000x1000.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  /** Method to test scaleByHalf */
  public static void testScaleByHalf()
  {
      Picture forest = new Picture("forest.jpg");
      forest.scaleByHalf();
      forest.explore();
  }
    
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    
    DigitalPicture p = new SimplePicture();
    
    testZeroBlue();
    testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    testNegate();
    testGrayscale();
    testFixUnderwater();
    testMirrorVertical();
    testMirrorVerticalRightToLeft();
    testMirrorHorizontal();
    testMirrorHorizontalBotToTop();
    testMirrorDiagonal();
    testMirrorTemple();
    testMirrorArms();
    testMirrorGull();
    testCollage();
    testCropAndCopy();
    testScaleByHalf();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}