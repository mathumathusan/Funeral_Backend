package com.funeralAPI.backendAPI.services;

import com.funeralAPI.backendAPI.dto.FamilyDto;

import java.util.List;

public interface FamilyService {

    FamilyDto createFamily(FamilyDto familyDto);

    FamilyDto getFamilyById(int id);

    List<FamilyDto> getAllFamily();
    FamilyDto updateFamily(int id, FamilyDto familyDto);

    void deleteFamily(int id);

}
