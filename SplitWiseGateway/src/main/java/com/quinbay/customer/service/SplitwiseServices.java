package com.quinbay.customer.service;


import com.quinbay.customer.model.vo.*;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface SplitwiseServices {
    Response userRegister(long userId , LoginVo loginVo);

    ResponseEntity<Response> userLogin(LoginVo loginVo);

    List<GroupVo> groupList(long userId);

    GroupVo groupDetails(long groupId);

    List<UserVo> getMemberList(long groupId);

    List<UserVo> userList();

    Response addNotification(NotificationVo notificationVo);

    List<NotificationVo> notifyListByUserId(long userId);

    List<ExpenseVo> expenseList(long groupId);

    UserExpenseSummary getUserExpenseSummary(long userId);

    Response userLogout(long userId);

    Response addGroup(long userId, GroupVo groupVo);

    Response addExpense(ExpenseVo expenseVo);

    Response userPayment(String expenseId, long userId);

    Response notifyRead(long notifyId);

    List<ExpenseVo> filterByGroupIdAndCategory(long groupId, String category);

    List<ExpenseVo> filterByUserIdAndCategory(long userId, String category);

    UserVo userDetails(long userId);

    Response updateGroup(long userId , GroupVo groupVo);

    List<UserExpenseSummary> filterAllCategory(long userId);

}
