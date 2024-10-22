package org.example.pos.Service.Implementation;

import org.example.pos.dto.request.AddStoreRequest;
import org.example.pos.dto.response.AddStoreResponse;
import org.example.pos.Model.AddStore;
import org.example.pos.repository.AddStoreRepository;
import org.example.pos.Service.AddStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddStoreImplement implements AddStoreService {
    private final AddStoreRepository addStoreRepository;

    public AddStoreResponse createStore(AddStoreRequest addStoreRequest) {
        AddStore addStore = new AddStore();
        addStore.setName(addStoreRequest.getName());
        addStore.setManager(addStoreRequest.getManager());
        addStore.setLocation(addStoreRequest.getLocation());
        addStore.setStorePhone(addStoreRequest.getStorePhone());
        addStore.setStatus(addStoreRequest.getStatus());

        AddStore saveStore = addStoreRepository.save(addStore);

        return new AddStoreResponse(saveStore.getName());
    }

    @Override
    public AddStoreResponse updateStore(int store_id, AddStoreRequest addStoreRequest) {
        AddStore existingStore = addStoreRepository.findById(store_id)
                .orElseThrow(() -> new IllegalStateException("Store with ID " + store_id + " not found"));

        existingStore.setName(addStoreRequest.getName());
        existingStore.setManager(addStoreRequest.getManager());
        existingStore.setLocation(addStoreRequest.getLocation());
        existingStore.setStorePhone(addStoreRequest.getStorePhone());
        existingStore.setStatus(addStoreRequest.getStatus());

        AddStore updatedStore = addStoreRepository.save(existingStore);
        return new AddStoreResponse(updatedStore.getName());
    }

    @Override
    public void deleteStore(int store_id) {
        AddStore store = addStoreRepository.findById(store_id)
                .orElseThrow(() -> new IllegalStateException("Store with ID " + store_id + " not found"));
        addStoreRepository.delete(store);
    }
}