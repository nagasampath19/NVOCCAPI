package com.nvoccapi.nvoccapibackend.repository;

import java.sql.Types;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.nvoccapi.nvoccapibackend.model.ShipperDetails;

import jakarta.annotation.PostConstruct;

@Repository
public class ShipperRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcCall simpleJdbcCall;

    @PostConstruct
    public void init() {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("spSaveShipperDetails")
                .declareParameters(
                        new SqlParameter("user_id", Types.BIGINT),
                        new SqlParameter("shipperName", Types.VARCHAR),
                        new SqlParameter("shipperAddress1", Types.VARCHAR),
                        new SqlParameter("shipperAddress2", Types.VARCHAR),
                        new SqlParameter("shipperCity", Types.VARCHAR),
                        new SqlParameter("shipperState", Types.VARCHAR),
                        new SqlParameter("shipperCountry", Types.VARCHAR),
                        new SqlParameter("shipperEmail", Types.VARCHAR),
                        new SqlParameter("shipperPhone", Types.VARCHAR),
                        new SqlParameter("shipperPinCode", Types.VARCHAR),
                        new SqlParameter("shipperCIN", Types.VARCHAR),
                        new SqlOutParameter("v_bl_id", Types.INTEGER) // Ensure this matches the stored procedure's output parameter
                );
    }

    public int saveShippingDetails(ShipperDetails shippingDetails) {
        try {
            Map<String, Object> result = simpleJdbcCall.execute(
                    shippingDetails.getUser_id(),
                    shippingDetails.getShipperName(),
                    shippingDetails.getShipperAddress1(),
                    shippingDetails.getShipperAddress2(),
                    shippingDetails.getShipperCity(),
                    shippingDetails.getShipperState(),
                    shippingDetails.getShipperCountry(),
                    shippingDetails.getShipperEmail(),
                    shippingDetails.getShipperPhone(),
                    shippingDetails.getShipperPinCode(),
                    shippingDetails.getShipperCIN()
            );
            if (result.containsKey("v_bl_id")) {
                return (int) result.get("v_bl_id");
            } else {
                return -1; // Indicate an error
            }
        } catch (Exception e) {
            return -1; // Indicate an error
        }
    }
}