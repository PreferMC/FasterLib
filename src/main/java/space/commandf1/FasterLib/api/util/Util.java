package space.commandf1.FasterLib.api.util;

@SuppressWarnings("unused")
public abstract class Util {
    private final String name;
    private final boolean canBeInstance;
    private final boolean canBeFather;

    public Util(String name, boolean canBeInstance, boolean canBeFather) {
        this.name = name;
        this.canBeInstance = canBeInstance;
        this.canBeFather = canBeFather;
    }

    public String getName() {
        return this.name;
    }

    public boolean getCanBeInstance() {
        return this.canBeInstance;
    }

    public boolean getCanBeFather() {
        return this.canBeFather;
    }
}
