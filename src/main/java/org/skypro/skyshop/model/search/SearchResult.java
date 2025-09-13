package org.skypro.skyshop.model.search;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchResult {
    private final String id;
    private final String name;
    private final String contentType;

    @JsonProperty
    public String getId() {
        return id;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public String getContentType() {
        return contentType;
    }

    public SearchResult(String id, String name, String contentType) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
    }

    public static SearchResult  fromSearchable (Searchable searchable){
        return new SearchResult(searchable.getID().toString(), searchable.getName(), searchable.getContentType());
    }
}
