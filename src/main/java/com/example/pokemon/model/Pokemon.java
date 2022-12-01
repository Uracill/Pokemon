package com.example.pokemon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name= "name")
    private String _name;

    @Column(name= "first_type")
    private String _firstType;

    @Column(name= "second_type")
    private String _secondType;

    @Column(name = "catch_rate")
    private int _catchRate;

    @Column(name = "gender")
    private String _gender;

    @Column(name = "caught")
    private boolean _caught;

    public Pokemon() {
    }

    public Pokemon(String name, String firstType, String secondType, int catchRate, String gender, boolean caught) {
        _name = name;
        _firstType = firstType;
        _secondType = secondType;
        _catchRate = catchRate;
        _gender = gender;
        _caught = caught;
    }

    public Long getId() {
        return id;
    }

    public void setId(long newId) {
        id = newId;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getFirstType() {
        return _firstType;
    }

    public void setFirstType(String firstType) {
        _firstType = firstType;
    }

    public String getSecondType() {
        return _secondType;
    }

    public void setSecondType(String secondType) {
        _secondType = secondType;
    }

    public int getCatchRate() {
        return _catchRate;
    }

    public void setCatchRate(int catchRate) {
        _catchRate = catchRate;
    }

    public String getGender() {
        return _gender;
    }

    public void setGender(String gender) {
        _gender = gender;
    }

    public boolean getCaught() {
        return _caught;
    }

    public void setCaught(boolean caught) {
        _caught = caught;
    }
}
