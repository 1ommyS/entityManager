package com.my.manager;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author 1ommy
 * @version 29.09.2021
 */
public class EntityManager<T extends Phone> {
    private List<T> phones;

    public EntityManager(List<T> phones) {
        this.phones = phones;
    }

    public void add(T entity) {
        phones.add(entity);
    }

    public void remove(T phone) {
        phones = phones.stream().filter(en -> en.getId() == phone.getId()).collect(Collectors.toList());
    }

    public final void sort() {
        phones = phones.stream().sorted(Comparator.comparingInt(Phone::getId)).collect(Collectors.toList());
    }

    @SafeVarargs
    public final void addAll(T... _phones) {
        phones.addAll(Arrays.asList(_phones));
    }

    public final void print() {
        phones.forEach(System.out::println);
    }

    public final List<T> map(Predicate<T> predicate) {
        List<T> copy = new ArrayList<>();
        for (T e : phones) {
            if (predicate.test(e)) {
                copy.add(e);
            }
        }
        return copy;
    }

    public T findPhoneById(int id) throws IllegalArgumentException {
        return phones.stream().filter(ph -> ph.getId() == id).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public T findPhoneByValue(String value) throws IllegalArgumentException {
        return phones.stream().filter(ph -> ph.getValue().equals(value)).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public T findPhoneByBalance(int value) throws IllegalArgumentException {
        return phones.stream().filter(ph -> ph.getBalance() == value).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public T findPhoneByBalanceInRange(int start, int end) throws IllegalArgumentException {
        return phones.stream().filter(ph -> ph.getBalance() > start && ph.getBalance() < end).findFirst().orElseThrow(IllegalAccessError::new);
    }

    public void removePhoneByValue(String value) {
        this.phones = phones.stream().filter(p -> !p.getValue().equals(value)).collect(Collectors.toList());
    }

    public void removeAllPhonesByOperator(String operator) {
        this.phones = phones.stream().filter(p -> !p.getOperator().equals(operator)).collect(Collectors.toList());

    }
    public List<T> findPhonesByOperator(String operator)
    {
        return phones.stream().filter(ph -> ph.getOperator().equals(operator)).collect(Collectors.toList());
    }
}
