package com.example.nam.travel.models.review;

import java.util.List;

public class ReviewPagination {
    int crrPage;
    int sumPage;
    List<Review> listEvaluation;

    public void setCrrPage(int crrPage) {
        this.crrPage = crrPage;
    }

    public void setListEvaluation(List<Review> listEvaluation) {
        this.listEvaluation = listEvaluation;
    }

    public int getCrrPage() {
        return crrPage;
    }

    public int getSumPage() {
        return sumPage;
    }

    public void setSumPage(int sumPage) {
        this.sumPage = sumPage;
    }

    public List<Review> getListEvaluation() {
        return listEvaluation;
    }
}
