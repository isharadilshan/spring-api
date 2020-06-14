package com.alphabit.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilteredRole {
    private String firstName;
    private String lastName;
    private String nic;
}
