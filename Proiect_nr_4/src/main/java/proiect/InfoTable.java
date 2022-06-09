package proiect;

public enum InfoTable {
    EVENTS {
        @Override
        public String toString() {
            return "university.events";
        }
    },
    ROOMS {
        @Override
        public String toString() {
            return "university.rooms";
        }
    },

}