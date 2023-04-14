package br.com.infnet.usuario.service;

import br.com.infnet.usuario.model.Admin;
import br.com.infnet.usuario.repository.IAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    IAdminRepository adminRepository;

    public void addAdmin(Admin admin) {
        adminRepository.save(admin);
    }
}
