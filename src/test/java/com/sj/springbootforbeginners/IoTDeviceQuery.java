package com.sj.springbootforbeginners;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IoTDeviceQuery {

    public static int numDevices(String statusQuery, int threshold, String dateStr) {
        int totalMatchingDevices = 0;
        String baseUrl = "https://jsonmock.hackerrank.com/api/iot_devices/search?status=" + statusQuery;
        int currentPage = 1;

        try {
            // Parse dateStr to get the start and end of the given month in milliseconds
            SimpleDateFormat sdf = new SimpleDateFormat("MM-yyyy");
            Date startDate = sdf.parse(dateStr);
            long startOfMonth = startDate.getTime();

            // Calculate the end of the month
            Date endDate = new Date(startOfMonth);
            endDate.setMonth(endDate.getMonth() + 1);
            long endOfMonth = endDate.getTime();

            while (true) {
                // Make the API call
                URL url = new URL(baseUrl + "&page=" + currentPage);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                // Read the response
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Parse the JSON response
                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONArray devices = jsonResponse.getJSONArray("data");
                int totalPages = jsonResponse.getInt("total_pages");

                // Process the devices in the current page
                for (int i = 0; i < devices.length(); i++) {
                    JSONObject device = devices.getJSONObject(i);

                    // Get the timestamp and operating parameters
                    long timestamp = device.getLong("timestamp");
                    JSONObject operatingParams = device.getJSONObject("operatingParams");
                    int rootThreshold = operatingParams.getInt("rootThreshold");

                    // Check if the device matches the criteria
                    if (timestamp >= startOfMonth && timestamp < endOfMonth && rootThreshold > threshold) {
                        totalMatchingDevices++;
                    }
                }

                // Check if we need to fetch the next page
                if (currentPage >= totalPages) {
                    break;
                }
                currentPage++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return totalMatchingDevices;
    }

    public static void main(String[] args) {
        // Example usage
        String statusQuery = "active";
        int threshold = 10;
        String dateStr = "02-2023";
        int result = numDevices(statusQuery, threshold, dateStr);
        System.out.println(result);
    }
}