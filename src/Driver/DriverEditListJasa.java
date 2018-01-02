/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import Controller.ControllerEditListJasa;
import Model.Aplikasi;

public class DriverEditListJasa {
    public static void main(String[] args) {
        Aplikasi app = new Aplikasi();
        ControllerEditListJasa controllerEditListJasa = new ControllerEditListJasa(app);
    }    
}
