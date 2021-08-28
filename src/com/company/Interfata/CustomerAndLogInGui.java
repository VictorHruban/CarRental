package com.company.Interfata;

import com.company.model.*;
import com.company.service.CarService;
import com.company.service.CustomerService;
import com.company.service.RentService;
import com.company.service.UserService;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Vector;


public class CustomerAndLogInGui extends JFrame {
    private User user;
    private Car car;
    private CarService carService = new CarService();
    private UserService userService = new UserService();
    private Customer savedCustomer = new Customer();
    private RentService rentService = new RentService();
    private CustomerService customerService = new CustomerService();

    JFrame frame = new JFrame();
    JFrame customerRegisterFrame = new JFrame();
    JFrame customerFrame = new JFrame();
    JFrame successLoginCustomerFrame = new JFrame();
    JFrame successLoginAdminFrame = new JFrame();
    JFrame successFrameRegister = new JFrame();
    JFrame successLoginAgentFrame = new JFrame();
    JFrame addRentFrame = new JFrame();
    JFrame rulesFrame = new JFrame();


    JPanel panel = new JPanel();
    JPanel panelCustomerRegister = new JPanel();
    JPanel customerPanel = new JPanel();
    JPanel successLoginCustomerPanel = new JPanel();
    JPanel successLoginAdminPanel = new JPanel();
    JPanel successPanelRegister = new JPanel();
    JPanel successLoginAgentPanel = new JPanel();
    JPanel addRentPanel = new JPanel();
    JPanel rulesPanel = new JPanel();
    DefaultTableModel defaultTableModel = new DefaultTableModel();
    DefaultTableModel defaultTableModel1 = new DefaultTableModel();


    JLabel userLabel = new JLabel("User");
    JLabel passwordLabel = new JLabel("Password");
    JLabel userRegistrationLabel = new JLabel("Username");
    JLabel passwordRegistrationLabel = new JLabel("Password");
    JLabel numeLabel = new JLabel("Nume");
    JLabel prenumeLabel = new JLabel("Prenume");
    JLabel telefonLabel = new JLabel("Telefon");
    JLabel emailLabel = new JLabel("Email");
    JLabel adresaLabel = new JLabel("Adresa");
    JLabel successLoginCustomerLabel = new JLabel("Logged in! ");
    JLabel successLoginAdminLabel = new JLabel("Logged in!");
    JLabel successLabelRegister = new JLabel("Registration complete!");
    JLabel successLoginAgentLabel = new JLabel("Logged in!");
    JLabel loginTitleLabel = new JLabel("Rent-a-car");
    JLabel messageLabel = new JLabel("Not a customer? Register here:");
    JLabel customerLabel = new JLabel("Customer page");
    JLabel carLabel = new JLabel("Car");
    JLabel makerLabel = new JLabel("Maker");
    JLabel modelLabel = new JLabel("Model");
    JLabel carTypeLabel = new JLabel("Car type");
    JLabel kmLabel = new JLabel("Km");
    JLabel rentDateLabel = new JLabel("Rent date");
    JLabel returnDateLabel = new JLabel("Return date");
    JLabel priceLabel = new JLabel("Price");
    JLabel rulesLabel = new JLabel("Rules!");
    JTextArea rulesTextArea = new JTextArea();
    JLabel carList = new JLabel("Car List");
    JLabel rentList = new JLabel("Rents");


    JTextField userText = new JTextField(20);
    JPasswordField passwordTextRegister = new JPasswordField(20);
    JTextField usernameText = new JTextField(20);
    JTextField numeText = new JTextField(20);
    JTextField prenumeText = new JTextField(20);
    JTextField telefonText = new JTextField(20);
    JTextField emailText = new JTextField(20);
    JTextField adresaText = new JTextField(20);
    JPasswordField passwordTextLogin = new JPasswordField(20);
    JComboBox<Car> carsJComboBox = new JComboBox<>(new Vector<>(carService.getUnRentedCars()));
    JTextField makerText = new JTextField(20);
    JTextField modelText = new JTextField(20);
    JTextField carTypeText = new JTextField(20);
    JTextField kmText = new JTextField(20);
    JTextField rentDateText = new JTextField(20);
    JTextField returnDateText = new JTextField(20);
    JTextField priceText = new JTextField(20);


    JButton loginButton = new JButton("Login");
    JButton registerCustomerButton = new JButton("Register Customer");
    JButton registerButton = new JButton("Register");
    JButton resetButton = new JButton("Reset");
    JButton backButton = new JButton("Back");
    JButton okSuccessLoginCustomerButton = new JButton("Ok");
    JButton okSuccessLoginAdminButton = new JButton("Ok");
    JButton okSuccessButtonRegistration = new JButton("Ok");
    JButton okSuccessLoginAgentButton = new JButton("Ok");
    JButton addRentButton = new JButton("Add rent");
    JButton resetButtonRent = new JButton("Reset");
    JButton backButtonRent = new JButton("Back");
    JButton checkPriceButton = new JButton("Check");
    JButton addRentButtonGui = new JButton("Add");
    JButton carsButton = new JButton("Cars");
    JButton rulesButton = new JButton("Rules");
    JButton logOutButton = new JButton("Log out");
    JButton getYourRentsButton = new JButton("Your rents");


    public void createFrame() {
        ImageIcon background = new ImageIcon("C:\\Users\\hruba\\Desktop\\car1.jpg");
        Image img = background.getImage();
        Image temp = img.getScaledInstance(500, 250, Image.SCALE_SMOOTH);
        background = new ImageIcon(temp);
        JLabel back = new JLabel(background);
        back.setLayout(null);
        back.setBounds(0, 0, 500, 250);


        frame.setTitle("Login Page.");
        frame.setSize(100, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(500, 250));
        frame.setMaximumSize(new Dimension(500, Integer.MAX_VALUE));
        frame.add(panel);


        panel.setLayout(null);
        panel.setSize(100, 300);


        loginTitleLabel.setBounds(200, 10, 100, 25);
        loginTitleLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        panel.add(loginTitleLabel);

        messageLabel.setBounds(10, 200, 200, 25);
        panel.add(messageLabel);


        userLabel.setBounds(10, 50, 80, 25);
        panel.add(userLabel);

        passwordLabel.setBounds(10, 80, 80, 25);
        panel.add(passwordLabel);

        userText.setBounds(100, 50, 165, 25);
        panel.add(userText);

        passwordTextLogin.setBounds(100, 80, 165, 25);
        panel.add(passwordTextLogin);

        loginButton.setBounds(183, 110, 80, 25);
        panel.add(loginButton);

        registerCustomerButton.setBounds(200, 200, 150, 25);
        panel.add(registerCustomerButton);

        panel.add(back);


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = passwordTextLogin.getText();

                user = userService.correctCredentials(username, password);
                if (user == null) {
                    JOptionPane.showMessageDialog(frame, "Incorrect credentials!", "Error", JOptionPane.ERROR_MESSAGE);
                    System.err.println("Incorrect credentials!");

                } else if (user.getUserType() == UserType.Admin) {
                    adminLoginMessage();
                    System.out.println("Admin logged in!");

                } else if (user.getUserType() == UserType.Customer) {
                    customerLoginMessage();
                    System.out.println("Customer logged in!");

                } else if (user.getUserType() == UserType.Agent) {
                    agentLoginMessage();
                    System.out.println("Agent logged in!");
                }


                passwordTextLogin.setText("");
            }

        });

        registerCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                registrationUiCustomer();
            }
        });
    }

    public void registrationUiCustomer() {
        customerRegisterFrame.setTitle("Registration Page.");
        customerRegisterFrame.setVisible(true);
        customerRegisterFrame.setSize(100, 100);
        customerRegisterFrame.setResizable(false);
        customerRegisterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customerRegisterFrame.setMinimumSize(new Dimension(500, 500));
        customerRegisterFrame.setMaximumSize(new Dimension(500, Integer.MAX_VALUE));
        customerRegisterFrame.add(panelCustomerRegister);

        panelCustomerRegister.setLayout(null);

        userRegistrationLabel.setBounds(10, 20, 80, 25);
        panelCustomerRegister.add(userRegistrationLabel);

        passwordRegistrationLabel.setBounds(10, 50, 80, 25);
        panelCustomerRegister.add(passwordRegistrationLabel);

        numeLabel.setBounds(10, 80, 80, 25);
        panelCustomerRegister.add(numeLabel);

        prenumeLabel.setBounds(10, 110, 80, 25);
        panelCustomerRegister.add(prenumeLabel);

        telefonLabel.setBounds(10, 140, 80, 25);
        panelCustomerRegister.add(telefonLabel);

        emailLabel.setBounds(10, 170, 80, 25);
        panelCustomerRegister.add(emailLabel);

        adresaLabel.setBounds(10, 200, 80, 25);
        panelCustomerRegister.add(adresaLabel);

        usernameText.setBounds(100, 20, 165, 25);
        panelCustomerRegister.add(usernameText);

        passwordTextRegister.setBounds(100, 50, 165, 25);
        panelCustomerRegister.add(passwordTextRegister);

        numeText.setBounds(100, 80, 165, 25);
        panelCustomerRegister.add(numeText);

        prenumeText.setBounds(100, 110, 165, 25);
        panelCustomerRegister.add(prenumeText);

        telefonText.setBounds(100, 140, 165, 25);
        panelCustomerRegister.add(telefonText);

        emailText.setBounds(100, 170, 165, 25);
        panelCustomerRegister.add(emailText);

        adresaText.setBounds(100, 200, 165, 25);
        panelCustomerRegister.add(adresaText);

        registerButton.setBounds(10, 300, 100, 25);
        panelCustomerRegister.add(registerButton);

        resetButton.setBounds(110, 300, 100, 25);
        panelCustomerRegister.add(resetButton);

        backButton.setBounds(210, 300, 100, 25);
        panelCustomerRegister.add(backButton);

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usernameText.setText("");
                passwordTextRegister.setText("");
                numeText.setText("");
                prenumeText.setText("");
                telefonText.setText("");
                emailText.setText("");
                adresaText.setText("");
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameText.getText();
                String password = passwordTextRegister.getText();
                String nume = numeText.getText();
                String prenume = prenumeText.getText();
                String telefon = telefonText.getText();
                String email = emailText.getText();
                String adresa = adresaText.getText();


                if (username != null && !username.isEmpty() && password != null && !password.isEmpty() && nume != null && !nume.isEmpty() && prenume != null
                        && !prenume.isEmpty() && telefon != null && !telefon.isEmpty() && email != null && !email.isEmpty() && adresa != null && !adresa.isEmpty()) {

                    savedCustomer = userService.createCustomer(username, password, nume, prenume, telefon, email, adresa);

                    successRegister();

                    usernameText.setText("");
                    passwordTextRegister.setText("");
                    numeText.setText("");
                    prenumeText.setText("");
                    telefonText.setText("");
                    emailText.setText("");
                    adresaText.setText("");
                } else {
                    JOptionPane.showMessageDialog(customerRegisterFrame, "Incomplete registration!", "Error", JOptionPane.ERROR_MESSAGE);
                    System.err.println("Incomplete registration!");
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
                customerRegisterFrame.setVisible(false);
            }
        });

    }


    public void customerLoginMessage() {
        successLoginCustomerFrame.setTitle("Login!");
        successLoginCustomerFrame.setVisible(true);
        successLoginCustomerFrame.setResizable(false);
        successLoginCustomerFrame.setSize(300, 150);

        successLoginCustomerFrame.add(successLoginCustomerPanel);

        successLoginCustomerPanel.setLayout(null);

        successLoginCustomerLabel.setBounds(105, 25, 130, 20);
        successLoginCustomerPanel.add(successLoginCustomerLabel);

        okSuccessLoginCustomerButton.setBounds(110, 55, 50, 20);
        successLoginCustomerPanel.add(okSuccessLoginCustomerButton);

        okSuccessLoginCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                successLoginCustomerFrame.setVisible(false);
                customerGui();
            }
        });

    }


    public void adminLoginMessage() {
        successLoginAdminFrame.setTitle("Login!");
        successLoginAdminFrame.setVisible(true);
        successLoginAdminFrame.setResizable(false);
        successLoginAdminFrame.setSize(300, 150);

        successLoginAdminFrame.add(successLoginAdminPanel);

        successLoginAdminPanel.setLayout(null);

        successLoginAdminLabel.setBounds(105, 25, 130, 20);
        successLoginAdminPanel.add(successLoginAdminLabel);

        okSuccessLoginAdminButton.setBounds(110, 55, 50, 20);
        successLoginAdminPanel.add(okSuccessLoginAdminButton);

        okSuccessLoginAdminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                successLoginAdminFrame.setVisible(false);
                new AdminGui();
            }
        });

    }


    public void successRegister() {
        successFrameRegister.setTitle("Success!");
        successFrameRegister.setVisible(true);
        successFrameRegister.setResizable(false);
        successFrameRegister.setSize(300, 150);

        successFrameRegister.add(successPanelRegister);

        successPanelRegister.setLayout(null);

        successLabelRegister.setBounds(75, 25, 150, 20);
        successPanelRegister.add(successLabelRegister);

        okSuccessButtonRegistration.setBounds(110, 55, 50, 20);
        successPanelRegister.add(okSuccessButtonRegistration);

        okSuccessButtonRegistration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
                customerRegisterFrame.setVisible(false);
                successFrameRegister.setVisible(false);


            }
        });
    }


    public void agentLoginMessage() {

        successLoginAgentFrame.setTitle("Login!");
        successLoginAgentFrame.setVisible(true);
        successLoginAgentFrame.setResizable(false);
        successLoginAgentFrame.setSize(300, 150);

        successLoginAgentFrame.add(successLoginAgentPanel);

        successLoginAgentPanel.setLayout(null);

        successLoginAgentLabel.setBounds(105, 25, 130, 20);
        successLoginAgentPanel.add(successLoginAgentLabel);

        okSuccessLoginAgentButton.setBounds(110, 55, 50, 20);
        successLoginAgentPanel.add(okSuccessLoginAgentButton);

        okSuccessLoginAgentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                successLoginAgentFrame.setVisible(false);
                new AgentGui();
            }
        });
    }

    public void customerGui() {
        customerFrame.setTitle("Customer page.");
        customerFrame.setVisible(true);
        customerFrame.setSize(100, 100);
        customerFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        customerFrame.setMinimumSize(new Dimension(500, 500));
        customerFrame.setMaximumSize(new Dimension(500, Integer.MAX_VALUE));
        customerFrame.add(customerPanel);


        customerPanel.setLayout(null);
        customerPanel.setBackground(new Color(0xFFFF66));


        customerLabel.setBounds(170, 20, 150, 25);
        customerLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        customerPanel.add(customerLabel);

        carsButton.setBounds(150, 100, 150, 25);
        customerPanel.add(carsButton);

        addRentButton.setBounds(150, 150, 150, 25);
        customerPanel.add(addRentButton);

        rulesButton.setBounds(150, 200, 150, 25);
        customerPanel.add(rulesButton);

        getYourRentsButton.setBounds(150, 250, 150, 25);
        customerPanel.add(getYourRentsButton);

        logOutButton.setBounds(150, 300, 150, 25);
        customerPanel.add(logOutButton);


        addRentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerFrame.setVisible(false);
                addRentGui();

            }
        });

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerFrame.setVisible(false);
                frame.setVisible(true);
            }
        });

        rulesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rulesGui();
            }
        });

        carsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unRentedCarList();
            }
        });

        getYourRentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rentClient();

            }
        });
    }

    public void addRentGui() {
        addRentFrame.setTitle("Add rent");
        addRentFrame.setVisible(true);
        addRentFrame.setResizable(false);
        addRentFrame.setSize(100, 100);
        addRentFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        addRentFrame.setMinimumSize(new Dimension(500, 500));
        addRentFrame.setMaximumSize(new Dimension(500, Integer.MAX_VALUE));
        addRentFrame.add(addRentPanel);

        addRentPanel.setLayout(null);

        carLabel.setBounds(10, 20, 80, 25);
        addRentPanel.add(carLabel);

        makerLabel.setBounds(10, 50, 80, 25);
        addRentPanel.add(makerLabel);

        modelLabel.setBounds(10, 80, 80, 25);
        addRentPanel.add(modelLabel);

        carTypeLabel.setBounds(10, 110, 80, 25);
        addRentPanel.add(carTypeLabel);

        kmLabel.setBounds(10, 140, 80, 25);
        addRentPanel.add(kmLabel);

        rentDateLabel.setBounds(10, 170, 80, 25);
        addRentPanel.add(rentDateLabel);

        returnDateLabel.setBounds(10, 200, 80, 25);
        addRentPanel.add(returnDateLabel);

        priceLabel.setBounds(10, 230, 80, 25);
        addRentPanel.add(priceLabel);

        carsJComboBox.setBounds(100, 20, 230, 25);
        carsJComboBox.setSelectedIndex(-1);
        addRentPanel.add(carsJComboBox);

        makerText.setBounds(100, 50, 165, 25);
        makerText.setEditable(false);
        addRentPanel.add(makerText);

        modelText.setBounds(100, 80, 165, 25);
        modelText.setEditable(false);
        addRentPanel.add(modelText);

        carTypeText.setBounds(100, 110, 165, 25);
        carTypeText.setEditable(false);
        addRentPanel.add(carTypeText);

        kmText.setBounds(100, 140, 165, 25);
        kmText.setEditable(false);
        addRentPanel.add(kmText);

        rentDateText.setBounds(100, 170, 165, 25);
        addRentPanel.add(rentDateText);

        returnDateText.setBounds(100, 200, 165, 25);
        addRentPanel.add(returnDateText);

        priceText.setBounds(100, 230, 165, 25);
        priceText.setEditable(false);
        addRentPanel.add(priceText);

        addRentButtonGui.setBounds(10, 300, 100, 25);
        addRentPanel.add(addRentButtonGui);

        checkPriceButton.setBounds(110, 300, 100, 25);
        addRentPanel.add(checkPriceButton);

        resetButtonRent.setBounds(210, 300, 100, 25);
        addRentPanel.add(resetButtonRent);

        backButtonRent.setBounds(310, 300, 100, 25);
        addRentPanel.add(backButtonRent);


        carsJComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Car car = (Car) carsJComboBox.getSelectedItem();
                if (car != null) {
                    makerText.setText(car.getMaker());
                    modelText.setText(car.getCarModel());
                    carTypeText.setText(car.getCarType());
                    kmText.setText(car.getKm());
                }
            }
        });

        checkPriceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                String firstDate = rentDateText.getText();
                String secondDate = returnDateText.getText();

                LocalDate date1 = LocalDate.parse(firstDate, formatter);
                LocalDate date2 = LocalDate.parse(secondDate, formatter);

                long daysBetween = ChronoUnit.DAYS.between(date1, date2);

                if (daysBetween > 0) {
                    System.out.println(daysBetween);
                } else {
                    System.out.println(daysBetween * -1);
                }


                double price;
                Car car = (Car) carsJComboBox.getSelectedItem();
                if (car != null) {
                    price = rentService.rentPrice(Math.toIntExact(daysBetween), car.getConfortType().getId());

                    priceText.setText(String.valueOf(price));
                }
            }
        });

        resetButtonRent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makerText.setText("");
                modelText.setText("");
                carTypeText.setText("");
                kmText.setText("");
                rentDateText.setText("");
                returnDateText.setText("");
                priceText.setText("");

            }
        });

        backButtonRent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRentFrame.setVisible(false);
                customerFrame.setVisible(true);
            }
        });

        addRentButtonGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Car car = (Car) carsJComboBox.getSelectedItem();
                Date rentDate = new java.sql.Date(rentService.convertStringToDate(rentDateText.getText()).getTime());
                Date returnDate = new java.sql.Date(rentService.convertStringToDate(returnDateText.getText()).getTime());
                Customer customer = new Customer();
                String usernameCustomer = userText.getText();
                int id = customerService.getUserId(usernameCustomer);
                customer.setId(id);


                rentService.createRent(car, customer, rentDate, returnDate);
                JOptionPane.showMessageDialog(addRentFrame, "Rent added!");
                System.out.println("Rent added!");


            }
        });
    }

    public void rulesGui() {
        rulesFrame.setTitle("Rules");
        rulesFrame.setVisible(true);
        rulesFrame.setSize(100, 100);
        rulesFrame.setDefaultCloseOperation(HIDE_ON_CLOSE);
        rulesFrame.setMinimumSize(new Dimension(500, 500));
        rulesFrame.setMaximumSize(new Dimension(500, Integer.MAX_VALUE));
        rulesFrame.add(rulesPanel);
        rulesFrame.setResizable(false);

        rulesPanel.setLayout(null);

        rulesLabel.setBounds(200, 20, 150, 25);
        rulesLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        rulesPanel.add(rulesLabel);


        rulesTextArea.setBounds(5, 50, 495, 350);
        rulesTextArea.setEditable(false);
        rulesTextArea.setText("Welcome to Rent-A-Car!\n" +
                "\n" +
                "Here are the rules:\n" +
                "\n" +
                "1)You need to have a valid driving license.\n" +
                "2)You need to have the minimum age of 25.\n" +
                "3)You need to be able to provide an acceptable form of payment.\n" +
                "4)If you rent a car more than 30,60,90 days, you will have an discount of 10%,20%,30%.\n" +
                "5)The price for each category is: 20$/day for normal comfort, 60$/day for medium comfort\n " +
                " and 100$/day for premium comfort.\n" +
                "6)If you can't return the car on the return date, you will be sued with the amount of money \n" +
                "your car is worth/day.");
        rulesPanel.add(rulesTextArea);
    }

    public void unRentedCarList() {
        JFrame tableFrame = new JFrame();
        JPanel headerPanel = new JPanel();
        JPanel bodyPanel = new JPanel();
        JTable table = new JTable(100, 5);

        tableFrame.setTitle("Cars");
        tableFrame.setVisible(true);
        tableFrame.setDefaultCloseOperation(HIDE_ON_CLOSE);
        tableFrame.setSize(600, 500);
        tableFrame.setResizable(false);
        tableFrame.setLayout(null);
        tableFrame.setBackground(Color.white);

        tableFrame.add(headerPanel);
        headerPanel.setBounds(0, 0, 600, 100);
        headerPanel.setBackground(Color.black);

        tableFrame.add(bodyPanel);
        bodyPanel.setBounds(0, 100, 600, 300);

        carList.setBounds(200, 400, 120, 25);
        carList.setFont(new Font("Serif", Font.ITALIC, 30));
        carList.setForeground(Color.CYAN);
        headerPanel.add(carList);

        defaultTableModel = (DefaultTableModel) table.getModel();
        JScrollPane jScrollPane = new JScrollPane(table);
        bodyPanel.setLayout(null);
        bodyPanel.add(jScrollPane);
        jScrollPane.setBounds(10, 10, 580, 600);


        table.getColumnModel().getColumn(0).setHeaderValue("Maker");
        table.getColumnModel().getColumn(1).setHeaderValue("Model");
        table.getColumnModel().getColumn(2).setHeaderValue("Car Type");
        table.getColumnModel().getColumn(3).setHeaderValue("Kilometers");
        table.getColumnModel().getColumn(4).setHeaderValue("Comfort Type");

        writeDataInTable();


    }

    public void writeDataInTable() {
        CarService carService = new CarService();
        List<Car> carList = carService.getUnRentedCars();
        if (carList.size() > defaultTableModel.getRowCount()) {
            System.out.println("Not enough rows in the table");
        }
        for (int i = 0; i < carList.size(); i++) {
            defaultTableModel.setValueAt(carList.get(i).getMaker(), i, 0);
            defaultTableModel.setValueAt(carList.get(i).getCarModel(), i, 1);
            defaultTableModel.setValueAt(carList.get(i).getCarType(), i, 2);
            defaultTableModel.setValueAt(carList.get(i).getKm(), i, 3);
            defaultTableModel.setValueAt(carList.get(i).getConfortType(), i, 4);
        }
    }

    public void rentClient() {
        JFrame tableRentFrame = new JFrame();
        JPanel headerRentPanel = new JPanel();
        JPanel bodyPanelRent = new JPanel();
        JTable table1 = new JTable(100, 6);

        tableRentFrame.setTitle("Rents");
        tableRentFrame.setVisible(true);
        tableRentFrame.setDefaultCloseOperation(HIDE_ON_CLOSE);
        tableRentFrame.setSize(600, 500);
        tableRentFrame.setResizable(false);
        tableRentFrame.setLayout(null);
        tableRentFrame.setBackground(Color.white);

        tableRentFrame.add(headerRentPanel);
        headerRentPanel.setBounds(0, 0, 600, 100);
        headerRentPanel.setBackground(Color.black);

        tableRentFrame.add(bodyPanelRent);
        bodyPanelRent.setBounds(0, 100, 600, 300);

        rentList.setBounds(200, 400, 120, 25);
        rentList.setFont(new Font("Serif", Font.ITALIC, 30));
        rentList.setForeground(Color.CYAN);
        headerRentPanel.add(rentList);

        defaultTableModel1 = (DefaultTableModel) table1.getModel();
        JScrollPane jScrollPane1 = new JScrollPane(table1);
        bodyPanelRent.setLayout(null);
        bodyPanelRent.add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 580, 600);

        table1.getColumnModel().getColumn(0).setHeaderValue("Name");
        table1.getColumnModel().getColumn(1).setHeaderValue("Surname");
        table1.getColumnModel().getColumn(2).setHeaderValue("Maker");
        table1.getColumnModel().getColumn(3).setHeaderValue("Model");
        table1.getColumnModel().getColumn(4).setHeaderValue("Rent date");
        table1.getColumnModel().getColumn(5).setHeaderValue("Return date");

        writeDataInTableCustomer();


    }


    public void writeDataInTableCustomer() {
        RentService rentService = new RentService();
        String usernameCustomer = userText.getText();
        Customer customer = new Customer();
        int id = customerService.getUserId(usernameCustomer);
        customer.setId(id);
        List<Rent> rentList = rentService.getCustomerRents(id);
        if (rentList.size() > defaultTableModel1.getRowCount()) {
            System.out.println("Not enough rows in the table");
        }
        for (int i = 0; i < rentList.size(); i++) {
            defaultTableModel1.setValueAt(rentList.get(i).getCustomer().getNume(), i, 0);
            defaultTableModel1.setValueAt(rentList.get(i).getCustomer().getPrenume(), i, 1);
            defaultTableModel1.setValueAt(rentList.get(i).getCar().getMaker(), i, 2);
            defaultTableModel1.setValueAt(rentList.get(i).getCar().getCarModel(), i, 3);
            defaultTableModel1.setValueAt(rentList.get(i).getRentDate(), i, 4);
            defaultTableModel1.setValueAt(rentList.get(i).getReturnDate(), i, 5);
        }
    }

    public CustomerAndLogInGui() {
        createFrame();


    }

    public static void main(String[] args) {
        new CustomerAndLogInGui();
    }
}
