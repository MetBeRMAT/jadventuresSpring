package com.generation.jadventures.model.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.generation.jadventures.entities.Quest;
import com.generation.jadventures.model.dto.quest.QuestDtoBase;
import com.generation.jadventures.model.dto.quest.QuestDtoR;
import com.generation.jadventures.model.dto.quest.QuestDtoRpost;
import com.generation.jadventures.model.dto.quest.QuestDtoRput;
import com.generation.jadventures.model.repositories.QuestRepository;

public class QuestConverter 
{
    @Autowired
    QuestRepository qRepo;

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

    public QuestDtoR questToDtoR (Quest q)
    {
        return QuestDtoR
                .builder()
                .id(q.getId())
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

    public QuestDtoRpost questToDtoRpost (QuestDtoRpost dto)
    {
        return QuestDtoRpost
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
                .guild_id(dto.getGuild_id())
                .build();

    }

    public QuestDtoRput questToDtoRput (QuestDtoRput dto)
    {
        return QuestDtoRput
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
                .guild_id(dto.getGuild_id())
                .build();
    }


}
//gaetanodaje
