package com.nvoccapi.nvoccapibackend.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.nvoccapi.nvoccapibackend.dto.ChargeDetailsSearchDTO;
import com.nvoccapi.nvoccapibackend.model.ChargeDetails;


@Repository
public class ChargesRepository {
     @Autowired
    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcCall simpleJdbcCall;
    public int saveChargesDetails(ChargeDetails chargesDetails) {
            simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
            .withProcedureName("spsavechargedetails")
            .declareParameters(
                    new SqlParameter("in_charge_id", Types.INTEGER),
                    new SqlParameter("in_user_id", Types.BIGINT),
                    new SqlParameter("in_charge_code", Types.VARCHAR),
                    new SqlParameter("in_charge_name", Types.VARCHAR),
                    new SqlParameter("in_charge_ledger", Types.VARCHAR),
                    new SqlParameter("in_charge_currency", Types.VARCHAR),
                    new SqlParameter("in_charge_type", Types.VARCHAR),
                    new SqlParameter("in_charge_gst", Types.VARCHAR),
                    new SqlParameter("in_charge_gstpercentage", Types.VARCHAR),
                    new SqlParameter("in_charge_vat", Types.VARCHAR),
                    new SqlParameter("in_charge_formula", Types.VARCHAR),
                    new SqlParameter("in_charge_limit", Types.VARCHAR),
                    new SqlParameter("in_charge_percentage", Types.VARCHAR),
                    new SqlParameter("in_charge_saccode", Types.VARCHAR) 
            );

            Map<String, Object> inParams = new HashMap<>();
            inParams.put("in_charge_id", chargesDetails.getChargeId());
            inParams.put("in_user_id", chargesDetails.getUser_id());
            inParams.put("in_charge_code", chargesDetails.getChargeCode());
            inParams.put("in_charge_name", chargesDetails.getChargeName());
            inParams.put("in_charge_ledger", chargesDetails.getChargeledger());
            inParams.put("in_charge_currency", chargesDetails.getChargecurrency());
            inParams.put("in_charge_type", chargesDetails.getChargetype());
            inParams.put("in_charge_gst", chargesDetails.getChargegst());
            inParams.put("in_charge_gstpercentage", chargesDetails.getChargegstpercentage());
            inParams.put("in_charge_vat", chargesDetails.getChargevat());
            inParams.put("in_charge_formula", chargesDetails.getChargeformula());
            inParams.put("in_charge_limit", chargesDetails.getChargelimit());
            inParams.put("in_charge_percentage", chargesDetails.getChargepercentage());
            inParams.put("in_charge_saccode", chargesDetails.getChargesaccode());
            simpleJdbcCall.execute(inParams);
            return 0; // Indicate success
    }

    public List<ChargeDetails> searchChargesDetails(ChargeDetailsSearchDTO searchDTO) {
        String sql = "SELECT * FROM spsearchchargedetails(?, ?, ?, ?)";
        return jdbcTemplate.query(sql, new Object[]{searchDTO.getChargeCode(), searchDTO.getChargeName(), searchDTO.getChargeCurrency(), searchDTO.getChargeType()}, new RowMapper<ChargeDetails>() {
            @Override
            public ChargeDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                ChargeDetails chargeDetails = new ChargeDetails();
                chargeDetails.setChargeId(rs.getInt("charge_id"));
                chargeDetails.setChargeCode(rs.getString("charge_code"));
                chargeDetails.setChargeName(rs.getString("charge_name"));
                chargeDetails.setChargeledger(rs.getString("charge_ledger"));
                chargeDetails.setChargecurrency(rs.getString("charge_currency"));
                chargeDetails.setChargetype(rs.getString("charge_type"));
                chargeDetails.setChargegst(rs.getString("charge_gst"));
                chargeDetails.setChargegstpercentage(rs.getString("charge_gstpercentage"));
                chargeDetails.setChargevat(rs.getString("charge_vat"));
                chargeDetails.setChargeformula(rs.getString("charge_formula"));
                chargeDetails.setChargelimit(rs.getString("charge_limit"));
                chargeDetails.setChargepercentage(rs.getString("charge_percentage"));
                chargeDetails.setChargesaccode(rs.getString("charge_saccode"));
                return chargeDetails;
            }
        });
    }

    public void deactivateChargesDetails(int charge_id) {
        SimpleJdbcCall simpleJdbcCallDeactivate = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("public")
                .withFunctionName("spdeactivatechargedetails")
                .declareParameters(new SqlParameter("in_charge_id", Types.INTEGER));

        Map<String, Object> params = new HashMap<>();
        params.put("in_charge_id",charge_id);

        simpleJdbcCallDeactivate.execute(params);
    }
    
    @SuppressWarnings("null")
    public int getChargesDetailsCount(int user_id) {
        SimpleJdbcCall simpleJdbcCallCount = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("public")
                .withFunctionName("spgetchargedetailscount")
                .declareParameters(new SqlParameter("in_user_id", Types.INTEGER));
        Map<String, Object> params = new HashMap<>();
        params.put("in_user_id",user_id);
        Integer chargedetailsCount = simpleJdbcCallCount.executeFunction(Integer.class,params);
        return chargedetailsCount;
    }

     public ChargeDetails getChargesDetailsById(int charge_Id) {
        String sql = "SELECT * FROM spgetchargedetailsbyid(?)";
        List<ChargeDetails> results = jdbcTemplate.query(sql, new Object[]{charge_Id}, new RowMapper<ChargeDetails>() {
            @Override
            public ChargeDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                ChargeDetails chargeDetails = new ChargeDetails();
                chargeDetails.setChargeId(rs.getInt("charge_id"));
                chargeDetails.setChargeCode(rs.getString("charge_code"));
                chargeDetails.setChargeName(rs.getString("charge_name"));
                chargeDetails.setChargeledger(rs.getString("charge_ledger"));
                chargeDetails.setChargecurrency(rs.getString("charge_currency"));
                chargeDetails.setChargetype(rs.getString("charge_type"));
                chargeDetails.setChargegst(rs.getString("charge_gst"));
                chargeDetails.setChargegstpercentage(rs.getString("charge_gstpercentage"));
                chargeDetails.setChargevat(rs.getString("charge_vat"));
                chargeDetails.setChargeformula(rs.getString("charge_formula"));
                chargeDetails.setChargelimit(rs.getString("charge_limit"));
                chargeDetails.setChargepercentage(rs.getString("charge_percentage"));
                chargeDetails.setChargesaccode(rs.getString("charge_saccode"));
                return chargeDetails;
            }
        });
        return results.isEmpty() ? null : results.get(0);
    }
}
