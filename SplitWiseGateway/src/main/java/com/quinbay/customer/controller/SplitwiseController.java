package com.quinbay.customer.controller;


import com.quinbay.customer.model.vo.*;
import com.quinbay.customer.service.SplitwiseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/httpmethod")
@CrossOrigin(origins="*")
public class SplitwiseController {

    @Autowired
    SplitwiseServices splitwiseservice;

    @PostMapping("/register/{userId}")
    public Response userLoginRegister(@PathVariable long userId , @RequestBody LoginVo loginVo){
        return splitwiseservice.userRegister(userId , loginVo);
    }

    @PostMapping("/login")
    public ResponseEntity<Response> userLoginRequest(@RequestBody LoginVo loginVo){
        return splitwiseservice.userLogin(loginVo);
    }

    @PostMapping("/logout")
    public Response userLogoutRequest(@RequestBody LogoutVO logoutVO) {
        return splitwiseservice.userLogout(logoutVO.getUserId()); }

    @PostMapping("/add/group/{userId}")
    public Response addGroupRequest(@PathVariable long userId , @RequestBody GroupVo groupVo){
        return splitwiseservice.addGroup(userId , groupVo);
    }

    @GetMapping("/group-list/{userId}")
    public List<GroupVo> groupListForUser(@PathVariable long userId){

        return splitwiseservice.groupList(userId);
    }

    @GetMapping("/group-details/{groupId}")
    public GroupVo groupDetailsRequest(@PathVariable long groupId){
        return splitwiseservice.groupDetails(groupId);
    }

    @GetMapping("/group-member/{groupId}")
    public List<UserVo> groupMemberList(@PathVariable long groupId){
        return splitwiseservice.getMemberList(groupId);
    }

    @GetMapping("/user-list")
    public List<UserVo> allUserList(){
        return splitwiseservice.userList();
    }

    @PostMapping("/add/notification")
    public Response addNewNotification(@RequestBody NotificationVo notificationVo)
    {
        return splitwiseservice.addNotification(notificationVo);
    }

    @GetMapping("/notify-list/{userId}")
    public List<NotificationVo> notificationList(@PathVariable long userId){
        return splitwiseservice.notifyListByUserId(userId);
    }

    @PutMapping("/notify-read/{notificationId}")
    public Response notificationRead(@PathVariable long notifyId){
        return splitwiseservice.notifyRead(notifyId);
    }

    @PostMapping("/add/expense")
    public Response addNewExpense(@RequestBody ExpenseVo expenseVo){
        return splitwiseservice.addExpense(expenseVo);
    }

    @PutMapping("/payment/{expenseId}/{userId}")
    public Response userPaymentRequest(@PathVariable String expenseId , @PathVariable long userId){
        return splitwiseservice.userPayment(expenseId , userId);
    }

    @GetMapping("/expense-list/{groupId}")
    public List<ExpenseVo> groupExpenseList(@PathVariable long groupId){
        return splitwiseservice.expenseList(groupId);
    }

    @GetMapping("/filter-amount/{userId}")
    public UserExpenseSummary getUserExpenseSummaryRequest(@PathVariable long userId){
        return splitwiseservice.getUserExpenseSummary(userId);
    }

    @GetMapping("/filter-group-category")
    public List<ExpenseVo> filterGroupCategory(
            @RequestParam(name = "groupId") long groupId,
            @RequestParam(name = "category") String category){
        return splitwiseservice.filterByGroupIdAndCategory(groupId , category);
    }

    @GetMapping("filter/user-category/{userId}")
    public List<UserExpenseSummary> filterUserAllCategory(@PathVariable long userId){
        return splitwiseservice.filterAllCategory(userId);
    }

    @GetMapping("/user-details/{userId}")
    public UserVo userDetailsRequest(@PathVariable long userId){
        return splitwiseservice.userDetails(userId);
    }

    @PutMapping("/update/group/{userId}")
    public Response updateGroupDetails(@PathVariable long userId , @RequestBody GroupVo groupVo ){
        return splitwiseservice.updateGroup(userId , groupVo);
    }

}




