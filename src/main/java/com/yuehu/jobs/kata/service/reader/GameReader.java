package com.yuehu.jobs.kata.service.reader;

import com.yuehu.jobs.kata.domain.Round;

import java.util.List;

public interface GameReader {
    List<Round> read(String input);
}
