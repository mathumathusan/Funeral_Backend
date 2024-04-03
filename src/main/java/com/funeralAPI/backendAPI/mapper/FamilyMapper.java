package com.funeralAPI.backendAPI.mapper;

import com.funeralAPI.backendAPI.dto.FamilyDto;
import com.funeralAPI.backendAPI.entity.Family;

public class FamilyMapper {

    public static FamilyDto mapToFamilyDto(Family family){
        return new FamilyDto(
                family.getFamily_id(),
                family.getPerson_id(),
                family.getFull_name(),
                family.getRelationship(),
                family.getPrefull_name(),
                family.getPrerelationship(),
                family.getMobile_number(),
                family.is_predeceased()
        );
    }

    public static Family mapToFamily(FamilyDto familyDto){
              return  new Family(
                      familyDto.getFamily_id(),
                      familyDto.getPerson_id(),
                      familyDto.getFull_name(),
                      familyDto.getPrefull_name(),
                      familyDto.getRelationship(),
                      familyDto.getPrerelationship(),
                      familyDto.getMobile_number(),
                      familyDto.is_predeceased()
              );
    }

}
