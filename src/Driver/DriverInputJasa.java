/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import Controller.ControllerInputJasa;
import Model.Aplikasi;

public class DriverInputJasa {
    public static void main(String[] args) {
        Aplikasi app = new Aplikasi();
        ControllerInputJasa controllerInputJasa = new ControllerInputJasa(app);
    }     
}
