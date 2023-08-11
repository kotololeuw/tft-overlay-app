package overlay;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

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
            mouseEnteredPanel(Constants.RUTA_PROPIA_SPATULA, imageSpatula.getWidth(), imageSpatula.getHeight(), defaultColor);
        }
        if (btnName.equals(Constants.KEYBINDINGS)) {
            BufferedImage imageKeybindings = getImageFromProject(Constants.RUTA_PROPIA_KEYBINDINGS);
            mouseEnteredPanel(Constants.RUTA_PROPIA_KEYBINDINGS, imageKeybindings.getWidth(), imageKeybindings.getHeight(), defaultColor);
        }
        if (btnName.equals(Constants.SET_SPECIFIC)) {
            BufferedImage imageSetSpecific = getImageFromProject(Constants.RUTA_PROPIA_SET_SPECIFIC);
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_SPECIFIC, imageSetSpecific.getWidth(), imageSetSpecific.getHeight(), defaultColor);
        }
        if (btnName.equals(Constants.CHAMPION_POOL)) {
            BufferedImage imageChampionPool = getImageFromProject(Constants.RUTA_PROPIA_CHAMPION_POOL);
            mouseEnteredPanel(Constants.RUTA_PROPIA_CHAMPION_POOL, imageChampionPool.getWidth(), imageChampionPool.getHeight(), defaultColor);
        }
        if (btnName.equals(Constants.GOLDEN_EGG)) {
            BufferedImage imageGoldenEgg = getImageFromProject(Constants.RUTA_PROPIA_GOLDEN_EGG);
            mouseEnteredPanel(Constants.RUTA_PROPIA_GOLDEN_EGG, imageGoldenEgg.getWidth(), imageGoldenEgg.getHeight(), defaultColor);
        }
        if (btnName.equals(Constants.TOME_TRAITS)) {
            BufferedImage imageTomeTraits = getImageFromProject(Constants.RUTA_PROPIA_TOME_TRAITS);
            mouseEnteredPanel(Constants.RUTA_PROPIA_TOME_TRAITS, imageTomeTraits.getWidth(), imageTomeTraits.getHeight(), defaultColor);
        }
        // Especifico SET
        if (btnName.equals(Constants.SET_UNO)) {
            BufferedImage imageSetUno = getImageFromProject(Constants.RUTA_PROPIA_SET_UNO);
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_UNO, imageSetUno.getWidth(), imageSetUno.getHeight(), defaultColor);
        }
        if (btnName.equals(Constants.SET_DOS)) {
            BufferedImage imageSetDos = getImageFromProject(Constants.RUTA_PROPIA_SET_DOS);
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_DOS, imageSetDos.getWidth(), imageSetDos.getHeight(), defaultColor);
        }
        if (btnName.equals(Constants.SET_TRES)) {
            BufferedImage imageSetTres = getImageFromProject(Constants.RUTA_PROPIA_SET_TRES);
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_TRES, imageSetTres.getWidth(), imageSetTres.getHeight(), defaultColor);
        }
        if (btnName.equals(Constants.SET_CUATRO)) {
            BufferedImage imageSetCuatro = getImageFromProject(Constants.RUTA_PROPIA_SET_CUATRO);
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_CUATRO, imageSetCuatro.getWidth(), imageSetCuatro.getHeight(), defaultColor);
        }
        if (btnName.equals(Constants.SET_CINCO)) {
            BufferedImage imageSetCinco = getImageFromProject(Constants.RUTA_PROPIA_SET_CINCO);
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_CINCO, imageSetCinco.getWidth(), imageSetCinco.getHeight(), defaultColor);
        }
        if (btnName.equals(Constants.SET_SEIS)) {
            BufferedImage imageSetSeis = getImageFromProject(Constants.RUTA_PROPIA_SET_SEIS);
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_SEIS, imageSetSeis.getWidth(), imageSetSeis.getHeight(), defaultColor);
        }
        if (btnName.equals(Constants.SET_SIETE)) {
            BufferedImage imageSetSiete = getImageFromProject(Constants.RUTA_PROPIA_SET_SIETE);
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_SIETE, imageSetSiete.getWidth(), imageSetSiete.getHeight(), defaultColor);
        }
        if (btnName.equals(Constants.SET_OCHO)) {
            BufferedImage imageSetOcho = getImageFromProject(Constants.RUTA_PROPIA_SET_OCHO);
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_OCHO, imageSetOcho.getWidth(), imageSetOcho.getHeight(), defaultColor);
        }
        if (btnName.equals(Constants.SET_NUEVE)) {
            BufferedImage imageSetNueve = getImageFromProject(Constants.RUTA_PROPIA_SET_NUEVE);
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_NUEVE, imageSetNueve.getWidth(), imageSetNueve.getHeight(), defaultColor);
        }
        if (btnName.equals(Constants.SET_DIEZ)) {
            BufferedImage imageSetNueve = getImageFromProject(Constants.RUTA_PROPIA_SET_DIEZ);
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_DIEZ, imageSetNueve.getWidth(), imageSetNueve.getHeight(), defaultColor);
        }
        if (btnName.equals(Constants.SET_ONCE)) {
            BufferedImage imageSetNueve = getImageFromProject(Constants.RUTA_PROPIA_SET_ONCE);
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_ONCE, imageSetNueve.getWidth(), imageSetNueve.getHeight(), defaultColor);
        }
        if (btnName.equals(Constants.SET_DOCE)) {
            BufferedImage imageSetNueve = getImageFromProject(Constants.RUTA_PROPIA_SET_DOCE);
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_DOCE, imageSetNueve.getWidth(), imageSetNueve.getHeight(), defaultColor);
        }
        if (btnName.equals(Constants.SET_TRECE)) {
            BufferedImage imageSetNueve = getImageFromProject(Constants.RUTA_PROPIA_SET_TRECE);
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_TRECE, imageSetNueve.getWidth(), imageSetNueve.getHeight(), defaultColor);
        }
    }

    private BufferedImage getImageFromProject(String path) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(Application.class.getResource(path));
        } catch (Throwable e) {
            System.out.println("no se ha encontrado la imagen en " + path);
        }
        return img;
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
        if (btnName.equals(Constants.GOLDEN_EGG)) {
            // limpiamos los componentes del jframe de informacion adicional
            borrarComponentesDeJframe();
        }
        if (btnName.equals(Constants.TOME_TRAITS)) {
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
     * @param panelWidth anchura
     * @param panelHeight altura
     * @param backgroundColor color de fondo
     */
    private void mouseEnteredPanel(String panelImageSrc, int panelWidth, int panelHeight, Color backgroundColor) {
        // Ponemos a visible el jframe de informacion adicional
        jframeAdditionalInfo.setVisible(true);

        String imageInHtml = "<html>"
                + "<div>&nbsp;&nbsp;<img src ='"
                + Application.class.getResource(panelImageSrc)
                + "'/>"
                + "</html>";
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
