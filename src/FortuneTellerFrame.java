import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;

    private JLabel titleLabel;
    private JTextArea fortuneArea;
    private JScrollPane scrollPane;

    private JButton fortuneButton;
    private JButton quitButton;

    private ArrayList<String> fortunes;
    private Random random;

    private int lastFortuneIndex = -1;

    public FortuneTellerFrame() {

        mainPanel = new JPanel(new BorderLayout());

        createFortunes();
        createTopPanel();
        createMiddlePanel();
        createBottomPanel();

        add(mainPanel);
    }

    private void createFortunes() {

        fortunes = new ArrayList<>();
        random = new Random();

        fortunes.add("You will find money in an unexpected place.");
        fortunes.add("A surprise is waiting for you this week.");
        fortunes.add("Your next meal will be better than expected.");
        fortunes.add("Someone will make you laugh today.");
        fortunes.add("A new opportunity will appear soon.");
        fortunes.add("Your phone battery will survive when you need it most.");
        fortunes.add("You will remember something important at the last second.");
        fortunes.add("Good news will arrive when you least expect it.");
        fortunes.add("Your next assignment will be easier than this one.");
        fortunes.add("You will avoid traffic at exactly the right time.");
        fortunes.add("A forgotten snack will save your day.");
        fortunes.add("Your code will compile on the first try... eventually.");
    }

    private void createTopPanel() {

        topPanel = new JPanel();

        // Image will be loaded from the project folder
        ImageIcon icon = new ImageIcon("fortuneTeller.png");

        titleLabel = new JLabel("Fortune Teller", icon, JLabel.CENTER);

        Font titleFont = new Font("Serif", Font.BOLD, 48);
        titleLabel.setFont(titleFont);

        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);

        topPanel.add(titleLabel);

        mainPanel.add(topPanel, BorderLayout.NORTH);
    }

    private void createMiddlePanel() {

        fortuneArea = new JTextArea();

        Font fortuneFont = new Font("Serif", Font.PLAIN, 20);
        fortuneArea.setFont(fortuneFont);

        fortuneArea.setEditable(false);
        fortuneArea.setLineWrap(true);
        fortuneArea.setWrapStyleWord(true);

        scrollPane = new JScrollPane(fortuneArea);

        mainPanel.add(scrollPane, BorderLayout.CENTER);
    }

    private void createBottomPanel() {

        bottomPanel = new JPanel();

        fortuneButton = new JButton("Read My Fortune!");
        quitButton = new JButton("Quit");

        Font buttonFont = new Font("SansSerif", Font.BOLD, 18);

        fortuneButton.setFont(buttonFont);
        quitButton.setFont(buttonFont);

        fortuneButton.addActionListener(e -> displayFortune());

        quitButton.addActionListener(e -> System.exit(0));

        bottomPanel.add(fortuneButton);
        bottomPanel.add(quitButton);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
    }

    private void displayFortune() {

        int newIndex;

        do {
            newIndex = random.nextInt(fortunes.size());
        } while (newIndex == lastFortuneIndex);

        lastFortuneIndex = newIndex;

        fortuneArea.append(fortunes.get(newIndex) + "\n");
    }
}