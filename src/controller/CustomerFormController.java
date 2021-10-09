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
import dto.CustomerDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.CustomerTM;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sachini Umayangana <sachi.umay@gmail.com>
 * @since 10/9/2021
 */
public class CustomerFormController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtSalary;
    public JFXButton btnSave;

    public void saveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (btnSave.getText().equalsIgnoreCase("Save")){
            CustomerDTO dto= new CustomerDTO(
                    txtId.getText(),
                    txtName.getText(),
                    txtAddress.getText(),
                    Double.parseDouble(txtSalary.getText())
            );
            PreparedStatement stm = DBConnection.getInstance().
                    getConnection().prepareStatement(
                    "INSERT INTO Customer VALUES(?,?,?,?)");
            stm.setString(1,dto.getId());
            stm.setString(2,dto.getName());
            stm.setString(3,dto.getAddress());
            stm.setObject(4,dto.getSalary());

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
