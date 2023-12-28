package com.example.group_services.dao.api;

import com.example.group_services.model.entity.UserGroupMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserGroupMappingRepository extends JpaRepository<UserGroupMapping, Long> {
    @Override
    UserGroupMapping save(UserGroupMapping userGroupMapping);

    List<UserGroupMapping> findByUserId(long userId);
    List<UserGroupMapping> findByGroupId(long groupId);
    UserGroupMapping findByGroupIdAndUserId(long groupId, long userId);
}
