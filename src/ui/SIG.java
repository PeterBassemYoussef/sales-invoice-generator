package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

public class SIG extends JFrame implements ActionListener {
    private JMenuBar menuBar;

    private JMenu fileMenu,
            helpMenu;

    private JMenuItem loadMenuItem,
            saveMenuItem,
            exitMenuItem,
            helpMenuItem;


    private JPanel leftPanel,
            innerLeftPanel,
            innerLeftBtns,
            rightPanel,
            innerInvoiceDataRightPanel,
            innerRightPanel,
            innerRightInvoiceItemsPanel,
            innerRightBtns;
    private JTable invoicesTable,
            invoiceItemsTable;
    private String[] invoicesTableHeaders = {
            "No.", "Date", "Customer", "Total"
    };
    private String [][] invoicesTableData = {
            {"1", "3-5-2022", "Peter", "2100"},
            {"2", "3-10-2022", "Khaled", "6100"}
    };

    private String[] invoiceItemHeaders = {
            "No.", "Item Name", "Item Price", "Count", "Item Total"
    };
    private String [][] invoiceItemData = {
            {"1", "phone", "1000", "2", "2000"},
            {"2", "item4", "550", "2", "1100"}
    };

    private JButton createNewInvoiceBtn,
            deleteInvoicBtn,
            saveBtn,
            cancelBtn;

    private JTextField invoiceDateText,
            customerNameText;

    public SIG() {
        this("Sales Invoice Generator Project");
    }
    public SIG(String title){
        super(title);
        setLayout(new GridLayout(1,2));

        menuBar = new JMenuBar();

        fileMenu = new JMenu("File");
        loadMenuItem = new JMenuItem("Load File", 'l');
        loadMenuItem.setAccelerator(KeyStroke.getKeyStroke('L', InputEvent.CTRL_MASK));
        saveMenuItem = new JMenuItem("Save File", 's');
        saveMenuItem.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_MASK));
        exitMenuItem = new JMenuItem("Exit",'E');
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke('E', InputEvent.CTRL_MASK));
        fileMenu.add(loadMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);


        helpMenu = new JMenu("Help");
        helpMenuItem = new JMenuItem("Help", 'h');
        helpMenuItem.setAccelerator(KeyStroke.getKeyStroke('H', InputEvent.CTRL_MASK));
        helpMenu.add(helpMenuItem);
        menuBar.add(helpMenu);

        // Set Menu action commands and append action listeners
        loadMenuItem.setActionCommand("load");
        loadMenuItem.addActionListener(this);
        saveMenuItem.setActionCommand("save");
        saveMenuItem.addActionListener(this);
        exitMenuItem.setActionCommand("exit");
        exitMenuItem.addActionListener(this);
        helpMenuItem.setActionCommand("help");
        helpMenuItem.addActionListener(this);

        setJMenuBar(menuBar);

        // Left-side panel
        leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        innerLeftPanel = new JPanel();
        invoicesTable = new JTable(invoicesTableData, invoicesTableHeaders);
        innerLeftPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Invoices Table"));
        innerLeftPanel.add("Invoices Table", new JScrollPane(invoicesTable));

        createNewInvoiceBtn = new JButton("Create New Invoice");
        deleteInvoicBtn = new JButton("Delete Invoice");

        innerLeftBtns = new JPanel();
        innerLeftBtns.setLayout(new FlowLayout());
        innerLeftBtns.add(createNewInvoiceBtn);
        innerLeftBtns.add(deleteInvoicBtn);

        leftPanel.add(innerLeftPanel);
        leftPanel.add(innerLeftBtns);


        // Right-side panel
        rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        innerInvoiceDataRightPanel =new JPanel();
        innerInvoiceDataRightPanel.setLayout(new GridLayout(4,2));

        innerInvoiceDataRightPanel.add(new JLabel("Invoice Number"));
        innerInvoiceDataRightPanel.add(new JLabel("23"));
        innerInvoiceDataRightPanel.add(new JLabel("Invoice Date"));
        invoiceDateText = new JTextField();
        innerInvoiceDataRightPanel.add(invoiceDateText);
        innerInvoiceDataRightPanel.add(new JLabel("Customer Name"));
        customerNameText = new JTextField();
        customerNameText.setSize(250, 10);
        innerInvoiceDataRightPanel.add(customerNameText);
        innerInvoiceDataRightPanel.add(new JLabel("Invoice Total"));
        innerInvoiceDataRightPanel.add(new JLabel("350.50"));

        innerRightInvoiceItemsPanel = new JPanel();
        invoiceItemsTable = new JTable(invoiceItemData, invoiceItemHeaders);
        invoiceItemsTable.setSize(new Dimension(20,100));
        innerRightInvoiceItemsPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Invoice Items"));
        innerRightInvoiceItemsPanel.add("Invoice Items", new JScrollPane(invoiceItemsTable));

        saveBtn = new JButton("Save");
        cancelBtn = new JButton("Cancel");

        innerRightBtns = new JPanel();
        innerRightBtns.setLayout(new FlowLayout());
        innerRightBtns.add(saveBtn);
        innerRightBtns.add(cancelBtn);

        rightPanel.add(innerInvoiceDataRightPanel);
        rightPanel.add(innerRightInvoiceItemsPanel);
        rightPanel.add(innerRightBtns);

        // Add panels to JForm
        add(leftPanel);
        add(rightPanel);

        setSize(1000, 700);
        setLocation(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "load":
                loadFile();
                break;
            case "save":
                saveFile();
                break;
            case "exit":
                System.exit(0);
                break;
            case "help":
                JOptionPane.showMessageDialog(null,
                        "This is Sales Invoice Generator Project ..\n" +
                                "Developed By Eng. Peter B. Youssef",
                        "Information Dialog",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }

    private void newFile() {

    }
    private void loadFile(){

    }

    private void saveFile() {

    }
}
