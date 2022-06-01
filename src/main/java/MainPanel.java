import javax.swing.*;
import javax.swing.text.Element;
import java.awt.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainPanel extends JPanel {

    private JButton whatsappButton;

    private Font buttonFont;

    private ChromeDriver driver;

    private boolean isClicked;

    public MainPanel (int x, int y, int width, int height){
        this.setLayout(null);
        this.setBounds(x, y , width, height);

        this.isClicked = false;

        this.buttonFont = new Font("David",Font.BOLD,Constants.BUTTON_FONT_SIZE);
        this.whatsappButton = new JButton();
        this.whatsappButton.setBounds((Constants.WINDOW_WIDTH - Constants.BUTTON_WIDTH)/2, Constants.WINDOW_HEIGHT/2, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
        this.whatsappButton.setText("Web Whatsapp");
        this.whatsappButton.setFont(this.buttonFont);
        this.add(this.whatsappButton);
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\dasha\\Downloads\\chromedriver_win32\\chromedriver.exe");

        this.whatsappButton.addActionListener((e) -> {
            this.isClicked = true;
            this.driver = new ChromeDriver();
            this.driver.get(Constants.webWhatsappAddress);
        });

//        this.whatsappButton.addActionListener((e) -> {
//            this.driver = new ChromeDriver();
//            this.driver.get(Constants.webWhatsappAddress);
//            driver.manage().window().maximize();
//            new Thread(() -> {
//                System.out.println("in thread");
//                while (true){
//                    if(driver.findElement(By.id("side")).isDisplayed()){
//                        System.out.println("is in");
//                    }
//                    try {
//                        Thread.sleep(1);
//                    } catch (InterruptedException exception) {
//                        exception.printStackTrace();
//                    }
//                }
//
//            }).start();
//        });

    }
}
