package com.nvoccapi.nvoccapibackend.repository;

import java.sql.Types;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.nvoccapi.nvoccapibackend.model.PackageDetails;

import jakarta.annotation.PostConstruct;

@Repository
public class PackageRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcCall simpleJdbcCall;

    @PostConstruct
    public void init() {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("spSavePackageDetails")
                .declareParameters(
                        new SqlParameter("packageCode", Types.VARCHAR),
                        new SqlParameter("description", Types.VARCHAR),
                        new SqlOutParameter("v_package_id", Types.INTEGER)
                );
    }

    public int savePackageDetails(PackageDetails packageDetails) {
        try {
            Map<String, Object> result = simpleJdbcCall.execute(
                    packageDetails.getPackageCode(),
                    packageDetails.getDescription()
            );
            if (result.containsKey("v_package_id")) {
                return (int) result.get("v_package_id");
            } else {
                return -1; // Indicate an error
            }
        } catch (Exception e) {
            return -1; // Indicate an error
        }
    }
}