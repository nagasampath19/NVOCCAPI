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

import com.nvoccapi.nvoccapibackend.dto.NotifyDetailsSearchDTO;
import com.nvoccapi.nvoccapibackend.model.NotifyDetails;

@Repository
public class NotifyRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int saveNotifyDetails(NotifyDetails notifyDetails) {

        SimpleJdbcCall saveNotifyDetailsCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("spsavenotifydetails")
                .declareParameters(
                        new SqlParameter("in_notify_id", Types.BIGINT),
                        new SqlParameter("in_user_id", Types.BIGINT),
                        new SqlParameter("in_notifyname", Types.VARCHAR),
                        new SqlParameter("in_notifyaddress", Types.VARCHAR),
                        new SqlParameter("in_notifyemail", Types.VARCHAR),
                        new SqlParameter("in_notifyphone", Types.VARCHAR)
                );
        Map<String, Object> inParams = new HashMap<>();
        inParams.put("in_notify_id", notifyDetails.getNotify_id() != null ? notifyDetails.getNotify_id() : 0);
        inParams.put("in_user_id", notifyDetails.getUser_id());
        inParams.put("in_notifyname", notifyDetails.getNotify_name());
        inParams.put("in_notifyaddress", notifyDetails.getNotify_address());
        inParams.put("in_notifyemail", notifyDetails.getNotify_email());
        inParams.put("in_notifyphone", notifyDetails.getNotify_phone());

        saveNotifyDetailsCall.execute(inParams);
        return 0;

    }

    public List<NotifyDetails> getNotifyDetails(Long blId, int userId) {
        // Define the SQL query to call the PostgreSQL function
        String sql = "SELECT * FROM spgetnotifydetails(?, ?)";

        // Execute the query and map the result
        return jdbcTemplate.query(sql, new Object[]{blId, userId}, (rs, rowNum) -> {
            NotifyDetails details = new NotifyDetails();
            details.setNotify_id(rs.getLong("notify_id"));
            details.setNotify_name(rs.getString("notify_name"));
            details.setNotify_address(rs.getString("notify_address"));
            details.setNotify_email(rs.getString("notify_email"));
            details.setNotify_phone(rs.getString("notify_phone"));
            return details;
        });
    }

    public List<NotifyDetails> searchNotifyDetails(NotifyDetailsSearchDTO searchDTO) {
        String sql = "SELECT * FROM spsearchnotifydetails(?, ?,?)";
        return jdbcTemplate.query(sql, new Object[]{searchDTO.getNotifyPartyName(), searchDTO.getNotifyPartyEmail(), searchDTO.getNotifyPartyPhone()}, new RowMapper<NotifyDetails>() {
            @Override
            public NotifyDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                NotifyDetails details = new NotifyDetails();
                details.setNotify_id(rs.getLong("notify_id"));
                details.setNotify_name(rs.getString("notify_name"));
                details.setNotify_address(rs.getString("notify_address"));
                details.setNotify_email(rs.getString("notify_email"));
                details.setNotify_phone(rs.getString("notify_phone"));
                return details;
            }
        });
    }

    public void deactivateNotifyDetails(int notify_id) {
        SimpleJdbcCall simpleJdbcCallDeactivate = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("public")
                .withFunctionName("spdeactivatenotifydetails")
                .declareParameters(new SqlParameter("in_notify_id", Types.INTEGER));

        Map<String, Object> params = new HashMap<>();
        params.put("in_notify_id", notify_id);

        simpleJdbcCallDeactivate.execute(params);
    }

    public int getNotifyDetailsCount(int user_id) {
        SimpleJdbcCall simpleJdbcCallCount = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("public")
                .withFunctionName("spgetnotifydetailscount")
                .declareParameters(new SqlParameter("in_user_id", Types.INTEGER));

        Map<String, Object> params = new HashMap<>();
        params.put("in_user_id", user_id);

        Integer notifyDetailsCount = simpleJdbcCallCount.executeFunction(Integer.class, params);
        return notifyDetailsCount;
    }

    public NotifyDetails getNotifyDetailsById(int notify_id) {
        String sql = "SELECT * FROM spgetnotifydetailsbyid(?)";
        List<NotifyDetails> results = jdbcTemplate.query(sql, new Object[]{notify_id}, new RowMapper<NotifyDetails>() {
            @Override
            public NotifyDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                NotifyDetails details = new NotifyDetails();
                details.setNotify_id(rs.getLong("notify_id"));
                details.setNotify_name(rs.getString("notify_name"));
                details.setNotify_address(rs.getString("notify_address"));
                details.setNotify_email(rs.getString("notify_email"));
                details.setNotify_phone(rs.getString("notify_phone"));
                return details;
            }
        });
        return results.isEmpty() ? null : results.get(0);
    }
}
