package com.cts.rest;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by cts1 on 2/18/14.
 */

/**
 * <Employee>
 *     <name>Ankit</name>
 *     <id>12345</id>
 * </Employee>
 *
 * {"name":"Ankit","id":12545}
 */
@XmlRootElement
public class Employee {

    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
