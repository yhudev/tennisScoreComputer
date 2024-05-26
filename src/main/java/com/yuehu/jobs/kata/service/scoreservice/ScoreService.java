package com.yuehu.jobs.kata.service.scoreservice;

import com.yuehu.jobs.kata.domain.Round;

import java.util.List;

public interface ScoreService {
    void process(List<Round> rounds);
}
