package pl.msliwczynski.employee.management.service.validators;

public interface Validator<T> {
    boolean validate(T object);
}
