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
    public void mouseEntered(MouseEvent e) {
        // limpiamos los componentes del jframe de informacion adicional
        borrarComponentesDeJframe();

        if (btnName.equals(Constants.ITEM_BF)) {
            mouseEnteredPanel(Constants.RUTA_PROPIA_BF, 700, 440, Color.BLACK);
        }
        if (btnName.equals(Constants.ITEM_BOW)) {
            mouseEnteredPanel(Constants.RUTA_PROPIA_BOW, 630, 440, Color.BLACK);
        }
        if (btnName.equals(Constants.ITEM_ROD)) {
            mouseEnteredPanel(Constants.RUTA_PROPIA_ROD, 810, 440, Color.BLACK);
        }
        if (btnName.equals(Constants.ITEM_TEAR)) {
            mouseEnteredPanel(Constants.RUTA_PROPIA_TEAR, 635, 440, Color.BLACK);
        }
        if (btnName.equals(Constants.ITEM_VEST)) {
            mouseEnteredPanel(Constants.RUTA_PROPIA_VEST, 690, 440, Color.BLACK);
        }
        if (btnName.equals(Constants.ITEM_CLOAK)) {
            mouseEnteredPanel(Constants.RUTA_PROPIA_CLOAK, 660, 440, Color.BLACK);
        }
        if (btnName.equals(Constants.ITEM_BELT)) {
            mouseEnteredPanel(Constants.RUTA_PROPIA_BELT, 790, 440, Color.BLACK);
        }
        if (btnName.equals(Constants.ITEM_SPATULA)) {
            mouseEnteredPanel(Constants.RUTA_PROPIA_SPATULA, 655, 440, Color.BLACK);
        }
        if (btnName.equals(Constants.TIERS)) {
            mouseEnteredPanel(Constants.RUTA_PROPIA_TIERS, 525, 340, Color.BLACK);
        }
        if (btnName.equals(Constants.KEYBINDINGS)) {
            mouseEnteredPanel(Constants.RUTA_PROPIA_KEYBINDINGS, 550, 340, new Color(6, 14, 33));
        }
        if (btnName.equals(Constants.HYPED_TIER_LIST)) {
            mouseEnteredPanel(Constants.RUTA_PROPIA_HYPED_TIER_LIST, 945, 600, new Color(181,182,182));
        }
        if (btnName.equals(Constants.ORIGINS_1)) {
            mouseEnteredPanel(Constants.RUTA_PROPIA_ORIGINS_1, 800, 930, new Color(6, 14, 33));
        }
        if (btnName.equals(Constants.META)) {
            mouseEnteredPanel(Constants.RUTA_PROPIA_META, 1150, 700, new Color(34, 35, 37));
        }
        if (btnName.equals(Constants.META_2)) {
            mouseEnteredPanel(Constants.RUTA_PROPIA_META_2, 820, 530, new Color(18, 30, 55));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (btnName.equals(Constants.ITEM_BF)) {
            // limpiamos los componentes del jframe de informacion adicional
            borrarComponentesDeJframe();
        }
        if (btnName.equals(Constants.ITEM_BOW)) {
            // limpiamos los componentes del jframe de informacion adicional
            borrarComponentesDeJframe();
        }
        if (btnName.equals(Constants.ITEM_ROD)) {
            // limpiamos los componentes del jframe de informacion adicional
            borrarComponentesDeJframe();
        }
        if (btnName.equals(Constants.ITEM_TEAR)) {
            // limpiamos los componentes del jframe de informacion adicional
            borrarComponentesDeJframe();
        }
        if (btnName.equals(Constants.ITEM_VEST)) {
            // limpiamos los componentes del jframe de informacion adicional
            borrarComponentesDeJframe();
        }
        if (btnName.equals(Constants.ITEM_CLOAK)) {
            // limpiamos los componentes del jframe de informacion adicional
            borrarComponentesDeJframe();
        }
        if (btnName.equals(Constants.ITEM_BELT)) {
            // limpiamos los componentes del jframe de informacion adicional
            borrarComponentesDeJframe();
        }
        if (btnName.equals(Constants.ITEM_SPATULA)) {
            // limpiamos los componentes del jframe de informacion adicional
            borrarComponentesDeJframe();
        }
        if (btnName.equals(Constants.TIERS)) {
            // limpiamos los componentes del jframe de informacion adicional
            borrarComponentesDeJframe();
        }
        if (btnName.equals(Constants.KEYBINDINGS)) {
            // limpiamos los componentes del jframe de informacion adicional
            borrarComponentesDeJframe();
        }
        if (btnName.equals(Constants.HYPED_TIER_LIST)) {
            // limpiamos los componentes del jframe de informacion adicional
            borrarComponentesDeJframe();
        }
        if (btnName.equals(Constants.ORIGINS_1)) {
            // limpiamos los componentes del jframe de informacion adicional
            borrarComponentesDeJframe();
        }
        if (btnName.equals(Constants.META)) {
            // limpiamos los componentes del jframe de informacion adicional
            borrarComponentesDeJframe();
        }
        if (btnName.equals(Constants.META_2)) {
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