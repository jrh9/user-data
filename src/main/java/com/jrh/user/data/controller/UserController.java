package com.jrh.user.data.controller;

import com.jrh.user.data.dto.CreateUserBean;
import com.jrh.user.data.dto.UpdateUserBean;
import com.jrh.user.data.service.UserService;
import com.jrh.user.data.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.net.HttpURLConnection;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jrh.user.data.dto.CreateUserBean;
import com.jrh.user.data.dto.UpdateUserBean;
import com.jrh.user.data.dto.UserParameterBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@Produces({MediaType.APPLICATION_JSON})
@Path("/user")
@RestController
public interface UserController {

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Saves a new user",
            notes = "Returns the newly created user",
            response = Response.class)
    @ApiResponses(value = {
            @ApiResponse(code = HttpURLConnection.HTTP_CREATED, message = "User created successfully", response = User.class),
            @ApiResponse(code = HttpURLConnection.HTTP_BAD_REQUEST, message = "Invalid client input", response = String.class),
            @ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Internal Server Error", response = String.class)}
    )
    @RequestMapping(method = RequestMethod.POST, value = "post")
    /**
     * The endpoint that provides the functionality to save an user based on the fields provided
     * @param bean The object containing the fields necessary
     * to create an user
     * @return A Response object with the user object as its entity
     * @throws SdaException
     */
    Response createUser(
            @ApiParam(value = "JSON user request body is required.", required = true)
            @RequestBody CreateUserBean bean) throws Exception;


    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Searches for users",
            notes = "Searches for users in the database by filters",
            response = Response.class)
    @ApiResponses(value = {
            @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "User was found", response = User.class),
            @ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Internal Server Error", response = String.class)}
    )
    @RequestMapping(method = RequestMethod.GET, value = "get")
    /**
     * The endpoint that provides the functionality to retrieve users based on the criteria provided
     * @param bean The object containing the search criteria query parameters
     * @return A Response object with the list of users as its entity
     * @throws SdaException
     */
    Response getUsers(
            @ApiParam(value = "The query parameters for the search criteria", required = false)
            @BeanParam UserParameterBean paramBean) throws Exception;

}
