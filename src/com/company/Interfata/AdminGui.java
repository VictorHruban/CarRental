package com.company.Interfata;

import com.company.model.Agent;
import com.company.model.Car;
import com.company.model.ComfortType;
import com.company.model.User;
import com.company.service.CarService;
import com.company.service.UserService;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import java.util.Vector;

public class AdminGui extends JFrame {
    private Agent savedAgent = new Agent();
    private User user;
    private UserService userService = new UserService();
    private Car savedCar = new Car();
    private CarService carService = new CarService();


    JFrame adminFrame = new JFrame();
    JFrame adminRegisterFrame = new JFrame();
    JFrame successFrameRegisterAdmin = new JFrame();
    JFrame addCarFrame = new JFrame();
    JFrame deleteCarFrame = new JFrame();
    JFrame successDeleteCarFrame = new JFrame();
    JFrame updateCarFrame = new JFrame();


    JPanel adminPanel = new JPanel();
    JPanel adminRegisterPanel = new JPanel();
    JPanel successPanelRegisterAdmin = new JPanel();
    JPanel addCarPanel = new JPanel();
    JPanel deleteCarPanel = new JPanel();
    JPanel successDeleteCarPanel = new JPanel();
    JPanel updateCarPanel = new JPanel();


    DefaultTableModel defaultTableModel = new DefaultTableModel();

    JLabel adminTitle = new JLabel("Admin page");
    JLabel userRegistrationLabelAdmin = new JLabel("Username");
    JLabel passwordRegistrationLabelAdmin = new JLabel("Password");
    JLabel numeLabelAdmin = new JLabel("Nume");
    JLabel prenumeLabelAdmin = new JLabel("Prenume");
    JLabel telefonLabelAdmin = new JLabel("Telefon");
    JLabel emailLabelAdmin = new JLabel("Email");
    JLabel adresaLabelAdmin = new JLabel("Adresa");
    JLabel successLabelRegisterAdmin = new JLabel("Registration complete!");
    JLabel makerLabel = new JLabel("Maker");
    JLabel modelLabel = new JLabel("Model");
    JLabel carTypeLabel = new JLabel("Car type");
    JLabel kmLabel = new JLabel("Km");
    JLabel confortTypeLabel = new JLabel("Comfort type");
    JLabel deleteCarLabel = new JLabel("Enter car id");
    JLabel successDeleteCarLabel = new JLabel("Car deleted");
    JLabel updateIdCarLabel = new JLabel("Id");
    JLabel updateMakerCarLabel = new JLabel("Maker");
    JLabel updateModelCarLabel = new JLabel("Model");
    JLabel updateCarTypeLabel = new JLabel("Car type");
    JLabel updateKmLabel = new JLabel("Km");
    JLabel updateComfortType = new JLabel("Comfort type");
    JLabel carList = new JLabel("Car List");
    JLabel showCarLabel = new JLabel("Car");


    JTextField usernameTextAdmin = new JTextField(20);
    JPasswordField passwordTextAdmin = new JPasswordField(20);
    JTextField numeTextAdmin = new JTextField(20);
    JTextField prenumeTextAdmin = new JTextField(20);
    JTextField telefonTextAdmin = new JTextField(20);
    JTextField emailTextAdmin = new JTextField(20);
    JTextField adresaTextAdmin = new JTextField(20);
    JTextField makerText = new JTextField(20);
    JTextField modelText = new JTextField(20);
    JTextField carTypeText = new JTextField(20);
    JTextField kmText = new JTextField(20);
    JComboBox<ComfortType> comfortTypeBox = new JComboBox<>(new Vector<>(carService.getComfortTypes()));
    JTextField deleteCarText = new JTextField(20);
    JTextField updateIdCarText = new JTextField(20);
    JTextField updateMakerCarText = new JTextField(20);
    JTextField updateModelCarText = new JTextField(20);
    JTextField updateCarTypeText = new JTextField(20);
    JTextField updateKmCarText = new JTextField(20);
    JComboBox<ComfortType> updateComfortTypeBox = new JComboBox<>(new Vector<>(carService.getComfortTypes()));
    JComboBox<Car> showCarsBox = new JComboBox<>(new Vector<>(carService.getCars()));


    JButton addCarButton = new JButton("Add new car");
    JButton modifyCarButton = new JButton("Modify car");
    JButton deleteCarButton = new JButton("Delete car");
    JButton addAdminButton = new JButton("Add new admin");
    JButton logOutButton = new JButton("Logout");
    JButton carsButton = new JButton("Cars");
    JButton resetButton = new JButton("Reset");
    JButton backButton = new JButton("Back");
    JButton registerButtonAdmin = new JButton("Register");
    JButton okSuccessButtonRegistrationAdmin = new JButton("Ok");
    JButton addCarButtonForUi = new JButton("Add car");
    JButton resetButtonCar = new JButton("Reset");
    JButton backButtonCar = new JButton("Back");
    JButton deleteCarButtonGui = new JButton("Delete");
    JButton backDeleteButton = new JButton("Back");
    JButton okDeletedCar = new JButton("Ok");
    JButton updateCar = new JButton("Update");
    JButton resetButtonUpdate = new JButton("Reset");
    JButton backUpdateButton = new JButton("Back");


    public AdminGui() {
        adminGui();


    }

    public void adminGui() {
        adminFrame.setTitle("Admin page.");
        adminFrame.setVisible(true);
        adminFrame.setSize(100, 100);
        adminFrame.setResizable(false);
        adminFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        adminFrame.setMinimumSize(new Dimension(500, 500));
        adminFrame.setMaximumSize(new Dimension(500, Integer.MAX_VALUE));
        adminFrame.add(adminPanel);

        adminPanel.setLayout(null);
        adminPanel.setBackground(new Color(0x99FF99));

        adminTitle.setBounds(170, 20, 150, 25);
        adminTitle.setFont(new Font("Serif", Font.PLAIN, 20));
        adminPanel.add(adminTitle);

        carsButton.setBounds(150, 100, 150, 25);
        adminPanel.add(carsButton);

        addCarButton.setBounds(150, 150, 150, 25);
        adminPanel.add(addCarButton);

        modifyCarButton.setBounds(150, 200, 150, 25);
        adminPanel.add(modifyCarButton);

        deleteCarButton.setBounds(150, 250, 150, 25);
        adminPanel.add(deleteCarButton);

        addAdminButton.setBounds(150, 300, 150, 25);
        adminPanel.add(addAdminButton);

        logOutButton.setBounds(150, 350, 150, 25);
        adminPanel.add(logOutButton);

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminFrame.setVisible(false);
                new CustomerAndLogInGui();
            }
        });

        addAdminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrationUiAdmin();
                adminFrame.setVisible(false);
            }
        });

        addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewCar();
                adminFrame.setVisible(false);
            }
        });

        deleteCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteCar();

            }
        });

        modifyCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCarGui();
                adminFrame.setVisible(false);
            }
        });

        carsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carList();

            }
        });

    }

    public void registrationUiAdmin() {
        adminRegisterFrame.setTitle("Registration Page.");
        adminRegisterFrame.setVisible(true);
        adminRegisterFrame.setSize(100, 100);
        adminRegisterFrame.setResizable(false);
        adminRegisterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminRegisterFrame.setMinimumSize(new Dimension(500, 500));
        adminRegisterFrame.setMaximumSize(new Dimension(500, Integer.MAX_VALUE));
        adminRegisterFrame.add(adminRegisterPanel);

        adminRegisterPanel.setLayout(null);

        userRegistrationLabelAdmin.setBounds(10, 20, 80, 25);
        adminRegisterPanel.add(userRegistrationLabelAdmin);

        passwordRegistrationLabelAdmin.setBounds(10, 50, 80, 25);
        adminRegisterPanel.add(passwordRegistrationLabelAdmin);

        numeLabelAdmin.setBounds(10, 80, 80, 25);
        adminRegisterPanel.add(numeLabelAdmin);

        prenumeLabelAdmin.setBounds(10, 110, 80, 25);
        adminRegisterPanel.add(prenumeLabelAdmin);

        telefonLabelAdmin.setBounds(10, 140, 80, 25);
        adminRegisterPanel.add(telefonLabelAdmin);

        emailLabelAdmin.setBounds(10, 170, 80, 25);
        adminRegisterPanel.add(emailLabelAdmin);

        adresaLabelAdmin.setBounds(10, 200, 80, 25);
        adminRegisterPanel.add(adresaLabelAdmin);

        usernameTextAdmin.setBounds(100, 20, 165, 25);
        adminRegisterPanel.add(usernameTextAdmin);

        passwordTextAdmin.setBounds(100, 50, 165, 25);
        adminRegisterPanel.add(passwordTextAdmin);

        numeTextAdmin.setBounds(100, 80, 165, 25);
        adminRegisterPanel.add(numeTextAdmin);

        prenumeTextAdmin.setBounds(100, 110, 165, 25);
        adminRegisterPanel.add(prenumeTextAdmin);

        telefonTextAdmin.setBounds(100, 140, 165, 25);
        adminRegisterPanel.add(telefonTextAdmin);

        emailTextAdmin.setBounds(100, 170, 165, 25);
        adminRegisterPanel.add(emailTextAdmin);

        adresaTextAdmin.setBounds(100, 200, 165, 25);
        adminRegisterPanel.add(adresaTextAdmin);

        registerButtonAdmin.setBounds(10, 300, 100, 25);
        adminRegisterPanel.add(registerButtonAdmin);

        resetButton.setBounds(110, 300, 100, 25);
        adminRegisterPanel.add(resetButton);

        backButton.setBounds(210, 300, 100, 25);
        adminRegisterPanel.add(backButton);

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usernameTextAdmin.setText("");
                passwordTextAdmin.setText("");
                numeTextAdmin.setText("");
                prenumeTextAdmin.setText("");
                telefonTextAdmin.setText("");
                emailTextAdmin.setText("");
                adresaTextAdmin.setText("");
            }
        });

        registerButtonAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextAdmin.getText();
                String password = passwordTextAdmin.getText();
                String nume = numeTextAdmin.getText();
                String prenume = prenumeTextAdmin.getText();
                String telefon = telefonTextAdmin.getText();
                String email = emailTextAdmin.getText();
                String adresa = adresaTextAdmin.getText();

                if (username != null && !username.isEmpty() && password != null && !password.isEmpty() && nume != null && !nume.isEmpty() && prenume != null
                        && !prenume.isEmpty() && telefon != null && !telefon.isEmpty() && email != null && !email.isEmpty() && adresa != null && !adresa.isEmpty()) {

                    savedAgent = userService.createAdmin(username, password, nume, prenume, telefon, email, adresa);
                    adminFrame.setVisible(true);
                    successRegisterAdmin();
                    System.out.println("New Admin!");

                    usernameTextAdmin.setText("");
                    passwordTextAdmin.setText("");
                    numeTextAdmin.setText("");
                    prenumeTextAdmin.setText("");
                    telefonTextAdmin.setText("");
                    emailTextAdmin.setText("");
                    adresaTextAdmin.setText("");
                } else {
                    JOptionPane.showMessageDialog(adminRegisterFrame, "Incomplete registration!", "Error", JOptionPane.ERROR_MESSAGE);
                    System.err.println("Incomplete registration!");
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminFrame.setVisible(true);
                adminRegisterFrame.setVisible(false);
            }
        });

    }


    public void successRegisterAdmin() {
        successFrameRegisterAdmin.setTitle("Success!");
        successFrameRegisterAdmin.setVisible(true);
        successFrameRegisterAdmin.setResizable(false);
        successFrameRegisterAdmin.setSize(300, 150);

        successFrameRegisterAdmin.add(successPanelRegisterAdmin);

        successPanelRegisterAdmin.setLayout(null);

        successLabelRegisterAdmin.setBounds(75, 25, 150, 20);
        successPanelRegisterAdmin.add(successLabelRegisterAdmin);

        okSuccessButtonRegistrationAdmin.setBounds(110, 55, 50, 20);
        successPanelRegisterAdmin.add(okSuccessButtonRegistrationAdmin);

        okSuccessButtonRegistrationAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminFrame.setVisible(true);
                adminRegisterFrame.setVisible(false);
                successFrameRegisterAdmin.setVisible(false);


            }
        });
    }

    public void addNewCar() {
        addCarFrame.setTitle("Add Car Page.");
        addCarFrame.setVisible(true);
        addCarFrame.setSize(100, 100);
        addCarFrame.setResizable(false);
        addCarFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addCarFrame.setMinimumSize(new Dimension(500, 500));
        addCarFrame.setMaximumSize(new Dimension(500, Integer.MAX_VALUE));
        addCarFrame.add(addCarPanel);

        addCarPanel.setLayout(null);

        makerLabel.setBounds(10, 20, 80, 25);
        addCarPanel.add(makerLabel);

        modelLabel.setBounds(10, 50, 80, 25);
        addCarPanel.add(modelLabel);

        carTypeLabel.setBounds(10, 80, 80, 25);
        addCarPanel.add(carTypeLabel);

        kmLabel.setBounds(10, 110, 80, 25);
        addCarPanel.add(kmLabel);

        confortTypeLabel.setBounds(10, 140, 80, 25);
        addCarPanel.add(confortTypeLabel);


        makerText.setBounds(100, 20, 165, 25);
        addCarPanel.add(makerText);

        modelText.setBounds(100, 50, 165, 25);
        addCarPanel.add(modelText);

        carTypeText.setBounds(100, 80, 165, 25);
        addCarPanel.add(carTypeText);

        kmText.setBounds(100, 110, 165, 25);
        addCarPanel.add(kmText);

        comfortTypeBox.setBounds(100, 140, 165, 25);
        comfortTypeBox.setSelectedIndex(-1);
        addCarPanel.add(comfortTypeBox);


        addCarButtonForUi.setBounds(10, 300, 100, 25);
        addCarPanel.add(addCarButtonForUi);

        resetButtonCar.setBounds(110, 300, 100, 25);
        addCarPanel.add(resetButtonCar);

        backButtonCar.setBounds(210, 300, 100, 25);
        addCarPanel.add(backButtonCar);

        resetButtonCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makerText.setText("");
                modelText.setText("");
                carTypeText.setText("");
                kmText.setText("");

            }
        });

        backButtonCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCarFrame.setVisible(false);
                adminFrame.setVisible(true);
            }
        });


        addCarButtonForUi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maker = makerText.getText();
                String model = modelText.getText();
                String carType = carTypeText.getText();
                String km = kmText.getText();
                ComfortType confortType = (ComfortType) comfortTypeBox.getSelectedItem();

                if (maker != null && !maker.isEmpty() && model != null && !model.isEmpty() && carType != null && !carType.isEmpty() && km != null
                        && !km.isEmpty() && comfortTypeBox != null) {

                    carService.createCar(maker, model, carType, km, confortType);
                    JOptionPane.showMessageDialog(addCarFrame, "New Car!");
                    System.out.println("New Car!");


                    makerText.setText("");
                    modelText.setText("");
                    carTypeText.setText("");
                    kmText.setText("");
                } else {
                    JOptionPane.showMessageDialog(addCarFrame, "Incomplete car!", "Error", JOptionPane.ERROR_MESSAGE);
                }


            }
        });

    }


    public void deleteCar() {
        deleteCarFrame.setTitle("Delete car");
        deleteCarFrame.setVisible(true);
        deleteCarFrame.setResizable(false);
        deleteCarFrame.setSize(300, 200);
        deleteCarFrame.add(deleteCarPanel);

        deleteCarPanel.setLayout(null);

        deleteCarLabel.setBounds(100, 25, 100, 25);
        deleteCarPanel.add(deleteCarLabel);

        deleteCarText.setBounds(100, 50, 70, 25);
        deleteCarText.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        deleteCarPanel.add(deleteCarText);

        deleteCarButtonGui.setBounds(50, 100, 75, 25);
        deleteCarPanel.add(deleteCarButtonGui);

        backDeleteButton.setBounds(150, 100, 75, 25);
        deleteCarPanel.add(backDeleteButton);

        backDeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteCarFrame.setVisible(false);

            }
        });

        deleteCarButtonGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String carId = deleteCarText.getText();

                if (carId != null && !carId.isEmpty()) {

                    carService.deleteCar(Integer.parseInt(carId));
                    System.out.println("Car deleted!");
                    successDeleteCar();
                } else {
                    JOptionPane.showMessageDialog(deleteCarFrame, "Enter car id!", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

    }

    public void successDeleteCar() {
        successDeleteCarFrame.setTitle("Success");
        successDeleteCarFrame.setVisible(true);
        successDeleteCarFrame.setResizable(false);
        successDeleteCarFrame.setSize(300, 150);
        successDeleteCarFrame.add(successDeleteCarPanel);

        successDeleteCarPanel.setLayout(null);

        successDeleteCarLabel.setBounds(110, 25, 150, 20);
        successDeleteCarPanel.add(successDeleteCarLabel);

        okDeletedCar.setBounds(115, 50, 50, 20);
        successDeleteCarPanel.add(okDeletedCar);

        okDeletedCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteCarFrame.setVisible(false);
                successDeleteCarFrame.setVisible(false);
                adminFrame.setVisible(true);
            }
        });

    }

    public void updateCarGui() {
        updateCarFrame.setTitle("Modify Car Page.");
        updateCarFrame.setVisible(true);
        updateCarFrame.setSize(100, 100);
        updateCarFrame.setResizable(false);
        updateCarFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        updateCarFrame.setMinimumSize(new Dimension(500, 500));
        updateCarFrame.setMaximumSize(new Dimension(500, Integer.MAX_VALUE));
        updateCarFrame.add(updateCarPanel);

        updateCarPanel.setLayout(null);

        showCarLabel.setBounds(10, 20, 80, 25);
        updateCarPanel.add(showCarLabel);

        updateIdCarLabel.setBounds(10, 50, 80, 25);
        updateCarPanel.add(updateIdCarLabel);

        updateMakerCarLabel.setBounds(10, 80, 80, 25);
        updateCarPanel.add(updateMakerCarLabel);

        updateModelCarLabel.setBounds(10, 110, 80, 25);
        updateCarPanel.add(updateModelCarLabel);

        updateCarTypeLabel.setBounds(10, 140, 80, 25);
        updateCarPanel.add(updateCarTypeLabel);

        updateKmLabel.setBounds(10, 170, 80, 25);
        updateCarPanel.add(updateKmLabel);

        updateComfortType.setBounds(10, 200, 80, 25);
        updateCarPanel.add(updateComfortType);

        showCarsBox.setBounds(100, 20, 230, 25);
        showCarsBox.setSelectedIndex(-1);
        updateCarPanel.add(showCarsBox);

        updateIdCarText.setBounds(100, 50, 165, 25);
        updateIdCarText.setEditable(false);
        updateCarPanel.add(updateIdCarText);

        updateMakerCarText.setBounds(100, 80, 165, 25);
        updateCarPanel.add(updateMakerCarText);

        updateModelCarText.setBounds(100, 110, 165, 25);
        updateCarPanel.add(updateModelCarText);

        updateCarTypeText.setBounds(100, 140, 165, 25);
        updateCarPanel.add(updateCarTypeText);

        updateKmCarText.setBounds(100, 170, 165, 25);
        updateCarPanel.add(updateKmCarText);

        updateComfortTypeBox.setBounds(100, 200, 165, 25);
        updateCarPanel.add(updateComfortTypeBox);

        updateCar.setBounds(10, 300, 100, 25);
        updateCarPanel.add(updateCar);

        resetButtonUpdate.setBounds(110, 300, 100, 25);
        updateCarPanel.add(resetButtonUpdate);

        backUpdateButton.setBounds(210, 300, 100, 25);
        updateCarPanel.add(backUpdateButton);

        backUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCarFrame.setVisible(false);
                adminFrame.setVisible(true);
            }
        });

        resetButtonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateIdCarText.setText("");
                updateMakerCarText.setText("");
                updateModelCarText.setText("");
                updateCarTypeText.setText("");
                updateKmCarText.setText("");

            }
        });

        updateCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Car car = (Car) showCarsBox.getSelectedItem();
                if (car != null) {
                    String maker = updateMakerCarText.getText();
                    String model = updateModelCarText.getText();
                    String carType = updateCarTypeText.getText();
                    String km = updateKmCarText.getText();
                    ComfortType comfortType = (ComfortType) updateComfortTypeBox.getSelectedItem();

                    car.setMaker(maker);
                    car.setCarModel(model);
                    car.setCarType(carType);
                    car.setKm(km);
                    car.setConfortType(comfortType);

                    if (maker != null && !maker.isEmpty() && model != null && !model.isEmpty() && carType != null && !carType.isEmpty() && km != null && !km.isEmpty()) {

                        carService.updateCar(car);
                        JOptionPane.showMessageDialog(updateCarFrame, "Updated Car!");
                        System.out.println("Updated Car!");

                        updateIdCarText.setText("");
                        updateMakerCarText.setText("");
                        updateModelCarText.setText("");
                        updateCarTypeText.setText("");
                        updateKmCarText.setText("");
                    } else {
                        JOptionPane.showMessageDialog(updateCarFrame, "Update failed!", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(updateCarFrame, "Update failed!", "Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Error!");
                }


            }
        });

        showCarsBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Car car = (Car) showCarsBox.getSelectedItem();
                if (car != null) {
                    updateIdCarText.setText(String.valueOf(car.getId()));
                    updateMakerCarText.setText(car.getMaker());
                    updateModelCarText.setText(car.getCarModel());
                    updateCarTypeText.setText(car.getCarType());
                    updateKmCarText.setText(car.getKm());


                } else {
                    JOptionPane.showMessageDialog(updateCarFrame, "Update failed!", "Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println("error");

                }

            }
        });
    }

    public void carList() {
        JFrame tableFrame = new JFrame();
        JPanel headerPanel = new JPanel();
        JPanel bodyPanel = new JPanel();
        JTable table = new JTable(100, 6);

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

        table.getColumnModel().getColumn(0).setHeaderValue("Id");
        table.getColumnModel().getColumn(1).setHeaderValue("Maker");
        table.getColumnModel().getColumn(2).setHeaderValue("Model");
        table.getColumnModel().getColumn(3).setHeaderValue("Car Type");
        table.getColumnModel().getColumn(4).setHeaderValue("Kilometers");
        table.getColumnModel().getColumn(5).setHeaderValue("Comfort Type");

        writeDataInTable();


    }

    public void writeDataInTable() {
        CarService carService = new CarService();
        List<Car> carList = carService.getCars();
        if (carList.size() > defaultTableModel.getRowCount()) {
            System.out.println("Not enough rows in the table");
        }
        for (int i = 0; i < carList.size(); i++) {
            defaultTableModel.setValueAt(carList.get(i).getId(), i, 0);
            defaultTableModel.setValueAt(carList.get(i).getMaker(), i, 1);
            defaultTableModel.setValueAt(carList.get(i).getCarModel(), i, 2);
            defaultTableModel.setValueAt(carList.get(i).getCarType(), i, 3);
            defaultTableModel.setValueAt(carList.get(i).getKm(), i, 4);
            defaultTableModel.setValueAt(carList.get(i).getConfortType(), i, 5);
        }
    }


    public static void main(String[] args) {
        new AdminGui();

    }
}
