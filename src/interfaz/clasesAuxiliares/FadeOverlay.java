package interfaz.clasesAuxiliares;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.*;

public class FadeOverlay extends JComponent {
    private float alpha = 1f;
    private final Timer fadeTimer;
    private Timer delayTimer;
    private Color fadeColor;
    private Runnable onComplete;
    
    // Constructor básico
    public FadeOverlay(int fadeSpeedMs, int delayMs) {
        this(fadeSpeedMs, delayMs, Color.BLACK, null);
    }
    
    // Constructor con color personalizado
    public FadeOverlay(int fadeSpeedMs, int delayMs, Color fadeColor) {
        this(fadeSpeedMs, delayMs, fadeColor, null);
    }
    
    // Constructor completo
    public FadeOverlay(int fadeSpeedMs, int delayMs, Color fadeColor, Runnable onComplete) {
        this.fadeColor = fadeColor;
        this.onComplete = onComplete;
        setOpaque(false);
        
        // Timer para el fade
        fadeTimer = new Timer(fadeSpeedMs, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alpha -= 0.02f;
                if (alpha <= 0) {
                    alpha = 0;
                    fadeTimer.stop();
                    // Remover este componente del parent de forma segura
                    SwingUtilities.invokeLater(() -> {
                        Container parent = getParent();
                        if (parent != null) {
                            parent.remove(FadeOverlay.this);
                            parent.revalidate();
                            parent.repaint();
                        }
                        // Ejecutar callback si existe
                        if (onComplete != null) {
                            onComplete.run();
                        }
                    });
                }
                repaint();
            }
        });
        
        // Timer opcional de delay
        if (delayMs > 0) {
            delayTimer = new Timer(delayMs, e -> {
                delayTimer.stop();
                fadeTimer.start();
            });
            delayTimer.setRepeats(false);
        }
        
        // Listener para redimensionar cuando el contenedor cambie de tamaño
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (getParent() != null) {
                    setBounds(0, 0, getParent().getWidth(), getParent().getHeight());
                }
            }
        });
    }
    
    public void start() {
        if (delayTimer != null) {
            delayTimer.start();
        } else {
            fadeTimer.start();
        }
    }
    
    public void stop() {
        if (delayTimer != null && delayTimer.isRunning()) {
            delayTimer.stop();
        }
        if (fadeTimer.isRunning()) {
            fadeTimer.stop();
        }
    }
    
    public void setFadeColor(Color color) {
        this.fadeColor = color;
        repaint();
    }
    
    public void setOnComplete(Runnable onComplete) {
        this.onComplete = onComplete;
    }
    
    // Método para controlar manualmente el alpha (útil para fade in)
    public void setAlpha(float alpha) {
        this.alpha = Math.max(0, Math.min(1, alpha)); // Clamp entre 0 y 1
        repaint();
    }
    
    public float getAlpha() {
        return alpha;
    }
    
    // Método para fade in (en lugar de fade out)
    public void startFadeIn(int fadeSpeedMs) {
        alpha = 0f;
        fadeTimer.setDelay(fadeSpeedMs);
        
        // Cambiar la dirección del fade
        fadeTimer.removeActionListener(fadeTimer.getActionListeners()[0]);
        fadeTimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alpha += 0.02f;
                if (alpha >= 1) {
                    alpha = 1;
                    fadeTimer.stop();
                    if (onComplete != null) {
                        onComplete.run();
                    }
                }
                repaint();
            }
        });
        fadeTimer.start();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        
        // Configurar antialiasing para mejor calidad
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Aplicar transparencia
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        
        // Rellenar con el color de fade
        g2.setColor(fadeColor);
        g2.fillRect(0, 0, getWidth(), getHeight());
        
        g2.dispose();
    }
    
    @Override
    public void addNotify() {
        super.addNotify();
        // Asegurarse de que ocupe todo el espacio cuando se añade al contenedor
        SwingUtilities.invokeLater(() -> {
            Container parent = getParent();
            if (parent != null) {
                setBounds(0, 0, parent.getWidth(), parent.getHeight());
            }
        });
    }
}