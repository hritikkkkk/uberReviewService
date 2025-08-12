package com.project.uber.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Review extends BaseModel{
    @Column(nullable = false)
    private String content;

    private Double rating;

    @Override
    public String toString() {
        return "Review: " + this.content + " " + this.rating + " " + this.createdAt;
    }

}