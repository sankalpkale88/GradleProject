package com.cts.rest.app;

/**
 * Created by cts1 on 2/18/14.
 */

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import java.util.HashMap;

import com.cts.rest.Employee;

import org.apache.log4j.Logger;

@Path("/")
public class TweeterApp {
    private org.apache.log4j.Logger logger = Logger.getLogger(TweeterApp.class);

    private static HashMap<Integer,Employee> employeeHashMap = new HashMap<Integer, Employee>();

    @GET
    @Path("getTweet")
    @Produces(MediaType.TEXT_PLAIN)
    public String getTweet() {
        return "Hi My First Tweet";
    }

    @POST
    @Path("tweet")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String postTweet(String msg) {
        String msg1 = "Your tweet is " + msg;
        return msg1;
    }

    @PUT
    @Path("addEmployee")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_XML)
    public String getTweet(JAXBElement<Employee> employeeJAXBElement) {

       Employee employee = employeeJAXBElement.getValue();
        employeeHashMap.put(employee.getId(),employee);

        return "Hi ," +employee.getName()+ "Your Id is "+ employee.getId();
    }


    @GET
    @Path("getEmployee/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployee(@PathParam("id") int  id) {

        logger.info("SANKY Id is "+ id);
        Employee employee = employeeHashMap.get(id);
        return employee;
    }


    @GET
    @Path("getEmployee")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployeeUsingQueryParam(@QueryParam("id") int  id) {

        logger.info("SANKY Query Param Id is "+ id);
        Employee employee = new Employee();
        employee.setId(1234);
        employee.setName("Ankit");
        //System.out.print("Employee is " + employee.getName());
        return employee;
    }

    @POST
    @Path("addJSONEmployee")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addEmployeeJSON(Employee employee) {
        employeeHashMap.put(employee.getId(),employee);
        return "Hi ," +employee.getName()+ "Your Id is "+ employee.getId();
    }

}
