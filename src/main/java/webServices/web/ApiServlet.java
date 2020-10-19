package webServices.web;


import com.fasterxml.jackson.databind.ObjectMapper;
import webServices.forecastService.model.ParsedJsonFromForecastApi;
import webServices.timezoneService.model.ParsedJsonFromZipcodeApi;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 */

@WebServlet("/")
public class ApiServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/zip-code":
                    showZipCodeForm(request, response);
                    break;
                case "/forecast":
                    showForecastForm(request, response);
                    break;
                    case "/search-forecast":
                    searchForecastByCityName(request, response);
                    break;
                 case "/search-time-zone":
                    searchTimeZoneByZipCode(request, response);
                    break;
                default:
                    defaultMethod(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    //method by default will redirect to index.jsp page
    private void  defaultMethod(HttpServletRequest request, HttpServletResponse response)
            throws  IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
    //method will redirect to zip-code-form.jsp
    private void  showZipCodeForm(HttpServletRequest request, HttpServletResponse response)
            throws  IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("zip-code-form.jsp");
        dispatcher.forward(request, response);
    }

    //method will redirect to city-form.jsp
    private void  showForecastForm(HttpServletRequest request, HttpServletResponse response)
            throws  IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("city-form.jsp");
        dispatcher.forward(request, response);
    }

    //method will receive "cityName" parameter from the jsp form - parse object from Json HTTP response - set Attributes to request
    //and redirect to forecast.jsp page
    private void searchForecastByCityName(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cityName = request.getParameter("city-name");
        ParsedJsonFromForecastApi testForecast = getForecastFromJson(cityName);
        request.setAttribute("parsed-city", testForecast.getLocation().getName());
        request.setAttribute("region", testForecast.getLocation().getRegion());
        request.setAttribute("country", testForecast.getLocation().getCountry());
        request.setAttribute("temp", testForecast.getCurrent().getTempC());
        request.setAttribute("condition", testForecast.getCurrent().getCondition().getText());
        request.setAttribute("condition-icon", testForecast.getCurrent().getCondition().getIcon());

        getServletContext().getRequestDispatcher("/forecast.jsp").forward(request, response);
    }

    //method will provide object mapping from Json HTTP response by Jackson library and return it
    private ParsedJsonFromForecastApi getForecastFromJson(String cityName){

        ParsedJsonFromForecastApi testForecast =null;
        String jsonResult = getJsonFromForecastApi(cityName);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            testForecast = objectMapper.readValue(jsonResult, ParsedJsonFromForecastApi.class);

        } catch (Exception j) {
            j.printStackTrace();
        }
        return testForecast;
    }

    //method will save Json HTTP response to a string and return it
    private String getJsonFromForecastApi(String cityName) {
        final String uri = "http://api.weatherapi.com/v1/current.json?key=77c97f7f1f404b68bf5182518201810&q=" +cityName;
        HttpURLConnection con = null;
        try {
            URL forecastUrl = new URL(uri);
            con = (HttpURLConnection) forecastUrl.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"));
            StringBuilder responseString = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                responseString.append(responseLine.trim());
            }
            return responseString.toString();
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    //method will receive "zip-code" parameter from the jsp form - parse object from Json HTTP response - set Attributes to request
    //and redirect to time-zone.jsp page
    private void searchTimeZoneByZipCode(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String zipCode = request.getParameter("zip-code");
        ParsedJsonFromZipcodeApi testTimezone = getTimezoneFromJson(zipCode);
        request.setAttribute("parsed-zip-code", testTimezone.getZipCode());
        request.setAttribute("timezone-identifier", testTimezone.getTimezone().getTimezoneIdentifier());
        request.setAttribute("timezone-abbr", testTimezone.getTimezone().getTimezoneAbbr());

        getServletContext().getRequestDispatcher("/time-zone.jsp").forward(request, response);
    }

    //method will provide object mapping from Json HTTP response by Jackson liblary and return it
    private ParsedJsonFromZipcodeApi getTimezoneFromJson(String zipCode){

        ParsedJsonFromZipcodeApi testTimezone =null;
        String jsonResult = getJsonFromZipCodeApi(zipCode);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            testTimezone = objectMapper.readValue(jsonResult, ParsedJsonFromZipcodeApi.class);

        } catch (Exception j) {
            j.printStackTrace();
        }
        return testTimezone;
    }

    //method will save Json HTTP response to a string and return it
    private String getJsonFromZipCodeApi(String zipCode) {
        final String uri = "https://www.zipcodeapi.com/rest/" +
                "6DhjWXAFQ04CZGerPJa2yvGYpJoVA3dFcbODQ8hE2l3izjx8mv3J2txtFjKni4M7/info.json/" +zipCode +"/degrees";
        HttpURLConnection con = null;
        try {
            URL url = new URL(uri);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"));
            StringBuilder responseString = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                responseString.append(responseLine.trim());
            }
           return responseString.toString();
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}

