package Entities;

import Entities.abstracts.IEntity;

import java.time.LocalDateTime;

public abstract class BaseEntity implements IEntity {
    private long id;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    //Constructors
    public BaseEntity(long id) {
        this.id = id;
        this.createdDate = LocalDateTime.now(); //oluşturulduğu anın tarihini atar
        this.updatedDate = this.createdDate; //oluşturulduğu anın tarihini atar (güncellenene kadar)
    }

    // Getter ve Setterlar
    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public LocalDateTime getCreatedDate() {return createdDate;}

    public void setCreatedDate(LocalDateTime createdDate){ this.createdDate = createdDate; }

    public LocalDateTime getUpdatedDate(){ return updatedDate; }

    public void setUpdatedDate(LocalDateTime updatedDate){ this.updatedDate = updatedDate; }

}
