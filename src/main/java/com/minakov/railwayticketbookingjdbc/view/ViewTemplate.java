package com.minakov.railwayticketbookingjdbc.view;

public abstract class ViewTemplate {

    public void page() {
        header();
        content();
        footer();
    }

    private void header() {
        System.out.println();
        System.out.println("========== Railway Ticket Booking ==========");
        System.out.println("============================================");
    }

    private void footer() {
        System.out.println("============================================");
        System.out.println("====== Type exit to close application ======");
        System.out.println();
    }

    public abstract void content();
}
