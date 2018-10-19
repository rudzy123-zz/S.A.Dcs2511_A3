package domains.puzzle;

import framework.ui.ProblemConsole;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * 
 * @author rudolfmusika main is contained in this class 
 */
public class PuzzleConsole extends Application
{
    @Override
    public void start(final Stage primaryStage) {
        final Scene scene = new Scene(new ProblemConsole(new PuzzleProblem(), 550.0, 700.0));
        primaryStage.setTitle("Testing 8-Puzzle Console");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(final String[] args) {
        launch(args);
    }
}

