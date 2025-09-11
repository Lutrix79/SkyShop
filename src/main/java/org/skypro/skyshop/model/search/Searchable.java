package org.skypro.skyshop.model.search;
import java.util.UUID;

public interface Searchable {

    String findSearchTerm();

    String getContentType();
    String getName();
    UUID getID();


    default String getStringRepresentation() {
        return "Имя " + getName() + " Тип " + getContentType() ;
    }

}

