package com.example.entityinheritance.enitities.joinedTableStrategy;

import jakarta.persistence.*;

//When we use joined strategy separate tables for superclasses and subclasses are created
//The objects defined in superclass are not included in the tables of subclasses

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class OperatingSystem {
    @Id
    private Long id;
    private String name;
    private String version;
    private boolean isOpenSource;
}

@Entity
@PrimaryKeyJoinColumn(name = "windowsId")
class Windows extends OperatingSystem {
    private String edition; // e.g., Home, Pro
}

@Entity
@PrimaryKeyJoinColumn(name = "linuxId")
class Linux extends OperatingSystem {
    private String distribution; // e.g., Ubuntu, Fedora
}