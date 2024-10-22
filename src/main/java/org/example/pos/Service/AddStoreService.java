package org.example.pos.Service;

import org.example.pos.Model.AddStore;
import org.example.pos.Model.Admin;
import org.example.pos.Model.Company;
import org.example.pos.dto.request.AddStoreRequest;
import org.example.pos.dto.response.AddStoreResponse;

import java.util.List;
import java.util.Optional;

public interface AddStoreService {


    public AddStoreResponse createStore(AddStoreRequest addStoreRequest);


    static List<AddStore> getStore() {
        return null;
    }

    static Optional<AddStore> getAllStores(int admin_id) {
        return Optional.empty();
    }

    AddStoreResponse updateStore(int store_id, AddStoreRequest addStoreRequest);

    void deleteStore(int store_id);
}