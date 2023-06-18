package overlay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

        if (btnName.equals(Constants.ITEM_SPATULA)) {
            mouseEnteredPanel(Constants.RUTA_PROPIA_SPATULA, 500, 755, Color.BLACK);
        }
        if (btnName.equals(Constants.KEYBINDINGS)) {
            mouseEnteredPanel(Constants.RUTA_PROPIA_KEYBINDINGS, 550, 340, new Color(6, 14, 33));
        }
        if (btnName.equals(Constants.SET_SPECIFIC)) {
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_SPECIFIC, 1450, 825, new Color(6, 14, 33));
        }
        if (btnName.equals(Constants.CHAMPION_POOL)) {
            mouseEnteredPanel(Constants.RUTA_PROPIA_CHAMPION_POOL, 750, 600, new Color(34, 35, 37));
        }
        if (btnName.equals(Constants.GOLDEN_EGG)) {
            mouseEnteredPanel(Constants.RUTA_PROPIA_GOLDEN_EGG, 600, 450, new Color(34, 35, 37));
        }
        if (btnName.equals(Constants.TOME_TRAITS)) {
            mouseEnteredPanel(Constants.RUTA_PROPIA_TOME_TRAITS, 1000, 200, new Color(34, 35, 37));
        }
        // Especifico SET
        if (btnName.equals(Constants.SET_UNO)) {
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_UNO, 740, 410, new Color(34, 35, 37));
        }
        if (btnName.equals(Constants.SET_DOS)) {
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_DOS, 980, 420, new Color(34, 35, 37));
        }
        if (btnName.equals(Constants.SET_TRES)) {
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_TRES, 1430, 800, new Color(34, 35, 37));
        }
        if (btnName.equals(Constants.SET_CUATRO)) {
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_CUATRO, 1380, 800, new Color(34, 35, 37));
        }
        if (btnName.equals(Constants.SET_CINCO)) {
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_CINCO, 760, 430, new Color(34, 35, 37));
        }
        if (btnName.equals(Constants.SET_SEIS)) {
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_SEIS, 730, 410, new Color(34, 35, 37));
        }
        if (btnName.equals(Constants.SET_SIETE)) {
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_SIETE, 1220, 810, new Color(34, 35, 37));
        }
        if (btnName.equals(Constants.SET_OCHO)) {
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_OCHO, 1570, 830, new Color(34, 35, 37));
        }
        if (btnName.equals(Constants.SET_NUEVE)) {
            mouseEnteredPanel(Constants.RUTA_PROPIA_SET_NUEVE, 740, 410, new Color(34, 35, 37));
        }
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
