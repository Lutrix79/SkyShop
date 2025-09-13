package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public final class Article implements Searchable {

    final private String nameArticle;
    final private String contentArticle;
    final private UUID id;

    public Article(String nameArticle, String contentArticle, UUID id) {
        this.nameArticle = nameArticle;
        this.contentArticle = contentArticle;
        this.id = id;
    }

    @Override
    public String toString() {
        return  nameArticle + "\n" + contentArticle + "\n";
    }

    @JsonIgnore
    @Override
    public String findSearchTerm() {
        return nameArticle + "\n" + contentArticle+ "\n";
     }

    @JsonIgnore
    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return nameArticle;
    }

    @Override
    public UUID getID() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Article article)) return false;
        return Objects.equals(nameArticle, article.nameArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameArticle);
    }
}
