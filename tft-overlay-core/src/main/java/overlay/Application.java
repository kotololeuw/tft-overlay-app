package overlay;

import javax.swing.*;
import java.awt.*;

public class Application extends JPanel {

    /**
     * Metodo que define el color del background
     *
     * @param g graphycs
     */
    public void paintComponent(Graphics g) {
        g.setColor(Color.PINK);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    public static void main(String[] args) {
        try {
            System.out.println("*************************************************");
            System.out.println("*** APPLICATION INIT ***");

            // Instanciamos el jframe
            JFrame jframeButtons = createStandardJframe();

            // Instanciamos el jframe de informacion adicional
            JFrame jframeAdditionalInfo = createAdditionalInfoJframe(jframeButtons);

            // Evento de raton de arrastrar por la pantalla
            addDragEventToJframe(jframeButtons, jframeAdditionalInfo);

            // Añadimos los botones de la barra principal
            createButtonMainBar(Constants.RUTA_SET_UNO_ICON, jframeButtons, Constants.DEFAULT_BUTTON_WIDTH, Constants.DEFAULT_BUTTON_HEIGHT, Constants.SET_UNO, jframeAdditionalInfo);
            createButtonMainBar(Constants.RUTA_SET_DOS_ICON, jframeButtons, Constants.DEFAULT_BUTTON_WIDTH, Constants.DEFAULT_BUTTON_HEIGHT, Constants.SET_DOS, jframeAdditionalInfo);
            createButtonMainBar(Constants.RUTA_SET_TRES_ICON, jframeButtons, Constants.DEFAULT_BUTTON_WIDTH, Constants.DEFAULT_BUTTON_HEIGHT, Constants.SET_TRES, jframeAdditionalInfo);
            createButtonMainBar(Constants.RUTA_SET_CUATRO_ICON, jframeButtons, Constants.DEFAULT_BUTTON_WIDTH, Constants.DEFAULT_BUTTON_HEIGHT, Constants.SET_CUATRO, jframeAdditionalInfo);
            createButtonMainBar(Constants.RUTA_SET_CINCO_ICON, jframeButtons, Constants.DEFAULT_BUTTON_WIDTH, Constants.DEFAULT_BUTTON_HEIGHT, Constants.SET_CINCO, jframeAdditionalInfo);
            createButtonMainBar(Constants.RUTA_SET_SEIS_ICON, jframeButtons, Constants.DEFAULT_BUTTON_WIDTH, Constants.DEFAULT_BUTTON_HEIGHT, Constants.SET_SEIS, jframeAdditionalInfo);
            createButtonMainBar(Constants.RUTA_SET_SIETE_ICON, jframeButtons, Constants.DEFAULT_BUTTON_WIDTH, Constants.DEFAULT_BUTTON_HEIGHT, Constants.SET_SIETE, jframeAdditionalInfo);
            createButtonMainBar(Constants.RUTA_SET_OCHO_ICON, jframeButtons, Constants.DEFAULT_BUTTON_WIDTH, Constants.DEFAULT_BUTTON_HEIGHT, Constants.SET_OCHO, jframeAdditionalInfo);
            createButtonMainBar(Constants.RUTA_SET_NUEVE_ICON, jframeButtons, Constants.DEFAULT_BUTTON_WIDTH, Constants.DEFAULT_BUTTON_HEIGHT, Constants.SET_NUEVE, jframeAdditionalInfo);
            createButtonMainBar(Constants.RUTA_SET_DIEZ_ICON, jframeButtons, Constants.DEFAULT_BUTTON_WIDTH, Constants.DEFAULT_BUTTON_HEIGHT, Constants.SET_DIEZ, jframeAdditionalInfo);
            createButtonMainBar(Constants.RUTA_SET_ONCE_ICON, jframeButtons, Constants.DEFAULT_BUTTON_WIDTH, Constants.DEFAULT_BUTTON_HEIGHT, Constants.SET_ONCE, jframeAdditionalInfo);
            createButtonMainBar(Constants.RUTA_SET_DOCE_ICON, jframeButtons, Constants.DEFAULT_BUTTON_WIDTH, Constants.DEFAULT_BUTTON_HEIGHT, Constants.SET_DOCE, jframeAdditionalInfo);
            createButtonMainBar(Constants.RUTA_SET_TRECE_ICON, jframeButtons, Constants.DEFAULT_BUTTON_WIDTH, Constants.DEFAULT_BUTTON_HEIGHT, Constants.SET_TRECE, jframeAdditionalInfo);

            // Añadimos los botones de los iconos standard
            createButtonMainBar(Constants.RUTA_ITEM_SPATULA_ICON, jframeButtons, Constants.DEFAULT_BUTTON_WIDTH, Constants.DEFAULT_BUTTON_HEIGHT, Constants.ITEM_SPATULA, jframeAdditionalInfo);
            // createButtonMainBar(Constants.RUTA_TOME_TRAITS_ICON, jframeButtons, Constants.DEFAULT_BUTTON_WIDTH, Constants.DEFAULT_BUTTON_HEIGHT, Constants.TOME_TRAITS, jframeAdditionalInfo);
            // createButtonMainBar(Constants.RUTA_GOLDEN_EGG_ICON, jframeButtons, Constants.DEFAULT_BUTTON_WIDTH, Constants.DEFAULT_BUTTON_HEIGHT, Constants.GOLDEN_EGG, jframeAdditionalInfo);
            // createButtonMainBar(Constants.RUTA_SET_SPECIFIC_ICON, jframeButtons, Constants.DEFAULT_BUTTON_WIDTH, Constants.DEFAULT_BUTTON_HEIGHT, Constants.SET_SPECIFIC, jframeAdditionalInfo);
            createButtonMainBar(Constants.RUTA_CHAMPION_POOL_ICON, jframeButtons, Constants.DEFAULT_BUTTON_WIDTH, Constants.DEFAULT_BUTTON_HEIGHT, Constants.CHAMPION_POOL, jframeAdditionalInfo);
            // createButtonMainBar(Constants.RUTA_KEYBINDINGS_ICON, jframeButtons, Constants.DEFAULT_BUTTON_WIDTH, Constants.DEFAULT_BUTTON_HEIGHT, Constants.KEYBINDINGS, jframeAdditionalInfo);
            createButtonMainBar(Constants.RUTA_EXIT_ICON, jframeButtons, Constants.DEFAULT_BUTTON_WIDTH, Constants.DEFAULT_BUTTON_HEIGHT, Constants.EXIT, jframeAdditionalInfo);

            // Pack jframe
            jframeButtons.pack();
            jframeAdditionalInfo.pack();
            System.out.println("*** APPLICATION SUCCESSFULLY LOADED ***");
            System.out.println("*************************************************");
        } catch (Throwable e) {
            System.out.println("Error inicializando: ");
            e.printStackTrace();
        }
    }

    /**
     * Metodo para crear el jframe para mostrar informacion adicional
     * @param jframeButtons jframe
     * @return JFrame
     */
    private static JFrame createAdditionalInfoJframe(JFrame jframeButtons) {
        JFrame jframeAdditionalInfo = createStandardJframe();
        // Añadimos el jpanel que mostrara la informacion adicional
        JPanel jpanelInformacionExtra = new JPanel();
        // Color del panel
        jpanelInformacionExtra.setBackground(Color.BLACK);
        // Definimos el Size
        jframeAdditionalInfo.setPreferredSize(new Dimension(Constants.DEFAULT_JPANEL_INFORMATION_ANCHURA, Constants.DEFAULT_JPANEL_INFORMATION_ALTURA));
        // Localizacion
        jframeAdditionalInfo.setLocation((int) jframeButtons.getLocation().getX(), (int) jframeButtons.getLocation().getY() + Constants.DEFAULT_BUTTON_HEIGHT + 2);
        // Nombre
        jpanelInformacionExtra.setName(Constants.JFRAME_ADDITIONAL_INFO);
        // Lo añadimos al nuevo jframe
        jframeAdditionalInfo.add(jpanelInformacionExtra);
        // Saldra oculto
        jframeAdditionalInfo.setVisible(false);
        return jframeAdditionalInfo;
    }

    /**
     * Metodo para obtener la referencia en el jframe de un componente, sabiendo la posicion lo podemos editar facilmente
     *
     * @param name nombre
     * @param jframe jframe
     * @return posicion
     */
    private static Integer getComponentReferenceByName(String name, JFrame jframe) throws Exception {
        Integer result = 0;
        Component[] components = jframe.getContentPane().getComponents();
        for (Component component : components) {
            if (null != component.getName() && component.getName().equals(name)) {
                return result;
            } else {
                result++;
            }
        }
        throw new Exception("Error recuperando el componente con nombre: " + name);
    }

    /**
     * Metodo para añadir botones al jframe principal
     *
     * @param imgSrc    ruta
     * @param jframeButtons  jframe
     * @param btnWidth  anchura boton
     * @param btnHeight altura boton
     * @param jframeAdditionalInfo    jframe
     */
    private static void createButtonMainBar(String imgSrc, JFrame jframeButtons, int btnWidth, int btnHeight, String name, JFrame jframeAdditionalInfo) {
        ImageIcon icon = null;
        try {
            icon = new ImageIcon(Application.class.getResource(imgSrc));
            JButton jbutton = new JButton();
            jbutton.setPreferredSize(new Dimension(btnWidth, btnHeight));
            icon = resizeIcon(icon, btnWidth, btnHeight);
            jbutton.setIcon(icon);

            // Nombre en caso de que necesitemos recuperarlo posteriormente
            jbutton.setName(name);

            // Añadimos espacio en el jframe para meter el boton
            Dimension dimension = jframeButtons.getPreferredSize();
            dimension.setSize(dimension.getWidth() + btnWidth, dimension.getHeight());
            jframeButtons.setPreferredSize(dimension);

            // Añadimos la funcion HOVER
            jbutton.addMouseListener(new HoverButtonMouseListener(jframeButtons, name, jframeAdditionalInfo));

            // Lo añadimos al frame principal
            jframeButtons.getRootPane().getContentPane().add(jbutton);
        } catch (Throwable e) {
            System.out.println("icon not found " + imgSrc);
        }
    }

    /**
     * Metodo para crear un JFRAME y asociarle caracteristicas standard
     */
    private static JFrame createStandardJframe() {
        JFrame jframe = new JFrame(Constants.JFRAME_BUTTONS_NAME);
        // Size
        jframe.setPreferredSize(new Dimension(50, 50));
        // Default
        jframe.setUndecorated(true);
        // Layout [Grid, Flow..]
        jframe.setLayout(new GridLayout());
        // Siempre ON TOP ?
        jframe.setAlwaysOnTop(true);
        // visible / no visible
        jframe.setVisible(true);
        // aparecera centrado
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        jframe.setLocation(dimension.width / 2 - jframe.getSize().width / 2, dimension.height / 2 - jframe.getSize().height / 2);
        // hacemos que aparte de centrado, aparezca arriba y  a la izquierda
        int resizeDimension = (int)jframe.getLocation().getX();
        resizeDimension = resizeDimension - 925;
        jframe.setLocation(resizeDimension,25);
        // al cerrarlo destruirlo
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jframe;
    }

    /**
     * Metodo para añadir el evento al jframe para arrastrar el jframe
     *
     * @param jframeButtons jframe
     * @param jframeAdditionalInfo jframe
     */
    private static void addDragEventToJframe(JFrame jframeButtons, JFrame jframeAdditionalInfo) {
        Application dragWindowEvent = new Application();
        DragWindowMouseListener mml = new DragWindowMouseListener(dragWindowEvent, jframeAdditionalInfo);
        dragWindowEvent.addMouseListener(mml);
        dragWindowEvent.addMouseMotionListener(mml);
        // Lo añadimos al frame principal para poder arrastrarlo donde queramos
        jframeButtons.getRootPane().getContentPane().add(dragWindowEvent);
    }

    /**
     * Resize icon to fill button method
     *
     * @param icon          icon
     * @param resizedWidth  resize Width
     * @param resizedHeight resize Height
     * @return Icon
     */
    private static ImageIcon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }


    /**
     * Method to check if icon's image is loaded correctly
     *
     * @param imageIcon
     */
    private static void checkIfImageIconIsLoadedCorrectly(ImageIcon imageIcon) {
        int result = imageIcon.getImageLoadStatus();
        if (result == MediaTracker.COMPLETE) {
            System.out.println("Image loaded: " + imageIcon);
        } else {
            System.out.println("Error loading image: " + imageIcon);
        }
    }
}
