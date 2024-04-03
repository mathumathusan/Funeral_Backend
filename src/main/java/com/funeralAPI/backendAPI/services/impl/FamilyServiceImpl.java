package com.funeralAPI.backendAPI.services.impl;

import com.funeralAPI.backendAPI.dto.FamilyDto;
import com.funeralAPI.backendAPI.entity.Family;
import com.funeralAPI.backendAPI.exception.ResourceNotFoundException;
import com.funeralAPI.backendAPI.mapper.FamilyMapper;
import com.funeralAPI.backendAPI.repository.FamilyRepository;
import com.funeralAPI.backendAPI.services.FamilyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FamilyServiceImpl implements FamilyService {

    FamilyRepository familyRepository;

    @Override
    public FamilyDto createFamily(FamilyDto familyDto) {
        Family family= FamilyMapper.mapToFamily(familyDto);
        Family savedFamily=familyRepository.save(family);
        return FamilyMapper.mapToFamilyDto(savedFamily);
    }

    @Override
    public FamilyDto getFamilyById(int id) {

       Family family= familyRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("family is not existed by this id"+id));

        return FamilyMapper.mapToFamilyDto(family);
    }

    @Override
    public List<FamilyDto> getAllFamily() {

        List<Family> families=familyRepository.findAll();
        return families.stream().map((family)->FamilyMapper.mapToFamilyDto(family)).collect(Collectors.toList());
    }

    @Override
    public FamilyDto updateFamily(int id, FamilyDto familyDto) {

       Family family= familyRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("family no found id"+id));
       family.setFamily_id(familyDto.getFamily_id());
       family.setPerson_id(familyDto.getPerson_id());
       family.setFull_name(familyDto.getFull_name());
       family.setPrefull_name(familyDto.getPrefull_name());
       family.setMobile_number(familyDto.getMobile_number());
       family.set_predeceased(familyDto.is_predeceased());
       family.setPrerelationship(familyDto.getPrerelationship());
       family.setRelationship(familyDto.getRelationship());

      Family updatedFamily= familyRepository.save(family);

        return FamilyMapper.mapToFamilyDto(updatedFamily);
    }

    @Override
    public void deleteFamily(int id) {
        Family family=familyRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("family not found id"+id));
        familyRepository.deleteById(id);

    }
}
