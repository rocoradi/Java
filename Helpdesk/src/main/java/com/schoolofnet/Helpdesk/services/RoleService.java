/**
 * @author Coradi
 *
 * 31 de dez de 2017
 */
package com.schoolofnet.Helpdesk.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.schoolofnet.Helpdesk.models.Role;

@Service
public interface RoleService {
	
	public List<Role> findAll();
	public Role create(Role role);
	public Boolean delete(Long id);
	public Role findByName(String name);

}
