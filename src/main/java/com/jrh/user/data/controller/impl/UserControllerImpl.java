package com.jrh.user.data.controller.impl;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.jrh.user.data.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jrh.user.data.service.UserService;
import com.jrh.user.data.controller.UserController;
import com.jrh.user.data.dto.CreateUserBean;
import com.jrh.user.data.dto.UserParameterBean;
import com.jrh.user.data.dto.UpdateUserBean;

import com.jrh.user.data.model.User;
import com.jrh.user.data.exception.UnexpectedErrorException;

/*
import com.jrh.monitoring.annotations.statuscodes.CommonStatusCodes;
import com.jrh.eg.monitoring.yawl.YawlLogger;
import com.jrh.user.data.exception.JsonInputInvalidException;
import com.jrh.user.data.exception.SdaException;
import com.jrh.user.data.service.UserService;
import com.jrh.user.data.service.rs.UserController;
import com.jrh.user.data.util.UserBeanValidator;
import com.jrh.user.data.util.SdaStatusCode;
import com.couchbase.client.java.error.DocumentAlreadyExistsException;
*/

@Component
public class UserControllerImpl implements UserController {

    //private static final YawlLogger logger = new YawlLogger(UserControllerImpl.class);
    private static final String USER = "user";

    @Autowired
    private UserService service;

    //@Autowired
    //private UserBeanValidator validator;

    @Override
    public Response createUser(final CreateUserBean userBean) throws ResourceNotFoundException {

        //logger.info(CommonStatusCodes.INFORMATIONAL, "Saving a user to the database with json", userBean);

        Response response;

        try {

            /*
            if (!validator.validateNewUser(userBean))
                throw new JsonInputInvalidException();
            */

            User newUser = service.createUser(userBean);

            //logger.info(SdaStatusCode.MANUFACTURER_SUCCESSFULLY_CREATED, MANUFACTURER, savedUser);

            response = Response.status(Status.CREATED).entity(newUser).build();
        /*
        } catch (DocumentAlreadyExistsException daee) {
            logger.error(SdaStatusCode.MANUFACTURER_ALREADY_EXISTS, daee);
            throw new ResourceNotFoundException(SdaStatusCode.MANUFACTURER_ALREADY_EXISTS, Status.BAD_REQUEST);
        } catch (ResourceNotFoundException sdaEx) {
            logger.error(sdaEx.getCode(), sdaEx);
            throw sdaEx;
        */
        } catch (Exception ex) {
            //logger.error(SdaStatusCode.UNEXPECTED_ERROR, ex);
            throw new UnexpectedErrorException();
        }

        return response;
    }

    @Override
    public Response getUsers(UserParameterBean paramBean) throws Exception {
        //logger.info(CommonStatusCodes.INFORMATIONAL, "Retrieving user with id", id);

        Response response;

        try {
            List<User> users = service.getUsers();

            if (users == null) {
                throw new ResourceNotFoundException();
                //throw new ResourceNotFoundException(SdaStatusCode.MANUFACTURER_NOT_FOUND, Status.BAD_REQUEST);
            }
            else {
                response = Response.ok().entity(users).build();
                //logger.info(SdaStatusCode.MANUFACTURER_SUCCESSFULLY_RETRIEVED, MANUFACTURER, user);
            }

        }
        /*
        catch (ResourceNotFoundException sdaEx) {
            logger.error(sdaEx.getCode(), sdaEx, "userId", id);
            throw sdaEx;
        }
        */
        catch (Exception ex) {
            //logger.error(SdaStatusCode.UNEXPECTED_ERROR, ex, "userId", id);
            throw new UnexpectedErrorException();
        }

        return response;
    }

    /*
    @Override
    public Response getUserById(final String id) throws ResourceNotFoundException {

        logger.info(CommonStatusCodes.INFORMATIONAL, "Retrieving user with id", id);

        Response response;

        try {
            UserModel user = service.getEntityById(id);

            if (user == null) {
                throw new ResourceNotFoundException(SdaStatusCode.MANUFACTURER_NOT_FOUND, Status.BAD_REQUEST);
            }
            else {
                response = Response.ok().entity(user).build();
                logger.info(SdaStatusCode.MANUFACTURER_SUCCESSFULLY_RETRIEVED, MANUFACTURER, user);
            }

        }
        catch (ResourceNotFoundException sdaEx) {
            logger.error(sdaEx.getCode(), sdaEx, "userId", id);
            throw sdaEx;
        }
        catch (Exception ex) {
            logger.error(SdaStatusCode.UNEXPECTED_ERROR, ex, "userId", id);
            throw new UnexpectedErrorException();
        }

        return response;
    }

    @Override
    public Response updateUser(UpdateUserBean bean) throws ResourceNotFoundException {

        logger.info(CommonStatusCodes.INFORMATIONAL, "Updating user name, modelId, and/or, model", bean);

        try {

            if (!validator.validateUpdateUser(bean))
                throw new JsonInputInvalidException();

            UserModel updatedUser = service.updateUser(bean);

            return Response.ok().entity(updatedUser).build();

        } catch (ResourceNotFoundException sdaEx) {
            logger.error(sdaEx.getCode(), sdaEx, "update user bean", bean);
            throw sdaEx;
        } catch (Exception ex) {
            logger.error(SdaStatusCode.UNEXPECTED_ERROR, ex, "update user bean", bean);
            throw new UnexpectedErrorException();
        }
    }

    @Override
    public Response deleteUser(String id) throws ResourceNotFoundException {

        logger.info(CommonStatusCodes.INFORMATIONAL, "Deleting user by id", id);

        Response response;

        try {
            UserModel userToDelete = service.getEntityById(id);

            if (userToDelete == null) {
                throw new ResourceNotFoundException(SdaStatusCode.MANUFACTURER_NOT_FOUND, Status.BAD_REQUEST);
            }
            else {
                response = Response.ok().entity(userToDelete).build();
                service.deleteEntity(id);
                logger.info(SdaStatusCode.MANUFACTURER_SUCCESSFULLY_DELETED, MANUFACTURER, userToDelete);
            }

        } catch (ResourceNotFoundException sdaEx) {
            logger.error(sdaEx.getCode(), sdaEx, "delete user by id", id);
            throw sdaEx;
        } catch (Exception ex) {
            logger.error(SdaStatusCode.UNEXPECTED_ERROR, ex, "delete user by id", id);
            throw new UnexpectedErrorException();
        }

        return response;
    }
    */
}