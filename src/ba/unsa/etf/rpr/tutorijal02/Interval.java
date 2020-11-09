package ba.unsa.etf.rpr.tutorijal02;

public class Interval {

    private double pocetnaTacka;
    private double krajnjaTacka;
    private boolean pocetnaPripada;
    private boolean krajnjaPripada;


    public Interval(double pocetnaTacka, double krajnjaTacka, boolean pocetnaPripada, boolean krajnjaPripada) {
        if(pocetnaTacka>krajnjaTacka) throw new IllegalArgumentException("Pocetna tacka ne moze biti veca od krajnje");
        this.pocetnaTacka = pocetnaTacka;
        this.krajnjaTacka = krajnjaTacka;
        this.pocetnaPripada = pocetnaPripada;
        this.krajnjaPripada = krajnjaPripada;
    }


    public Interval() {
        this.pocetnaTacka = 0;
        this.krajnjaTacka = 0;
        this.pocetnaPripada = false;
        this.krajnjaPripada = false;
    }

    public boolean isNull() {
        return pocetnaTacka == 0 && !pocetnaPripada && krajnjaTacka == 0 && !krajnjaPripada;
    }

    public boolean isIn(double broj) {
        return (((pocetnaPripada && (pocetnaTacka <= broj)) || (pocetnaTacka < broj)) &&
                ((krajnjaPripada && (krajnjaTacka >= broj)) || (krajnjaTacka > broj)));
    }

    @Override
    public boolean equals(Object obj) {
        Interval interval = new Interval();
        interval = (Interval) obj;
        return pocetnaTacka == interval.pocetnaTacka && pocetnaPripada == interval.pocetnaPripada &&
                krajnjaTacka == interval.krajnjaTacka && krajnjaPripada == interval.krajnjaPripada;
    }

    @Override
    public String toString() {
        String vrati = "";
        if(!pocetnaPripada && !krajnjaPripada && pocetnaTacka==0 && krajnjaTacka==0) return "()";
        if(this.pocetnaPripada) vrati += "[";
        else vrati +="(";
        vrati += this.pocetnaTacka + "," + this.krajnjaTacka;
        if(this.krajnjaPripada) vrati += "]";
        else vrati +=")";

        return vrati;
    }

    public Interval intersect (Interval interval) {
        double first=0, last=0;
        boolean firstBoolean=false, lastBoolean=false;

        //pocetna tacka
        if(this.pocetnaTacka == interval.pocetnaTacka) {
            first=this.pocetnaTacka;
        }
        else if(this.pocetnaTacka< interval.pocetnaTacka) {
            first= interval.pocetnaTacka;
            firstBoolean = interval.pocetnaPripada;
        }
        else {
            first = this.pocetnaTacka;
            firstBoolean = this.pocetnaPripada;
        }


        //krajnja tacka

        if(this.krajnjaTacka== interval.krajnjaTacka) {
            last = krajnjaTacka;
        }
        else if(this.krajnjaTacka < interval.krajnjaTacka) {
            last = this.krajnjaTacka;
            lastBoolean= this.krajnjaPripada;
        }
        else {
            last = interval.krajnjaTacka;
            lastBoolean = interval.krajnjaPripada;
        }

        Interval interv = new Interval(first, last, firstBoolean ,lastBoolean);
        return interv;
    }

    public static Interval intersect (Interval interval1, Interval interval2) {
        return interval1.intersect(interval2);
    }


}
