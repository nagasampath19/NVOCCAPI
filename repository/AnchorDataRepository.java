package com.nvoccapi.nvoccapibackend.repository;

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

import com.nvoccapi.nvoccapibackend.model.PortDetails;

@Repository
public class AnchorDataRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int savePortDetails(PortDetails portDetails) {
        SimpleJdbcCall simpleJdbcCallSave = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("public")
                .withFunctionName("spsaveportdetails")
                .declareParameters(
                        new SqlParameter("in_port_id", Types.INTEGER),
                        new SqlParameter("in_portcode", Types.VARCHAR),
                        new SqlParameter("in_portname", Types.VARCHAR),
                        new SqlParameter("in_cfsaddress", Types.VARCHAR),
                        new SqlParameter("in_edicode", Types.VARCHAR),
                        new SqlParameter("in_jnptcode", Types.VARCHAR),
                        new SqlParameter("in_nsictgroupcode", Types.VARCHAR),
                        new SqlParameter("in_gticode", Types.VARCHAR),
                        new SqlParameter("in_gtigroupname", Types.VARCHAR),
                        new SqlParameter("in_bmctcode", Types.VARCHAR),
                        new SqlParameter("in_nsigtcode", Types.VARCHAR),
                        new SqlParameter("in_porttype", Types.INTEGER)
                );

        Map<String, Object> params = new HashMap<>();
        params.put("in_port_id", portDetails.getPort_id());
        params.put("in_portcode", portDetails.getPortcode());
        params.put("in_portname", portDetails.getPortname());
        params.put("in_cfsaddress", portDetails.getCfsaddress());
        params.put("in_edicode", portDetails.getEdicode());
        params.put("in_jnptcode", portDetails.getJnptcode());
        params.put("in_nsictgroupcode", portDetails.getNsictgroupcode());
        params.put("in_gticode", portDetails.getGticode());
        params.put("in_gtigroupname", portDetails.getGtigroupname());
        params.put("in_bmctcode", portDetails.getBmctcode());
        params.put("in_nsigtcode", portDetails.getNsigtcode());
        params.put("in_porttype", portDetails.getPorttype());

        Map<String, Object> result = simpleJdbcCallSave.execute(params);
        return (int) result.get("v_port_id");
    }

    public List<PortDetails> searchPortDetails(int porttype, String portcode, String portname) {
        String sql = "SELECT * FROM spsearchportdetails(?, ?, ?)";
        return jdbcTemplate.query(sql, new Object[]{porttype, portcode, portname}, new RowMapper<PortDetails>() {
            @Override
            public PortDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                PortDetails portDetails = new PortDetails();
                portDetails.setPort_id(rs.getInt("port_id"));
                portDetails.setPortcode(rs.getString("portcode"));
                portDetails.setPortname(rs.getString("portname"));
                portDetails.setCfsaddress(rs.getString("cfsaddress"));
                portDetails.setEdicode(rs.getString("edicode"));
                portDetails.setJnptcode(rs.getString("jnptcode"));
                portDetails.setNsictgroupcode(rs.getString("nsictgroupcode"));
                portDetails.setGticode(rs.getString("gticode"));
                portDetails.setGtigroupname(rs.getString("gtigroupname"));
                portDetails.setBmctcode(rs.getString("bmctcode"));
                portDetails.setNsigtcode(rs.getString("nsigtcode"));
                portDetails.setPorttype(rs.getInt("porttype"));
                return portDetails;
            }
        });
    }

    public int getPortDetailsCount() {
        SimpleJdbcCall simpleJdbcCallCount = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("public")
                .withFunctionName("get_port_details_count");

        return simpleJdbcCallCount.executeFunction(Integer.class);
    }
}
