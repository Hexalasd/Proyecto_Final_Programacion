package interfaz.clasesAuxiliares;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimatorSwing {

    private static Timer timer;

    /**
     * Anima un JLabel haciéndolo subir y bajar suavemente.
     * @param label El JLabel a animar
     * @param amplitude Cuántos píxeles se mueve (ej: 5)
     * @param speed Velocidad de animación (ej: 0.08)
     */
    public static void floatAnimation(JLabel label, int amplitude, double speed) {
        int originalY = label.getY();

        timer = new Timer(16, new ActionListener() {  // ~60 FPS
            double angle = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                int offset = (int) (Math.sin(angle) * amplitude);
                label.setLocation(label.getX(), originalY + offset);
                angle += speed;
            }
        });

        timer.start();
    }

    public static void stopAnimation() {
        if (timer != null) {
            timer.stop();
        }
    }
}
