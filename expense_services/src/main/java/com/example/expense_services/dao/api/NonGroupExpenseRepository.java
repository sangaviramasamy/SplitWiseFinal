package com.example.expense_services.dao.api;

import com.example.expense_services.model.entity.NonGroupExpense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NonGroupExpenseRepository extends MongoRepository<NonGroupExpense, String> {
    List<NonGroupExpense> findByCreatedByAndReceiverUser(long createdBy, long receiverUser);
    NonGroupExpense findByExpenseId(String expenseId);
    List<NonGroupExpense> findByCategoryAndCreatedBy(String category , long createdBy);
    @Query("SELECT nonGroup FROM NonGroupExpense nonGroup WHERE nonGroup.category = :category AND (nonGroup.createdBy = :userId OR nonGroup.receiverUser = :userId)")
    List<NonGroupExpense> findByCategoryAndUserId(@Param("category") String category, @Param("userId") long userId);
    List<NonGroupExpense> findByCreatedBy(long createdBy);
    List<NonGroupExpense> findByReceiverUser(long receiverUser);

//    @Query("{'$or': [ {'createdBy': :createdUser, 'receiverUser': :receiverUser}, {'createdBy': :receiverUser, 'receiverUser': :createdUser} ]}")
//    List<NonGroupExpense> findByUserIds(@Param("createdUser") long createdUser, @Param("receiverUser") long receiverUser);
}