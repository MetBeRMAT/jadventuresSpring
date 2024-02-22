package com.generation.jadventures.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.jadventures.entities.Quest;
import com.generation.jadventures.model.dto.quest.QuestDtoR;
import com.generation.jadventures.model.dto.quest.QuestDtoRpost;
import com.generation.jadventures.model.dto.quest.QuestDtoRput;

public interface QuestRepository extends JpaRepository<Quest,Integer>
{

    Object save(QuestDtoRput q);

}
