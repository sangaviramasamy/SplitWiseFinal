package com.quinbay.customer.service;


import com.quinbay.customer.model.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.ResponseEntity;


import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class SplitwiseImple implements SplitwiseServices{


    @Autowired
    RestTemplate restTemplate;


    private static final String Group = "http://localhost:8081/httpmethod";
    String Notification = "http://localhost:8085/httpmethod";
    String Expense = "http://localhost:8089/httpmethod";

    public static final String LOGOUTURL = Group + "/logout";

    public ResponseEntity<Response> userLogin(LoginVo loginVo){
//        System.out.println("Inside the login");
        HttpHeaders headers = createHttpHeaders();
        HttpEntity<LoginVo> entity = new HttpEntity<>(loginVo, headers);
        Response responseEntity  = restTemplate.exchange(Group +"/login",HttpMethod.POST,entity,Response.class).getBody();
        return new ResponseEntity<Response>(responseEntity,HttpStatus.OK);

//        if (responseEntity.getToken() != null) {
//            String token = responseEntity.getToken();
//            System.out.println(token);
//            HttpHeaders responseHeaders = new HttpHeaders();
//            responseHeaders.add("Set-Cookie", "uid=" + token + "; Max-Age=" + "; HttpOnly; Path=/");
//            return new ResponseEntity<Response>(responseEntity,responseHeaders ,HttpStatus.OK);
//        }else {
//            System.out.println("Inside else");
//            return new ResponseEntity<Response>(responseEntity, HttpStatus.UNAUTHORIZED);
//
//        }

    }

    public List<GroupVo> filterGroupName(String groupName){
        HttpHeaders headers = createHttpHeaders();
        HttpEntity<List<GroupVo>> entity = new HttpEntity<>(headers);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(Group +"/filter-group/{groupName}").buildAndExpand(groupName);
        return restTemplate.exchange(builder.toUriString(),HttpMethod.GET,entity,List.class).getBody();

    }

    public List<UserVo> filterUserName(String userName){
        HttpHeaders headers = createHttpHeaders();
        HttpEntity<List<UserVo>> entity = new HttpEntity<>(headers);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(Group +"/filter-user/{userName}").buildAndExpand(userName);
        return restTemplate.exchange(builder.toUriString(),HttpMethod.GET,entity,List.class).getBody();
    }

    public Response groupSettlement(long userId , long groupId){
        HttpHeaders headers = createHttpHeaders();
        HttpEntity entity = new HttpEntity<>(headers);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(Expense +"/settlement/{userId}/{groupId}").buildAndExpand(userId,groupId);
        return restTemplate.exchange(builder.toUriString(),HttpMethod.PUT,entity,Response.class).getBody();
    }

    public Response nonGroupExpense(ExpenseVo expenseVo){
        HttpHeaders headers = createHttpHeaders();
        HttpEntity<ExpenseVo> entity = new HttpEntity<>(expenseVo, headers);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(Expense +"/non-group-expense").build();
        return restTemplate.exchange(builder.toUriString(),HttpMethod.POST,entity,Response.class).getBody();

    }

    public Response userRegister(long userId , LoginVo loginVo){
        HttpHeaders headers = createHttpHeaders();
        HttpEntity<LoginVo> entity = new HttpEntity<>(loginVo, headers);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(Group +"/register/{userId}").buildAndExpand(userId);
        return restTemplate.exchange(builder.toUriString(),HttpMethod.POST,entity,Response.class).getBody();
    }

    public Response userLogout(long userId){

        HttpHeaders headers = createHttpHeaders();
        LogoutVO logoutVO = new LogoutVO();
        logoutVO.setUserId(userId);
        HttpEntity<LogoutVO> entity = new HttpEntity<>(logoutVO, headers);

        return restTemplate.exchange(LOGOUTURL,HttpMethod.POST,
                entity,
                Response.class).getBody();
    }

    public UserVo userDetails(long userId){
        HttpHeaders headers = createHttpHeaders();
        HttpEntity<UserVo>  entity = new HttpEntity<>(headers);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(Group +"/user-details/{userId}").buildAndExpand(userId);
        return restTemplate.exchange(builder.toUriString(),HttpMethod.GET,entity,UserVo.class).getBody();
    }

    public Response updateGroup(long userId , GroupVo groupVo) {
        HttpHeaders headers = createHttpHeaders();
        HttpEntity<GroupVo> entity = new HttpEntity<>(groupVo, headers);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(Group +"/update/group/{userId}").buildAndExpand(userId);
        return restTemplate.exchange(builder.toUriString(),HttpMethod.PUT,entity,Response.class).getBody();
    }

    public Response addGroup(long userId, GroupVo groupVo){
        HttpHeaders headers = createHttpHeaders();
        HttpEntity<GroupVo> entity = new HttpEntity<>(groupVo, headers);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(Group +"/add/group/{userId}").buildAndExpand(userId);
        return restTemplate.exchange(builder.toUriString(),HttpMethod.POST,entity,Response.class).getBody();
    }

    public List<GroupVo> groupList(long userId){
        HttpHeaders headers = createHttpHeaders();
        HttpEntity<List<GroupVo>> entity = new HttpEntity<>(headers);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(Group +"/group-list/{userId}").buildAndExpand(userId);
        return restTemplate.exchange(builder.toUriString(),HttpMethod.GET,entity,List.class).getBody();
    }

    public GroupVo groupDetails(long groupId){
        HttpHeaders headers = createHttpHeaders();
        HttpEntity<GroupVo>  entity = new HttpEntity<>(headers);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(Group +"/group-details/{groupId}").buildAndExpand(groupId);
        return restTemplate.exchange(builder.toUriString(),HttpMethod.GET,entity,GroupVo.class).getBody();
    }

    public List<UserVo> getMemberList(long groupId){
        HttpHeaders headers = createHttpHeaders();
        HttpEntity<List<UserVo>> entity = new HttpEntity<>(headers);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(Group +"/group-member/{groupId}").buildAndExpand(groupId);
        return restTemplate.exchange(builder.toUriString(),HttpMethod.GET,entity,List.class).getBody();
    }

    public List<UserVo> userList(){
        HttpHeaders headers = createHttpHeaders();
        HttpEntity<List<UserVo>> entity = new HttpEntity<>(headers);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(Group +"/user-list").build();
        return restTemplate.exchange(builder.toUriString(),HttpMethod.GET,entity,List.class).getBody();
    }

    public String pendingPaymentCheck(long userId , long groupId){
        HttpHeaders headers = createHttpHeaders();
        HttpEntity entity = new HttpEntity<>(headers);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(Expense +"/payment-pending/{userId}/{groupId}").buildAndExpand(userId,groupId);
        return restTemplate.exchange(builder.toUriString(),HttpMethod.GET,entity,String.class).getBody();

    }


    public Response addNotification(NotificationVo notificationVo){

        HttpHeaders headers = createHttpHeaders();
        HttpEntity<NotificationVo> entity = new HttpEntity<>(notificationVo, headers);
        return restTemplate.exchange(Notification +"/add/notification",HttpMethod.POST,entity,Response.class).getBody();
    }

    public List<NotificationVo> notifyListByUserId(long userId){
        HttpHeaders headers = createHttpHeaders();
        HttpEntity<List<NotificationVo>> entity = new HttpEntity<>(headers);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(Notification +"/notify-list/{userId}").buildAndExpand(userId);
        return restTemplate.exchange(builder.toUriString(),HttpMethod.GET,entity,List.class).getBody();
    }

    public Response addExpense(ExpenseVo expenseVo){
        HttpHeaders headers = createHttpHeaders();
        HttpEntity<ExpenseVo> entity = new HttpEntity<>(expenseVo, headers);
        return restTemplate.exchange(Expense +"/add/expense",HttpMethod.POST,entity,Response.class).getBody();
    }

    public Response categoryList(){
        HttpHeaders headers = createHttpHeaders();
        HttpEntity entity = new HttpEntity<>(headers);
        return restTemplate.exchange(Expense +"/category-list",HttpMethod.GET,entity,Response.class).getBody();
    }

    public Response userPayment(String expenseId, long userId) {
        HttpHeaders headers = createHttpHeaders();
        HttpEntity entity = new HttpEntity<>(headers);
        return restTemplate.exchange(Expense +"/payment/"+expenseId+"/"+userId,HttpMethod.PUT,entity,Response.class).getBody();
    }

    public List<ExpenseVo> expenseList(long groupId){

        HttpHeaders headers = createHttpHeaders();
        HttpEntity<List<ExpenseVo>> entity = new HttpEntity<>(headers);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(Expense +"/expense-list/{groupId}").buildAndExpand(groupId);
        return restTemplate.exchange(builder.toUriString(),HttpMethod.GET,entity,List.class).getBody();
    }

    public UserExpenseSummary getUserExpenseSummary(long userId) {
        HttpHeaders headers = createHttpHeaders();
        HttpEntity<UserExpenseSummary> entity = new HttpEntity<>(headers);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(Expense +"/filter-amount/{userId}").buildAndExpand(userId);
        return restTemplate.exchange(builder.toUriString(),HttpMethod.GET,entity,UserExpenseSummary.class).getBody();
    }

    public Response notifyRead(long notifyId){
        HttpHeaders headers = createHttpHeaders();
        HttpEntity entity = new HttpEntity<>(headers);
        return restTemplate.exchange(Notification +"/notify-read/"+notifyId,HttpMethod.PUT,entity,Response.class).getBody();
    }

    public List<ExpenseVo> filterByGroupIdAndCategory(long groupId, String category) {
        HttpHeaders headers = createHttpHeaders();
        HttpEntity entity = new HttpEntity<>(headers);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Expense + "/filter-group-category")
                .queryParam("groupId", groupId)
                .queryParam("category", category);
        return restTemplate.exchange(builder.toUriString(),HttpMethod.GET,entity,List.class).getBody();

    }

    public List<UserExpenseSummary> filterAllCategory(long userId) {
        HttpHeaders headers = createHttpHeaders();
        HttpEntity<List<UserExpenseSummary>> entity = new HttpEntity<>(headers);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(Expense + "/filter/user-category/{userId}").buildAndExpand(userId);
        return restTemplate.exchange(builder.toUriString(),HttpMethod.GET,entity,List.class).getBody();
    }

    public List<ExpenseVo> filterByUserIdAndCategory(long userId, String category) {
        HttpHeaders headers = createHttpHeaders();
        HttpEntity entity = new HttpEntity<>(headers);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Expense + "/filter-user-category")
                .queryParam("userId", userId)
                .queryParam("category", category);
        return restTemplate.exchange(builder.toUriString(),HttpMethod.GET,entity,List.class).getBody();
    }

    public List<NonGroupExpenseVo> nonGroupPaymentsList(long createdUser , long receiverUser){
        HttpHeaders headers = createHttpHeaders();
        HttpEntity<List<NonGroupExpenseVo>> entity = new HttpEntity<>(headers);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(Expense + "/non-group-expenses/{createdUser}/{receiverUser}").buildAndExpand(createdUser,receiverUser);
        return restTemplate.exchange(builder.toUriString(),HttpMethod.GET,entity,List.class).getBody();

    }

    public Response addNonGroupExpense(NonGroupExpenseVo nonGroupVo){
        HttpHeaders headers = createHttpHeaders();
        HttpEntity<NonGroupExpenseVo> entity = new HttpEntity<>(nonGroupVo, headers);
        return restTemplate.exchange(Expense +"/add/non-group-expense",HttpMethod.POST,entity,Response.class).getBody();
    }

    public Response payNonGroupExpense(String expenseId, long memberId){
        HttpHeaders headers = createHttpHeaders();
        HttpEntity entity = new HttpEntity<>(headers);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(Expense +"/non-group-pay/{expenseId}/{memberId}").buildAndExpand(expenseId,memberId);
        return restTemplate.exchange(builder.toUriString(),HttpMethod.PUT,entity,Response.class).getBody();
    }


    private HttpHeaders createHttpHeaders(){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
