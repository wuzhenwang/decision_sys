package edu.sxu.decision_sys.mapper;

import edu.sxu.decision_sys.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author wzw
 * @version 1.0
 * @description userMapper
 * @date 2020/5/1 18:27
 */
@Mapper
@Repository
public interface UserMapper {
    /**
     * 根据id查询
     * @param userId
     * @return
     */
    User queryById(String userId);

    /**
     * 通过用户名查询
     * @param username
     * @return
     */
    User queryByUsername(String username);
}
