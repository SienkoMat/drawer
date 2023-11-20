package com.example;

import com.example.entity.Bracket;
import com.example.service.BracketService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.example.constants.DialogConstants.SIZE_QUESTION;

public final class Main extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String count = request.getParameter("count");
        String bound = request.getParameter("bound");
        String numbers = request.getParameter("numbers");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(count + bound + numbers);

    }

    public static void main(String[] args) {

        /*
         * System.out.println("Jak się nazywasz?");
         * String user = scanner.nextLine();
         */
        BracketService service = new BracketService(new Scanner(System.in));
        service.beginGuessing();

    }

}

