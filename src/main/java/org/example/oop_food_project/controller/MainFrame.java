package org.example.oop_food_project.controller;

import org.example.oop_food_project.api.inputoutput.food.create.FoodCreateInput;
import org.example.oop_food_project.api.inputoutput.food.create.FoodCreateOperation;
import org.example.oop_food_project.api.inputoutput.food.getall.FoodGetAllInput;
import org.example.oop_food_project.api.inputoutput.food.getall.FoodGetAllOperation;
import org.example.oop_food_project.api.inputoutput.food.getbycaloriesover.FoodGetByCaloriesOverInput;
import org.example.oop_food_project.api.inputoutput.food.getbycaloriesover.FoodGetByCaloriesOverListOutput;
import org.example.oop_food_project.api.inputoutput.food.getbycaloriesover.FoodGetByCaloriesOverOperation;
import org.example.oop_food_project.api.inputoutput.food.getbycaloriesover.FoodGetByCaloriesOverOutput;
import org.example.oop_food_project.api.inputoutput.food.gethighfats.FoodGetWithHighFatsInput;
import org.example.oop_food_project.api.inputoutput.food.gethighfats.FoodGetWithHighFatsListOutput;
import org.example.oop_food_project.api.inputoutput.food.gethighfats.FoodGetWithHighFatsOperation;
import org.example.oop_food_project.api.inputoutput.food.gethighfats.FoodGetWithHighFatsOutput;
import org.example.oop_food_project.api.inputoutput.food.gethighprotein.FoodGetWithHighProteinInput;
import org.example.oop_food_project.api.inputoutput.food.gethighprotein.FoodGetWithHighProteinListOutput;
import org.example.oop_food_project.api.inputoutput.food.gethighprotein.FoodGetWithHighProteinOperation;
import org.example.oop_food_project.api.inputoutput.food.gethighprotein.FoodGetWithHighProteinOutput;
import org.example.oop_food_project.api.inputoutput.food.gethighvitamina.FoodGetWithHighVitaminAInput;
import org.example.oop_food_project.api.inputoutput.food.gethighvitamina.FoodGetWithHighVitaminAListOutput;
import org.example.oop_food_project.api.inputoutput.food.gethighvitamina.FoodGetWithHighVitaminAOperation;
import org.example.oop_food_project.api.inputoutput.food.gethighvitaminb1.FoodGetWithHighVitaminB1Input;
import org.example.oop_food_project.api.inputoutput.food.gethighvitaminb1.FoodGetWithHighVitaminB1ListOutput;
import org.example.oop_food_project.api.inputoutput.food.gethighvitaminb1.FoodGetWithHighVitaminB1Operation;
import org.example.oop_food_project.api.inputoutput.food.gethighvitaminb12.FoodGetWithHighVitaminB12Input;
import org.example.oop_food_project.api.inputoutput.food.gethighvitaminb12.FoodGetWithHighVitaminB12ListOutput;
import org.example.oop_food_project.api.inputoutput.food.gethighvitaminb12.FoodGetWithHighVitaminB12Operation;
import org.example.oop_food_project.api.inputoutput.food.gethighvitamins.FoodGetWithHighVitaminsInput;
import org.example.oop_food_project.api.inputoutput.food.gethighvitamins.FoodGetWithHighVitaminsListOutput;
import org.example.oop_food_project.api.inputoutput.food.gethighvitamins.FoodGetWithHighVitaminsOperation;
import org.example.oop_food_project.api.inputoutput.food.gethighvitamins.FoodGetWithHighVitaminsOutput;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.text.DecimalFormat;

@Component
public class MainFrame extends JFrame {
    private final FoodCreateOperation foodCreateOperation;
    private final FoodGetByCaloriesOverOperation foodGetByCaloriesOverOperation;
    private final FoodGetWithHighProteinOperation foodGetWithHighProteinOperation;
    private final FoodGetWithHighFatsOperation foodGetWithHighFatsOperation;
    private final FoodGetWithHighVitaminsOperation foodGetWithHighVitaminsOperation;
    private final FoodGetWithHighVitaminAOperation foodGetWithHighVitaminAOperation;
    private final FoodGetWithHighVitaminB1Operation foodGetWithHighVitaminB1Operation;
    private final FoodGetWithHighVitaminB12Operation foodGetWithHighVitaminB12Operation;
    private final FoodGetAllOperation foodGetAllOperation;
    private final CardLayout cardLayout;
    private final JPanel cardPanel;

    public MainFrame(FoodCreateOperation foodCreateOperation, FoodGetByCaloriesOverOperation foodGetByCaloriesOverOperation, FoodGetWithHighProteinOperation foodGetWithHighProteinOperation, FoodGetWithHighFatsOperation foodGetWithHighFatsOperation, FoodGetWithHighVitaminsOperation foodGetWithHighVitaminsOperation, FoodGetWithHighVitaminAOperation foodGetWithHighVitaminAOperation, FoodGetWithHighVitaminB1Operation foodGetWithHighVitaminB1Operation, FoodGetWithHighVitaminB12Operation foodGetWithHighVitaminB12Operation, FoodGetAllOperation foodGetAllOperation) {
        this.foodCreateOperation = foodCreateOperation;
        this.foodGetByCaloriesOverOperation = foodGetByCaloriesOverOperation;
        this.foodGetWithHighProteinOperation = foodGetWithHighProteinOperation;
        this.foodGetWithHighFatsOperation = foodGetWithHighFatsOperation;
        this.foodGetWithHighVitaminsOperation = foodGetWithHighVitaminsOperation;
        this.foodGetWithHighVitaminAOperation = foodGetWithHighVitaminAOperation;
        this.foodGetWithHighVitaminB1Operation = foodGetWithHighVitaminB1Operation;
        this.foodGetWithHighVitaminB12Operation = foodGetWithHighVitaminB12Operation;
        this.foodGetAllOperation = foodGetAllOperation;
        setTitle("Food Application");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        JPanel homeView = createHomeView();
        JPanel formView = createFormView();
        JPanel queryVitaminView = createQueryVitaminView();
        JPanel highNutrientView = createHighNutrientView();
        JPanel pieChartView = createPieChartView();

        cardPanel.add(homeView, "Home");
        cardPanel.add(formView, "Form");
        cardPanel.add(queryVitaminView, "QueryVitamin");
        cardPanel.add(highNutrientView, "HighNutrient");
        cardPanel.add(pieChartView, "PieChart");

        add(cardPanel);
        setVisible(true);
    }

    private JPanel createHomeView() {
        JPanel panel = new JPanel(new GridLayout(5, 1, 5, 5));
        JLabel label = new JLabel("Welcome to Food Application", SwingConstants.CENTER);
        JButton goToForm = new JButton("Go to Form");
        JButton goToQueryVitamin = new JButton("Query by Vitamin");
        JButton goToHighNutrient = new JButton("High Nutrient Foods");
        JButton goToPieChart = new JButton("Pie Chart Analysis");

        goToForm.addActionListener(e -> cardLayout.show(cardPanel, "Form"));
        goToQueryVitamin.addActionListener(e -> cardLayout.show(cardPanel, "QueryVitamin"));
        goToHighNutrient.addActionListener(e -> cardLayout.show(cardPanel, "HighNutrient"));
        goToPieChart.addActionListener(e -> cardLayout.show(cardPanel, "PieChart"));

        panel.add(label);
        panel.add(goToForm);
        panel.add(goToQueryVitamin);
        panel.add(goToHighNutrient);
        panel.add(goToPieChart);

        return panel;
    }

    private JPanel createFormView() {
        JPanel panel = new JPanel(new GridLayout(13, 2, 5, 5));

        JTextField product = new JTextField();
        JTextField productType = new JTextField();
        JTextField vitaminAiu = new JTextField();
        JTextField vitaminB1mg = new JTextField();
        JTextField vitaminB12mg = new JTextField();
        JTextField monounsaturatedFatsGrams = new JTextField();
        JTextField polyunsaturatedFatsGrams = new JTextField();
        JTextField saturatedFatsGrams = new JTextField();
        JTextField transFatsGrams = new JTextField();
        JTextField calories = new JTextField();
        JTextField proteinDescription = new JTextField();
        JButton sendButton = new JButton("Send");
        JButton backButton = new JButton("Back to Home");

        sendButton.addActionListener(e -> {
            try {
                foodCreateOperation.process(FoodCreateInput.builder()
                        .product(product.getText())
                        .productType(productType.getText())
                        .vitaminAiu(Integer.parseInt(vitaminAiu.getText()))
                        .vitaminB1mg(Integer.parseInt(vitaminB1mg.getText()))
                        .vitaminB12mg(Integer.parseInt(vitaminB12mg.getText()))
                        .monounsaturatedFatsGrams(Integer.parseInt(monounsaturatedFatsGrams.getText()))
                        .polyunsaturatedFatsGrams(Integer.parseInt(polyunsaturatedFatsGrams.getText()))
                        .saturatedFatsGrams(Integer.parseInt(saturatedFatsGrams.getText()))
                        .transFatsGrams(Integer.parseInt(transFatsGrams.getText()))
                        .calories(Integer.parseInt(calories.getText()))
                        .proteinAmount(Integer.parseInt(proteinDescription.getText()))
                        .build());
                JOptionPane.showMessageDialog(this, "Food entry submitted successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Submission failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        backButton.addActionListener(e -> cardLayout.show(cardPanel, "Home"));

        panel.add(new JLabel("Product:"));
        panel.add(product);
        panel.add(new JLabel("Product Type:"));
        panel.add(productType);
        panel.add(new JLabel("Vitamin A (IU):"));
        panel.add(vitaminAiu);
        panel.add(new JLabel("Vitamin B1 (mg):"));
        panel.add(vitaminB1mg);
        panel.add(new JLabel("Vitamin B12 (mg):"));
        panel.add(vitaminB12mg);
        panel.add(new JLabel("Monounsaturated Fats (g):"));
        panel.add(monounsaturatedFatsGrams);
        panel.add(new JLabel("Polyunsaturated Fats (g):"));
        panel.add(polyunsaturatedFatsGrams);
        panel.add(new JLabel("Saturated Fats (g):"));
        panel.add(saturatedFatsGrams);
        panel.add(new JLabel("Trans Fats (g):"));
        panel.add(transFatsGrams);
        panel.add(new JLabel("Calories:"));
        panel.add(calories);
        panel.add(new JLabel("Proteins:"));
        panel.add(proteinDescription);
        panel.add(sendButton);
        panel.add(backButton);

        return panel;
    }

    private enum VitaminQueryType {
        VITAMIN_A, VITAMIN_B1, VITAMIN_B12
    }

    private Object currentVitaminQueryResults;
    private VitaminQueryType currentVitaminQueryType;

    private void updateVitaminDescriptionField(JTextArea descField, Object queryResult, VitaminQueryType queryType, int selectedIndex) {
        try {
            switch (queryType) {
                case VITAMIN_A:
                    var vitaminAFood = ((FoodGetWithHighVitaminAListOutput)queryResult).getFood().get(selectedIndex);
                    displayVitaminFoodDetails(descField, vitaminAFood);
                    break;

                case VITAMIN_B1:
                    var vitaminB1Food = ((FoodGetWithHighVitaminB1ListOutput)queryResult).getFood().get(selectedIndex);
                    displayVitaminFoodDetails(descField, vitaminB1Food);
                    break;

                case VITAMIN_B12:
                    var vitaminB12Food = ((FoodGetWithHighVitaminB12ListOutput)queryResult).getFood().get(selectedIndex);
                    displayVitaminFoodDetails(descField, vitaminB12Food);
                    break;
            }
        } catch (Exception ex) {
            descField.setText("Error displaying food details: " + ex.getMessage());
        }
    }
    private void displayVitaminFoodDetails(JTextArea descField, Object food) {
        // Create a condensed display of food information for the text field
        descField.setText(
                "Product: " + getFieldValue(food, "getProduct") + "\n" +
                        "Type: " + getFieldValue(food, "getProductType") + "\n" +
                        "Calories: " + getFieldValue(food, "getCalories") + "\n" +
                        "Vitamin A (IU): " + getFieldValue(food, "getVitaminAiu") + "\n" +
                        "Vitamin B1 (mg): " + getFieldValue(food, "getVitaminB1mg") + "\n" +
                        "Vitamin B12 (mg): " + getFieldValue(food, "getVitaminB12mg") + "\n" +
                        "Monounsaturated Fats (g): " + getFieldValue(food, "getMonounsaturatedFatsGrams") + "\n" +
                        "Polyunsaturated Fats (g): " + getFieldValue(food, "getPolyunsaturatedFatsGrams") + "\n" +
                        "Saturated Fats (g): " + getFieldValue(food, "getSaturatedFatsGrams") + "\n" +
                        "Trans Fats (g): " + getFieldValue(food, "getTransFatsGrams") + "\n" +
                        "Proteins: " + getFieldValue(food, "getProteinsAmount")
        );
    }

    private JPanel createQueryVitaminView() {
        JPanel panel = new JPanel(new BorderLayout());
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> foodList = new JList<>(listModel);
        JTextArea descriptionField = new JTextArea();
        descriptionField.setEditable(false);

        JButton queryVitaminA = new JButton("Query Vitamin A");
        JButton queryVitaminB1 = new JButton("Query Vitamin B1");
        JButton queryVitaminB12 = new JButton("Query Vitamin B12");
        JButton backButton = new JButton("Back to Home");

        queryVitaminA.addActionListener(e -> {
            try {
                var output = foodGetWithHighVitaminAOperation.process(FoodGetWithHighVitaminAInput.builder().build());

                // Store the results and update the query type
                currentVitaminQueryResults = output;
                currentVitaminQueryType = VitaminQueryType.VITAMIN_A;

                listModel.clear();
                for (var food : output.getFood()) {
                    listModel.addElement(food.getProduct());
                }
                if (listModel.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "No foods high in Vitamin A found.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error fetching data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        queryVitaminB1.addActionListener(e -> {
            try {
                var output = foodGetWithHighVitaminB1Operation.process(FoodGetWithHighVitaminB1Input.builder().build());

                // Store the results and update the query type
                currentVitaminQueryResults = output;
                currentVitaminQueryType = VitaminQueryType.VITAMIN_B1;

                listModel.clear();
                for (var food : output.getFood()) {
                    listModel.addElement(food.getProduct());
                }
                if (listModel.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "No foods high in Vitamin B1 found.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error fetching data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        queryVitaminB12.addActionListener(e -> {
            try {
                var output = foodGetWithHighVitaminB12Operation.process(FoodGetWithHighVitaminB12Input.builder().build());

                // Store the results and update the query type
                currentVitaminQueryResults = output;
                currentVitaminQueryType = VitaminQueryType.VITAMIN_B12;

                listModel.clear();
                for (var food : output.getFood()) {
                    listModel.addElement(food.getProduct());
                }
                if (listModel.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "No foods high in Vitamin B12 found.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error fetching data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Generic list selection listener to handle all vitamin query types
        foodList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedIndex = foodList.getSelectedIndex();
                if (selectedIndex != -1 && currentVitaminQueryResults != null) {
                    updateVitaminDescriptionField(descriptionField, currentVitaminQueryResults, currentVitaminQueryType, selectedIndex);
                }
            }
        });

        backButton.addActionListener(e -> cardLayout.show(cardPanel, "Home"));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(queryVitaminA);
        buttonPanel.add(queryVitaminB1);
        buttonPanel.add(queryVitaminB12);
        buttonPanel.add(backButton);

        panel.add(new JScrollPane(foodList), BorderLayout.CENTER);
        panel.add(descriptionField, BorderLayout.SOUTH);
        panel.add(buttonPanel, BorderLayout.NORTH);

        return panel;
    }

    private JPanel createHighNutrientView() {
        JPanel panel = new JPanel(new BorderLayout());

        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> foodList = new JList<>(listModel);
        JTextArea descriptionArea = new JTextArea(5, 30);
        descriptionArea.setEditable(false);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);

        // Store the current query results and type
        // Using array references so they can be effectively final for use in lambda expressions
        final Object[] currentQueryResults = new Object[1];
        final QueryType[] currentQueryType = new QueryType[1];

        JButton queryHighProtein = new JButton("High Protein Foods");
        JButton queryHighFats = new JButton("High Fats Foods");
        JButton queryHighCalories = new JButton("High Calories Foods");
        JButton queryHighVitamins = new JButton("High Vitamins Foods");
        JButton backButton = new JButton("Back to Home");

        backButton.addActionListener(e -> cardLayout.show(cardPanel, "Home"));

        queryHighProtein.addActionListener(e -> {
            try {
                FoodGetWithHighProteinListOutput food = foodGetWithHighProteinOperation.process(FoodGetWithHighProteinInput.builder().build());

                // Store the results and update the query type
                currentQueryResults[0] = food;
                currentQueryType[0] = QueryType.PROTEIN;

                listModel.clear();
                for (FoodGetWithHighProteinOutput foodItem : food.getFood()) {
                    listModel.addElement(foodItem.getProduct());
                }
                if (listModel.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "No high-protein foods found.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error fetching data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        queryHighFats.addActionListener(e -> {
            try {
                FoodGetWithHighFatsListOutput food = foodGetWithHighFatsOperation.process(FoodGetWithHighFatsInput.builder().build());

                // Store the results and update the query type
                currentQueryResults[0] = food;
                currentQueryType[0] = QueryType.FATS;

                listModel.clear();
                for (FoodGetWithHighFatsOutput foodItem : food.getFood()) {
                    listModel.addElement(foodItem.getProduct());
                }
                if (listModel.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "No high-fats found.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error fetching data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        queryHighCalories.addActionListener(e -> {
            try {
                var output = foodGetByCaloriesOverOperation.process(FoodGetByCaloriesOverInput.builder().build());

                // Store the results and update the query type
                currentQueryResults[0] = output;
                currentQueryType[0] = QueryType.CALORIES;

                listModel.clear();
                for (var food : output.getFood()) {
                    listModel.addElement(food.getProduct());
                }
                if (listModel.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "No high-calorie foods found.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error fetching data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        queryHighVitamins.addActionListener(e -> {
            try {
                FoodGetWithHighVitaminsListOutput food = foodGetWithHighVitaminsOperation.process(FoodGetWithHighVitaminsInput.builder().build());

                // Store the results and update the query type
                currentQueryResults[0] = food;
                currentQueryType[0] = QueryType.VITAMINS;

                listModel.clear();
                for (FoodGetWithHighVitaminsOutput foodItem : food.getFood()) {
                    listModel.addElement(foodItem.getProduct());
                }
                if (listModel.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "No high-vitamin found.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error fetching data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Generic list selection listener to handle all query types
        foodList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedIndex = foodList.getSelectedIndex();
                if (selectedIndex != -1 && currentQueryResults[0] != null) {
                    updateDescriptionArea(descriptionArea, currentQueryResults[0], currentQueryType[0], selectedIndex);
                }
            }
        });

        // Layout components
        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 5, 5));
        buttonPanel.add(queryHighProtein);
        buttonPanel.add(queryHighFats);
        buttonPanel.add(queryHighCalories);
        buttonPanel.add(queryHighVitamins);
        buttonPanel.add(backButton);

        panel.add(new JScrollPane(foodList), BorderLayout.WEST);
        panel.add(new JScrollPane(descriptionArea), BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.EAST);

        return panel;
    }

//    private JPanel createPieChartView() {
//        JPanel panel = new JPanel(new BorderLayout());
//        JButton backButton = new JButton("Back to Home");
//        backButton.addActionListener(e -> cardLayout.show(cardPanel, "Home"));
//
//        JPanel chartPanel = new JPanel();
//        chartPanel.setBackground(Color.WHITE);
//        // Here you would add your pie chart implementation
//
//        JPanel buttonPanel = new JPanel();
//        buttonPanel.add(backButton);
//
//        panel.add(chartPanel, BorderLayout.CENTER);
//        panel.add(buttonPanel, BorderLayout.SOUTH);
//
//        return panel;
//    }

    // Enum to track the type of the last executed query
    private enum QueryType {
        PROTEIN, FATS, CALORIES, VITAMINS
    }

    // Helper method to update the description area based on the query type and selected index
    private void updateDescriptionArea(JTextArea descArea, Object queryResult, QueryType queryType, int selectedIndex) {
        try {
            switch (queryType) {
                case PROTEIN:
                    FoodGetWithHighProteinOutput proteinFood = ((FoodGetWithHighProteinListOutput)queryResult).getFood().get(selectedIndex);
                    displayFoodDetails(descArea, proteinFood);
                    break;

                case FATS:
                    FoodGetWithHighFatsOutput fatFood = ((FoodGetWithHighFatsListOutput)queryResult).getFood().get(selectedIndex);
                    displayFoodDetails(descArea, fatFood);
                    break;

                case CALORIES:
                    FoodGetByCaloriesOverOutput calorieFood = ((FoodGetByCaloriesOverListOutput)queryResult).getFood().get(selectedIndex);
                    displayFoodDetails(descArea, calorieFood);
                    break;

                case VITAMINS:
                    FoodGetWithHighVitaminsOutput vitaminFood = ((FoodGetWithHighVitaminsListOutput)queryResult).getFood().get(selectedIndex);
                    displayFoodDetails(descArea, vitaminFood);
                    break;
            }
        } catch (Exception ex) {
            descArea.setText("Error displaying food details: " + ex.getMessage());
        }
    }

    // Helper method to display food details regardless of type
    private void displayFoodDetails(JTextArea descArea, Object food) {
        // Use reflection or direct field access based on common fields
        descArea.setText(
                "Product: " + getFieldValue(food, "getProduct") + "\n" +
                        "Type: " + getFieldValue(food, "getProductType") + "\n" +
                        "Calories: " + getFieldValue(food, "getCalories") + "\n" +
                        "Vitamin A (IU): " + getFieldValue(food, "getVitaminAiu") + "\n" +
                        "Vitamin B1 (mg): " + getFieldValue(food, "getVitaminB1mg") + "\n" +
                        "Vitamin B12 (mg): " + getFieldValue(food, "getVitaminB12mg") + "\n" +
                        "Monounsaturated Fats (g): " + getFieldValue(food, "getMonounsaturatedFatsGrams") + "\n" +
                        "Polyunsaturated Fats (g): " + getFieldValue(food, "getPolyunsaturatedFatsGrams") + "\n" +
                        "Saturated Fats (g): " + getFieldValue(food, "getSaturatedFatsGrams") + "\n" +
                        "Trans Fats (g): " + getFieldValue(food, "getTransFatsGrams") + "\n" +
                        "Proteins: " + getFieldValue(food, "getProteinsAmount")
        );
    }

    // Helper method to safely retrieve field values using reflection
    private String getFieldValue(Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);
            Object result = method.invoke(obj);
            return result != null ? result.toString() : "N/A";
        } catch (Exception e) {
            return "N/A"; // Return N/A if the method doesn't exist or throws an exception
        }
    }





    private JPanel createPieChartView() {
        JPanel panel = new JPanel(new BorderLayout());

        // Create panels for the layout
        JPanel leftPanel = new JPanel(new BorderLayout());
        JPanel chartPanel = new JPanel(new BorderLayout());
        chartPanel.setBackground(Color.WHITE);

        // Create list model and list for food items
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> foodList = new JList<>(listModel);

        // Create the back button
        JButton backButton = new JButton("Back to Home");
        backButton.addActionListener(e -> cardLayout.show(cardPanel, "Home"));

        // Create radio buttons for different chart types
        JRadioButton macronutrientsButton = new JRadioButton("Macronutrients");
        JRadioButton fatsButton = new JRadioButton("Types of Fats");
        JRadioButton vitaminsButton = new JRadioButton("Vitamins");

        // Group the radio buttons
        ButtonGroup chartTypeGroup = new ButtonGroup();
        chartTypeGroup.add(macronutrientsButton);
        chartTypeGroup.add(fatsButton);
        chartTypeGroup.add(vitaminsButton);
        macronutrientsButton.setSelected(true); // Default selection

        // Create a panel for the radio buttons
        JPanel radioPanel = new JPanel();
        radioPanel.add(macronutrientsButton);
        radioPanel.add(fatsButton);
        radioPanel.add(vitaminsButton);

        // Load all food items when this view is created
        try {
            var allFoods = foodGetAllOperation.process(FoodGetAllInput.builder().build());

            // Populate the list model
            for (var food : allFoods.getFood()) {
                listModel.addElement(food.getProduct());
            }

            // Add listener to handle selection of food items
            foodList.addListSelectionListener(e -> {
                if (!e.getValueIsAdjusting()) {
                    int selectedIndex = foodList.getSelectedIndex();
                    if (selectedIndex != -1) {
                        var selectedFood = allFoods.getFood().get(selectedIndex);
                        updatePieChart(chartPanel, selectedFood, getCurrentChartType(macronutrientsButton, fatsButton, vitaminsButton));
                    }
                }
            });

            // Add listeners to radio buttons to update the chart when selection changes
            ActionListener radioListener = e -> {
                int selectedIndex = foodList.getSelectedIndex();
                if (selectedIndex != -1) {
                    var selectedFood = allFoods.getFood().get(selectedIndex);
                    updatePieChart(chartPanel, selectedFood, getCurrentChartType(macronutrientsButton, fatsButton, vitaminsButton));
                }
            };

            macronutrientsButton.addActionListener(radioListener);
            fatsButton.addActionListener(radioListener);
            vitaminsButton.addActionListener(radioListener);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(panel, "Error loading food data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Add components to panels
        leftPanel.add(new JScrollPane(foodList), BorderLayout.CENTER);
        leftPanel.add(radioPanel, BorderLayout.SOUTH);

        // Add panels to main panel
        panel.add(leftPanel, BorderLayout.WEST);
        panel.add(chartPanel, BorderLayout.CENTER);
        panel.add(backButton, BorderLayout.SOUTH);

        return panel;
    }

    // Enum to track the type of chart to display
    private enum ChartType {
        MACRONUTRIENTS, FATS, VITAMINS
    }

    // Helper method to determine the current chart type from radio buttons
    private ChartType getCurrentChartType(JRadioButton macronutrientsButton, JRadioButton fatsButton, JRadioButton vitaminsButton) {
        if (fatsButton.isSelected()) {
            return ChartType.FATS;
        } else if (vitaminsButton.isSelected()) {
            return ChartType.VITAMINS;
        } else {
            return ChartType.MACRONUTRIENTS; // Default
        }
    }

    //TODO fix pie chart view
    private void updatePieChart(JPanel chartPanel, Object foodItem, ChartType chartType) {
        // Clear the chart panel
        chartPanel.removeAll();

        // Create the dataset for the pie chart
        DefaultPieDataset dataset = new DefaultPieDataset();

        switch (chartType) {
            case MACRONUTRIENTS:
                // Get protein, carb, and fat values (assuming they exist in the food item)
                double proteins = getNumericValue(foodItem, "getProteinsAmount", 0);
                double carbs = getNumericValue(foodItem, "getCarbsAmount", 0);
                double totalFat = getNumericValue(foodItem, "getTotalFat", 0);

                // Add data to the dataset
                if (proteins > 0) dataset.setValue("Proteins", proteins);
                if (carbs > 0) dataset.setValue("Carbohydrates", carbs);
                if (totalFat > 0) dataset.setValue("Fats", totalFat);
                break;

            case FATS:
                // Get different fat types
                double saturated = getNumericValue(foodItem, "getSaturatedFatsGrams", 0);
                double monounsaturated = getNumericValue(foodItem, "getMonounsaturatedFatsGrams", 0);
                double polyunsaturated = getNumericValue(foodItem, "getPolyunsaturatedFatsGrams", 0);
                double trans = getNumericValue(foodItem, "getTransFatsGrams", 0);

                // Add data to the dataset
                if (saturated > 0) dataset.setValue("Saturated Fats", saturated);
                if (monounsaturated > 0) dataset.setValue("Monounsaturated Fats", monounsaturated);
                if (polyunsaturated > 0) dataset.setValue("Polyunsaturated Fats", polyunsaturated);
                if (trans > 0) dataset.setValue("Trans Fats", trans);
                break;

            case VITAMINS:
                // Get vitamin values
                double vitaminA = getNumericValue(foodItem, "getVitaminAiu", 0);
                double vitaminB1 = getNumericValue(foodItem, "getVitaminB1mg", 0);
                double vitaminB12 = getNumericValue(foodItem, "getVitaminB12mg", 0);

                // Normalize vitamin values (since they use different units)
                // Convert to percentage of daily value or another common scale

                // For example, using arbitrary normalizing factors for demonstration:
                double vitaminANormalized = vitaminA / 5000.0 * 100; // Assuming 5000 IU is 100% daily value
                double vitaminB1Normalized = vitaminB1 / 1.2 * 100;  // Assuming 1.2 mg is 100% daily value
                double vitaminB12Normalized = vitaminB12 / 2.4 * 100; // Assuming 2.4 mcg is 100% daily value

                // Add data to the dataset
                if (vitaminANormalized > 0) dataset.setValue("Vitamin A", vitaminANormalized);
                if (vitaminB1Normalized > 0) dataset.setValue("Vitamin B1", vitaminB1Normalized);
                if (vitaminB12Normalized > 0) dataset.setValue("Vitamin B12", vitaminB12Normalized);
                break;
        }

        // Create the chart
        String title = "Nutritional Composition: " + getFieldValue(foodItem, "getProduct");
        JFreeChart chart = ChartFactory.createPieChart(
                title,       // chart title
                dataset,     // data
                true,        // include legend
                true,        // tooltips
                false        // URLs
        );

        // Customize the chart
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setNoDataMessage("No data available");
        plot.setCircular(true);
        plot.setLabelGap(0.02);

        // Add value labels to the pie slices
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
                "{0}: {1} ({2})",  // Format: Category: Value (Percentage)
                new DecimalFormat("0.##"),  // Value format - display with up to 2 decimal places
                new DecimalFormat("0.0%")   // Percentage format - display with 1 decimal place
        ));

        // Enable labels if there's data
        plot.setLabelOutlinePaint(null);  // Remove label outline
        plot.setLabelShadowPaint(null);   // Remove label shadow
        plot.setLabelBackgroundPaint(new Color(255, 255, 255, 180));  // Semi-transparent white background
        plot.setLabelPaint(Color.BLACK);  // Black text

        // Create a panel containing the chart
        ChartPanel cp = new ChartPanel(chart);
        cp.setPreferredSize(new Dimension(500, 300));

        // Add the chart panel to the main chart panel
        chartPanel.add(cp, BorderLayout.CENTER);

        // Add a label showing the measurement units
        JLabel unitsLabel = new JLabel(getUnitsLabel(chartType));
        unitsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        chartPanel.add(unitsLabel, BorderLayout.SOUTH);

        // Refresh the panel
        chartPanel.revalidate();
        chartPanel.repaint();
    }

    // Helper method to get a numeric value from a method call, with default if it fails
    private double getNumericValue(Object obj, String methodName, double defaultValue) {
        try {
            Method method = obj.getClass().getMethod(methodName);
            Object result = method.invoke(obj);
            if (result instanceof Number) {
                return ((Number) result).doubleValue();
            } else if (result != null) {
                return Double.parseDouble(result.toString());
            }
        } catch (Exception e) {
            // Method doesn't exist or returned null or non-numeric value
        }
        return defaultValue;
    }

    // Helper method to get appropriate units label based on chart type
    private String getUnitsLabel(ChartType chartType) {
        return switch (chartType) {
            case MACRONUTRIENTS, FATS -> "Units: grams (g)";
            case VITAMINS -> "Units: % of Daily Value";
            default -> "";
        };
    }

}