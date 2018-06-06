/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pailan.dao;

import com.pailan.dto.Description;
import com.pailan.dto.PatientsDetails;
import com.pailan.util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ankur
 */
public class PatientDao {

    public static PatientsDetails getPatient(int smartcard) {
//        ArrayList patientList = new ArrayList();

        DbUtil myDbUtil = DbUtil.getInstance();
        Connection conn = null;
        PatientsDetails patientsDetails = new PatientsDetails();
        try {
            conn = (Connection) myDbUtil.getDbConnection();
            String sql = "SELECT\n"
                    + "  smartcard,\n"
                    + "  NAME,\n"
                    + "  contact,\n"
                    + "  amount,\n"
                    + "  claim,\n"
                    + "  balance,\n"
                    + "  email\n"
                    + "FROM\n"
                    + "  patient_details"
                    + " where smartcard=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, smartcard);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                patientsDetails.setSmartCard(rs.getInt("smartcard"));
                patientsDetails.setName(rs.getString("name"));
                patientsDetails.setContact(rs.getString("contact"));
                patientsDetails.setAmount(rs.getDouble("amount"));
                patientsDetails.setClaim(rs.getDouble("claim"));
                patientsDetails.setBalance(rs.getDouble("balance"));
                patientsDetails.setEmail(rs.getString("email"));

//                patientList.add(patientsDetails);
            }

        } catch (Exception ex) {

            ex.printStackTrace();
            try {
                conn.close();
            } catch (SQLException ex1) {
                Logger.getLogger(PatientDao.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

        return patientsDetails;

    }

    public static boolean addPatient(PatientsDetails patientsDetails) {
        boolean result = false;
        DbUtil myDbUtil = DbUtil.getInstance();
        try {
            Connection conn = (Connection) myDbUtil.getDbConnection();
            String sql = "INSERT INTO patient_details (\n"
                    + "  smartcard,\n"
                    + "  name,\n"
                    + "  contact,\n"
                    + "  amount,\n"
                    + "  claim,\n"
                    + "  balance,\n"
                    + "  email\n"
                    + ")\n"
                    + "VALUES\n"
                    + "  (?,?,?,?,?,?,?);";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, patientsDetails.getSmartCard());
            stmt.setString(2, patientsDetails.getName());
            stmt.setString(3, patientsDetails.getContact());
            stmt.setDouble(4, 0);
            stmt.setDouble(5, 0);
            stmt.setDouble(6, 500000);
            stmt.setString(7, patientsDetails.getEmail());

            int row = stmt.executeUpdate();

            if (row > 0) {
                result = true;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;

    }

    public static Description getFullDescription(int description_id) {
        Description description = new Description();

        DbUtil myDbUtil = DbUtil.getInstance();
        Connection conn = null;

        try {
            conn = (Connection) myDbUtil.getDbConnection();
            String sql = "SELECT\n"
                    + "  description_id,\n"
                    + "  description_name,\n"
                    + "  description_amount\n"
                    + "FROM\n"
                    + "  description"
                    + " where description_id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, description_id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                description.setDescription_id(rs.getInt("description_id"));
                description.setDescription_name(rs.getString("description_name"));
                description.setDescription_amount(rs.getInt("description_amount"));
            }

        } catch (Exception ex) {

            ex.printStackTrace();
            try {
                conn.close();
            } catch (SQLException ex1) {
                Logger.getLogger(PatientDao.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

        return description;

    }

    public static ArrayList getDescriptions() {
        ArrayList descriptionList = new ArrayList();

        DbUtil myDbUtil = DbUtil.getInstance();
        try {
            Connection conn = (Connection) myDbUtil.getDbConnection();
            String sql = "SELECT\n"
                    + "  description_id,\n"
                    + "  description_name\n"
                    + " FROM\n"
                    + "  description"
                    + " order by description_id";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                Description description = new Description();
                description.setDescription_id(rs.getInt("description_id"));
                description.setDescription_name(rs.getString("description_name"));

                descriptionList.add(description);
            }

        } catch (Exception ex) {

            ex.printStackTrace();;
        }

        return descriptionList;

    }

    public static PatientsDetails updatePatient(int Id, String Name) {
        DbUtil myDbUtil = DbUtil.getInstance();
        Connection conn = null;
        double claim = 0.0;
                double claimm = 0.0;


        try {
            conn = (Connection) myDbUtil.getDbConnection();
            String sql = "SELECT\n"
                    + "  description_id,\n"
                    + "  description_name,\n"
                    + "  description_amount\n"
                    + "  FROM\n"
                    + "  description"
                    + " where description_id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                claim = (rs.getDouble("description_amount"));

//                patientList.add(patientsDetails);
            }

        } catch (Exception ex) {

            ex.printStackTrace();
            try {
                conn.close();
            } catch (SQLException ex1) {
                Logger.getLogger(PatientDao.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

        PatientsDetails patientsDetails = new PatientsDetails();
        try {
            conn = (Connection) myDbUtil.getDbConnection();
            String sql = "SELECT\n"
                    + "  smartcard,\n"
                    + "  name,\n"
                    + "  contact,\n"
                    + "  amount,\n"
                    + "  claim,\n"
                    + "  balance,\n"
                    + "  email\n"
                    + "  FROM\n"
                    + "  patient_details"
                    + "  where name=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Name);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                patientsDetails.setSmartCard(rs.getInt("smartcard"));
                patientsDetails.setName(rs.getString("name"));
                patientsDetails.setContact(rs.getString("contact"));
               claimm=rs.getDouble("claim");
               double plus=claim+claimm;
                double balance = rs.getDouble("balance");
                double amount = balance - plus;

                patientsDetails.setAmount(amount);
                patientsDetails.setClaim(plus);
                patientsDetails.setBalance(balance);
                patientsDetails.setEmail(rs.getString("email"));
            }

        } catch (Exception ex) {

            ex.printStackTrace();
            try {
                conn.close();
            } catch (SQLException ex1) {
                Logger.getLogger(PatientDao.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

        return patientsDetails;
    }

    public static PatientsDetails getEmail(String patientName) {
        DbUtil myDbUtil = DbUtil.getInstance();
        Connection conn = null;
        PatientsDetails patientsDetails = new PatientsDetails();
        try {
            conn = (Connection) myDbUtil.getDbConnection();
            String sql = "SELECT\n"
                    + "  smartcard,\n"
                    + "  name,\n"
                    + "  contact,\n"
                    + "  amount,\n"
                    + "  claim,\n"
                    + "  balance,\n"
                    + "  email\n"
                    + "  FROM\n"
                    + "  patient_details"
                    + "  where name=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, patientName);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                patientsDetails.setSmartCard(rs.getInt("smartcard"));
                patientsDetails.setName(rs.getString("name"));
                patientsDetails.setContact(rs.getString("contact"));
                patientsDetails.setAmount(rs.getDouble("amount"));
                patientsDetails.setClaim(rs.getDouble("claim"));
                patientsDetails.setBalance(rs.getDouble("balance"));
                patientsDetails.setEmail(rs.getString("email"));

            }
        } catch (Exception ex) {

            ex.printStackTrace();
            try {
                conn.close();
            } catch (SQLException ex1) {
                Logger.getLogger(PatientDao.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return patientsDetails;
    }

    public static boolean savePatient(PatientsDetails patient) {
        //To change body of generated methods, choose Tools | Templates.
        boolean response = false;
        DbUtil myDbUtil = DbUtil.getInstance();
        try {
            Connection conn = (Connection) myDbUtil.getDbConnection();
            String sql = "UPDATE\n"
                    + "  patient_details\n"
                    + "SET\n"
                    + "  amount = ?,\n"
                    + "  claim = ?,\n"
                    + "  balance = ?,\n"
                    + "  email = ?\n"
                    + "WHERE smartcard = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setDouble(1, patient.getAmount());
            stmt.setDouble(2, patient.getClaim());
            stmt.setDouble(3,patient.getBalance());
            stmt.setString(4, patient.getEmail());
            stmt.setInt(5, patient.getSmartCard());

            int row = stmt.executeUpdate();

            if (row > 0) {
                response = true;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }
}
