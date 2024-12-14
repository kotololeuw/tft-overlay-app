package overlay;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class HoverButtonMouseListener extends MouseAdapter {

    private JFrame jframeButtons;
    private String btnName;
    private JFrame jframeAdditionalInfo;

    public HoverButtonMouseListener(JFrame jframeButtons, String btnName, JFrame jframeAdditionalInfo) {
        this.jframeButtons = jframeButtons;
        this.btnName = btnName;
        this.jframeAdditionalInfo = jframeAdditionalInfo;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // limpiamos los componentes del jframe de informacion adicional
        borrarComponentesDeJframe();
        if (btnName.equals(Constants.EXIT)) {
            System.exit(0);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // limpiamos los componentes del jframe de informacion adicional
        borrarComponentesDeJframe();
        Color defaultColor = new Color(34, 35, 37);
        if (btnName.equals(Constants.ITEM_SPATULA)) {
            BufferedImage imageSpatula = getImageFromProject(Constants.RUTA_PROPIA_SPATULA);
            mouseEnteredPanel(Constants.RUTA_PROPIA_SPATULA, defaultColor, imageSpatula);
        }
        if (btnName.equals(Constants.CHAMPION_POOL)) {
            BufferedImage imageChampionPool = getImageFromProject(Constants.RUTA_PROPIA_CHAMPION_POOL);
            mouseEnteredPanel(Constants.RUTA_PROPIA_CHAMPION_POOL, defaultColor, imageChampionPool);
        }
        if (btnName.equals(Constants.ITEM_FRYING_PAN)) {
            BufferedImage imageFryingPan = getImageFromProject(Constants.RUTA_PROPIA_FRYING_PAN);
            mouseEnteredPanel(Constants.RUTA_PROPIA_FRYING_PAN, defaultColor, imageFryingPan);
        }
        // Especifico SET
        if (btnName.equals(Constants.SET_UNO)) {
            BufferedImage imageSetUno = getImageFromProject(Constants.RUTA_PROPIA_SET_UNO);
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_UNO, defaultColor, imageSetUno);
        }
        if (btnName.equals(Constants.SET_DOS)) {
            BufferedImage imageSetDos = getImageFromProject(Constants.RUTA_PROPIA_SET_DOS);
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_DOS, defaultColor, imageSetDos);
        }
        if (btnName.equals(Constants.SET_TRES)) {
            BufferedImage imageSetTres = getImageFromProject(Constants.RUTA_PROPIA_SET_TRES);
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_TRES, defaultColor, imageSetTres);
        }
        if (btnName.equals(Constants.SET_CUATRO)) {
            BufferedImage imageSetCuatro = getImageFromProject(Constants.RUTA_PROPIA_SET_CUATRO);
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_CUATRO, defaultColor, imageSetCuatro);
        }
        if (btnName.equals(Constants.SET_CINCO)) {
            BufferedImage imageSetCinco = getImageFromProject(Constants.RUTA_PROPIA_SET_CINCO);
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_CINCO, defaultColor, imageSetCinco);
        }
        if (btnName.equals(Constants.SET_SEIS)) {
            BufferedImage imageSetSeis = getImageFromProject(Constants.RUTA_PROPIA_SET_SEIS);
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_SEIS, defaultColor, imageSetSeis);
        }
        if (btnName.equals(Constants.SET_SIETE)) {
            BufferedImage imageSetSiete = getImageFromProject(Constants.RUTA_PROPIA_SET_SIETE);
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_SIETE, defaultColor, imageSetSiete);
        }
        if (btnName.equals(Constants.SET_OCHO)) {
            BufferedImage imageSetOcho = getImageFromProject(Constants.RUTA_PROPIA_SET_OCHO);
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_OCHO, defaultColor, imageSetOcho);
        }
        if (btnName.equals(Constants.SET_NUEVE)) {
            BufferedImage imageSetNueve = getImageFromProject(Constants.RUTA_PROPIA_SET_NUEVE);
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_NUEVE, defaultColor, imageSetNueve);
        }
        if (btnName.equals(Constants.SET_DIEZ)) {
            BufferedImage imageSetDiez = getImageFromProject(Constants.RUTA_PROPIA_SET_DIEZ);
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_DIEZ, defaultColor, imageSetDiez);
        }
        if (btnName.equals(Constants.SET_ONCE)) {
            BufferedImage imageSetOnce = getImageFromProject(Constants.RUTA_PROPIA_SET_ONCE);
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_ONCE, defaultColor, imageSetOnce);
        }
        if (btnName.equals(Constants.SET_DOCE)) {
            BufferedImage imageSetDoce = getImageFromProject(Constants.RUTA_PROPIA_SET_DOCE);
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_DOCE, defaultColor, imageSetDoce);
        }
    }

    public static BufferedImage getImageFromProject(String path) {
        BufferedImage img = null;
        try {
            // Ruta imagenes
            Application application = new Application();
            String folderImagesPath = application.getAppDataDirLocalImages();
            String fullPath = folderImagesPath + path;
            File ficheroFull = new File(fullPath);
            img = ImageIO.read(ficheroFull);
            if (img != null && img.getWidth() > 1900) {
                System.out.println("imagen superior a 1900 de width width= " + img.getWidth() + ", path= " + path
                        + " || Establecer como maximo 1856 ancho x 850 de alto");
            }
        } catch (Throwable e) {
            System.out.println("no se ha encontrado la imagen en " + path);
        }
        return img;
    }

    public BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
        return outputImage;
    }

    @Override
    public void mouseExited(MouseEvent e) {

        if (btnName.equals(Constants.ITEM_SPATULA)) {
            // limpiamos los componentes del jframe de informacion adicional
            borrarComponentesDeJframe();
        }
        if (btnName.equals(Constants.KEYBINDINGS)) {
            // limpiamos los componentes del jframe de informacion adicional
            borrarComponentesDeJframe();
        }
        if (btnName.equals(Constants.SET_SPECIFIC)) {
            // limpiamos los componentes del jframe de informacion adicional
            borrarComponentesDeJframe();
        }
        if (btnName.equals(Constants.CHAMPION_POOL)) {
            // limpiamos los componentes del jframe de informacion adicional
            borrarComponentesDeJframe();
        }
        if (btnName.equals(Constants.ITEM_FRYING_PAN)) {
            // limpiamos los componentes del jframe de informacion adicional
            borrarComponentesDeJframe();
        }
        // Especifico SET
        if (btnName.equals(Constants.SET_UNO)) {
            // limpiamos los componentes del jframe de informacion adicional
            borrarComponentesDeJframe();
        }
        if (btnName.equals(Constants.SET_DOS)) {
            // limpiamos los componentes del jframe de informacion adicional
            borrarComponentesDeJframe();
        }
        if (btnName.equals(Constants.SET_TRES)) {
            // limpiamos los componentes del jframe de informacion adicional
            borrarComponentesDeJframe();
        }
        if (btnName.equals(Constants.SET_CUATRO)) {
            // limpiamos los componentes del jframe de informacion adicional
            borrarComponentesDeJframe();
        }
        if (btnName.equals(Constants.SET_CINCO)) {
            // limpiamos los componentes del jframe de informacion adicional
            borrarComponentesDeJframe();
        }
        if (btnName.equals(Constants.SET_SEIS)) {
            // limpiamos los componentes del jframe de informacion adicional
            borrarComponentesDeJframe();
        }
        if (btnName.equals(Constants.SET_SIETE)) {
            // limpiamos los componentes del jframe de informacion adicional
            borrarComponentesDeJframe();
        }
        if (btnName.equals(Constants.SET_OCHO)) {
            // limpiamos los componentes del jframe de informacion adicional
            borrarComponentesDeJframe();
        }
        if (btnName.equals(Constants.SET_NUEVE)) {
            // limpiamos los componentes del jframe de informacion adicional
            borrarComponentesDeJframe();
        }
        if (btnName.equals(Constants.SET_DIEZ)) {
            // limpiamos los componentes del jframe de informacion adicional
            borrarComponentesDeJframe();
        }
        if (btnName.equals(Constants.SET_ONCE)) {
            // limpiamos los componentes del jframe de informacion adicional
            borrarComponentesDeJframe();
        }
        if (btnName.equals(Constants.SET_DOCE)) {
            // limpiamos los componentes del jframe de informacion adicional
            borrarComponentesDeJframe();
        }
        jframeAdditionalInfo.setVisible(false);
    }

    /**
     * Metodo para borrar todos los componentes de un Jframe
     */
    private void borrarComponentesDeJframe() {
        if (jframeAdditionalInfo.getRootPane().getContentPane().getComponentCount() > 0) {
            int size = jframeAdditionalInfo.getRootPane().getContentPane().getComponentCount();
            for (int i = 0; i < size; i++) {
                // Al hacer el remove, el siguiente objeto pasa a la posicion anterior, con lo cual al borrar siempre la posicion cero se borraran todos
                jframeAdditionalInfo.getRootPane().getContentPane().remove(0);
            }
        }
    }

    /**
     * Metodo para rellenar el panel al hacer hover en un boton
     * @param panelImageSrc ruta de la imagen a mostrar
     * @param backgroundColor color de fondo
     */
    private void mouseEnteredPanel(String panelImageSrc, Color backgroundColor,
                                   BufferedImage bufferedImage) {
        int panelWidth = bufferedImage.getWidth();
        int panelHeight = bufferedImage.getHeight();

        // Ponemos a visible el jframe de informacion adicional
        jframeAdditionalInfo.setVisible(true);

       Application application = new Application();
       String folderImagesPath = application.getAppDataDirLocalImages();
       String fullPath = folderImagesPath + panelImageSrc;
        File ficheroFull = new File(fullPath);
        String imageInHtml = "";
        if(!ficheroFull.exists()) {
            System.out.println("Se ha producido un error, no existe el fichero en la ruta " + fullPath);
        } else {
            try {
                imageInHtml = "<html>"
                        + "<div>&nbsp;&nbsp;<img src =\"" + ficheroFull.toURI().toURL()
                        + "\" />"
                        + "</html>";
            } catch (Throwable e) {
                System.out.println("error crendo la imagen: " + e.getMessage());
            }
        }
        JLabel jlabel = new JLabel(imageInHtml);

        // Hacemos que empiece arriba del jframe
        jlabel.setVerticalAlignment(SwingConstants.TOP);

        // color de fondo, por defecto opaque es false con lo cual sino es true no se pinta el color de fondo
        jlabel.setOpaque(true);
        jlabel.setBackground(backgroundColor);

        // Añadimos el jlabel al panel
        jframeAdditionalInfo.getRootPane().getContentPane().add(jlabel);

        // Ajustamos el tamaño del jframe
        jframeAdditionalInfo.setSize(new Dimension(panelWidth, panelHeight));

        // actualizamos el jframe
        jframeAdditionalInfo.getRootPane().getContentPane().revalidate();
        jframeAdditionalInfo.getRootPane().getContentPane().repaint();
    }

}
