package Util;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.*;

import javax.imageio.ImageIO;

public class ImageTransparency {
    /*ImageTransparency() throws IOException {
        String imagePath = "src";
        File inFile = new File("src/images/a.png");
        BufferedImage image = ImageIO.read(inFile);
        Image transpImg2 = TransformColorToTransparency(image, new Color(image.getRGB(0, 0)), new Color(200, 200, 255));
        BufferedImage resultImage2 = ImageToBufferedImage(transpImg2, image.getWidth(), image.getHeight());
        File outFile2 = new File(imagePath, "map_with.png");
        ImageIO.write(resultImage2, "PNG", outFile2);
    }*/
    public  BufferedImage toTransparency(BufferedImage image){
        Image transpImg2 = TransformColorToTransparency(image, new Color(image.getRGB(0, 0)));
        BufferedImage result = ImageToBufferedImage(transpImg2, image.getWidth(), image.getHeight());
        return result;
    }
    private  Image TransformGrayToTransparency(BufferedImage image) {
        ImageFilter filter = new RGBImageFilter() {
            public final int filterRGB(int x, int y, int rgb) {
                return (rgb << 8) & 0xFF000000;
            }
        };

        ImageProducer ip = new FilteredImageSource(image.getSource(), filter);
        return Toolkit.getDefaultToolkit().createImage(ip);
    }
 
    private Image TransformColorToTransparency(BufferedImage image, Color c1) {

        ImageFilter filter = new RGBImageFilter() {

            public int markerRGB = c1.getRGB() | 0xFF000000;

            public final int filterRGB(int x, int y, int rgb) {
                if ((rgb | 0xFF000000) == markerRGB) {
                    return 0x00FFFFFF & rgb;
                } else {
                    return rgb;
                }
            }
        };

        ImageProducer ip = new FilteredImageSource(image.getSource(), filter);
        return Toolkit.getDefaultToolkit().createImage(ip);
    }

    private Image TransformColorToTransparency(BufferedImage image, Color c1, Color c2) { /*
         // Primitive test, just an example
         final int r1 = c1.getRed();
         final int g1 = c1.getGreen();
         final int b1 = c1.getBlue();
         final int r2 = c2.getRed();
         final int g2 = c2.getGreen();
         final int b2 = c2.getBlue();
         ImageFilter filter = new RGBImageFilter()
         {
         public final int filterRGB(int x, int y, int rgb)
         {
         int r = (rgb & 0xFF0000) >> 16;
         int g = (rgb & 0xFF00) >> 8;
         int b = rgb & 0xFF;
         if (r >= r1 && r <= r2 &&
         g >= g1 && g <= g2 &&
         b >= b1 && b <= b2)
         {
         // Set fully transparent but keep color
         return rgb & 0xFFFFFF;
         }
         return rgb;
         }
         };

         ImageProducer ip = new FilteredImageSource(image.getSource(), filter);
         return Toolkit.getDefaultToolkit().createImage(ip);
         */

        ImageFilter filter = new RGBImageFilter() {

            // the color we are looking for... Alpha bits are set to opaque
            public int markerRGB = c1.getRGB() | 0xFF000000;

            public final int filterRGB(int x, int y, int rgb) {
                if ((rgb | 0xFF000000) == markerRGB) {
                    // Mark the alpha bits as zero - transparent
                    return 0x00FFFFFF & rgb;
                } else {
                    // nothing to do
                    return rgb;
                }
            }
        };

        ImageProducer ip = new FilteredImageSource(image.getSource(), filter);
        return Toolkit.getDefaultToolkit().createImage(ip);
    }

    private BufferedImage ImageToBufferedImage(Image image, int width, int height) {
        BufferedImage dest = new BufferedImage(
                width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = dest.createGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
        return dest;
    }

    public static void main(String[] args) throws IOException {
        ImageTransparency at = new ImageTransparency();
    }
}
