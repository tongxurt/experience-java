package design.pattern.builder;

public interface IItem {
    String name();

    IPacking packing();

    float price();
}
