package myapp.controller;

import myapp.model.Employee;
import myapp.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


/**
 * Created by bisz on 4/7/17.
 */
@Controller
public class EmpController {
    @Autowired
    private EmpService empService;
//    @RequestMapping(value = "/hello")
//    public ModelAndView view() {
//        ModelAndView mav = new ModelAndView("hello");
//        return mav;
//    }
    @GetMapping("/hello")
    public String hello(Model model){
        return "hello";
    }

    @Transactional
    @RequestMapping("/index")
    public String setupForm(Map<String, Object>map){
        Employee employee = new Employee();
        map.put("employee", employee);
        map.put("employeeList", empService.getAllEmployee());
        return "employee";
    }

    @Transactional
    @RequestMapping(value = "/employee.do", method = RequestMethod.POST)
    public String doActions(@ModelAttribute Employee employee, @RequestParam String action,
                            Map<String, Object> map){
        Employee empResult = new Employee();
        switch (action.toLowerCase()) {
            case "add":
                empService.add(employee);
                empResult = employee;
                break;
            case "edit":
                empService.update(employee);
                empResult = employee;
                break;
            case "delete":
                empService.delete(employee.getEmpID());
                empResult = employee;
                break;
            case "search":
                Employee searchEmployee = empService.getEmployee(employee.getEmpID());
                empResult = searchEmployee!=null ? searchEmployee : new Employee();
                break;
        }
        map.put("employee", empResult);
        map.put("employeeList", empService.getAllEmployee());
        return "employee";
    }

}
