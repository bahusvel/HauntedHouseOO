package com.company;

/**
 * Created by denislavrov on 25.07.14.
 */
public class Data extends py2java {
    static String[] DirectionsArray = {"SE", "WE", "WE", "SWE", "WE", "WE", "SWE", "WS",
            "NS", "SE", "WE", "NW", "SE", "W", "NE", "NSW",
            "NS", "NS", "SE", "WE", "NWUD", "SE", "WSUD", "NS",
            "N", "NS", "NSE", "WE", "WE", "NSW", "NS", "NS",
            "S", "NSE", "NSW", "S", "NSUD", "N", "N", "NS",
            "NE", "NW", "NE", "W", "NSE", "WE", "W", "NS",
            "SE", "NSW", "E", "WE", "NW", "S", "SW", "NW",
            "NE", "NWE", "WE", "WE", "WE", "NWE", "NWE", "W"};

    static String[] LocationsArray =
            {"DARK CORNER", "OVERGROWN GARDEN", "BY LARGE WOODPILE", "YARD BY RUBBISH",
                    "WEEDPATCH", "FOREST", "THICK FOREST", "BLASTED TREE",
                    "CORNER OF HOUSE", "ENTRANCE TO KITCHEN", "KITCHEN & GRIMY COOKER", "SCULLERY DOOR",
                    "ROOM WITH INCHES OF DUST", "REAR TURRET ROOM", "CLEARING BY HOUSE", "PATH",
                    "SIDE OF HOUSE", "BACK OF HALLWAY", "DARK ALCOVE", "SHALL DARK ROOM",
                    "BOTTOM OF SPIRAL STAIRCASE", "WIDE PASSAGE", "SLIPPERY STEPS", "CLIFFTOP",
                    "NEAR CRUMBLING WALL", "GLOOMY PASSAGE", "POOL OF LIGHT", "IMPRESSIVE VAULTED HALLWAY",
                    "HALL BY THICK WOODEN DOOR", "TROPHY ROOM", "CELLAR WITH BARRED WINDOW", "CLIFF PATH",
                    "CUPBOARD WITH HANGING COAT", "FRONT HALL", "SITTING ROOM", "SECRET ROOM",
                    "STEEP MARBLE STAIRS", "DINING ROOM", "DEEP CELLAR WITH COFFIN", "CLIFF PATH",
                    "CLOSET", "FRONT LOBBY", "LIBRARY OF EVIL BOOKS", "STUDY WITH DESK & HOLE IN WALL",
                    "WEIRD COBWEBBY ROOM", "VERY COLD CHAMBER", "SPOOKY ROOM", "CLIFF PATH BY MARSH",
                    "RUBBLE-STREWN VERANDAH", "FRONT PORCH", "FRONT TOWER", "SLOPING CORRIDOR",
                    "UPPER GALLERY", "MARSH BY WALL", "MARSH", "SOGGY PATH",
                    "BY TWISTED RAILING", "PATH THROUGH IRON GATE", "BY RAILINGS", "BENEATH FRONT TOWER",
                    "DEBRIS FROM CRUMBLING FACADE", "LARGE FALLEN BRICKWORK", "ROTTING STONE ARCH", "CRUMBLING CLIFFTOP"};

    static String[] VerbList = {"HELP", "CARRYING?", "GO", "N", "S", "W", "E", "U", "D",
            "GET", "TAKE", "OPEN", "EXAMINE", "READ", "SAY",
            "DIG", "SWING", "CLIMB", "LIGHT", "UNLIGHT", "SPRAY", "USE", "UNLOCK", "DROP", "SCORE"};

    static String[] NounList = {"NORTH", "SOUTH", "WEST", "EAST", "UP", "DOWN",
            "DOOR", "BATS", "GHOSTS", "X2ANFAR", "SPELLS", "WALL"};

    static String[] PropList = {"DRAWER", "DESK", "COAT", "RUBBISH", "COFFIN", "BOOKS"};

    static int[] PositionOfProps = {43, 43, 32, 3, 38, 35};

    static String[] ItemList = {"PAINTING", "RING", "MAGIC SPELLS", "GOBLET", "SCROLL", "COINS", "STATUE", "CANDLESTICK", "MATCHES",
            "VACUUM", "BATTERIES", "SHOVEL", "AXE", "ROPE", "BOAT", "AEROSOL", "CANDLE", "KEY"};

    static int[] PositionOfItems = {46, 38, 35, 50, 13, 18, 28, 42, 10, 25, 26, 4, 2, 7, 47, 60, 100, 100};


    static int LocationID = 0;
}
