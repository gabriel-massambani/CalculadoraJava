import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calc extends JFrame implements ActionListener {

    private JTextField num1Field, num2Field, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton;

    public calc() {
        // Configurar o JFrame
        setTitle("Calculadora");
        setSize(300, 150); // Reduzi a altura para acomodar os botões ao lado
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Usar um FlowLayout com orientação horizontal para os botões ficarem ao lado um do outro
        setLayout(new FlowLayout(FlowLayout.CENTER));

        // Campos de texto com tamanho reduzido
        num1Field = new JTextField(5); // Defina o tamanho desejado
        num2Field = new JTextField(5); // Defina o tamanho desejado
        resultField = new JTextField(10); // Defina o tamanho desejado
        resultField.setEditable(false);

        // Botões
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("x");
        divideButton = new JButton("÷");

        // Adicionar ActionListener aos botões
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);

        // Adicionar componentes ao JFrame
        add(new JLabel("Número 1:"));
        add(num1Field);
        add(new JLabel("Número 2:"));
        add(num2Field);
        add(new JLabel("Resultado:"));
        add(resultField);
        
        // Adicionar os botões um ao lado do outro
        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(divideButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0.0;

            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subtractButton) {
                result = num1 - num2;
            } else if (e.getSource() == multiplyButton) {
                result = num1 * num2;
            } else if (e.getSource() == divideButton) {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    JOptionPane.showMessageDialog(this, "Divisão por zero não é permitida.");
                }
            }

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite números válidos.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            calc calculator = new calc();
            calculator.setVisible(true);
        });
    }
}
