package com.generation.jadventures.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.jadventures.entities.Quest;
import com.generation.jadventures.model.dto.quest.QuestDtoR;
import com.generation.jadventures.model.dto.quest.QuestDtoWNoPatron;
import com.generation.jadventures.model.dto.quest.QuestDtoWNoQuestOfParty;
import com.generation.jadventures.model.dto.quest.QuestDtoWQuestOfParty;
import com.generation.jadventures.model.dto.quest.QuestDtoWWithPatron;
import com.generation.jadventures.model.repositories.GuildRepository;
import com.generation.jadventures.model.repositories.QuestRepository;

@Service
public class QuestConverter 
{
    @Autowired
    QuestRepository qRepo;
    @Autowired
    GuildRepository gRepo;

    public Quest DtoRToQuest (QuestDtoR dto)
    {
        return Quest
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

    public QuestDtoWWithPatron questToDtoWWithPatron (Quest q)
    {
        return QuestDtoWWithPatron
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
                .patron(q.getPatron())
                .build();
    }

    public QuestDtoWNoPatron questToDtoWNoPatron (Quest q)
    {
        return QuestDtoWNoPatron
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

    public QuestDtoWNoQuestOfParty questToDtoWNoQuestOfParty (Quest q)
    {
        return QuestDtoWNoQuestOfParty
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

    public QuestDtoWQuestOfParty questToDtoWQuestOfParty (Quest q)
    {
        return QuestDtoWQuestOfParty
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
                .questOfParty(q.getQuestOfParty())
                .build();
    }
}
//gaetanodaje