package org.example.pos.Controller;

import org.example.pos.Model.AddStore;
import org.example.pos.Model.Admin;
import org.example.pos.Model.Company;
import org.example.pos.Service.AdminService;
import org.example.pos.dto.request.AddStoreRequest;
import org.example.pos.dto.response.AddStoreResponse;
import org.example.pos.Service.AddStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/signstore")
@RequiredArgsConstructor
public class AddStoreController {
    private final AddStoreService addStoreService;

    @PostMapping("/savestore")
    public AddStoreResponse saveStore(@RequestBody @Validated AddStoreRequest addStoreRequest) {
        addStoreService.createStore(addStoreRequest);
        return new AddStoreResponse(addStoreRequest.getName());
    }


    @GetMapping(path ="/Store")
    public AddStore getStore(){
        return (AddStore) AddStoreService.getStore();
    }

    @GetMapping(path = "/{store_id}")
    public Optional<AddStore> getStoreId(int store_id){
        return AddStoreService.getAllStores(store_id);
    }

    @PutMapping("/update/{store_id}")
    public AddStoreResponse updateStore(@PathVariable int store_id, @RequestBody @Validated AddStoreRequest addStoreRequest) {
        return addStoreService.updateStore(store_id, addStoreRequest);
    }

    @DeleteMapping("/delete/{store_id}")
    public String deleteStore(@PathVariable int store_id) {
        addStoreService.deleteStore(store_id);
        return "Store with ID " + store_id + " has been deleted.";
    }
}