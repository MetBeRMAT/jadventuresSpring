package com.generation.jadventures.model.dto.party;

import java.util.List;
import com.generation.jadventures.entities.Quest;

import lombok.Data;
import lombok.experimental.SuperBuilder;
@SuperBuilder
@Data

public class PartyDtoWQuest extends PartyDtoBase
{
    public PartyDtoWQuest(){}
    private Integer id;
    private List<Quest> quests;
}
