package BD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UniformGUI extends JFrame {
    private JTabbedPane tabbedPane;
    private JTable sotrudnikTable, uniformTable, extraditionTable;

    public UniformGUI() {
        setTitle("Система управления выдачей униформы");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);

        initializeComponents();
        loadData();
    }

    private void initializeComponents() {
        tabbedPane = new JTabbedPane();

   
        sotrudnikTable = new JTable();
        JPanel sotrudnikPanel = createTablePanel(sotrudnikTable, "Сотрудники");
        tabbedPane.addTab("Сотрудники", sotrudnikPanel);


        uniformTable = new JTable();
        JPanel uniformPanel = createTablePanel(uniformTable, "Униформа");
        tabbedPane.addTab("Униформа", uniformPanel);

     
        extraditionTable = new JTable();
        JPanel extraditionPanel = createTablePanel(extraditionTable, "Выдача униформы");
        tabbedPane.addTab("Выдача", extraditionPanel);

        add(tabbedPane, BorderLayout.CENTER);

      
        JPanel buttonPanel = new JPanel();
        JButton refreshBtn = new JButton("Обновить данные");
        JButton exitBtn = new JButton("Выход");

        refreshBtn.addActionListener(e -> loadData());
        exitBtn.addActionListener(e -> System.exit(0));

        buttonPanel.add(refreshBtn);
        buttonPanel.add(exitBtn);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JPanel createTablePanel(JTable table, String title) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel(title, JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        return panel;
    }

    private void loadData() {
        loadSotrudnik();
        loadUniform();
        loadExtradition();
    }

    private void loadSotrudnik() {
        sotrudnikDAO dao = new sotrudnikDAO();
        List<sotrudniki> sotrudniki = dao.getAllSotrudnik();

        String[] columns = {"ID", "Имя", "Фамилия", "Отчество", "Рост", "Должность"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (sotrudniki sotr : sotrudniki) {
            model.addRow(new Object[]{
                sotr.getIdEmployee(),
                sotr.getName(),
                sotr.getSurname(),
                sotr.getPatronymic(),
                sotr.getHeightEmployee(),
                sotr.getPost()
            });
        }
        sotrudnikTable.setModel(model);
    }

    private void loadUniform() {
        uniformDAO dao = new uniformDAO();
        List<uniform> uniforms = dao.getAllUniform();

        String[] columns = {"ID", "Номер комплекта", "Размер"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (uniform unif : uniforms) {
            model.addRow(new Object[]{
                unif.getIdUniform(),
                unif.getSetNumber(),
                unif.getSize(),
              
            });
        }
        uniformTable.setModel(model);
    }
    

    private void loadExtradition() {
        ExtraditionDAO dao = new ExtraditionDAO(); 
        List<extradition> extraditions = dao.getAllExtradition();  

        String[] columns = {"ID выдачи", "ID сотрудника", "ID униформы", "Дата выдачи"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (extradition extr : extraditions) {
            model.addRow(new Object[] {
                extr.getIdExtradition(),
                extr.getIdEmployee(),
                extr.getIdUniform(),
                extr.getDateIssue(),
            });
        }
        extraditionTable.setModel(model);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new UniformGUI().setVisible(true);
        });
    }
}