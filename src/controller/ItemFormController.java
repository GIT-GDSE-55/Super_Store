/*
 *
 *  * -------------------------------------------------------------
 *  *  Copyright (c) GDSE- Gansters. All rights reserved
 *  *  Licensed under the SriLankan Information  License. See LICENSE.txt in the project root for License information
 *  * -------------------------------------------------------------
 *
 */

package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import dto.ItemDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Sachini Umayangana <sachi.umay@gmail.com>
 * @since 10/9/2021
 */
public class ItemFormController {
    public TextField txtCode;
    public TextField txtDescription;
    public TextField txtUnitPrice;
    public TextField txtQtyOnHand;
    public JFXButton btnSaveItem;

    public void saveItemOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (btnSaveItem.getText().equalsIgnoreCase("Save")){
            ItemDTO dto= new ItemDTO(
                    txtCode.getText(),
                    txtDescription.getText();
                    Double.parseDouble(txtUnitPrice.getText());
                    Integer.parseInt(txtQtyOnHand.getText());

            );
            PreparedStatement stm = DBConnection.getInstance().
                    getConnection().prepareStatement(
                    "INSERT INTO Item VALUES(?,?,?,?)");
            stm.setString(1,dto.getCode());
            stm.setString(2,dto.getDescription());
            stm.setObject(4,dto.getUnitPrice());
            stm.setInt(4,dto.getQtyOnHand());

            if(stm.executeUpdate()>0){
                new Alert(Alert.AlertType.CONFIRMATION,
                        "Saved!", ButtonType.OK).show();
            }else{
                new Alert(Alert.AlertType.WARNING,
                        "Try Again!", ButtonType.OK).show();
            }
        }else{
            new Alert(Alert.AlertType.WARNING,
                    "Try Again!", ButtonType.OK).show();
        }
    }
    }
}
