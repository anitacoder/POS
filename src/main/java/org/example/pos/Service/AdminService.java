package org.example.pos.Service;

import org.example.pos.Model.Admin;
import org.example.pos.Model.Company;
import org.example.pos.dto.request.AdminRequest;
import org.example.pos.dto.response.AdminResponse;

import java.util.List;
import java.util.Optional;

public interface AdminService {


    public AdminResponse createAdmin(AdminRequest adminRequest);

    static List<Admin> getAllAdmins() {
        return null;
    }

    static Optional<Company> getAllAdminId(int admin_id) {
        return null;
    }

    AdminResponse updateAdmin(int adminId, AdminRequest adminRequest);

    void deleteAdmin(int adminId);
}