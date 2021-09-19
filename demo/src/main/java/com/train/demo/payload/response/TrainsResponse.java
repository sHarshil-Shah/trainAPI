package com.train.demo.payload.response;

import com.train.demo.model.Train;

import java.util.List;

public class TrainsResponse {
    List<Train> trains;
    int totalItems;
    int totalPages;
    int currentPage;

    public TrainsResponse(List<Train> trains, int pageSize, int currentPage, double totalTrainCount) {
        this.trains = trains;
        this.totalItems = trains.size();
        this.totalPages = (int)Math.ceil(totalTrainCount/pageSize);
        this.currentPage = currentPage;
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
