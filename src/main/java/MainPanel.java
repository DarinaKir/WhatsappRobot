import javax.swing.*;
import java.awt.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainPanel extends JPanel {

    private JButton whatsappButton;

    private Font buttonFont;
    private  Font textFont;

    private boolean isConnected;

//    private ChromeDriver driver;

    public MainPanel (int x, int y, int width, int height){
        this.setLayout(null);
        this.setBounds(x, y , width, height);

        this.buttonFont = new Font("David",Font.BOLD,Constants.BUTTON_FONT_SIZE);
        this.textFont = new Font("David",Font.ROMAN_BASELINE, Constants.BUTTON_FONT_SIZE);

        this.whatsappButton = new JButton();
        this.whatsappButton.setBounds((Constants.WINDOW_WIDTH - Constants.BUTTON_WIDTH)/2, Constants.WINDOW_HEIGHT/2, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
        this.whatsappButton.setText("Web Whatsapp");
        this.whatsappButton.setFont(this.buttonFont);
        this.add(this.whatsappButton);
        this.isConnected = false;

//        JLabel connectedText = new JLabel("You are not connected yet...");
        JLabel connectedText = new JLabel();
        connectedText.setBounds((this.whatsappButton.getX()-(Constants.CONNECTED_TEXT_WIDTH - this.whatsappButton.getWidth())/2),
                this.whatsappButton.getY() + this.whatsappButton.getHeight(), Constants.CONNECTED_TEXT_WIDTH, this.whatsappButton.getHeight());
        connectedText.setFont(this.textFont);
        this.add(connectedText);

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\dasha\\Downloads\\chromedriver_win32\\chromedriver.exe");
        this.whatsappButton.addActionListener((e) -> {
            ChromeDriver driver = new ChromeDriver();
            driver.get(Constants.WEB_WHATSAPP_ADDRESS);
            while (!this.isConnected){
                try {
                    this.isConnected = (driver.findElement(By.id("side")).isDisplayed());
                }catch (NoSuchElementException exception){
                }
            }
            connectedText.setText("You were able to connect!");
        });

//        new Thread(() -> {
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException exception) {
//                exception.printStackTrace();
//            }
//        }).start();

    }
}
