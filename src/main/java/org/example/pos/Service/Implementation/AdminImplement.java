package org.example.pos.Service.Implementation;

import org.example.pos.dto.request.AdminRequest;
import org.example.pos.dto.response.AdminResponse;
import org.example.pos.Model.Admin;
import org.example.pos.repository.AdminRepository;
import org.example.pos.Service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminImplement implements AdminService {
    private final AdminRepository adminRepository;

    public AdminResponse createAdmin(AdminRequest adminRequest) {
        Admin admin = new Admin();
        admin.setFullName(adminRequest.getFullName());
        admin.setEmail(adminRequest.getEmail());
        admin.setAdmin_Phone(adminRequest.getAdmin_Phone());
        admin.setUsername(adminRequest.getUsername());
        admin.setPassword(adminRequest.getPassword());

        Admin saveAdmin = adminRepository.save(admin);

        return new AdminResponse(saveAdmin.getUsername());
    }
    @Override
    public AdminResponse updateAdmin(int adminId, AdminRequest adminRequest) {
        Admin existingAdmin = adminRepository.findById(adminId).orElseThrow(() -> new IllegalStateException("Admin with ID " + adminId + " not found"));

        existingAdmin.setFullName(adminRequest.getFullName());
        existingAdmin.setEmail(adminRequest.getEmail());
        existingAdmin.setAdmin_Phone(adminRequest.getAdmin_Phone());
        existingAdmin.setUsername(adminRequest.getUsername());
        existingAdmin.setPassword(adminRequest.getPassword());

        Admin updatedAdmin = adminRepository.save(existingAdmin);
        return new AdminResponse(updatedAdmin.getUsername());
    }

    @Override
    public void deleteAdmin(int adminId) {
        Admin admin = adminRepository.findById(adminId).orElseThrow(() -> new IllegalStateException("Admin with ID " + adminId + " not found"));
        adminRepository.delete(admin);
    }
}