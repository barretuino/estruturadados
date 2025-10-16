package pjAula10;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class VisualizadorArvore extends JPanel {
	private ArvoreBinariaDeBusca arvore;
	private final int RAIO_NO = 20; // Raio dos círculos que representam os nós
	private final int ESPACO_X = 50;  // Espaçamento horizontal base
	private final int ESPACO_Y = 60;  // Espaçamento vertical entre níveis

	public VisualizadorArvore(ArvoreBinariaDeBusca arvore) {
		this.arvore = arvore;
		// Definir um tamanho preferencial para que a janela saiba o quanto redimensionar
		setPreferredSize(new Dimension(800, 600)); 
		setBackground(Color.WHITE);
	}

	// Este método é chamado automaticamente pelo Swing para desenhar o componente
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (arvore.raiz != null) {
			// Inicia o desenho a partir da raiz, no topo central
			desenharArvore(g2d, arvore.raiz, getWidth() / 2, 30, getWidth() / 4);
		}
	}

	/**
	 * Função recursiva para desenhar a árvore.
	 * @param g2d Objeto gráfico para desenhar.
	 * @param no O nó atual a ser desenhado.
	 * @param x Posição X do nó atual.
	 * @param y Posição Y do nó atual.
	 * @param offsetX Distância horizontal para os nós filhos.
	 */
	private void desenharArvore(Graphics2D g2d, No no, int x, int y, int offsetX) {
		if (no == null) {
			return;
		}

		// Desenhar a linha (aresta) para o pai (se não for a raiz)
		// Isso será feito no próximo passo para os filhos (esquerda e direita)

		// Desenhar o nó atual (Círculo)
		g2d.setColor(Color.BLUE);
		g2d.fillOval(x - RAIO_NO, y - RAIO_NO, 2 * RAIO_NO, 2 * RAIO_NO);

		// Desenhar o valor (Texto) dentro do nó
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("Arial", Font.BOLD, 12));
		String texto = String.valueOf(no.valor);
		FontMetrics fm = g2d.getFontMetrics();
		int textX = x - fm.stringWidth(texto) / 2;
		int textY = y + fm.getAscent() / 2 - 2; // Ajuste para centralizar
		g2d.drawString(texto, textX, textY);

		// Desenhar os filhos recursivamente

		// Novo offset X: divide-se a distância pela metade a cada nível
		int novoOffsetX = offsetX / 2; 

		// Filho Esquerdo
		if (no.esquerda != null) {
			int xEsq = x - offsetX;
			int yEsq = y + ESPACO_Y;

			// Desenhar a linha do nó atual para o filho esquerdo
			g2d.setColor(Color.BLACK);
			// Ajusta o início e fim da linha para a borda do nó (não o centro)
			g2d.drawLine(x, y + RAIO_NO, xEsq, yEsq - RAIO_NO); 

			desenharArvore(g2d, no.esquerda, xEsq, yEsq, novoOffsetX);
		}

		// Filho Direito
		if (no.direita != null) {
			int xDir = x + offsetX;
			int yDir = y + ESPACO_Y;

			// Desenhar a linha do nó atual para o filho direito
			g2d.setColor(Color.BLACK);
			// Ajusta o início e fim da linha para a borda do nó (não o centro)
			g2d.drawLine(x, y + RAIO_NO, xDir, yDir - RAIO_NO); 

			desenharArvore(g2d, no.direita, xDir, yDir, novoOffsetX);
		}
	}

	// Método principal para rodar o exemplo
	public static void main(String[] args) {
		// 1. Criar a Árvore e inserir alguns valores
		ArvoreBinariaDeBusca arvore = new ArvoreBinariaDeBusca();

		// Exemplo de inserção
		arvore.inserir(50);
		arvore.inserir(30);
		arvore.inserir(70);
		arvore.inserir(20);
		arvore.inserir(40);
		arvore.inserir(60);
		arvore.inserir(80);
		arvore.inserir(10); // Adiciona mais profundidade na esquerda
		arvore.inserir(45); // Adiciona mais profundidade no meio/direita

		// 2. Criar a Janela (JFrame) e adicionar o visualizador
		JFrame frame = new JFrame("Visualização de Árvore Binária de Busca");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		VisualizadorArvore visualizador = new VisualizadorArvore(arvore);
		frame.add(new JScrollPane(visualizador)); // Adiciona scroll, caso a árvore seja grande

		frame.pack(); // Ajusta o tamanho da janela ao conteúdo
		frame.setLocationRelativeTo(null); // Centraliza a janela
		frame.setVisible(true);
	}
}