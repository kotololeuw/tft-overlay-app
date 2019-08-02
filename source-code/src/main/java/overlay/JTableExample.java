package overlay;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class JTableExample {

    JFrame jframeAdditionalInfo;

    public void test() {
        // Instanciamos el objeto DefaultTableModel
        DefaultTableModel dtm = new DefaultTableModel();

        // Columnas - Sino se pone la jtable dentro de un JScrollPane no se mostraran
        dtm.setColumnIdentifiers(new Object[]{"OBJETO1", "+", "OBJETO2", "=", "OBJETO_FINAL", "DESCRIPCION"});

        // Filas
        Icon icon = new ImageIcon(HoverButtonMouseListener.class.getResource(Constants.RUTA_ITEM_BOW_ICON));
        Icon icon2 = new ImageIcon(HoverButtonMouseListener.class.getResource(Constants.RUTA_ITEM_BOW_ICON));
        dtm.addRow(new Object[]{icon, "MAS", icon2, "IGUAL", icon, "descripc sadas dasdasdasdasdas asdasdasdasd asdasd asd asdasdas wwww"});

        // Instanciamos el objeto Jtable, si ponemos un poco nos cogera el icono sino el texto
        JTable table = new JTable(dtm) {
            public Class getColumnClass(int column) {
                return (column == 0 || column == 2 || column == 4) ? Icon.class : Object.class;
            }
        };

        // altura de las celdas
        table.setRowHeight(0, 50);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        // color de fondo negro
        table.setBackground(Color.BLACK);

        table.setForeground(Color.GREEN);

        // tabla con celdas sin bordes
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setShowGrid(false);

        // hay que ponerla dentro un jscrollpanel sino no se muestran los headers
        JScrollPane jScrollPane = new JScrollPane(table);

        // lo añadimos al panel de informacion adicional
        jframeAdditionalInfo.getRootPane().getContentPane().add(jScrollPane);
    }
}
