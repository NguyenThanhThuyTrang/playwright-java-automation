
package com.tester;

import com.microsoft.playwright.*; //dấu * cho phép sử dụng tất cả các class của playwright mà không cần phải import từng class riêng

public class App {
    public static void main(String[] args){
        //Khởi tạo đối tượng Playwright, dùng hàm create() để tạo công cụ điều khiển trình duyệt
        try (Playwright playwright = Playwright.create()){
            // khởi chạy trình duyệt chrominum. setHeadless(false) giúp nhìn thấy cửa sổ trình duyệt thay vì chạy ngầm
            Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
            );

            //Tạo một tab mới trong trình duyệt
            Page page = browser.newPage();

            //điều hướng đến link
            page.navigate("https://playwright.dev");

            //In title của page
            System.out.println(page.title());
            System.out.println("URL: " + page.url());
            System.out.println("Title: " + page.title());
            
            //Đóng trình duyệt sau khi hoàn tất
            browser.close();
        }
    }
}


