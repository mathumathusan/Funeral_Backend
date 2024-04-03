package com.funeralAPI.backendAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {

    private int contact_id;
    private int person_id;
    private String contact_name;
    private String contact_relationship;
    private String contact_mobile_number;

}
