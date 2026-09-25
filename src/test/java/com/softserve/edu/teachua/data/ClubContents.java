package com.softserve.edu.teachua.data;

public enum ClubContents {
    IT_EDUCATION_CLUB(Cities.KYIV_CITY, "IT освіта: курси \"ГРАНД\"", "Ми вивчаємо все, що можна уявити в ІТ"),
    NEW_CADRE_CLUB(Cities.KHARKIV_CITY, "Новий Кадр", "Новий кадр — це справжній творчий  майданчик"),
    VECTOR_CLUB(Cities.KHARKIV_CITY, "Центр позашкільної освіти \"ВЕКТОР\" Харківської міської ради", "Центр пропонує заняття у гуртках");

    private ClubContents(Cities city, String title, String description) {
        // TODO Task 2: store city, title and description.
    }

    public Cities getCity() {
        // TODO Task 2: return the stored city.
        throw new UnsupportedOperationException("Implement ClubContents.getCity()");
    }

    public String getTitle() {
        // TODO Task 2: return the stored title.
        throw new UnsupportedOperationException("Implement ClubContents.getTitle()");
    }

    public String getDescription() {
        // TODO Task 2: return the stored description.
        throw new UnsupportedOperationException("Implement ClubContents.getDescription()");
    }

    @Override
    public String toString() {
        // TODO Task 2: return a readable club title.
        return name();
    }
}
