package com.gowri.model;
/*
 * @author NaveenWodeyar
 * @date 13-10-2024
 */

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Dairy {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long dairyId;
}
