package flights;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Route implements Serializable {
    private static final long serialVersionUID = -2403746842148223177L;


    private String airlineCode;

    @ManyToOne
    @Id
    private Airline airline;

    private String sourceCode;

    @ManyToOne
    @Id
    private Airport source;

    private String destinationCode;

    @ManyToOne
    @Id
    private Airport destination;

    private Boolean codeshare;

    private Short stops;

    private String equipment;



    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public Airport getSource() {
        return source;
    }

    public void setSource(Airport source) {
        this.source = source;
    }

    public String getDestinationCode() {
        return destinationCode;
    }

    public void setDestinationCode(String destinationCode) {
        this.destinationCode = destinationCode;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public Boolean getCodeshare() {
        return codeshare;
    }

    public void setCodeshare(Boolean codeshare) {
        this.codeshare = codeshare;
    }

    public Short getStops() {
        return stops;
    }

    public void setStops(Short stops) {
        this.stops = stops;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }
}
