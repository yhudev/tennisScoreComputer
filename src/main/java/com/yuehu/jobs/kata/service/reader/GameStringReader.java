package com.yuehu.jobs.kata.service.reader;

import com.yuehu.jobs.kata.domain.Round;

import java.util.List;

public class GameStringReader implements GameReader {
    @Override
    public List<Round> read(String input) {
        return input.chars()
                .boxed()
                .map(Character::toChars)
                .map(String::valueOf)
                .map(Round::new)
                .toList();
    }
}
