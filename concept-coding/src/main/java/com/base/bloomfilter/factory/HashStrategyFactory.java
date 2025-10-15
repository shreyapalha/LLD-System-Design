package com.base.bloomfilter.factory;

import com.base.bloomfilter.enums.HashType;
import com.base.bloomfilter.strategy.DJB2HashStrategy;
import com.base.bloomfilter.strategy.FNV1aHashStrategy;
import com.base.bloomfilter.strategy.HashStrategy;

public class HashStrategyFactory {
    public static HashStrategy getStrategy(HashType hashType){
        return switch (hashType) {
            case DJB2 -> new DJB2HashStrategy();
            case FNV1A -> new FNV1aHashStrategy();
            default -> throw new IllegalArgumentException("Unsupported hash type: " + hashType);
        };
    }
}
