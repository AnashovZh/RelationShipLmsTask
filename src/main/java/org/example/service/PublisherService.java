package org.example.service;

import org.example.model.Publisher;

import java.util.List;

public interface PublisherService {
    String  savePublisher(Publisher publisher);
    Publisher getPublisherById(Long id);
    List<Publisher> getAllPublishers(String ascOrDesc);//(аты боюнча сорттоп чыгаруу)
    String updatePublisher(Long publisherId,Publisher publisher);
    String deletePublisherByName(String name);
}
