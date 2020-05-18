package com.tippers.containment.live.repository.model.redis;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.UUID;

@Data
@Setter
@Builder
@RedisHash(value = "Invoice", timeToLive = 60)
public class Invoice implements Serializable {

    private UUID id;
    private String reference;
    private String file;
    private Integer createdAt;
}
