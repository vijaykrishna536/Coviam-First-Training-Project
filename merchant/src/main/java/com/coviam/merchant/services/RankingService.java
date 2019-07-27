package com.coviam.merchant.services;

import com.coviam.merchant.dto.Rank;

import java.util.List;

public interface RankingService {

    List<Rank> fetchRankListForProduct(String pid);

}