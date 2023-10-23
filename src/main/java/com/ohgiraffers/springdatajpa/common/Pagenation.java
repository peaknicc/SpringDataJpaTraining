package com.ohgiraffers.springdatajpa.common;

import org.springframework.data.domain.Page;

public class Pagenation {
    public static PagingButton getPagingButtonInfo(Page page) {
        int currentPage = page.getNumber() + 1;
        int defaultButtonCount = 10;
        int startPage;
        int endPage;
        int totalPage = page.getTotalPages();
        System.out.println("전체페이지 : " + page.getTotalPages());

        startPage = (int) (Math.ceil((double) currentPage / defaultButtonCount) - 1) * defaultButtonCount + 1;
        endPage = startPage + defaultButtonCount - 1;

        if(page.getTotalPages() < endPage){
            endPage = page.getTotalPages();
            System.out.println("(page.getTotalPages() < endPage) 에서 endPage " + endPage);
            }


        if(page.getTotalPages() == 0 && endPage == 0){
            endPage = startPage;
            System.out.println("(page.getTotalPages() == 0 && endPage == 0) 에서 endPage " + endPage);
        }

        System.out.println("currentPage : " + currentPage);
        System.out.println("startPage : " + startPage);
        System.out.println("endPage : " + endPage);



        return new PagingButton(currentPage, startPage, endPage, totalPage);
    }
}
