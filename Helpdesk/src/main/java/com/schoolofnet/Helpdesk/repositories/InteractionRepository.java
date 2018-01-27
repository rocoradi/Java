/**
 * @author Coradi
 *
 * 1 de jan de 2018
 */
package com.schoolofnet.Helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolofnet.Helpdesk.models.Interaction;

@Repository
public interface InteractionRepository extends JpaRepository<Interaction, Long> {

}