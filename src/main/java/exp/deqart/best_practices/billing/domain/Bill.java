package exp.deqart.best_practices.billing.domain;

import jakarta.persistence.Id;

public class Bill {
    @Id
    private Integer id;
    private String name;
    private Double ht;
    private Double ttc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getHt() {
        return ht;
    }

    public void setHt(Double ht) {
        this.ht = ht;
    }

    public Double getTtc() {
        return ttc;
    }

    public void setTtc(Double ttc) {
        this.ttc = ttc;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ht=" + ht +
                ", ttc=" + ttc +
                '}';
    }
}
