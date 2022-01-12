package org.example.utils;

import com.github.javafaker.Faker;
import org.example.models.parts.Status;
import org.example.models.parts.Tag;

import java.util.List;
import java.util.Random;

public class FakeGenerator {
    private static Faker faker = new Faker();

    public static long getPositive() {
        return faker.number().numberBetween(0, Long.MAX_VALUE);
    }

}
