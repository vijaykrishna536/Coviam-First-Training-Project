package com.coviam.merchant.controller;

import com.coviam.merchant.dto.Rank;
import com.coviam.merchant.services.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class RankController {

    @Autowired
    private RankingService rankingService;


    @GetMapping("/getRankList/{pid}")
    public List<Rank> getRankList(@PathVariable(name = "pid") String pid) {
        return rankingService.fetchRankListForProduct(pid);
    }

    @GetMapping("/getBestMerchant/{pid}")
    public Rank getBestMerchant(@PathVariable(name = "pid") String pid) {
        if (pid == null) return null;
        return rankingService.fetchRankListForProduct(pid).get(0);
    }

}
