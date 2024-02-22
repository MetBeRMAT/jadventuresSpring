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

import com.generation.jadventures.entities.Guild;
import com.generation.jadventures.entities.Quest;
import com.generation.jadventures.model.dto.quest.QuestDtoBase;
import com.generation.jadventures.model.dto.quest.QuestDtoR;
import com.generation.jadventures.model.dto.quest.QuestDtoRpost;
import com.generation.jadventures.model.dto.quest.QuestDtoRput;
import com.generation.jadventures.model.repositories.GuildRepository;
import com.generation.jadventures.model.repositories.QuestRepository;
import com.generation.jadventures.model.service.GuildConverter;
import com.generation.jadventures.model.service.QuestConverter;

@RestController
@CrossOrigin
public class QuestController {
    @Autowired
    QuestRepository repo;
    @Autowired
    QuestConverter conv;
    @Autowired
    GuildRepository gRepo;

    @GetMapping("/quests")
    public List<QuestDtoBase> getAll()
    {
        return repo.findAll().stream().map(d -> conv.questToDtoBase(d)).toList();
    }

    @PostMapping("/quests")
    public QuestDtoR insert (@RequestBody QuestDtoRpost dto)
    {
        Quest q = conv.dtoRpostToQuest(dto);
        return conv.questToDtoR(repo.save(q));
    }

    @PutMapping("/quests")
    public QuestDtoR updateQuest(@RequestBody QuestDtoRput dto)
    {
        Quest q = conv.dtoRputToQuest(dto);
        return conv.questToDtoR(repo.save(q));
    }

    @PutMapping("/quests/{id}")
    public QuestDtoR updateWithId(@RequestBody QuestDtoRput dto,@PathVariable Integer id)
    {
        
        Quest q = conv.dtoRputToQuest(dto);
        q.setId(id);
        
        return conv.questToDtoR(repo.save(q));
    }

    @DeleteMapping("/quests/{id}")
    public void deleteQuest(@PathVariable Integer id)
    {
        repo.deleteById(id);
    }

}
