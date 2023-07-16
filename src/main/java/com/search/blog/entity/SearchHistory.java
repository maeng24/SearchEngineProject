package com.search.blog.entity;

import com.search.blog.common.jpa.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "search_hist_m", uniqueConstraints = {@UniqueConstraint(columnNames = {"search_hist_id"})})
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class SearchHistory extends BaseEntity {

    @Id
    @Column(name="search_hist_id")
    @GenericGenerator(
            name="search_hist_m",
            strategy="org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters={
                    @org.hibernate.annotations.Parameter(name="sequence_name", value="search_hist_seq"),
                    @org.hibernate.annotations.Parameter(name="optimizer", value="pooled"),
                    @org.hibernate.annotations.Parameter(name="initial_value", value="1"),
                    @org.hibernate.annotations.Parameter(name="increment_size", value="1")

            }
    )
    @GeneratedValue(strategy=GenerationType.SEQUENCE,
    generator = "search_hist_m")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long searchHistId;

    @Column(name = "keyword")
    @NotNull
    private String keyword;

    @Column(name = "category")
    @Size(max = 10)
    @NotEmpty
    private String category;

    @Column(name = "count")
    private Long searchCount;

}
