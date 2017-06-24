/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemparkir.tabelmodel;

import com.sistemparkir.entity.Parkiran;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelModelParkiran extends AbstractTableModel{
    
    List<Parkiran> list=new ArrayList<>();

    public TabelModelParkiran() {
    }
    
    @Override
    public int getRowCount() {
         return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:return list.get(rowIndex).getNo_polisi();
            case 1:return list.get(rowIndex).getJenis_kendaraan();
            case 2:return list.get(rowIndex).getTgl_masuk();
            case 3:return list.get(rowIndex).getJam_masuk();
            case 4:return list.get(rowIndex).getTgl_keluar();
            case 5:return list.get(rowIndex).getJam_keluar();
                default:return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:return "No Polisi";
            case 1:return "Jenis";
            case 2:return "Tanggal Masuk";
            case 3:return "Jam Masuk";
            case 4:return "Tanggal Keluar";
            case 5:return "Jam Keluar";
                default:return null;
        }
    }
    
    public Parkiran getParkiran(int index){
        return list.get(index);
    }
    
    public void setData(List<Parkiran> list){
        this.list=list;
        fireTableDataChanged();
    }
    
}
