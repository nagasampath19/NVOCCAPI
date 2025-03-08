package com.nvoccapi.nvoccapibackend.repository;

import java.sql.Types;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.nvoccapi.nvoccapibackend.model.ShippingLineDetails;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class ShippingLineRepository {

    private static final Logger logger = LoggerFactory.getLogger(ShippingLineRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcCall simpleJdbcCall;

    @PostConstruct
    public void init() {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("spSaveShippingLineDetail")
                .declareParameters(
                        new SqlParameter("user_id", Types.INTEGER),
                        new SqlParameter("shippingLineCode", Types.VARCHAR),
                        new SqlParameter("shippingLineName", Types.VARCHAR),
                        new SqlParameter("addressLine1", Types.VARCHAR),
                        new SqlParameter("addressLine2", Types.VARCHAR),
                        new SqlParameter("agentCode", Types.VARCHAR),
                        new SqlParameter("lineCode", Types.VARCHAR),
                        new SqlParameter("shippingLineType", Types.VARCHAR),
                        new SqlOutParameter("v_shipping_line_id", Types.INTEGER)
                );
    }

    public int saveShippingLineDetails(ShippingLineDetails shippingLineDetails) {
        try {
            Map<String, Object> result = simpleJdbcCall.execute(
                    shippingLineDetails.getUserId(),
                    shippingLineDetails.getShippingLineCode(),
                    shippingLineDetails.getShippingLineName(),
                    shippingLineDetails.getAddressLine1(),
                    shippingLineDetails.getAddressLine2(),
                    shippingLineDetails.getAgentCode(),
                    shippingLineDetails.getLineCode(),
                    shippingLineDetails.getShippingLineType()
            );

            if (result.containsKey("v_shipping_line_id")) {
                return (int) result.get("v_shipping_line_id");
            } else {
                logger.error("Stored procedure did not return a shipping line ID.");
                return -1; // Indicate an error
            }
        } catch (Exception e) {
            logger.error("Error executing stored procedure: ", e);
            return -1; // Indicate an error
        }
    }
}