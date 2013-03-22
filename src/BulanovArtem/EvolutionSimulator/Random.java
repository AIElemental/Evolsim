package BulanovArtem.EvolutionSimulator;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * BulanovArtem.EvolutionSimulator.Random
 * User: aielemental
 * Date: 13.07.12
 * Time: 13:26
 */
//todo add description
public class Random {
    
    public static final int quality = 6;
    public static Point3 getRandomIdentityVector2(double seed) {
        double angle = seed * Math.random() * 2 * Math.PI;
        return new Point3(Math.sin(angle), Math.cos(angle));
    }
    public static double getGaussian(double a, double b) throws IllegalArgumentException {
        if (b <= a) throw new IllegalArgumentException("Not valid interval");
        double seed;
        double x;
        double GaussianX = 0;
        for (int i = 0; i < quality; i++) {
            seed = Math.random();
            x = seed * (b-a) + a;
            GaussianX += x;
        }
        return GaussianX / quality;
    };
    
    public static double getGaussian() {
        double GaussianX = 0;
        for (int i = 0; i < quality; i++) {
            GaussianX += Math.random();
        }
        return GaussianX / quality;
    };

    public static void main(String[] args){

        final int N = 10;
        final int[] values = new int[N];

    for (int i = 0; i < N; i++) values[i] = 0;
    final Frame frame = new Frame("Random test");
    Canvas canvas = new Canvas(){
         public void paint(Graphics g){
            g.setColor(new Color(255,255,255));
            g.fillRect(0,0,getWidth(),getHeight());
         }
         public void update(Graphics g){
            int max = 0;
            g.setColor(Color.WHITE);
            g.fillRect(0,0,getWidth(),getHeight());
            for (int i = 0; i < 1000; i++) values[(int)Math.round(Math.floor(Random.getGaussian(0, N)))] += 1;
            for (int i = 0; i < N; i++) if (max < values[i]) max = values[i];

            g.setColor(Color.BLACK);
            for (int i =  0; i < N; i++){
                g.fillRect(i * this.getWidth() / N, this.getHeight() - values[i] * this.getHeight() / max,
                        this.getWidth() / N, values[i] * this.getHeight() / max);
            }
         }
    };
    frame.add(canvas);
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ((Canvas) e.getSource()).repaint();
            }
        });
    frame.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            frame.dispose();
        }
    });
    frame.setSize(800, 500);
    frame.setVisible(true);

    canvas.repaint();
    }
};

