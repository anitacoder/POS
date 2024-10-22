package org.example.pos.Controller;

import lombok.RequiredArgsConstructor;
import org.example.pos.Model.Admin;
import org.example.pos.Model.Company;
import org.example.pos.Service.AdminService;
import org.example.pos.dto.request.AdminRequest;
import org.example.pos.dto.response.AdminResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/signadmin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/saveadmin")  // Corrected the mapping here
    public AdminResponse saveAdmin(@RequestBody @Validated AdminRequest adminRequest) {
        adminService.createAdmin(adminRequest);
        return new AdminResponse(adminRequest.getUsername());
    }

    @GetMapping(path ="/admins")
    public Admin getAllAdmins(){
        return (Admin) AdminService.getAllAdmins();
    }

    @GetMapping(path = "/{Id}")
    public Optional<Company> geAllAdminId(int admin_id){
        return AdminService.getAllAdminId(admin_id);
    }

    public String deleteAdmin(@PathVariable int adminId) {
        adminService.deleteAdmin(adminId);
        return "Admin with ID " + adminId + " has been deleted.";
    }
}