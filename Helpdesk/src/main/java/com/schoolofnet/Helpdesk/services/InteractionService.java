/**
 * @author Coradi
 *
 * 1 de jan de 2018
 */
package com.schoolofnet.Helpdesk.services;

import com.schoolofnet.Helpdesk.models.Interaction;

public interface InteractionService {
	
	public Interaction create(Interaction interaction, Long ticketId);
	public Boolean delete(Long id, Long ticketId);
}
