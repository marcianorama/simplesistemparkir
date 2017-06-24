/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemparkir.dao;

import com.sistemparkir.db.DBConnection;
import com.sistemparkir.entity.Parkiran;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ParkiranDAO {

    private Connection connection;

    public ParkiranDAO() {
        connection = DBConnection.getConnection();
    }

    public boolean insert(Parkiran p) {
        boolean valid = false;
        PreparedStatement statement = null;
        String sql = "insert into parkiran (id_parkiran, no_polisi, jenis_kendaraan, tgl_masuk, jam_masuk)"
                + " values (?,?,?,curdate(),curtime())";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, p.getId_parkiran());
            statement.setString(2, p.getNo_polisi());
            statement.setString(3, p.getJenis_kendaraan());
            statement.executeUpdate();
            valid = true;
        } catch (SQLException ex) {
            Logger.getLogger(ParkiranDAO.class.getName()).log(Level.SEVERE, null, ex);
            valid = false;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ParkiranDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

    public Parkiran getParkiran(String id) {
        PreparedStatement statement = null;
        ResultSet rs = null;
        Parkiran p = null;
        String sql = "select * from parkiran where id_parkiran=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                p = new Parkiran();
                p.setId_parkiran(rs.getString("id_parkiran"));
                p.setNo_polisi(rs.getString("no_polisi"));
                p.setJenis_kendaraan(rs.getString("jenis_kendaraan"));
                p.setTgl_masuk(rs.getDate("tgl_masuk"));
                p.setJam_masuk(rs.getString("jam_masuk"));
                p.setTgl_keluar(rs.getDate("tgl_keluar"));
                p.setJam_keluar(rs.getString("jam_keluar"));
            }
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(ParkiranDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ParkiranDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ParkiranDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public List<Parkiran> getParkirans() {
        PreparedStatement statement = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "select * from parkiran";
        try {
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                Parkiran p = new Parkiran();
                p.setId_parkiran(rs.getString("id_parkiran"));
                p.setNo_polisi(rs.getString("no_polisi"));
                p.setJenis_kendaraan(rs.getString("jenis_kendaraan"));
                p.setTgl_masuk(rs.getDate("tgl_masuk"));
                p.setJam_masuk(rs.getString("jam_masuk"));
                p.setTgl_keluar(rs.getDate("tgl_keluar"));
                p.setJam_keluar(rs.getString("jam_keluar"));
                list.add(p);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ParkiranDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ParkiranDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ParkiranDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public Parkiran getParkirans(String no_polisi) {
        PreparedStatement statement = null;
        ResultSet rs = null;
        Parkiran p = null;
        String sql = "select * from parkiran where no_polisi=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, no_polisi);
            rs = statement.executeQuery();
            while (rs.next()) {
                p = new Parkiran();
                p.setId_parkiran(rs.getString("id_parkiran"));
                p.setNo_polisi(rs.getString("no_polisi"));
                p.setJenis_kendaraan(rs.getString("jenis_kendaraan"));
                p.setTgl_masuk(rs.getDate("tgl_masuk"));
                p.setJam_masuk(rs.getString("jam_masuk"));
                p.setTgl_keluar(rs.getDate("tgl_keluar"));
                p.setJam_keluar(rs.getString("jam_keluar"));
            }
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(ParkiranDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ParkiranDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ParkiranDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public boolean update(Parkiran p) {
        boolean valid = false;
        PreparedStatement statement = null;
        String sql = "update parkiran set tgl_keluar=curdate(), jam_keluar=curtime() where id_parkiran=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, p.getId_parkiran());
            statement.executeUpdate();
            valid = true;
        } catch (SQLException ex) {
            Logger.getLogger(ParkiranDAO.class.getName()).log(Level.SEVERE, null, ex);
            valid = false;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ParkiranDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

    public Parkiran getDurasiParkir(String id) {
        PreparedStatement statement = null;
        ResultSet rs = null;
        Parkiran p = null;
        String sql = "SELECT  tgl_keluar, jam_keluar, TIME_FORMAT(`jam_keluar`,'%H')-TIME_FORMAT(`jam_masuk`,'%H') AS durasi FROM parkiran where id_parkiran=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                p = new Parkiran();
                p.setTgl_keluar(rs.getDate("tgl_keluar"));
                p.setJam_keluar(rs.getString("jam_keluar"));
                p.setDurasi(rs.getString("durasi"));
            }
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(ParkiranDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ParkiranDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ParkiranDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public String setId() {
        PreparedStatement statement = null;
        ResultSet rs = null;
        String kode = null;
        String s, s1;
        Integer j;
        Integer panjang = 5;
        String sql = "select max(right(id_parkiran, 5)) from parkiran";
        try {
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            if (rs.first() == false) {
                kode = "PR/00001";
            } else {
                rs.last();
                s = Integer.toString(rs.getInt(1) + 1);
                j = s.length();
                s1 = "";
                for (int i = 1; i <= panjang - j; i++) {
                    s1 = s1 + "0";
                }
                kode = "PR/" + s1 + s;
            }
            return kode;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return kode;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ParkiranDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public boolean simpanparkir(Parkiran p) {
        boolean valid = false;
        PreparedStatement statement = null;
        String sql = "update parkiran set total=? where id_parkiran=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setDouble(1, p.getTotal());
            statement.setString(2, p.getId_parkiran());
            statement.executeUpdate();
            valid = true;
        } catch (SQLException ex) {
            Logger.getLogger(ParkiranDAO.class.getName()).log(Level.SEVERE, null, ex);
            valid = false;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ParkiranDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }
}
