package se.lexicon.dao;

import se.lexicon.dao.sequencer.CustomerIdSequencer;
import se.lexicon.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDaoImpl implements CustomerDao {

    private List<Customer> storage = new ArrayList<>();

    @Override
    public Customer create(Customer customer) {
        // validate the param as needed.
        customer.setId(CustomerIdSequencer.nextId()); // 1001
        storage.add(customer);
        return customer;
    }

    @Override
    public Optional<Customer> find(int id) {
        for (Customer customer : storage) {
            if (customer.getId() == id) {
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean remove(int id) {
        Optional<Customer> customerOptional = find(id);
        if (customerOptional.isPresent()) {
            storage.remove(customerOptional.get());
            return true;
        }
        return false;
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public void update(Customer customer) {
        for (Customer storedCustomer : storage) {
            if (storedCustomer.getId() == customer.getId()) {
                storedCustomer.setName(customer.getName());
                storedCustomer.setPhoneNumber(customer.getPhoneNumber());
                storedCustomer.setReservation(customer.getReservation());
                // Exist the loop after updating the customer.
                break;
            }
        }
    }

}
