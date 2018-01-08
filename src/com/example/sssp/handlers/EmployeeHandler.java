package com.example.sssp.handlers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sssp.entities.Employee;
import com.example.sssp.service.EmployeeService;

@Controller
public class EmployeeHandler {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping(value="/emps")
    public String list(@RequestParam(value="pageNo",required=false,defaultValue="1")String pageNoStr,Map<String,Object> map){
    	int pageNo=1;
    	try {
    		//��pageNoУ��
    		pageNo=Integer.parseInt(pageNoStr);
    		if(pageNo<1){
    			pageNo=1;
    		}
		} catch (Exception e) {}
    	Page<Employee> page = employeeService.getPage(pageNo, 5);
    	map.put("page", page);
    	return "emp/list";
    }
}