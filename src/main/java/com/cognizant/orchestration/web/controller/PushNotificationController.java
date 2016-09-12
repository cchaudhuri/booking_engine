package com.cognizant.orchestration.web.controller;

import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.orchestration.dto.EmptyResponse;
import com.cognizant.orchestration.dto.PushNotificationRequest;
import com.cognizant.orchestration.exception.BookingApplException;
import com.cognizant.orchestration.util.DeviceDetailsConstant;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * Rest Controller class for handling push notification related services.
 * 
 */
@RestController
public class PushNotificationController {

    /**
     * Mock service method which handles push notifications transports.
     * 
     * @param notificationRequest
     * @return success message
     */
    @RequestMapping(value = "/api/booking/notify/info", method = RequestMethod.POST)
    public EmptyResponse pushNotify(
        @ApiParam(value = "Triggers a push notification request") @RequestBody final PushNotificationRequest notificationRequest) {
        if (ObjectUtils.isEmpty(notificationRequest)) {
            throw new BookingApplException("Please specifiy push notification request details");
        }
        final EmptyResponse response = new EmptyResponse();
        response.setSuccess(DeviceDetailsConstant.PUSH_NOTIFY_SUCCESS_MSG);
        return response;
    }

}