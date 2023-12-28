package com.example.expense_services.dao.api;

import com.example.expense_services.model.entity.Expense;
import com.example.expense_services.model.vo.ExpenseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.Date;
import java.util.List;

@Repository
public interface ExpenseRepository extends MongoRepository<Expense, String> {
    Expense findExpenseByExpenseId(String expenseId);
    List<Expense> findByCreatedBy(long userId);
    List<Expense> findByUserListUserId(long userId);
    List<Expense> findExpenseListByGroupId(long groupId);
    List<Expense> findByGroupIdAndCreatedBy(long groupId, long createdBy);
    List<Expense> findByUserListUserIdAndGroupId(long userId, long groupId);
    List<Expense> findByGroupIdAndCategory(long groupId, String category);
    List<Expense> findByCategoryAndUserListUserId(String category, long userId);
    List<Expense> findByCategoryAndCreatedBy(String category, long userId);
//    List<Expense> findExpensesByGroupIdAndUserListUserId(long groupId, long userId);
//    Expense findExpensesByExpenseIdAndUserListUserId(String expenseId, long userId);
}
