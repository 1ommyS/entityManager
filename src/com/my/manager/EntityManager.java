package com.my.manager;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author 1ommy
 * @version 29.09.2021
 */
public class EntityManager<T extends Entity> {
    private List<T> entities;

    public EntityManager(List<T> entities) {
        this.entities = entities;
    }

    public void add(T entity) {
        entities.add(entity);
    }

    public void remove(T entity) {
        entities = entities.stream().filter(en -> en.getId() == entity.getId()).collect(Collectors.toList());
    }

    public void sort() {
        entities.stream().sorted(Comparator.comparingInt(Entity::getId)).collect(Collectors.toList());
    }

    public void addAll(T... _entities) {
        entities.addAll(Arrays.asList(_entities));
    }

    public void print() {
        entities.forEach(System.out::println);
    }

    public List<T> map(Predicate<T> predicate) {
        List<T> copy = new ArrayList<>();
        for (T e : entities) {
            if (predicate.test(e)) {
                copy.add(e);
            }
        }
        return copy;
    }
}
