package interfaz.clasesAuxiliares;

import javax.swing.*;
import java.awt.*;

public class FadeManager {
    
    // Crear fade out simple
    public static FadeOverlay createFadeOut(JFrame frame, int fadeSpeed, int delay, Runnable onComplete) {
        FadeOverlay overlay = new FadeOverlay(fadeSpeed, delay, Color.BLACK, onComplete);
        frame.getLayeredPane().add(overlay, JLayeredPane.MODAL_LAYER);
        overlay.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        return overlay;
    }
    
    // Crear fade in simple
    public static FadeOverlay createFadeIn(JFrame frame, int fadeSpeed, Runnable onComplete) {
        FadeOverlay overlay = new FadeOverlay(fadeSpeed, 0, Color.BLACK, onComplete);
        overlay.setAlpha(1f); // Comienza opaco
        frame.getLayeredPane().add(overlay, JLayeredPane.MODAL_LAYER);
        overlay.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        overlay.startFadeIn(fadeSpeed);
        return overlay;
    }
    
    // Secuencia completa: fade out → acción → fade in
    public static void fadeTransition(JFrame currentFrame, Runnable middleAction, int fadeSpeed) {
        // Fade out del frame actual
        FadeOverlay fadeOut = createFadeOut(currentFrame, fadeSpeed, 0, () -> {
            // Ejecutar acción intermedia (cambiar pantalla, etc.)
            if (middleAction != null) {
                middleAction.run();
            }
        });
        fadeOut.start();
    }
}