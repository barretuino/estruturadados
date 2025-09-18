package pjFila;

import javax.swing.*;
import java.awt.*;

public class FilaPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Fila<String> fila;
	private final int LARGURA_BLOCO = 80;
	private final int ALTURA_BLOCO = 40;
	private final int MARGEM = 10;

	public FilaPanel(Fila<String> fila) {
		this.fila = fila;
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(800, 100));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setFont(new Font("Arial", Font.BOLD, 14));

		Object[] elementos = fila.toArray();
		int x = MARGEM;
		int y = getHeight() / 2 - ALTURA_BLOCO / 2;

		if (elementos.length == 0) {
			g2d.setColor(Color.GRAY);
			g2d.drawString("Fila Vazia", x, y + ALTURA_BLOCO);
		} else {
			for (int i = 0; i < elementos.length; i++) {
				// Desenha a borda do bloco
				g2d.setColor(Color.BLUE);
				g2d.setStroke(new BasicStroke(2));
				g2d.drawRect(x, y, LARGURA_BLOCO, ALTURA_BLOCO);

				// Desenha o preenchimento do bloco
				g2d.setColor(new Color(173, 216, 230)); // Azul claro
				g2d.fillRect(x + 1, y + 1, LARGURA_BLOCO - 2, ALTURA_BLOCO - 2);

				// Desenha o texto do elemento
				g2d.setColor(Color.BLACK);
				String elemento = (String) elementos[i];
				FontMetrics fm = g2d.getFontMetrics();
				int textX = x + (LARGURA_BLOCO - fm.stringWidth(elemento)) / 2;
				int textY = y + (fm.getAscent() + (ALTURA_BLOCO - fm.getHeight())) / 2;
				g2d.drawString(elemento, textX, textY);

				// Mostra o índice da posição
				g2d.setColor(Color.DARK_GRAY);
				g2d.setFont(new Font("Arial", Font.PLAIN, 12));
				g2d.drawString("[" + i + "]", x, y - 5);
				g2d.setFont(new Font("Arial", Font.BOLD, 14));

				x += LARGURA_BLOCO + MARGEM;
			}
		}
	}
}