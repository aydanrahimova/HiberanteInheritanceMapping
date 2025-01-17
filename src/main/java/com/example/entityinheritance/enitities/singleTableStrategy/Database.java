package com.example.entityinheritance.enitities.singleTableStrategy;

import jakarta.persistence.*;

//When we use single table strategy-here we have single table of superclass with all field,
//the only disadvantage is that some unused columns can be null
//by using discriminatorValue we can create queries,like:
//select * from Database where database = "relationalDatabase"

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "database")
public abstract class Database {
    @Id
    private Long id;
    private String name;
    private String vendor; // e.g., Oracle, MongoDB
    private String version;
}

@Entity
@DiscriminatorValue("relationalDatabase")
class RelationalDatabase extends Database {
    private String sqlDialect; // e.g., MySQL, PostgreSQL
}

@Entity
@DiscriminatorValue("noSQLDatabase")
class NoSQLDatabase extends Database {
    private String dataModel; // e.g., Document, Key-Value, Graph
}
