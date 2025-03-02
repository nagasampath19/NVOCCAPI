package com.nvoccapi.nvoccapibackend.repository;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.nvoccapi.nvoccapibackend.model.NotifyDetails;

import jakarta.annotation.PostConstruct;

@Repository
public class NotifyRepository {

    /*
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    private SimpleJdbcCall simpleJdbcCall;
    private SimpleJdbcCall simpleJdbcCallGet;

    public NotifyRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void init() {
        /*simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("spsavenotifydetails")
                .declareParameters(
                        new SqlParameter("in_user_id", Types.BIGINT),
                        new SqlParameter("in_bl_id", Types.INTEGER),
                        new SqlParameter("in_notifyname", Types.VARCHAR),
                        new SqlParameter("in_notifyaddress", Types.VARCHAR),
                        new SqlParameter("in_notifyemail", Types.VARCHAR),
                        new SqlParameter("in_notifyphone", Types.VARCHAR),
                        new SqlOutParameter("v_notify_id", Types.INTEGER)
                );
         this.simpleJdbcCallGet = new SimpleJdbcCall(jdbcTemplate)
                .withFunctionName("spgetnotifydetails2")
                .returningResultSet("notify_details",
                        BeanPropertyRowMapper.newInstance(NotifyDetails.class));
    }

    public int saveNotifyDetails(NotifyDetails notifyDetails) {
        try {
            Map<String, Object> result = simpleJdbcCall.execute(
                    notifyDetails.getUser_id(),
                    notifyDetails.getBl_id(),
                    notifyDetails.getName(),
                    notifyDetails.getAddress(),
                    notifyDetails.getEmail(),
                    notifyDetails.getPhone()
            );
            if (result.containsKey("v_notify_id")) {
                return (int) result.get("v_notify_id");
            } else {
                return -1; // Indicate an error
            }
        } catch (Exception e) {
            return -1; // Indicate an error
        }
    }

    public List<NotifyDetails> getNotifyDetails(int blId, int userId) {
        try {
            Map<String, Object> inputParams = Map.of(
                "in_bl_id", blId,
                "in_user_id", userId
            );
            Map<String, Object> result = simpleJdbcCall.execute(inputParams);

            // Extract and return the result set
            return (List<NotifyDetails>) result.get("notify_details");
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Indicate an error
        }
    }

    private static final class NotifyDetailsRowMapper implements RowMapper<NotifyDetails> {
        @Override
        public NotifyDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
            NotifyDetails notifyDetails = new NotifyDetails();
            notifyDetails.setName(rs.getString("out_notify_id"));
            notifyDetails.setName(rs.getString("out_notify_name"));
            notifyDetails.setAddress(rs.getString("out_notify_address"));
            notifyDetails.setEmail(rs.getString("out_notify_email"));
            notifyDetails.setPhone(rs.getString("out_notify_phone"));
            return notifyDetails;
        }
    }
        */
        
        private final JdbcTemplate jdbcTemplate;
        private SimpleJdbcCall simpleJdbcCall;
        
        public NotifyRepository(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }

        @PostConstruct
        public void init() {

            simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("spsavenotifydetails")
                .declareParameters(
                        new SqlParameter("in_notify_id", Types.BIGINT),
                        new SqlParameter("in_user_id", Types.BIGINT),
                        new SqlParameter("in_bl_id", Types.INTEGER),
                        new SqlParameter("in_notifyname", Types.VARCHAR),
                        new SqlParameter("in_notifyaddress", Types.VARCHAR),
                        new SqlParameter("in_notifyemail", Types.VARCHAR),
                        new SqlParameter("in_notifyphone", Types.VARCHAR),
                        new SqlOutParameter("v_notify_id", Types.INTEGER)
                );

        }
    
        public int saveNotifyDetails(NotifyDetails notifyDetails) {
            try {
                Map<String, Object> result = simpleJdbcCall.execute(    
                        notifyDetails.getNotify_id(),
                        notifyDetails.getUser_id(),
                        notifyDetails.getBl_id(),
                        notifyDetails.getNotify_name(),
                        notifyDetails.getNotify_address(),
                        notifyDetails.getNotify_email(),
                        notifyDetails.getNotify_phone()
                );
                if (result.containsKey("v_notify_id")) {
                    return (int) result.get("v_notify_id");
                } else {
                    return -1; // Indicate an error
                }
            } catch (Exception e) {
                return -1; // Indicate an error
            }
        }
        
        public List<NotifyDetails> getNotifyDetails(Long blId, int userId) {
            // Define the SQL query to call the PostgreSQL function
            String sql = "SELECT * FROM spgetnotifydetails(?, ?)";
    
            // Execute the query and map the result
            return jdbcTemplate.query(sql, new Object[]{blId, userId}, (rs, rowNum) -> {
                NotifyDetails details = new NotifyDetails();
                details.setNotify_id(rs.getLong("out_notify_id"));
                details.setBl_id(rs.getLong("out_bl_id"));
                details.setUser_id(rs.getInt("out_user_id"));
                details.setNotify_name(rs.getString("out_notify_name"));
                details.setNotify_address(rs.getString("out_notify_address"));
                details.setNotify_email(rs.getString("out_notify_email"));
                details.setNotify_phone(rs.getString("out_notify_phone"));
                return details;
            });
        }
}
