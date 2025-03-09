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

import com.nvoccapi.nvoccapibackend.dto.ShipperDetailsSearchDTO;
import com.nvoccapi.nvoccapibackend.model.ShipperDetails;


@Repository
public class ShipperRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int saveShipperDetails(ShipperDetails shipperDetails) {
        
            SimpleJdbcCall saveShipperDetailsCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("spsaveshipperdetails")
                .declareParameters(
                    new SqlParameter("in_shipper_id", Types.BIGINT),
                    new SqlParameter("in_user_id", Types.BIGINT),
                    new SqlParameter("in_shippername", Types.VARCHAR),
                    new SqlParameter("in_shipperaddress1", Types.VARCHAR),
                    new SqlParameter("in_shipperaddress2", Types.VARCHAR),
                    new SqlParameter("in_shippercity", Types.VARCHAR),
                    new SqlParameter("in_shipperstate", Types.VARCHAR),
                    new SqlParameter("in_shippercountry", Types.VARCHAR),
                    new SqlParameter("in_shipperemail", Types.VARCHAR),
                    new SqlParameter("in_shipperphone", Types.VARCHAR),
                    new SqlParameter("in_shipperpincode", Types.VARCHAR),
                    new SqlParameter("in_shippercin", Types.VARCHAR)
                );

            Map<String, Object> inParams = new HashMap<>();
            inParams.put("in_shipper_id", shipperDetails.getShipperid());
            inParams.put("in_user_id", shipperDetails.getUser_id());
            inParams.put("in_shippername", shipperDetails.getShipperName());
            inParams.put("in_shipperaddress1", shipperDetails.getShipperAddress1());
            inParams.put("in_shipperaddress2", shipperDetails.getShipperAddress2());
            inParams.put("in_shippercity", shipperDetails.getShipperCity());
            inParams.put("in_shipperstate", shipperDetails.getShipperState());
            inParams.put("in_shippercountry", shipperDetails.getShipperCountry());
            inParams.put("in_shipperemail", shipperDetails.getShipperEmail());
            inParams.put("in_shipperphone", shipperDetails.getShipperPhone());
            inParams.put("in_shipperpincode", shipperDetails.getShipperPinCode());
            inParams.put("in_shippercin", shipperDetails.getShipperCIN());

            saveShipperDetailsCall.execute(inParams);
            return 0; // Indicate success
    }
    public List<ShipperDetails> searchShipperDetails(ShipperDetailsSearchDTO searchDTO) {
        String sql = "SELECT * FROM spsearchshipperdetails(?, ?, ?)";
        return jdbcTemplate.query(sql, new Object[]{searchDTO.getShippername(),searchDTO.getEmail(),searchDTO.getPhone()}, new RowMapper<ShipperDetails>() {
            @Override
            public ShipperDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                ShipperDetails shipperDetails = new ShipperDetails();
                shipperDetails.setShipperid(rs.getInt("shipper_id"));
                shipperDetails.setShipperName(rs.getString("shipper_name"));
                shipperDetails.setShipperAddress1(rs.getString("shipper_address1"));
                shipperDetails.setShipperAddress2(rs.getString("shipper_address2"));
                shipperDetails.setShipperCountry(rs.getString("shipper_country"));
                shipperDetails.setShipperPinCode(rs.getString("shipper_pincode"));
                shipperDetails.setShipperEmail(rs.getString("shipper_email"));
                shipperDetails.setShipperPhone(rs.getString("shipper_phone"));
                shipperDetails.setShipperCIN(rs.getString("shippercin"));
                shipperDetails.setShipper_fulladdress(rs.getString("shipper_fulladdress"));
                return shipperDetails;
            }
        });
    }

    public void deactivateShipperDetails(int shipper_id) {
        SimpleJdbcCall simpleJdbcCallDeactivate = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("public")
                .withFunctionName("spdeactivateshipperdetails")
                .declareParameters(new SqlParameter("in_shipper_id", Types.INTEGER));

        Map<String, Object> params = new HashMap<>();
        params.put("in_shipper_id", shipper_id);

        simpleJdbcCallDeactivate.execute(params);
    }
    
    @SuppressWarnings("null")
    public int getShipperDetailsCount() {
        SimpleJdbcCall simpleJdbcCallCount = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("public")
                .withFunctionName("spgetshipperdetailscount");

        Integer shipperdetailsCount = simpleJdbcCallCount.executeFunction(Integer.class);
        return shipperdetailsCount;
    }

     public ShipperDetails getShipperDetailsById(int shipper_id) {
        String sql = "SELECT * FROM spgetshipperdetailsbyid(?)";
        List<ShipperDetails> results = jdbcTemplate.query(sql, new Object[]{shipper_id}, new RowMapper<ShipperDetails>() {
            @Override
            public ShipperDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                ShipperDetails shipperDetails = new ShipperDetails();
                shipperDetails.setShipperid(rs.getInt("shipper_id"));
                shipperDetails.setShipperName(rs.getString("shipper_name"));
                shipperDetails.setShipperAddress1(rs.getString("shipper_address1"));
                shipperDetails.setShipperAddress2(rs.getString("shipper_address2"));
                shipperDetails.setShipperCity(rs.getString("shipper_city"));
                shipperDetails.setShipperState(rs.getString("shipper_state"));
                shipperDetails.setShipperCountry(rs.getString("shipper_country"));
                shipperDetails.setShipperPinCode(rs.getString("shipper_pincode"));
                shipperDetails.setShipperEmail(rs.getString("shipper_email"));
                shipperDetails.setShipperPhone(rs.getString("shipper_phone"));
                shipperDetails.setShipperCIN(rs.getString("shippercin"));
                shipperDetails.setShipper_fulladdress(rs.getString("shipper_fulladdress"));
                return shipperDetails;
            }
        });
        return results.isEmpty() ? null : results.get(0);
    }
}