package ra.formdatabinding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.formdatabinding.model.Employee;

@Controller
@RequestMapping("/")
public class EmployeeController {
    @GetMapping(value = {"/","/employee"})
    public String showForm(ModelMap model) {
        model.addAttribute("employee", new Employee());
        System.out.println("model" + model);
        return "employee/create";
    }

    @PostMapping("/addEmployee")
    public String submit(@ModelAttribute("employee") Employee employee, ModelMap model) {
        model.addAttribute("name", employee.getName());
        model.addAttribute("contactNumber", employee.getContactNumber());
        model.addAttribute("id", employee.getId());
        return "employee/info";
    }
}
