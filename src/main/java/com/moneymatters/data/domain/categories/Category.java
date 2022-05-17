package com.moneymatters.data.domain.categories;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer id;

    @Column(name = "category")
    private String category;

    /**
     *
     * @param category
     */
    public Category(String category) {
        this.category = category;
    }
}
