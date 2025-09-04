package pkAula5Duplamente;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Simulador de lista duplamente ligada
 * @autor Prof. Ms. Paulo Barreto
 * @data 04/09/2025
 */
public class LinkedListVisualizer extends JPanel {
	private static final long serialVersionUID = 1L;
	private DoublyLinkedList list;
	private static final int NODE_WIDTH = 60;
	private static final int NODE_HEIGHT = 40;
	private static final int HORIZONTAL_GAP = 50;

	public LinkedListVisualizer(DoublyLinkedList list) {
		this.list = list;
		setPreferredSize(new Dimension(820, 200));
		setBackground(Color.WHITE);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setFont(new Font("Arial", Font.BOLD, 14));

		Node current = list.head;
		int x = 50;
		int y = 50;

		// Desenha os nós
		while (current != null) {
			// Desenha o retângulo do nó
			g2d.setColor(new Color(173, 216, 230)); // Azul claro
			g2d.fillRect(x, y, NODE_WIDTH, NODE_HEIGHT);
			g2d.setColor(Color.BLACK);
			g2d.drawRect(x, y, NODE_WIDTH, NODE_HEIGHT);

			// Desenha o valor do dado
			String dataStr = String.valueOf(current.data);
			FontMetrics fm = g2d.getFontMetrics();
			int stringWidth = fm.stringWidth(dataStr);
			int stringHeight = fm.getAscent();
			g2d.drawString(dataStr, x + (NODE_WIDTH - stringWidth) / 2, y + (NODE_HEIGHT + stringHeight) / 2 - 2);

			// Desenha as setas para a próxima ligação
			if (current.next != null) {
				int startX = x + NODE_WIDTH;
				int startY = y + NODE_HEIGHT / 4;
				int endX = x + NODE_WIDTH + HORIZONTAL_GAP;
				int endY = y + NODE_HEIGHT / 4;
				drawArrow(g2d, startX, startY, endX, endY);
			} else {
				// Se for o último nó, mostra que ele aponta para null
				g2d.drawString("null", x + NODE_WIDTH + 5, y + NODE_HEIGHT / 4 + 5);
			}

			// Desenha as setas para a ligação anterior
			if (current.prev != null) {
				int startX = x;
				int startY = y + 3 * NODE_HEIGHT / 4;
				int endX = x - HORIZONTAL_GAP;
				int endY = y + 3 * NODE_HEIGHT / 4;
				drawArrow(g2d, startX, startY, endX, endY);
			} else {
				// Se for o primeiro nó, mostra que ele aponta para null
				g2d.drawString("null", x - 30, y + 3 * NODE_HEIGHT / 4 + 5);
			}

			// Move para a próxima posição
			current = current.next;
			x += NODE_WIDTH + HORIZONTAL_GAP;
		}
	}

	// Método auxiliar para desenhar uma seta
	private void drawArrow(Graphics2D g2d, int x1, int y1, int x2, int y2) {
		g2d.setColor(Color.BLUE);
		g2d.setStroke(new BasicStroke(2));
		g2d.draw(new Line2D.Double(x1, y1, x2, y2));

		// Desenha a ponta da seta
		int dx = x2 - x1;
		int dy = y2 - y1;
		double angle = Math.atan2(dy, dx);
		int arrowSize = 6;
		g2d.fillPolygon(new int[]{x2, x2 - (int) (arrowSize * Math.cos(angle - Math.PI / 4)),
				x2 - (int) (arrowSize * Math.cos(angle + Math.PI / 4))},
				new int[]{y2, y2 - (int) (arrowSize * Math.sin(angle - Math.PI / 4)),
						y2 - (int) (arrowSize * Math.sin(angle + Math.PI / 4))}, 3);
	}

	// Método principal para executar a visualização
	public static void main(String[] args) {
		// Cria a lista duplamente ligada e adiciona elementos
		DoublyLinkedList list = new DoublyLinkedList();
		list.addEnd(10);
		list.addEnd(20);
		list.addEnd(30);
		list.addEnd(40);
		list.addEnd(50);
		list.addEnd(60);
		list.addEnd(70);

		// Cria a janela e o visualizador
		JFrame frame = new JFrame("Visualização de Lista Duplamente Ligada");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new LinkedListVisualizer(list));
		frame.pack();
		frame.setLocationRelativeTo(null); // Centraliza a janela
		frame.setVisible(true);
	}
}
