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

import com.nvoccapi.nvoccapibackend.dto.CommodityDetailsSearchDTO;
import com.nvoccapi.nvoccapibackend.model.CommodityDetails;

@Repository 
public class CommodityRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void savecommodityDetails(CommodityDetails commodityDetails) {

        SimpleJdbcCall saveCommodityDetailsCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("spsavecommoditydetails")
                .declareParameters(
                        new SqlParameter("in_commodityid", Types.INTEGER),
                        new SqlParameter("in_commodity_name", Types.VARCHAR),
                        new SqlParameter("in_commodity_imocode", Types.VARCHAR),
                        new SqlParameter("in_commodity_unocode", Types.VARCHAR)
                );
        Map<String, Object> inParams = new HashMap<>();
        inParams.put("in_commodityid", commodityDetails.getCommodityId() != null ? commodityDetails.getCommodityId() : 0);
        inParams.put("in_commodity_name", commodityDetails.getCommodityName());
        inParams.put("in_commodity_imocode", commodityDetails.getCommodityimocode());
        inParams.put("in_commodity_unocode", commodityDetails.getCommodityUnoCode());
        saveCommodityDetailsCall.execute(inParams);
    }

    public List<CommodityDetails> searchcommodityDetails(CommodityDetailsSearchDTO searchDTO) {
        String sql = "SELECT * FROM spsearchcommoditydetails(?, ?)";
        return jdbcTemplate.query(sql, new Object[]{searchDTO.getCommodity_name(),searchDTO.getCommodity_imocode()}, new RowMapper<CommodityDetails>() {
            @Override
            public CommodityDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                CommodityDetails commodityDetails = new CommodityDetails();
                commodityDetails.setCommodityId(rs.getInt("commodity_id"));
                commodityDetails.setCommodityName(rs.getString("commodity_name"));
                commodityDetails.setCommodityimocode(rs.getString("commodity_imocode"));
                commodityDetails.setCommodityUnoCode(rs.getString("commodity_unocode"));
                return commodityDetails;
            }
        });
    }

    public void deactivatecommodityDetails(int commodity_id) {
        SimpleJdbcCall simpleJdbcCallDeactivate = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("public")
                .withFunctionName("spdeactivatecommoditydetails")
                .declareParameters(new SqlParameter("in_commodity_id", Types.INTEGER));

        Map<String, Object> params = new HashMap<>();
        params.put("in_commodity_id", commodity_id);

        simpleJdbcCallDeactivate.execute(params);
    }
    
    @SuppressWarnings("null")
    public int getcommodityDetailsCount() {
        SimpleJdbcCall simpleJdbcCallCount = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("public")
                .withFunctionName("spgetcommoditydetailscount");

        Integer commodityCount = simpleJdbcCallCount.executeFunction(Integer.class);
        return commodityCount;
    }

     public CommodityDetails getcommodityDetailsById(int commodityId) {
        String sql = "SELECT * FROM spgetcommoditydetailsbyid(?)";
        List<CommodityDetails> results = jdbcTemplate.query(sql, new Object[]{commodityId}, new RowMapper<CommodityDetails>() {
            @Override
            public CommodityDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                CommodityDetails commodityDetails = new CommodityDetails();
                commodityDetails.setCommodityId(rs.getInt("commodity_id"));
                commodityDetails.setCommodityName(rs.getString("commodity_name"));
                commodityDetails.setCommodityimocode(rs.getString("commodity_imocode"));
                commodityDetails.setCommodityUnoCode(rs.getString("commodity_unocode"));
                return commodityDetails;
            }
        });
        return results.isEmpty() ? null : results.get(0);
    }
}
