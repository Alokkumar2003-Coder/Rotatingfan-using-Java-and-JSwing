import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Example3 extends JFrame 
{
    public Example3() 
    {
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        MyAnimation2 panel = new MyAnimation2(780, 560);
        panel.setBackground(Color.BLACK);
        add(panel);
        setVisible(true);
    }
}

class MyAnimation2 extends JPanel implements ActionListener 
{
    int x = 0;
    int y = 0;
    int fanWidth = 300;
    int fanHeight = 300;
    int angle = 0;
    int centerX;
    int centerY;
    Timer timer;

    MyAnimation2(int w, int h) 
    {
        this.centerX = w / 2;
        this.centerY = h / 2;
        this.x = centerX - fanWidth / 2;
        this.y = centerY - fanHeight / 2;
        timer = new Timer(50, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillArc(x, y, fanWidth, fanHeight, angle, 30);
        g.fillArc(x, y, fanWidth, fanHeight, angle + 120, 30);
        g.fillArc(x, y, fanWidth, fanHeight, angle + 240, 30);
        g.drawLine(centerX, centerY, centerX, centerY + 2*fanHeight );

        angle = (angle + 10) % 360;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}

public class JAnimPrt3 
{
    public static void main(String[] args) 
    {
        new Example3().setVisible(true);
    }
}
