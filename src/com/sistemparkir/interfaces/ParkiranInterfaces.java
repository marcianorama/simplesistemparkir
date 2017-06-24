/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemparkir.interfaces;

import com.sistemparkir.entity.Parkiran;
import java.util.List;

public interface ParkiranInterfaces {
    String setId();
    boolean insert(Parkiran p);
    boolean update(Parkiran p);
    boolean simpanparkir(Parkiran p);
    Parkiran getParkiran(String id);
    List<Parkiran> getParkirans();
    Parkiran getDurasiParkir(String id);
    Parkiran getParkirans(String no_polisi);
}
