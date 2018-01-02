/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import Controller.*;
import Model.Aplikasi;

public class DriverMenuPetugas {
    public static void main(String[] args) {
        Aplikasi app = new Aplikasi();
        ControllerMenuPetugas controllerMenuPetugas = new ControllerMenuPetugas(app);
    }
}
    

