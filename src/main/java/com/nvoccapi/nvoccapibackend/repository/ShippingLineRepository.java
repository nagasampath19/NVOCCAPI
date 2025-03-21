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

import com.nvoccapi.nvoccapibackend.dto.ShippinglineDetailsSearchDTO;
import com.nvoccapi.nvoccapibackend.model.ShippingLineDetails;


@Repository
public class ShippingLineRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveShippingLineDetails(ShippingLineDetails shippingLineDetails) {
        SimpleJdbcCall saveShippingDetailsCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("spSaveShippingLineDetails")
                .declareParameters(
                        new SqlParameter("in_shippingline_id", Types.INTEGER),
                        new SqlParameter("in_shippinglinecode", Types.VARCHAR),
                        new SqlParameter("in_shippingline_name", Types.VARCHAR),
                        new SqlParameter("in_shippinglineaddress", Types.VARCHAR),
                        new SqlParameter("in_shippinglineagentcode", Types.VARCHAR),
                        new SqlParameter("in_shippinglinelinecode", Types.VARCHAR),
                        new SqlParameter("in_shippinglinetype", Types.VARCHAR)
                );

        Map<String, Object> inParams = new HashMap<>();
        inParams.put("in_shippingline_id", shippingLineDetails.getShippingLineId() != null ? shippingLineDetails.getShippingLineId() : 0);
        inParams.put("in_shippinglinecode", shippingLineDetails.getShippingLineCode());
        inParams.put("in_shippingline_name", shippingLineDetails.getShippingLineName());
        inParams.put("in_shippinglineaddress", shippingLineDetails.getAddressLine1());
        inParams.put("in_shippinglineagentcode", shippingLineDetails.getAgentCode());
        inParams.put("in_shippinglinelinecode", shippingLineDetails.getLineCode());
        inParams.put("in_shippinglinetype", shippingLineDetails.getShippingLineType());
        saveShippingDetailsCall.execute(inParams);
    }

    public List<ShippingLineDetails> searchshippinglineDetails(ShippinglineDetailsSearchDTO searchDTO) {
        String sql = "SELECT * FROM spsearchshippinglinedetails(?, ?, ?)";
        return jdbcTemplate.query(sql, new Object[]{searchDTO.getShippinglinecode(), searchDTO.getShippinglinename(), searchDTO.getShippinglinetype()}, new RowMapper<ShippingLineDetails>() {
            @Override
            public ShippingLineDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                ShippingLineDetails shippinglineDetails = new ShippingLineDetails();
                shippinglineDetails.setShippingLineId(rs.getInt("shippingline_id"));
                shippinglineDetails.setShippingLineCode(rs.getString("shippinglinecode"));
                shippinglineDetails.setShippingLineName(rs.getString("shippinglinename"));
                shippinglineDetails.setAddressLine1(rs.getString("shippinglineaddress"));
                shippinglineDetails.setAgentCode(rs.getString("shippinglineagentcode"));
                shippinglineDetails.setLineCode(rs.getString("shippinglinelinecode"));
                shippinglineDetails.setShippingLineType(rs.getString("shippinglinetype"));
                return shippinglineDetails;
            }
        });
    }

    public void deactivateshippinglineDetails(int shippingline_id) {
        SimpleJdbcCall simpleJdbcCallDeactivate = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("public")
                .withFunctionName("spdeactivateshippinglinedetails")
                .declareParameters(new SqlParameter("in_shippingline_id", Types.INTEGER));

        Map<String, Object> params = new HashMap<>();
        params.put("in_shippingline_id", shippingline_id);

        simpleJdbcCallDeactivate.execute(params);
    }

    @SuppressWarnings("null")
    public int getshippinglineDetailsCount() {
        SimpleJdbcCall simpleJdbcCallCount = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("public")
                .withFunctionName("spgetshippinglinesdetailscount");

        Integer shippinglineCount = simpleJdbcCallCount.executeFunction(Integer.class);
        return shippinglineCount;
    }

    public ShippingLineDetails getshippinglineDetailsById(int shippinglineId) {
        String sql = "SELECT * FROM spgetshippinglinedetailsbyid(?)";
        List<ShippingLineDetails> results = jdbcTemplate.query(sql, new Object[]{shippinglineId}, new RowMapper<ShippingLineDetails>() {
            @Override
            public ShippingLineDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                ShippingLineDetails shippinglineDetails = new ShippingLineDetails();
                shippinglineDetails.setShippingLineId(rs.getInt("shippingline_id"));
                shippinglineDetails.setShippingLineCode(rs.getString("shippinglinecode"));
                shippinglineDetails.setShippingLineName(rs.getString("shippinglinename"));
                shippinglineDetails.setAddressLine1(rs.getString("shippinglineaddress"));
                shippinglineDetails.setAgentCode(rs.getString("shippinglineagentcode"));
                shippinglineDetails.setLineCode(rs.getString("shippinglinelinecode"));
                shippinglineDetails.setShippingLineType(rs.getString("shippinglinetype"));
                return shippinglineDetails;
            }
        });
        return results.isEmpty() ? null : results.get(0);
    }
}
