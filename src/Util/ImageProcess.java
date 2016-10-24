package Util;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImageProcess {

    private BufferedImage imagenActual;
    public BufferedImage getImageFromChooser(String startDefault) {
        BufferedImage imagen = null;
        JFileChooser selector = new JFileChooser(startDefault);
        selector.setDialogTitle("Seleccione una imagen");
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter(
                "JPG & GIF & BMP & PNG ", "jpg", "gif", "bmp", "png");
        selector.setFileFilter(filtroImagen);
        int flag = selector.showOpenDialog(null);
        if (flag == JFileChooser.APPROVE_OPTION) {
            try {
                File imagenSeleccionada = selector.getSelectedFile();
                imagen = ImageIO.read(imagenSeleccionada);
            } catch (Exception e) {

            }
        }
        imagenActual = imagen;
        return imagen;
    }

    public BufferedImage getImageFromPath(String path) {
        BufferedImage imagen = null;
        try {
            File imagenSeleccionada = new File(path);
            imagen = ImageIO.read(imagenSeleccionada);
            System.out.println("Imagen : "+path);
        } catch (Exception e) {
            System.out.println("e" + e);
        }
        return imagen;
    }

    public double[][] getImageAsPixels(BufferedImage image) {
       
        BufferedImage imageScaled = null;
        imageScaled = ImageScale.scale(image,2,3);
        int width = imageScaled.getWidth();
        int height = imageScaled.getHeight();
        System.out.println("dim:"+width + " "+height);
        double dataInput[][] = new double[height][width];

        //Recorremos la imagen píxel a píxel
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                dataInput[i][j] = imageScaled.getRGB(j, i)>=0 ? -1:1;
            }
        }
        imageAsDataInput(dataInput);
        return dataInput;
    }
    public BufferedImage scale(BufferedImage image,int width,int heigth){
        return ImageScale.scale(image, width, heigth);
    }
    public BufferedImage toTransparent(BufferedImage image) throws IOException{
        return new ImageTransparency().toTransparency(image);
    }
    public void imageAsDataInput(double dataInput[][]) {
        for (int i = 0; i < dataInput.length; i++) {
            for (int j = 0; j < dataInput[i].length; j++) {
                System.out.print(" " + dataInput[i][j]);
            }
            System.out.println("");
        }
    }

}
