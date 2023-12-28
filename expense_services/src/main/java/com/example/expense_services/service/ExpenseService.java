package com.example.expense_services.service;

import com.example.expense_services.model.entity.Expense;
import com.example.expense_services.model.vo.ExpenseVo;
import com.example.expense_services.model.vo.NonGroupExpenseVo;
import com.example.expense_services.model.vo.Response;
import com.example.expense_services.model.vo.UserExpenseSummary;

import java.util.Date;
import java.util.List;

public interface ExpenseService {
    Response addExpense(ExpenseVo expenseVo);
    Response userPayment(String expenseId , long userId);
    List<ExpenseVo> expenseList(long groupId);
//    List<ExpenseVo> filterByUserIdAndCategory(long userId, String category);
    UserExpenseSummary getUserExpenseSummary(long userId);
    List<ExpenseVo> filterByGroupIdAndCategory(long groupId, String category);
    List<UserExpenseSummary> filterAllCategory(long userId);
    Response groupSettlement(long userId , long groupId);
    String pendingPaymentCheck(long userId , long groupId);
    Response categoryList();
}
