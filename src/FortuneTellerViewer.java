import javax.swing.*;
import java.awt.*;

public class FortuneTellerViewer {

    public static void main(String[] args) {

        FortuneTellerFrame frame = new FortuneTellerFrame();

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        int width = (int) (screenSize.width * 0.75);
        int height = (int) (screenSize.height * 0.75);

        frame.setSize(width, height);
        frame.setTitle("Fortune Teller");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}