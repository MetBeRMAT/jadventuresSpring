package com.generation.javdventures.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.jadventures.entities.Quest;
import com.generation.jadventures.model.dto.quest.QuestDtoR;
import com.generation.jadventures.model.dto.quest.QuestDtoWNoPatron;
import com.generation.jadventures.model.dto.quest.QuestDtoWQuestOfParty;
import com.generation.jadventures.model.dto.quest.QuestDtoWWithPatron;
import com.generation.jadventures.model.repositories.QuestRepository;
import com.generation.jadventures.model.service.QuestConverter;

@RestController
@CrossOrigin
public class QuestController {
    @Autowired
    QuestRepository repo;
    @Autowired
    QuestConverter conv;

    @GetMapping("/quests")
    public List<QuestDtoWNoPatron> getAll()
    {
        return repo.findAll().stream().map(d -> conv.questToDtoWNoPatron(d)).toList();
    }

    @GetMapping("/quests/{id}")
    public QuestDtoWNoPatron getOneWithNoGuild(@PathVariable Integer id)
    {
        return conv.questToDtoWNoPatron(repo.findById(id).get());
    }

    @GetMapping("/quests/{id}/patron")
    public QuestDtoWWithPatron getOneWithGuild(@PathVariable Integer id)
    {
        return conv.questToDtoWWithPatron(repo.findById(id).get());
    }

    @GetMapping("/quests/{id}/questofparty")
    public QuestDtoWQuestOfParty getOneWithQuestOfParty(@PathVariable Integer id)
    {
        return conv.questToDtoWQuestOfParty(repo.findById(id).get());
    }

    @PostMapping("/quests")
    public QuestDtoWWithPatron insert (@RequestBody QuestDtoR dto)
    {
        Quest q = conv.DtoRToQuest(dto);
        return conv.questToDtoWWithPatron(repo.save(q));
    }

    @PutMapping("/quests")
    public QuestDtoWWithPatron updateQuest(@RequestBody QuestDtoR dto)
    {
        Quest q = conv.DtoRToQuest(dto);
        return conv.questToDtoWWithPatron(repo.save(q));
    }

    @PutMapping("/quests/{id}")
    public QuestDtoWWithPatron updateWithId(@RequestBody QuestDtoR dto,@PathVariable Integer id)
    {
        
        Quest q = conv.DtoRToQuest(dto);
        q.setId(id);
        
        return conv.questToDtoWWithPatron(repo.save(q));
    }

    @DeleteMapping("/quests/{id}")
    public void deleteQuest(@PathVariable Integer id)
    {
        repo.deleteById(id);
    }
}
