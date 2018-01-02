/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import Controller.ControllerAdminUpdate;
import Model.Aplikasi;

/**
 *
 * @author MBP
 */
public class DriverAdminUpdate {
    public static void main(String[] args) {
        Aplikasi app = new Aplikasi();
        new ControllerAdminUpdate(app);
    }
}
