package com.vishnukl.model;

import java.util.List;

public class Items {
    private final List<Lion> lions;
    private final List<Region> regions;
    private final List<Pond> ponds;
    private final List<Ambulance> ambulances;

    public Items(List<Lion> Lions, List<Region> Regions, List<Pond> Ponds, List<Ambulance> Ambulances) {
        this.lions = Lions;
        this.regions = Regions;
        this.ponds = Ponds;
        this.ambulances = Ambulances;
    }

    public List<Lion> getLions() {
        return lions;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public List<Pond> getPonds() {
        return ponds;
    }

    public List<Ambulance> getAmbulances() {
        return ambulances;
    }
}
