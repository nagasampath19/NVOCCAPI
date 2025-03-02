package com.nvoccapi.nvoccapibackend.repository;

import java.sql.Types;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.nvoccapi.nvoccapibackend.model.ConsigneeDetails;

import jakarta.annotation.PostConstruct;

@Repository
public class ConsigneeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcCall simpleJdbcCall;

    @PostConstruct
    public void init() {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("spsaveconsigneedetails")
                .declareParameters(
                        new SqlParameter("in_user_id", Types.BIGINT),
                        new SqlParameter("in_bl_id", Types.INTEGER),
                        new SqlParameter("in_ConsigneeName", Types.VARCHAR),
                        new SqlParameter("in_ConsigneeAddress1", Types.VARCHAR),
                        new SqlParameter("in_ConsigneeAddress2", Types.VARCHAR),
                        new SqlParameter("in_ConsigneeCity", Types.VARCHAR),
                        new SqlParameter("in_ConsigneeState", Types.VARCHAR),
                        new SqlParameter("in_ConsigneeCountry", Types.VARCHAR),
                        new SqlParameter("in_ConsigneeEmail", Types.VARCHAR),
                        new SqlParameter("in_ConsigneePhone", Types.VARCHAR),
                        new SqlParameter("in_ConsigneePinCode", Types.VARCHAR),
                        new SqlParameter("in_ConsigneeRegNo", Types.VARCHAR),
                        new SqlParameter("in_ConsigneeTINNO", Types.VARCHAR),
                        new SqlOutParameter("v_bl_id", Types.INTEGER) 
                );
    }

    public int saveConsigneeDetails(ConsigneeDetails ConsigneeDetails) {
        try {
            Map<String, Object> result = simpleJdbcCall.execute(
                    ConsigneeDetails.getUser_id(),
                    ConsigneeDetails.getBL_ID(),
                    ConsigneeDetails.getConsigneeName(),
                    ConsigneeDetails.getConsigneeAddress1(),
                    ConsigneeDetails.getConsigneeAddress2(),
                    ConsigneeDetails.getConsigneeCity(),
                    ConsigneeDetails.getConsigneeState(),
                    ConsigneeDetails.getConsigneeCountry(),
                    ConsigneeDetails.getConsigneeEmail(),
                    ConsigneeDetails.getConsigneePhone(),
                    ConsigneeDetails.getConsigneePinCode(),
                    ConsigneeDetails.getConsigneeRegNo(),
                    ConsigneeDetails.getConsigneeTINNo()
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