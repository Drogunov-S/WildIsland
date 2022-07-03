package ru.javarush.drogunov.wildisland.view;

public interface View {
    String showStatistics();

    @SuppressWarnings("unused")
    //used for test
    String showMap();

    @SuppressWarnings("unused")
    //Used for test
    String showCountCellUnits();

    void showFinishMassage();
}
