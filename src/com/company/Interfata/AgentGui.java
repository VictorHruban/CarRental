package com.company.Interfata;

import com.company.model.*;
import com.company.service.*;

import javax.print.attribute.standard.JobKOctets;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class AgentGui extends JFrame {

    private Agent savedAgent = new Agent();
    private User user;
    private UserService userService = new UserService();
    private DiscountService discountService = new DiscountService();

    JFrame agentFrame = new JFrame();
    JFrame agentRegisterFrame = new JFrame();

    JFrame successFrameRegisterAgent = new JFrame();

    JFrame modifyDiscountFrame = new JFrame();

    JPanel agentPanel = new JPanel();
    JPanel agentRegisterPanel = new JPanel();

    JPanel successPanelRegisterAgent = new JPanel();

    JPanel modifyDiscountPanel = new JPanel();

    JLabel agentTitleLabel = new JLabel("Agent page");
    JLabel agentUserLabel = new JLabel("Username");
    JLabel agentPasswordLabel = new JLabel("Password");
    JLabel agentNumeLabel = new JLabel("Nume");
    JLabel agentPrenumeLabel = new JLabel("Prenume");
    JLabel agentTelefonLabel = new JLabel("Telefon");
    JLabel agentEmailLabel = new JLabel("Email");
    JLabel agentAdresaLabel = new JLabel("Adresa");
    JLabel agentErrorLabel = new JLabel("Incomplete registration!");
    JLabel successLabelRegisterAgent = new JLabel("Registration complete!");
    JLabel customerList = new JLabel("Customer List");
    JLabel rentList = new JLabel("Rent List");
    JLabel discountLabel = new JLabel("Discount");
    JLabel daysForDiscountLabel = new JLabel("Days for discount");

    JTextField agentUserText = new JTextField(20);
    JPasswordField agentPasswordText = new JPasswordField(20);
    JTextField agentNumeText = new JTextField(20);
    JTextField agentPrenumeText = new JTextField(20);
    JTextField agentTelefonText = new JTextField(20);
    JTextField agentEmailText = new JTextField(20);
    JTextField agentAdresaText = new JTextField(20);
    DefaultTableModel defaultTableModel = new DefaultTableModel();

    DefaultTableModel defaultTableModelRent = new DefaultTableModel();

    JTextField discountText = new JTextField(20);
    JComboBox<Discount> updateDiscountBox = new JComboBox<>(new Vector<>(discountService.getAllDaysForDiscount()));


    JButton customersButton = new JButton("Customers");
    JButton rentsButton = new JButton("Rents");
    JButton modifyRentButton = new JButton("Modify discount");
    JButton addNewAgentButton = new JButton("Add agent");
    JButton logOutButton = new JButton("Log out");
    JButton registerAgentButton = new JButton("Register");
    JButton resetButtonAgent = new JButton("Reset");
    JButton backButtonAgent = new JButton("Back");
    JButton agentErrorRegisterButton = new JButton("Ok");
    JButton okSuccessButtonRegistrationAgent = new JButton("Ok");
    JButton updateDiscountButton = new JButton("Update");
    JButton backUpdateDiscountButton = new JButton("Back");

    public AgentGui() {
        agentGui();


    }

    public void agentGui() {
        agentFrame.setTitle("Agent page.");
        agentFrame.setVisible(true);
        agentFrame.setResizable(false);
        agentFrame.setSize(100, 100);
        agentFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        agentFrame.setMinimumSize(new Dimension(500, 500));
        agentFrame.setMaximumSize(new Dimension(500, Integer.MAX_VALUE));
        agentFrame.add(agentPanel);

        agentPanel.setLayout(null);
        agentPanel.setBackground(new Color(0x3333CC));

        agentTitleLabel.setBounds(170, 20, 150, 30);
        agentTitleLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        agentPanel.add(agentTitleLabel);

        customersButton.setBounds(150, 100, 150, 25);
        agentPanel.add(customersButton);

        rentsButton.setBounds(150, 150, 150, 25);
        agentPanel.add(rentsButton);

        modifyRentButton.setBounds(150, 200, 150, 25);
        agentPanel.add(modifyRentButton);

        addNewAgentButton.setBounds(150, 250, 150, 25);
        agentPanel.add(addNewAgentButton);

        logOutButton.setBounds(150, 300, 150, 25);
        agentPanel.add(logOutButton);

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agentFrame.setVisible(false);
                new CustomerAndLogInGui();
            }
        });

        addNewAgentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agentFrame.setVisible(false);
                registrationUiAgent();

            }
        });

        customersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerList();
            }
        });

        rentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rentList();
            }
        });

        modifyRentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyDiscount();
            }
        });

    }

    public void registrationUiAgent() {
        agentRegisterFrame.setTitle("Registration Page.");
        agentRegisterFrame.setVisible(true);
        agentRegisterFrame.setSize(100, 100);
        agentRegisterFrame.setResizable(false);
        agentRegisterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        agentRegisterFrame.setMinimumSize(new Dimension(500, 500));
        agentRegisterFrame.setMaximumSize(new Dimension(500, Integer.MAX_VALUE));
        agentRegisterFrame.add(agentRegisterPanel);

        agentRegisterPanel.setLayout(null);

        agentUserLabel.setBounds(10, 20, 80, 25);
        agentRegisterPanel.add(agentUserLabel);

        agentPasswordLabel.setBounds(10, 50, 80, 25);
        agentRegisterPanel.add(agentPasswordLabel);

        agentNumeLabel.setBounds(10, 80, 80, 25);
        agentRegisterPanel.add(agentNumeLabel);

        agentPrenumeLabel.setBounds(10, 110, 80, 25);
        agentRegisterPanel.add(agentPrenumeLabel);

        agentTelefonLabel.setBounds(10, 140, 80, 25);
        agentRegisterPanel.add(agentTelefonLabel);

        agentEmailLabel.setBounds(10, 170, 80, 25);
        agentRegisterPanel.add(agentEmailLabel);

        agentAdresaLabel.setBounds(10, 200, 80, 25);
        agentRegisterPanel.add(agentAdresaLabel);

        agentUserText.setBounds(100, 20, 165, 25);
        agentRegisterPanel.add(agentUserText);

        agentPasswordText.setBounds(100, 50, 165, 25);
        agentRegisterPanel.add(agentPasswordText);

        agentNumeText.setBounds(100, 80, 165, 25);
        agentRegisterPanel.add(agentNumeText);

        agentPrenumeText.setBounds(100, 110, 165, 25);
        agentRegisterPanel.add(agentPrenumeText);

        agentTelefonText.setBounds(100, 140, 165, 25);
        agentRegisterPanel.add(agentTelefonText);

        agentEmailText.setBounds(100, 170, 165, 25);
        agentRegisterPanel.add(agentEmailText);

        agentAdresaText.setBounds(100, 200, 165, 25);
        agentRegisterPanel.add(agentAdresaText);

        registerAgentButton.setBounds(10, 300, 100, 25);
        agentRegisterPanel.add(registerAgentButton);

        resetButtonAgent.setBounds(110, 300, 100, 25);
        agentRegisterPanel.add(resetButtonAgent);

        backButtonAgent.setBounds(210, 300, 100, 25);
        agentRegisterPanel.add(backButtonAgent);

        resetButtonAgent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agentUserText.setText("");
                agentPasswordText.setText("");
                agentNumeText.setText("");
                agentPrenumeText.setText("");
                agentTelefonText.setText("");
                agentEmailText.setText("");
                agentAdresaText.setText("");
            }
        });

        backButtonAgent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agentRegisterFrame.setVisible(false);
                agentFrame.setVisible(true);
            }
        });

        registerAgentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = agentUserText.getText();
                String password = agentPasswordText.getText();
                String nume = agentNumeText.getText();
                String prenume = agentPrenumeText.getText();
                String telefon = agentTelefonText.getText();
                String email = agentEmailText.getText();
                String adresa = agentAdresaText.getText();

                if (username != null && !username.isEmpty() && password != null && !password.isEmpty() && nume != null && !nume.isEmpty() && prenume != null
                        && !prenume.isEmpty() && telefon != null && !telefon.isEmpty() && email != null && !email.isEmpty() && adresa != null && !adresa.isEmpty()) {

                    savedAgent = userService.createAgent(username, password, nume, prenume, telefon, email, adresa);
                    successAgentLogin();
                    System.out.println("New Agent!");

                    agentUserText.setText("");
                    agentPasswordText.setText("");
                    agentNumeText.setText("");
                    agentPrenumeText.setText("");
                    agentTelefonText.setText("");
                    agentEmailText.setText("");
                    agentAdresaText.setText("");
                } else {
                    JOptionPane.showMessageDialog(agentRegisterFrame, "Incomplete registration!", "Error", JOptionPane.ERROR_MESSAGE);
                    System.err.println("Incomplete registration!");
                }
            }
        });
    }


    public void successAgentLogin() {
        successFrameRegisterAgent.setTitle("Success!");
        successFrameRegisterAgent.setVisible(true);
        successFrameRegisterAgent.setResizable(false);
        successFrameRegisterAgent.setSize(300, 150);

        successFrameRegisterAgent.add(successPanelRegisterAgent);

        successPanelRegisterAgent.setLayout(null);

        successLabelRegisterAgent.setBounds(75, 25, 150, 20);
        successPanelRegisterAgent.add(successLabelRegisterAgent);

        okSuccessButtonRegistrationAgent.setBounds(110, 55, 50, 20);
        successPanelRegisterAgent.add(okSuccessButtonRegistrationAgent);

        okSuccessButtonRegistrationAgent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agentFrame.setVisible(true);
                agentRegisterFrame.setVisible(false);
                successFrameRegisterAgent.setVisible(false);


            }
        });
    }

    public void customerList() {

        JFrame tableFrame = new JFrame();
        JPanel headerPanel = new JPanel();
        JPanel bodyPanel = new JPanel();
        JTable table = new JTable(100, 6);

        tableFrame.setTitle("Customers");
        tableFrame.setVisible(true);
        tableFrame.setDefaultCloseOperation(HIDE_ON_CLOSE);
        tableFrame.setSize(1200, 1100);
        tableFrame.setResizable(false);
        tableFrame.setLayout(null);
        tableFrame.setBackground(Color.WHITE);

        tableFrame.add(headerPanel);
        headerPanel.setBounds(0, 0, 1200, 100);
        headerPanel.setBackground(Color.BLACK);

        tableFrame.add(bodyPanel);
        bodyPanel.setBounds(0, 100, 1200, 600);

        customerList.setBounds(200, 400, 120, 25);
        customerList.setFont(new Font("Serif", Font.ITALIC, 30));
        customerList.setForeground(Color.CYAN);
        headerPanel.add(customerList);

        defaultTableModel = (DefaultTableModel) table.getModel();
        JScrollPane jScrollPane = new JScrollPane(table);
        bodyPanel.setLayout(null);
        bodyPanel.add(jScrollPane);
        jScrollPane.setBounds(10, 10, 1150, 1000);

        table.getColumnModel().getColumn(0).setHeaderValue("Id");
        table.getColumnModel().getColumn(1).setHeaderValue("Nume");
        table.getColumnModel().getColumn(2).setHeaderValue("Prenume");
        table.getColumnModel().getColumn(3).setHeaderValue("Telefon");
        table.getColumnModel().getColumn(4).setHeaderValue("Email");
        table.getColumnModel().getColumn(5).setHeaderValue("Adresa");

        writeDataInTable();

    }

    public void writeDataInTable() {
        CustomerService customerService = new CustomerService();
        List<Customer> customerList = customerService.getCustomers();
        if (customerList.size() > defaultTableModel.getRowCount()) {
            System.out.println("Not enough rows in the table");
        }
        for (int i = 0; i < customerList.size(); i++) {
            defaultTableModel.setValueAt(customerList.get(i).getId(), i, 0);
            defaultTableModel.setValueAt(customerList.get(i).getNume(), i, 1);
            defaultTableModel.setValueAt(customerList.get(i).getPrenume(), i, 2);
            defaultTableModel.setValueAt(customerList.get(i).getTelefon(), i, 3);
            defaultTableModel.setValueAt(customerList.get(i).getEmail(), i, 4);
            defaultTableModel.setValueAt(customerList.get(i).getAdresa(), i, 5);

        }
    }

    public void rentList() {
        JFrame rentTableFrame = new JFrame();
        JPanel headerRentPanel = new JPanel();
        JPanel bodyRentPanel = new JPanel();
        JTable tableRent = new JTable(100, 7);

        rentTableFrame.setTitle("Cars");
        rentTableFrame.setVisible(true);
        rentTableFrame.setDefaultCloseOperation(HIDE_ON_CLOSE);
        rentTableFrame.setSize(600, 500);
        rentTableFrame.setResizable(false);
        rentTableFrame.setLayout(null);
        rentTableFrame.setBackground(Color.white);

        rentTableFrame.add(headerRentPanel);
        headerRentPanel.setBounds(0, 0, 600, 100);
        headerRentPanel.setBackground(Color.black);

        rentTableFrame.add(bodyRentPanel);
        bodyRentPanel.setBounds(0, 100, 600, 300);

        rentList.setBounds(200, 400, 120, 25);
        rentList.setFont(new Font("Serif", Font.ITALIC, 30));
        rentList.setForeground(Color.CYAN);
        headerRentPanel.add(rentList);

        defaultTableModelRent = (DefaultTableModel) tableRent.getModel();
        JScrollPane jScrollPane = new JScrollPane(tableRent);
        bodyRentPanel.setLayout(null);
        bodyRentPanel.add(jScrollPane);
        jScrollPane.setBounds(10, 10, 580, 600);

        tableRent.getColumnModel().getColumn(0).setHeaderValue("Id");
        tableRent.getColumnModel().getColumn(1).setHeaderValue("Name");
        tableRent.getColumnModel().getColumn(2).setHeaderValue("Surname");
        tableRent.getColumnModel().getColumn(3).setHeaderValue("Maker");
        tableRent.getColumnModel().getColumn(4).setHeaderValue("Model");
        tableRent.getColumnModel().getColumn(5).setHeaderValue("Rent date");
        tableRent.getColumnModel().getColumn(6).setHeaderValue("Return date");

        writeDataInTableRent();
    }

    public void writeDataInTableRent() {
        RentService rentService = new RentService();
        List<Rent> rentList = rentService.getRents();
        if (rentList.size() > defaultTableModelRent.getRowCount()) {
            System.out.println("Not enough rows in the table");
        }
        for (int i = 0; i < rentList.size(); i++) {
            defaultTableModelRent.setValueAt(rentList.get(i).getId(), i, 0);
            defaultTableModelRent.setValueAt(rentList.get(i).getCustomer().getNume(), i, 1);
            defaultTableModelRent.setValueAt(rentList.get(i).getCustomer().getPrenume(), i, 2);
            defaultTableModelRent.setValueAt(rentList.get(i).getCar().getMaker(), i, 3);
            defaultTableModelRent.setValueAt(rentList.get(i).getCar().getCarModel(), i, 4);
            defaultTableModelRent.setValueAt(rentList.get(i).getRentDate(), i, 5);
            defaultTableModelRent.setValueAt(rentList.get(i).getReturnDate(), i, 6);
        }
    }

    public void modifyDiscount() {
        modifyDiscountFrame.setTitle("Update Discount");
        modifyDiscountFrame.setVisible(true);
        modifyDiscountFrame.setSize(50, 50);
        modifyDiscountFrame.setResizable(false);
        modifyDiscountFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        modifyDiscountFrame.setMinimumSize(new Dimension(300, 200));
        modifyDiscountFrame.setMaximumSize(new Dimension(300, Integer.MAX_VALUE));
        modifyDiscountFrame.add(modifyDiscountPanel);

        modifyDiscountPanel.setLayout(null);

        discountLabel.setBounds(10, 20, 50, 35);
        modifyDiscountPanel.add(discountLabel);

        daysForDiscountLabel.setBounds(10, 50, 100, 35);
        modifyDiscountPanel.add(daysForDiscountLabel);

        discountText.setBounds(120, 30, 80, 20);
        modifyDiscountPanel.add(discountText);

        updateDiscountBox.setBounds(120, 60, 100, 20);
        updateDiscountBox.setSelectedIndex(-1);
        modifyDiscountPanel.add(updateDiscountBox);

        updateDiscountButton.setBounds(50, 100, 80, 20);
        modifyDiscountPanel.add(updateDiscountButton);

        backUpdateDiscountButton.setBounds(150, 100, 80, 20);
        modifyDiscountPanel.add(backUpdateDiscountButton);

        backUpdateDiscountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyDiscountFrame.setVisible(false);
            }
        });

        updateDiscountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String discount = discountText.getText();
                Discount discount1 = (Discount) updateDiscountBox.getSelectedItem();

                if (discount != null && !discount.isEmpty() && updateDiscountBox != null) {

                    discountService.updateDiscount(Double.parseDouble(discount), Integer.parseInt(String.valueOf(discount1)));
                    JOptionPane.showMessageDialog(modifyDiscountFrame, "Updated");
                    System.out.println("Updated!");
                    modifyDiscountFrame.setVisible(false);
                    discountText.setText("");
                } else {
                    JOptionPane.showMessageDialog(modifyDiscountFrame, "Update failed", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }


    public static void main(String[] args) {
        new AgentGui();
    }
}
