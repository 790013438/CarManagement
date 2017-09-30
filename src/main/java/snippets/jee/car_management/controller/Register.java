package snippets.jee.car_management.controller;

import snippets.jee.car_management.dao.InfoDAO;

public class Register {

    private static InfoDAO infoDAO;

    public static InfoDAO getInfoDAO() {
        return infoDAO;
    }

    public static void setInfoDAO(InfoDAO infoDAO) {
        Register.infoDAO = infoDAO;
    }
}
