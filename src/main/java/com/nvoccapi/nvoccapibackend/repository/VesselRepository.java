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

import com.nvoccapi.nvoccapibackend.dto.VesselDetailsSearchDTO;
import com.nvoccapi.nvoccapibackend.model.CountryFlags;
import com.nvoccapi.nvoccapibackend.model.VesselDetails;

@Repository
public class VesselRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<CountryFlags> getAllCountries() {
        String sql = "SELECT * FROM spGetAllCountries()";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            CountryFlags country = new CountryFlags();
            country.setCountryid(rs.getInt("countryid"));
            country.setCountryname(rs.getString("countryname"));
            country.setCountrycode(rs.getString("countrycode"));
            country.setCountryflag(rs.getString("countryflag"));
            return country;
        });
    }

    public void saveVesselDetails(VesselDetails vesselDetails) {
        SimpleJdbcCall saveVesselDetailsCall = new SimpleJdbcCall(jdbcTemplate)
            .withProcedureName("spsavevesseldetails")
            .declareParameters(
                new SqlParameter("in_vesselid", Types.INTEGER),
                new SqlParameter("in_vesselname", Types.VARCHAR),
                new SqlParameter("in_vesselimocode", Types.VARCHAR),
                new SqlParameter("in_vesselflag", Types.VARCHAR),
                new SqlParameter("in_vesselcallsign", Types.VARCHAR)
            );

        Map<String, Object> inParams = new HashMap<>();
        inParams.put("in_vesselid", vesselDetails.getVesselid() != null ? vesselDetails.getVesselid() : 0);
        inParams.put("in_vesselname", vesselDetails.getVesselname());
        inParams.put("in_vesselimocode", vesselDetails.getVesselimocode());
        inParams.put("in_vesselflag", vesselDetails.getVesselflag());
        inParams.put("in_vesselcallsign", vesselDetails.getVesselcallsign());

        saveVesselDetailsCall.execute(inParams);
    }
    
    public List<VesselDetails> searchVesselDetails(VesselDetailsSearchDTO searchDTO) {
        String sql = "SELECT * FROM spsearchvesseldetails(?, ?, ?)";
        return jdbcTemplate.query(sql, new Object[]{searchDTO.getVesselname(),searchDTO.getVesselimocode(),searchDTO.getVesselcallsign()}, new RowMapper<VesselDetails>() {
            @Override
            public VesselDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                VesselDetails vesselDetails = new VesselDetails();
                vesselDetails.setVesselid(rs.getInt("vesselid"));
                vesselDetails.setVesselname(rs.getString("vesselname"));
                vesselDetails.setVesselimocode(rs.getString("vesselimocode"));
                vesselDetails.setVesselflag(rs.getString("vesselflag"));
                vesselDetails.setVesselcallsign(rs.getString("vesselcallsign"));
                return vesselDetails;
            }
        });
    }

    public void deactivateVesselDetails(int vessel_id) {
        SimpleJdbcCall simpleJdbcCallDeactivate = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("public")
                .withFunctionName("spdeactivatevesseldetails")
                .declareParameters(new SqlParameter("in_vessel_id", Types.INTEGER));

        Map<String, Object> params = new HashMap<>();
        params.put("in_vessel_id", vessel_id);

        simpleJdbcCallDeactivate.execute(params);
    }
    
    @SuppressWarnings("null")
    public int getVesselDetailsCount() {
        SimpleJdbcCall simpleJdbcCallCount = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("public")
                .withFunctionName("spgetvesseldetailscount");

        Integer vesselCount = simpleJdbcCallCount.executeFunction(Integer.class);
        return vesselCount;
    }

     public VesselDetails getVesselDetailsById(int vesselId) {
        String sql = "SELECT * FROM spgetvesseldetailsbyid(?)";
        List<VesselDetails> results = jdbcTemplate.query(sql, new Object[]{vesselId}, new RowMapper<VesselDetails>() {
            @Override
            public VesselDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                VesselDetails vesselDetails = new VesselDetails();
                vesselDetails.setVesselid(rs.getInt("vesselid"));
                vesselDetails.setVesselname(rs.getString("vesselname"));
                vesselDetails.setVesselimocode(rs.getString("vesselimocode"));
                vesselDetails.setVesselflag(rs.getString("vesselflag"));
                vesselDetails.setVesselcallsign(rs.getString("vesselcallsign"));
                return vesselDetails;
            }
        });
        return results.isEmpty() ? null : results.get(0);
    }
}
