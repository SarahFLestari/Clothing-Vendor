/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import Controller.ControllerEditListPreOrder;
import Model.Aplikasi;

/**
 *
 * @author MBP
 */
public class DriverEditListPreOrder {
    public static void main(String[] args) {
        Aplikasi app = new Aplikasi();
        new ControllerEditListPreOrder(app);
    } 
}
