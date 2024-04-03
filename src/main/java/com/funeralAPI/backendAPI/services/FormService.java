package com.funeralAPI.backendAPI.services;

import com.funeralAPI.backendAPI.dto.FormDto;

public interface FormService {

    FormDto createForm(FormDto formDto);
    FormDto updateForm(int id,FormDto formDto);

    void deleteForm(int id);


}
