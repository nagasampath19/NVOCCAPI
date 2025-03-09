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

import com.nvoccapi.nvoccapibackend.dto.ConsigneeDetailsSearchDTO;
import com.nvoccapi.nvoccapibackend.model.ConsigneeDetails;

@Repository
public class ConsigneeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcCall simpleJdbcCall;
    public int saveConsigneeDetails(ConsigneeDetails consigneeDetails) {
            simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
            .withProcedureName("spsaveconsigneedetails")
            .declareParameters(
                    new SqlParameter("in_consignee_id", Types.BIGINT),
                    new SqlParameter("in_user_id", Types.BIGINT),
                    new SqlParameter("in_ConsigneeName", Types.VARCHAR),
                    new SqlParameter("in_ConsigneeAddress1", Types.VARCHAR),
                    new SqlParameter("in_ConsigneeAddress2", Types.VARCHAR),
                    new SqlParameter("in_ConsigneeCity", Types.VARCHAR),
                    new SqlParameter("in_ConsigneeState", Types.VARCHAR),
                    new SqlParameter("in_ConsigneeCountry", Types.VARCHAR),
                    new SqlParameter("in_ConsigneeEmail", Types.VARCHAR),
                    new SqlParameter("in_ConsigneePhone", Types.VARCHAR),
                    new SqlParameter("in_ConsigneePinCode", Types.VARCHAR),
                    new SqlParameter("in_consignee_gstin", Types.VARCHAR),
                    new SqlParameter("in_consignee_pan", Types.VARCHAR),
                    new SqlParameter("in_consignee_iec", Types.VARCHAR)
            );

            Map<String, Object> inParams = new HashMap<>();
            inParams.put("in_consignee_id", consigneeDetails.getConsignee_Id());
            inParams.put("in_user_id", consigneeDetails.getUser_id());
            inParams.put("in_ConsigneeName", consigneeDetails.getConsigneeName());
            inParams.put("in_ConsigneeAddress1", consigneeDetails.getConsigneeAddress1());
            inParams.put("in_ConsigneeAddress2", consigneeDetails.getConsigneeAddress2());
            inParams.put("in_ConsigneeCity", consigneeDetails.getConsigneeCity());
            inParams.put("in_ConsigneeState", consigneeDetails.getConsigneeState());
            inParams.put("in_ConsigneeCountry", consigneeDetails.getConsigneeCountry());
            inParams.put("in_ConsigneeEmail", consigneeDetails.getConsigneeEmail());
            inParams.put("in_ConsigneePhone", consigneeDetails.getConsigneePhone());
            inParams.put("in_ConsigneePinCode", consigneeDetails.getConsigneePinCode());
            inParams.put("in_consignee_gstin", consigneeDetails.getConsigneeGSTIN());
            inParams.put("in_consignee_pan", consigneeDetails.getConsigneePAN());
            inParams.put("in_consignee_iec", consigneeDetails.getConsigneeIEC());

            simpleJdbcCall.execute(inParams);
            return 0; // Indicate success
    }

    public List<ConsigneeDetails> searchConsigneeDetails(ConsigneeDetailsSearchDTO searchDTO) {
        String sql = "SELECT consignee_id, consignee_name, consignee_address1, consignee_address2, consignee_city, consignee_state, consignee_country, consignee_pincode, consignee_email, consignee_phone, consignee_gstin, consignee_pan, consignee_iec, consignee_fulladdress FROM spsearchconsigneedetails(?, ?, ?, ?, ?)";
        return jdbcTemplate.query(sql, new Object[]{searchDTO.getConsigneename(), searchDTO.getConsigneeemail(), searchDTO.getConsigneephone(), searchDTO.getConsigneePAN(), searchDTO.getConsigneeIEC()}, new RowMapper<ConsigneeDetails>() {
            @Override
            public ConsigneeDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                ConsigneeDetails consigneeDetails = new ConsigneeDetails();
                consigneeDetails.setConsignee_Id(rs.getInt("consignee_id"));
                consigneeDetails.setConsigneeName(rs.getString("consignee_name"));
                consigneeDetails.setConsigneeAddress1(rs.getString("consignee_address1"));
                consigneeDetails.setConsigneeAddress2(rs.getString("consignee_address2"));
                consigneeDetails.setConsigneeCity(rs.getString("consignee_city"));
                consigneeDetails.setConsigneeState(rs.getString("consignee_state"));
                consigneeDetails.setConsigneeCountry(rs.getString("consignee_country"));
                consigneeDetails.setConsigneePinCode(rs.getString("consignee_pincode"));
                consigneeDetails.setConsigneeEmail(rs.getString("consignee_email"));
                consigneeDetails.setConsigneePhone(rs.getString("consignee_phone"));
                consigneeDetails.setConsigneeGSTIN(rs.getString("consignee_gstin"));
                consigneeDetails.setConsigneePAN(rs.getString("consignee_pan"));
                consigneeDetails.setConsigneeIEC(rs.getString("consignee_iec"));
                consigneeDetails.setConsignee_fulladdress(rs.getString("consignee_fulladdress"));
                return consigneeDetails;
            }
        });
    }

    public void deactivateConsigneeDetails(int consignee_id) {
        SimpleJdbcCall simpleJdbcCallDeactivate = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("public")
                .withFunctionName("spdeactivateconsigneedetails")
                .declareParameters(new SqlParameter("in_consignee_id", Types.INTEGER));

        Map<String, Object> params = new HashMap<>();
        params.put("in_consignee_id",consignee_id);

        simpleJdbcCallDeactivate.execute(params);
    }
    
    @SuppressWarnings("null")
    public int getConsigneeDetailsCount(int user_id) {
        SimpleJdbcCall simpleJdbcCallCount = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("public")
                .withFunctionName("spgetconsigneedetailscount")
                .declareParameters(new SqlParameter("in_user_id", Types.INTEGER));
        Map<String, Object> params = new HashMap<>();
        params.put("in_user_id",user_id);
        Integer consigneedetailsCount = simpleJdbcCallCount.executeFunction(Integer.class,params);
        return consigneedetailsCount;
    }

     public ConsigneeDetails getConsigneeDetailsById(int consignee_id) {
        String sql = "SELECT * FROM spgetconsigneedetailsbyid(?)";
        List<ConsigneeDetails> results = jdbcTemplate.query(sql, new Object[]{consignee_id}, new RowMapper<ConsigneeDetails>() {
            @Override
            public ConsigneeDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                ConsigneeDetails consigneeDetails = new ConsigneeDetails();
                consigneeDetails.setConsignee_Id(rs.getInt("consignee_id"));
                consigneeDetails.setConsigneeName(rs.getString("consignee_name"));
                consigneeDetails.setConsigneeAddress1(rs.getString("consignee_address1"));
                consigneeDetails.setConsigneeAddress2(rs.getString("consignee_address2"));
                consigneeDetails.setConsigneeCity(rs.getString("consignee_city"));
                consigneeDetails.setConsigneeState(rs.getString("consignee_state"));
                consigneeDetails.setConsigneeCountry(rs.getString("consignee_country"));
                consigneeDetails.setConsigneePinCode(rs.getString("consignee_pincode"));
                consigneeDetails.setConsigneeEmail(rs.getString("consignee_email"));
                consigneeDetails.setConsigneePhone(rs.getString("consignee_phone"));
                consigneeDetails.setConsigneeGSTIN(rs.getString("consignee_gstin"));
                consigneeDetails.setConsigneePAN(rs.getString("consignee_pan"));
                consigneeDetails.setConsigneeIEC(rs.getString("consignee_iec"));
                return consigneeDetails;
            }
        });
        return results.isEmpty() ? null : results.get(0);
    }
    
}