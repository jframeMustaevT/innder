package stc21.innopolis.university.entity;

public enum TripType {
    CARSHARING {
        public String getLocalName(){
            return "Каршеринг";
        }
    },
    OWNERCAR {
        public String getLocalName(){
            return "Личный автомобиль";
        }
    },
    BUS{
        public String getLocalName(){
            return "Автобус";
        }
    };

    public abstract String getLocalName();
}
