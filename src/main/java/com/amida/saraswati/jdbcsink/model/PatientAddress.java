package com.amida.saraswati.jdbcsink.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "patient_address")
public class PatientAddress extends Address {
}