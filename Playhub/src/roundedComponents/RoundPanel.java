package roundedComponents;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPanel;

public class RoundPanel extends JPanel {

    private int arcWidth;
    private int arcHeight;
    private Color borderColor = null;
    private float borderThickness = 1.0f;
    private boolean drawBorder = false;

    public RoundPanel(int arcWidth, int arcHeight) {
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        setOpaque(false);  // Evita relleno cuadrado
    }

    /**
     * Establece el color del borde y lo activa
     */
    public void setCustomBorderColor(Color color) {
        this.borderColor = color;
        this.drawBorder = true;
        repaint();
    }

    /**
     * Establece el grosor del borde (por ejemplo 1.0f, 2.5f, etc.)
     */
    public void setCustomBorderThickness(float thickness) {
        this.borderThickness = thickness;
        repaint();
    }

    /**
     * Habilita o deshabilita la visualización del borde
     */
    public void setBorderVisible(boolean visible) {
        this.drawBorder = visible;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Fondo redondeado
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), arcWidth, arcHeight));

        super.paintComponent(g);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        if (drawBorder && borderColor != null) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(borderColor);
            g2.setStroke(new BasicStroke(borderThickness));

            // Ajustar para el grosor del borde
            float offset = borderThickness / 2f;
            g2.draw(new RoundRectangle2D.Float(offset, offset, getWidth() - borderThickness, getHeight() - borderThickness, arcWidth, arcHeight));

            g2.dispose();
        }
    }
}
