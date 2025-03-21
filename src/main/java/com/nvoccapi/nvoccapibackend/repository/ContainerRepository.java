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

import com.nvoccapi.nvoccapibackend.dto.ContainerDetailsSearchDTO;
import com.nvoccapi.nvoccapibackend.model.ContainerDetails;
import com.nvoccapi.nvoccapibackend.model.ContainerSize;

@Repository
public class ContainerRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcCall simpleJdbcCall;

    public int saveContainerDetails(ContainerDetails containerDetails) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("spsavecontainerdetails")
                .declareParameters(
                        new SqlParameter("in_container_id", Types.INTEGER),
                        new SqlParameter("in_user_id", Types.BIGINT),
                        new SqlParameter("in_container_number", Types.VARCHAR),
                        new SqlParameter("in_container_sizeid", Types.INTEGER),
                        new SqlParameter("in_container_typeid", Types.INTEGER),
                        new SqlParameter("in_container_agent", Types.VARCHAR),
                        new SqlParameter("in_container_purchasedate", Types.VARCHAR),
                        new SqlParameter("in_container_makeyear", Types.VARCHAR),
                        new SqlParameter("in_container_hire", Types.VARCHAR),
                        new SqlParameter("in_container_hiredate", Types.VARCHAR),
                        new SqlParameter("in_container_inventorytype", Types.VARCHAR),
                        new SqlParameter("in_container_locationid", Types.INTEGER),
                        new SqlParameter("in_container_currency", Types.VARCHAR),
                        new SqlParameter("in_container_amount", Types.DOUBLE),
                        new SqlParameter("in_container_freedays", Types.VARCHAR),
                        new SqlParameter("in_container_pickupcharge", Types.DOUBLE),
                        new SqlParameter("in_container_pickupcredit", Types.DOUBLE),
                        new SqlParameter("in_container_leasepurchsestartdate", Types.VARCHAR),
                        new SqlParameter("in_container_leasepurchseenddate", Types.VARCHAR),
                        new SqlParameter("in_container_offhirelocsold", Types.VARCHAR),
                        new SqlParameter("in_container_offhirelocsolddate", Types.VARCHAR)
                );

        Map<String, Object> inParams = new HashMap<>();
        inParams.put("in_container_id", containerDetails.getContainer_id());
        inParams.put("in_user_id", containerDetails.getUser_id());
        inParams.put("in_container_number", containerDetails.getContainer_number());
        inParams.put("in_container_sizeid", containerDetails.getContainer_sizeid());
        inParams.put("in_container_typeid", containerDetails.getContainer_typeid());
        inParams.put("in_container_agent", containerDetails.getContainer_agent());
        inParams.put("in_container_purchasedate", containerDetails.getContainer_purchasedate());
        inParams.put("in_container_makeyear", containerDetails.getContainer_makeyear());
        inParams.put("in_container_hire", containerDetails.getContainer_hire());
        inParams.put("in_container_hiredate", containerDetails.getContainer_hiredate());
        inParams.put("in_container_inventorytype", containerDetails.getContainer_inventorytype());
        inParams.put("in_container_locationid", containerDetails.getContainer_locationid());
        inParams.put("in_container_currency", containerDetails.getContainer_currency());
        inParams.put("in_container_amount", containerDetails.getContainer_amount());
        inParams.put("in_container_freedays", containerDetails.getContainer_freedays());
        inParams.put("in_container_pickupcharge", containerDetails.getContainer_pickupcharge());
        inParams.put("in_container_pickupcredit", containerDetails.getContainer_pickupcredit());
        inParams.put("in_container_leasepurchsestartdate", containerDetails.getContainer_leasepurchsestartdate());
        inParams.put("in_container_leasepurchseenddate", containerDetails.getContainer_leasepurchseenddate());
        inParams.put("in_container_offhirelocsold", containerDetails.getContainer_offhirelocsold());
        inParams.put("in_container_offhirelocsolddate", containerDetails.getContainer_offhirelocsolddate());

        simpleJdbcCall.execute(inParams);
        return 0; // Indicate success
    }

    public void deactivateContainerDetails(int containerId) {
        SimpleJdbcCall simpleJdbcCallDeactivate = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("public")
                .withFunctionName("spdeactivatecontainerdetails")
                .declareParameters(new SqlParameter("in_container_id", Types.INTEGER));

        Map<String, Object> params = new HashMap<>();
        params.put("in_container_id", containerId);

        simpleJdbcCallDeactivate.execute(params);
    }

    public int getContainerDetailsCount(int userId) {
        SimpleJdbcCall simpleJdbcCallCount = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("public")
                .withFunctionName("spgetcontainerdetailscount")
                .declareParameters(new SqlParameter("in_user_id", Types.INTEGER));
        Map<String, Object> params = new HashMap<>();
        params.put("in_user_id", userId);
        Integer containerDetailsCount = simpleJdbcCallCount.executeFunction(Integer.class, params);
        return containerDetailsCount;
    }

    public ContainerDetails getContainerDetailsById(int containerId) {
        String sql = "SELECT * FROM spgetcontainerdetailsbyid(?)";
        List<ContainerDetails> results = jdbcTemplate.query(sql, new Object[]{containerId}, new RowMapper<ContainerDetails>() {
            @Override
            public ContainerDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                ContainerDetails containerDetails = new ContainerDetails();
                containerDetails.setContainer_id(rs.getInt("container_id"));
                containerDetails.setContainer_number(rs.getString("container_number"));
                containerDetails.setContainer_sizeid(rs.getInt("container_sizeid"));
                containerDetails.setContainer_typeid(rs.getInt("container_typeid"));
                containerDetails.setContainer_agent(rs.getString("container_agent"));
                containerDetails.setContainer_purchasedate(rs.getString("container_purchasedate"));
                containerDetails.setContainer_makeyear(rs.getString("container_makeyear"));
                containerDetails.setContainer_hire(rs.getString("container_hire"));
                containerDetails.setContainer_hiredate(rs.getString("container_hiredate"));
                containerDetails.setContainer_inventorytype(rs.getString("container_inventorytype"));
                containerDetails.setContainer_locationid(rs.getInt("container_locationid"));
                containerDetails.setContainer_currency(rs.getString("container_currency"));
                containerDetails.setContainer_amount(rs.getDouble("container_amount"));
                containerDetails.setContainer_freedays(rs.getString("container_freedays"));
                containerDetails.setContainer_pickupcharge(rs.getDouble("container_pickupcharge"));
                containerDetails.setContainer_pickupcredit(rs.getDouble("container_pickupcredit"));
                containerDetails.setContainer_leasepurchsestartdate(rs.getString("container_leasepurchsestartdate"));
                containerDetails.setContainer_leasepurchseenddate(rs.getString("container_leasepurchseenddate"));
                containerDetails.setContainer_offhirelocsold(rs.getString("container_offhirelocsold"));
                containerDetails.setContainer_offhirelocsolddate(rs.getString("container_offhirelocsolddate"));
                return containerDetails;
            }
        });
        return results.isEmpty() ? null : results.get(0);
    }

    public List<ContainerDetails> searchContainerDetails(ContainerDetailsSearchDTO searchDTO) {
          String sql = "SELECT * FROM spsearchcontainerdetails(?, ?, ?)";
        return jdbcTemplate.query(sql, new Object[]{searchDTO.getContainer_number(), searchDTO.getContainer_sizeid(), searchDTO.getContainer_typeid()}, new RowMapper<ContainerDetails>() {
            @Override
            public ContainerDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                ContainerDetails containerDetails = new ContainerDetails();
                containerDetails.setContainer_id(rs.getInt("container_id"));
                containerDetails.setContainer_number(rs.getString("container_number"));
                containerDetails.setContainersize_type(rs.getString("containersize_type"));
                containerDetails.setContainertype_name(rs.getString("containertype_name"));
                return containerDetails;
            }
        });
    }

    public void SaveContainerSize(ContainerSize containerSize) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("public")
                .withFunctionName("spsavecontainersize")
                .declareParameters(
                        new SqlParameter("in_containersize_id", Types.INTEGER),
                        new SqlParameter("in_containersize_type", Types.VARCHAR),
                        new SqlParameter("in_containersize_desc", Types.VARCHAR),
                        new SqlParameter("in_containersize_isocode", Types.VARCHAR)
                );

        Map<String, Object> params = new HashMap<>();
        params.put("in_containersize_id", containerSize.getContainersize_id());
        params.put("in_containersize_type", containerSize.getContainersize_type());
        params.put("in_containersize_desc", containerSize.getContainersize_desc());
        params.put("in_containersize_isocode", containerSize.getContainersize_isocode());

        simpleJdbcCall.execute(params);
    }

    public List<ContainerSize> getContainerSizes() {
        String sql = "SELECT * FROM spgetcontainersizes()";
        return jdbcTemplate.query(sql, new RowMapper<ContainerSize>() {
            @Override
            public ContainerSize mapRow(ResultSet rs, int rowNum) throws SQLException {
                ContainerSize containerSize = new ContainerSize();
                containerSize.setContainersize_id(rs.getInt("containersize_id"));
                containerSize.setContainersize_type(rs.getString("containersize_type"));
                containerSize.setContainersize_desc(rs.getString("containersize_desc"));
                containerSize.setContainersize_isocode(rs.getString("containersize_isocode"));
                return containerSize;
            }
        });
    }
}