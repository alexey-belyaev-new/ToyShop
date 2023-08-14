package model.toys;

import java.io.Serializable;

public class Toy implements Serializable {
    private final Integer id;
    private final String title;
    private Double weight;


    public Toy(Integer id, String title, Double weight) {
        this.id = id;
        this.title = title;
        this.weight = weight;
    }
    public String getInfo(){
        return "id: " +
                id +
                ", title: " +
                title +
                ", weight: " +
                weight;
    }

    public Double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "model.toys.Toy{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", weight=" + weight +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if (!(obj instanceof Toy)){
            return false;
        }
        Toy other = (Toy) obj;
        return other.getId().equals(getId()) && other.getTitle().equals(getTitle()) && other.getWeight().equals(getWeight());
    }

    public String getTitle() {
        return title;
    }
}
