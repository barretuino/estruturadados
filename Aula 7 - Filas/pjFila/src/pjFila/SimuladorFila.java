package pjFila;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SimuladorFila extends JFrame {
	private static final long serialVersionUID = 1L;
	private Fila<String> fila;
	private FilaPanel filaPanel;
	private JTextField txtElemento;
	private JLabel lblStatus;

	public SimuladorFila() {
		super("Simulador de Fila");
		fila = new Fila<>(10); // Capacidade da fila

		// Configurações da janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout(10, 10));

		// Painel para a visualização da fila
		filaPanel = new FilaPanel(fila);
		add(filaPanel, BorderLayout.CENTER);

		// Painel de controle (botões e campo de texto)
		JPanel painelControle = new JPanel();
		painelControle.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		txtElemento = new JTextField(10);
		JButton btnEnqueue = new JButton("Enqueue");
		JButton btnDequeue = new JButton("Dequeue");
		JButton btnPeek = new JButton("Peek");

		lblStatus = new JLabel("Status: Fila pronta.");
		lblStatus.setFont(new Font("Arial", Font.ITALIC, 12));

		painelControle.add(new JLabel("Elemento:"));
		painelControle.add(txtElemento);
		painelControle.add(btnEnqueue);
		painelControle.add(btnDequeue);
		painelControle.add(btnPeek);

		add(painelControle, BorderLayout.NORTH);
		add(lblStatus, BorderLayout.SOUTH);

		// Ações dos botões
		btnEnqueue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String elemento = txtElemento.getText().trim();
				if (!elemento.isEmpty()) {
					if (fila.enqueue(elemento)) {
						lblStatus.setText("Status: " + elemento + " enfileirado com sucesso.");
					} else {
						lblStatus.setText("Status: Erro! Fila cheia.");
					}
					txtElemento.setText(""); // Limpa o campo de texto
					filaPanel.repaint(); // Redesenha o painel
				} else {
					lblStatus.setText("Status: Por favor, insira um elemento.");
				}
			}
		});

		btnDequeue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String elemento = fila.dequeue();
				if (elemento != null) {
					lblStatus.setText("Status: " + elemento + " desenfileirado com sucesso.");
				} else {
					lblStatus.setText("Status: Erro! Fila vazia.");
				}
				filaPanel.repaint();
			}
		});

		btnPeek.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String elemento = fila.peek();
				if (elemento != null) {
					lblStatus.setText("Status: Próximo elemento é " + elemento);
				} else {
					lblStatus.setText("Status: Fila vazia.");
				}
			}
		});

		pack(); // Ajusta o tamanho da janela
		setLocationRelativeTo(null); // Centraliza a janela na tela
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new SimuladorFila().setVisible(true);
		});
	}
}