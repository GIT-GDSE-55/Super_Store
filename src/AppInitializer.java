/*
 *
 *  * -------------------------------------------------------------
 *  *  Copyright (c) GDSE- Gansters. All rights reserved
 *  *  Licensed under the SriLankan Information  License. See LICENSE.txt in the project root for License information
 *  * -------------------------------------------------------------
 *
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setScene(new Scene(FXMLLoader.load(this.getClass()
                .getResource("view/CustomerForm.fxml"))));
        primaryStage.show();  //Ctrl + ALT+ L
    }
}
