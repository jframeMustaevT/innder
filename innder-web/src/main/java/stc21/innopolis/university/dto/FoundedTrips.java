package stc21.innopolis.university.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import stc21.innopolis.university.entity.Route;
import stc21.innopolis.university.entity.Trip;
import stc21.innopolis.university.entity.User;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoundedTrips implements Serializable {



    private long startDataTime;

    private String tripType;

    private String description;

    private String cost;

    private String startLocation;

    private String endLocation;

    private String userName;

    private long id;

    public FoundedTrips(Trip trip) {
        this.id = trip.getId();
        this.startDataTime = trip.getStartDataTime();
        this.tripType = trip.getType().getLocalName();
        this.description = trip.getDescription();
        this.cost = trip.getCost();

        Route route = trip.getRoute();
        if (route != null) {
            StringBuilder builder = new StringBuilder();
            builder.append(route.getStartCity() + " ");
            builder.append(route.getStartStreet() + " ");
            builder.append(route.getStartStreetNumber() + " ");
            this.startLocation = builder.toString().trim();
            builder = new StringBuilder();
            builder.append(route.getEndCity() + " ");
            builder.append(route.getEndStreet() + " ");
            builder.append(route.getEndStreetNumber() + " ");
            this.endLocation = builder.toString().trim();
        } else {
            this.startLocation = "";
            this.endLocation = "";
        }
        User owner = trip.getOwner();
        if (owner != null) {
            if (owner.getFirstName() != null || owner.getFirstName().trim().length() != 0){
                this.userName = owner.getFirstName();
            }else {
                this.userName = owner.getUsername();
            }
        }
    }
}
