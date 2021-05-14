 package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductsAPI
 */
@WebServlet("/ProductsAPI")
public class ProductsAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
  //Itemobject create  
	Product itemObj = new Product();
   /**
    * @see HttpServlet#HttpServlet()
    */
	//API call
   public ProductsAPI() {
       super();
       // TODO Auto-generated constructor stub
    }

 

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
 //get method
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

 

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    	String output = itemObj.insertProduct(request.getParameter("Product_code"),request.getParameter("Product_name"),request.getParameter("Price"),request.getParameter("Description"));response.getWriter().write(output);
    }

 

    /**
     * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
     */
  //post method
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        
        Map paras = getParasMap(request);
        String output = itemObj.updateProduct(paras.get("hidProduct_idSave").toString(),paras.get("Product_code").toString(),paras.get("Product_name").toString(),paras.get("Price").toString(),paras.get("Description").toString());response.getWriter().write(output);
    }

 

    /**
     * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
     */
  //delete method
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        
        Map paras = getParasMap(request);
        String output = itemObj.deleteProduct(paras.get("Product_id").toString());
        response.getWriter().write(output);
    }
    
    //mapping
    private static Map getParasMap(HttpServletRequest request)
    {
     Map<String, String> map = new HashMap<String, String>();
    try
     {
     Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
     String queryString = scanner.hasNext() ?
     scanner.useDelimiter("\\A").next() : "";
     scanner.close();
     String[] params = queryString.split("&");
     for (String param : params)
     { 
    
    String[] p = param.split("=");
     map.put(p[0], p[1]);
     }
     }
    catch (Exception e)
     {
     }
    return map;
    }

 

}