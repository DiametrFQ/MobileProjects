package ru.mirea.khokhlov.data.network;

import java.util.ArrayList;
import java.util.List;

import ru.mirea.khokhlov.data.database.entity.StarEntity;

public class MockNetworkApi {
    public List<StarEntity> fetchStars() {
        List<StarEntity> mockStars = new ArrayList<>();
//        mockStars.add(new StarEntity("Sirius", "The brightest star in the night sky."));
//        mockStars.add(new StarEntity("Betelgeuse", "A red supergiant in the Orion constellation."));
        return mockStars;
    }
}
