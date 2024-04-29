package com.projet_QCM.model;

import jakarta.persistence.*;
import lombok.*;

/****
 * Autheur : Michel35
 *
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Faire {

    @EmbeddedId
    private Faire_key id;

    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("quiz_id")
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    private double note;

    @Override
    public String toString() {
        return "Faire{" +
                "id=" + id +
                ", note=" + note +
                '}';
    }
}