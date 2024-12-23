package Entities;

import java.time.LocalDateTime;

public abstract class BaseEntity {
    private long id;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    //Constructors
    public BaseEntity(long id) {
        this.id = id;
        this.createdDate = LocalDateTime.now();
        this.updatedDate = this.createdDate;
    }

    // Getters and Setters
    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public LocalDateTime getCreatedDate() {return createdDate;}

    public void setCreatedDate(LocalDateTime createdDate){ this.createdDate = createdDate; }

    public LocalDateTime getUpdatedDate(){ return updatedDate; }

    public void setUpdatedDate(LocalDateTime updatedDate){ this.updatedDate = updatedDate; }

}
