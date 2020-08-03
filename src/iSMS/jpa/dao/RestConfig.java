/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iSMS.jpa.dao;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

 
/**
 *
 * This class is used to tell to the server that there are REST services.
 * An alternative is to declare a servlet in the web.xml.
 *
 * @author marco
 */
 
@ApplicationPath("/rest") // the 'rest' adress is mapped to the REST services
public class RestConfig extends Application{ // a javax.ws.rs.core.Application must be extended

}