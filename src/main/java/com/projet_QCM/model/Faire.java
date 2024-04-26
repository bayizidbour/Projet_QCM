package com.projet_QCM.model;

import jakarta.persistence.*;
import lombok.*;

/****
 * Autheur : Michel35
 *
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Faire {

   @EmbeddedId
    private Faire_key faireKey;
}
