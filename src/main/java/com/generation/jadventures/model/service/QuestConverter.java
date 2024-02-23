package com.generation.jadventures.model.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.generation.jadventures.entities.Guild;
import com.generation.jadventures.entities.Quest;
import com.generation.jadventures.model.dto.quest.QuestDtoBase;
import com.generation.jadventures.model.dto.quest.QuestDtoR;
import com.generation.jadventures.model.repositories.GuildRepository;
import com.generation.jadventures.model.repositories.QuestRepository;

public class QuestConverter 
{
    @Autowired
    QuestRepository qRepo;
    @Autowired
    GuildRepository gRepo;

    public QuestDtoBase questToDtoBase (Quest q)
    {
        return QuestDtoBase
                .builder()
                .date_created(q.getDate_created())
                .status(q.getStatus())
                .rank(q.getRank())
                .reward(q.getReward())
                .area(q.getArea())
                .date_completed(q.getDate_completed())
                .map_url(q.getMap_url())
                .description(q.getDescription())
                .type(q.getType())
                .build();

    }

    public QuestDtoR questToDtoR (Quest dto)
    {
        return QuestDtoR
                .builder()
                .id(dto.getId())
                .date_created(dto.getDate_created())
                .status(dto.getStatus())
                .rank(dto.getRank())
                .reward(dto.getReward())
                .area(dto.getArea())
                .date_completed(dto.getDate_completed())
                .map_url(dto.getMap_url())
                .description(dto.getDescription())
                .type(dto.getType())
                .build();



    }
public Quest dtoRpostToQuest (QuestDtoR dto)
    {
        Guild g = gRepo.findById(dto.getGuild_id()).get();
        return  Quest
                .builder()
                .date_created(dto.getDate_created())
                .status(dto.getStatus())
                .rank(dto.getRank())
                .reward(dto.getReward())
                .area(dto.getArea())
                .date_completed(dto.getDate_completed())
                .map_url(dto.getMap_url())
                .description(dto.getDescription())
                .type(dto.getType())
                .guild(g)
                .build();

    }

    public Quest dtoRputToQuest (QuestDtoR dto)
    {   
        Guild g = gRepo.findById(dto.getGuild_id()).get();
        return 
        Quest
                .builder()
                .id(dto.getId())
                .date_created(dto.getDate_created())
                .status(dto.getStatus())
                .rank(dto.getRank())
                .reward(dto.getReward())
                .area(dto.getArea())
                .date_completed(dto.getDate_completed())
                .map_url(dto.getMap_url())
                .description(dto.getDescription())
                .type(dto.getType())
                .guild(g)
                .build();
    }


}
//gaetanodaje