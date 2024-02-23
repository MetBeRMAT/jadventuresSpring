package com.generation.jadventures.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.jadventures.entities.Party;
import com.generation.jadventures.entities.Quest;

public interface PartyRepository extends JpaRepository<Party,Integer>
{
    
}
