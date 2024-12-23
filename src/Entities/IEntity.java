package Entities;

import java.time.LocalDateTime;

public interface IEntity {
    long getId();
    void setId(long id);

    LocalDateTime getCreatedDate();
    void setCreatedDate(LocalDateTime createdDate);

    LocalDateTime getUpdatedDate();
    void setUpdatedDate(LocalDateTime updatedDate);

}
