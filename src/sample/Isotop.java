package sample;

public class Isotop {
    private String name;
    private Float half_life;
    private String interval;
    private double kg;

    public Isotop(String name, Float half_life, String interval, double kg, Float mol) {
        this.name = name;
        this.half_life = half_life;
        this.interval = interval;
        this.kg = kg;
        this.mol = mol;
    }

    public Float getMol() {
        return mol;
    }

    public void setMol(Float mol) {
        this.mol = mol;
    }

    private Float mol;



    public double getKg() {
        return kg;
    }

    public void setKg(double kg) {
        this.kg = kg;
    }

    public Isotop(String name, Float half_life, String interval) {
        this.name = name;
        this.half_life = half_life;
        this.interval=interval;
    }

    public Isotop(String name, Float half_life, String interval, double kg) {
        this.name = name;
        this.half_life = half_life;
        this.interval = interval;
        this.kg = kg;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getHalf_life() {
        return half_life;
    }

    public void setHalf_life(Float half_life) {
        this.half_life = half_life;
    }

    @Override
    public String toString() {
        return "Isotop: "  + name +
                ", half_life=" + half_life +
                " " + interval+ " weight: " +kg;
    }
}
