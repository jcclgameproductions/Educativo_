package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.*;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.jfoenix.controls.JFXButton;
import Model.Dao.UserDAO;
import Model.Bean.User;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


import javax.swing.JOptionPane;

public class FxController implements Initializable {
    @FXML 
    public JFXTextField emailtf;
    @FXML 
    public JFXTextField nmtfcd;
    @FXML 
    public JFXTextField psscd;
    @FXML 
    public JFXTextField psscd2;
    @FXML
    public TextField usertf;
    @FXML
    public PasswordField psspf;
    @FXML
    public Label lbl1;
    @FXML
    public Label lbl2;
    @FXML 
    public Label lbl3;
    @FXML 
    public Label lbl4;
    @FXML 
    public Label lbl5;
    @FXML
    public Label lblmsg;
    @FXML
    public JFXButton btnlg;
    @FXML
    public JFXButton btncd;
    @FXML
    public JFXButton btnircd;
    @FXML
    public JFXButton btnirlg;
    @FXML
    public Hyperlink hplfb;
    @FXML
    public Hyperlink hplemail;
    @FXML
    public ImageView img;
    @FXML
    public ImageView imgfb;
    @FXML
    public ImageView imggm;


    private Stage stage;

    public UserDAO usdao = new UserDAO();
    public User us = new User();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
    }
    
       public void btnircd(ActionEvent e) {
        //Desativa layout de login//
        btnlg.setVisible(false);
        btnlg.setDisable(true);
        hplemail.setVisible(false);
        hplemail.setDisable(true);
        hplfb.setVisible(false);
        hplfb.setDisable(true);
        btnircd.setVisible(false);
        btnircd.setDisable(true);
        imgfb.setVisible(false);
        imggm.setVisible(false);
        usertf.setVisible(false);
        usertf.setDisable(true);
        psspf.setVisible(false);
        psspf.setDisable(true);
        lblmsg.setVisible(false);
        //--------------------//
        //-------------------//
        //Ativa layout de cadastro//
        lbl1.setVisible(true);
        lbl1.setDisable(false);
        lbl2.setVisible(true);
        lbl2.setDisable(false);
        lbl3.setVisible(true);
        lbl3.setDisable(false);
        lbl4.setVisible(true);
        lbl4.setDisable(false);
        lbl5.setVisible(true);
        lbl5.setDisable(false);
        img.setVisible(true);
        psscd.setVisible(true);
        psscd.setDisable(false);
        psscd2.setVisible(true);
        psscd2.setDisable(false);
        nmtfcd.setVisible(true);
        nmtfcd.setDisable(false);
        btnirlg.setVisible(true);
        btnirlg.setDisable(false);
        btncd.setDisable(false);
        btncd.setVisible(true);
        emailtf.setVisible(true);
        emailtf.setDisable(false);
        nmtfcd.setVisible(true);
        nmtfcd.setDisable(false);
        
    }
public void btnirlg(ActionEvent e) {
        //Desativa layout de login//
        btnlg.setVisible(true);
        btnlg.setDisable(false);
        hplemail.setVisible(true);
        hplemail.setDisable(false);
        hplfb.setVisible(true);
        hplfb.setDisable(false);
        btnircd.setVisible(true);
        btnircd.setDisable(false);
        imgfb.setVisible(true);
        imggm.setVisible(true);
        usertf.setVisible(true);
        usertf.setDisable(false);
        psspf.setVisible(true);
        psspf.setDisable(false);
        //--------------------//
        //-------------------//
        //Ativa layout de Login//
        lbl1.setVisible(false);
        lbl1.setDisable(true);
        lbl2.setVisible(false);
        lbl2.setDisable(true);
        lbl3.setVisible(false);
        lbl3.setDisable(true);
        lbl4.setVisible(false);
        lbl4.setDisable(true);
        lbl5.setVisible(false);
        lbl5.setDisable(true);
        img.setVisible(false);
        psscd.setVisible(false);
        psscd.setDisable(true);
        psscd2.setVisible(false);
        psscd2.setDisable(true);
        nmtfcd.setVisible(false);
        nmtfcd.setDisable(true);
        btnirlg.setVisible(false);
        btnirlg.setDisable(true);
        btncd.setDisable(true);
        btncd.setVisible(false);
        emailtf.setVisible(false);
        emailtf.setDisable(true);
        nmtfcd.setVisible(false);
        nmtfcd.setDisable(true);

        
    }
    public void btncd(ActionEvent e) {
        String nome = nmtfcd.getText();
        String senha = psscd2.getText();
        String email = emailtf.getText();
        

        us.setCdsenha(senha);
        us.setNmuser(nome);
        us.setEmail(email);
        usdao.create(us);
    }

    public void btnlg(ActionEvent e) throws IOException {
        lblmsg.setVisible(false);
        try {
            //Recebe senha e nome de usuario do TextField 
            String nome = usertf.getText();
            String senha = psspf.getText();
            //Seta o nome do usuario como nome e senha;
            us.setCdsenha(nome);
            us.setNmuser(senha);
            //Cria e autentica o usuario no banco de dados;
            ResultSet rslt = usdao.autUser(us);

            if (rslt.next()) {

                JOptionPane.showMessageDialog(null, "Conexão estabelecida");

                Parent root = FXMLLoader.load(getClass().getResource("/View//sistema.fxml"));
                stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                //stage.initStyle(StageStyle.UNDECORATED);
                stage.setResizable(true);
                stage.setScene(scene);
                stage.show();

            } else {
               lblmsg.setVisible(true);
               
              
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(FxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
