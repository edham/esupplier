
package com.ebim.esupplier.common;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@MappedSuperclass
@Getter @Setter
public abstract class BaseEntity<ID> {
    @Column(name = "created_at")
    protected Instant createdAt = Instant.now();
    @Column(name = "updated_at")
    protected Instant updatedAt = Instant.now();

    @PreUpdate
    public void onUpdate() {
        updatedAt = Instant.now();
    }

    public abstract ID getId();
}
