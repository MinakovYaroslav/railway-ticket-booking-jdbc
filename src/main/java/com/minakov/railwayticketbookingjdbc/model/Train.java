package com.minakov.railwayticketbookingjdbc.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trains")
public class Train extends AbstractIdentifiable {

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name="train_wagons",
            joinColumns=@JoinColumn(name="train_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="wagon_id", referencedColumnName="id"))
    private List<Wagon> wagons;

    public List<Wagon> getWagons() {
        return wagons;
    }

    public void setWagons(List<Wagon> wagons) {
        this.wagons = wagons;
    }
}
