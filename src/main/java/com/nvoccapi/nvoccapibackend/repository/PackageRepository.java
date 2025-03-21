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

import com.nvoccapi.nvoccapibackend.dto.PackageDetailsSearchDTO;
import com.nvoccapi.nvoccapibackend.model.PackageDetails;


@Repository
public class PackageRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void savePackageDetails(PackageDetails packageDetails) {

        SimpleJdbcCall saveVesselDetailsCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("spsavepackagedetails")
                .declareParameters(
                        new SqlParameter("in_packageid", Types.INTEGER),
                        new SqlParameter("in_packagecode", Types.VARCHAR),
                        new SqlParameter("in_packagedesc", Types.VARCHAR)
                );
        Map<String, Object> inParams = new HashMap<>();
        inParams.put("in_packageid", packageDetails.getPackageId() != null ? packageDetails.getPackageId() : 0);
        inParams.put("in_packagecode", packageDetails.getPackageCode());
        inParams.put("in_packagedesc", packageDetails.getDescription());
        saveVesselDetailsCall.execute(inParams);
    }

    public List<PackageDetails> searchPackageDetails(PackageDetailsSearchDTO searchDTO) {
        String sql = "SELECT * FROM spsearchpackagedetails(?, ?)";
        return jdbcTemplate.query(sql, new Object[]{searchDTO.getPackageCode(),searchDTO.getPackageDescription()}, new RowMapper<PackageDetails>() {
            @Override
            public PackageDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                PackageDetails packageDetails = new PackageDetails();
                packageDetails.setPackageId(rs.getInt("package_id"));
                packageDetails.setPackageCode(rs.getString("package_code"));
                packageDetails.setDescription(rs.getString("package_desc"));
                return packageDetails;
            }
        });
    }

    public void deactivatepackageDetails(int package_id) {
        SimpleJdbcCall simpleJdbcCallDeactivate = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("public")
                .withFunctionName("spdeactivatepackagedetails")
                .declareParameters(new SqlParameter("in_package_id", Types.INTEGER));

        Map<String, Object> params = new HashMap<>();
        params.put("in_package_id", package_id);

        simpleJdbcCallDeactivate.execute(params);
    }
    
    @SuppressWarnings("null")
    public int getpackageDetailsCount() {
        SimpleJdbcCall simpleJdbcCallCount = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("public")
                .withFunctionName("spgetpackagedetailscount");

        Integer packageCount = simpleJdbcCallCount.executeFunction(Integer.class);
        return packageCount;
    }

     public PackageDetails getpackageDetailsById(int packageId) {
        String sql = "SELECT * FROM spgetpackagedetailsbyid(?)";
        List<PackageDetails> results = jdbcTemplate.query(sql, new Object[]{packageId}, new RowMapper<PackageDetails>() {
            @Override
            public PackageDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                PackageDetails packageDetails = new PackageDetails();
                packageDetails.setPackageId(rs.getInt("package_id"));
                packageDetails.setPackageCode(rs.getString("package_code"));
                packageDetails.setDescription(rs.getString("package_desc"));
                return packageDetails;
            }
        });
        return results.isEmpty() ? null : results.get(0);
    }
}
