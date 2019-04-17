/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Nguyen Duc Hoang
 */
@Named(value = "messageProducerBean")
@RequestScoped
public class MessageProducerBean {
    
    public MessageProducerBean() {
    }
    
}
