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
import com.generation.jadventures.model.repositories.QuestRepository;

@RestController
@CrossOrigin
public class QuestController {
    @Autowired
    QuestRepository repo;
    @Autowired
    QuestConverter conv;

    @GetMapping("/quests")
    public List<Quest> getAll()
    {
        return repo.findAll().stream().map(d -> conv.quest(d)).toList();
    }

    @PostMapping("/quests")
    public Quest insert (@RequestBody QuestDtoRpost dto)
    {
        Quest d = conv.dtoRpostToQuest(dto);
        return conv.quest(repo.save(d));
    }

    @PutMapping("/quests")
    public Quest update(@RequestBody QuestDtoRput dto)
    {
        Quest d = conv.dtoRputToQuest(dto);
        return conv.quest(repo.save(d));
    }

    @PutMapping("/quests/{id}")
    public Quest updateWithId(@RequestBody QuestDtoRput dto,@PathVariable Integer id)
    {
        dto.setId(id);
        Quest d = conv.dtoRputToQuest(dto);
        return conv.quest(repo.save(d));
    }

    @DeleteMapping("/quests/{id}")
    public void deleteQuest(@PathVariable Integer id)
    {
        repo.deleteById(id);
    }


    


}
