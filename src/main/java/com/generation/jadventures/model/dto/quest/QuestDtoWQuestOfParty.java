package com.generation.jadventures.model.dto.quest;

import com.generation.jadventures.entities.Party;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class QuestDtoWQuestOfParty extends QuestDtoBase
{
    private Integer id;
    private Party questOfParty;
}
