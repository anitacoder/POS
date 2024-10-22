package org.example.pos.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddStoreRequest {
    private String name;
    private String manager;
    private String location;
    private String StorePhone;
    private String status;
}

