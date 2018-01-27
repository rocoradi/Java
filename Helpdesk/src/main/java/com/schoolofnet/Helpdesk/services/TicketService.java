/**
 * @author Coradi
 *
 * 1 de jan de 2018
 */
package com.schoolofnet.Helpdesk.services;

import java.util.List;

import org.springframework.ui.Model;

import com.schoolofnet.Helpdesk.models.Ticket;

public interface TicketService {

	public List<Ticket> findAll();
	public Model findAllTechinician(Model model);
	public Ticket create(Ticket ticket);
	public Boolean delete(Long id);
	public Boolean update(Long id, Ticket ticket);
	public Ticket show(Long id);
	public List<Ticket> reportTicketByDays(Integer day);
}
