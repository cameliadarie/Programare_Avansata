package Db;

public enum InfoTable {
    CONTINENTS {
        @Override
        public String toString() {
            return "theworld.continents";
        }
    },
    COUNTRIES {
        @Override
        public String toString() {
            return "theworld.countries";
        }
    },
    CITIES {
        @Override
        public String toString() {
            return "theworld.cities";
        }
    },
}