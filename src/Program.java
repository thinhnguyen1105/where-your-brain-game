import javafx.embed.swing.JFXPanel;

/**
 * Created by duyanh on 10/31/17.
 */
public class Program {

    public static void main(String[] args) {
        final JFXPanel fxPanel = new JFXPanel();
        GameWindow gameWindow = new GameWindow();
        gameWindow.gameLoop();

        System.out.println("yes");
    }
}
