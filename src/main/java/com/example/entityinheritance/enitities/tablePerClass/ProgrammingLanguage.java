package com.example.entityinheritance.enitities.tablePerClass;

import jakarta.persistence.*;

//similar to mapperSuperClass method
//When we use table per class strategy here for each entity table is created
//we can perform polymorphic queries

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
class ProgrammingLanguage {
    @Id
    private Long id;
    private String name;
    private String creator;
    private int yearCreated;
}

@Entity
class CompiledLanguage extends ProgrammingLanguage {
    private String compiler; // e.g., GCC, Clang
}

@Entity
class InterpretedLanguage extends ProgrammingLanguage {
    private String interpreter; // e.g., CPython, Node.js
}
