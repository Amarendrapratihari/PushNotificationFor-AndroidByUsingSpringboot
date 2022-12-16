package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

import java.io.OutputStreamWriter;

import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

@SpringBootApplication
public class SpringBootPushNotificationsApplication {

	public final static String AUTH_KEY_FCM = "AAAAMSjomCw:APA91bEl7A4NHRHFe05Yla76KAPr04QSMYUgK_yNPTn57WZ6FD87QRXMIWXGDsgA9D-jp1Zz2MfRz90hxXmtjISeFZqNcU3rYKpRafwaFUZh0xVqrzfh4CScVhaJmq5vjThmpUgwRzPA";
	public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";
	public final static String DEVICE_TOKEN = "cY30fN5CK-M:APA91bFG3X7P4Tgblyf3spemab_TVgHkluSM_gqWS47PBYspCrWwXi3LPUFyi9FgOrwBWhOye0zdhZivM5cDraYSr18aRkCRxtWcmmfJP-W6x0o31p19JHdURbwaHBD-2LOjOw-GbzGM";

	public static void sendPushNotification() throws IOException, JsonSyntaxException {
		System.out.println("Inside method call");
		String result = "";

		URL url = new URL(API_URL_FCM);
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization",
				"key=AAAAMSjomCw:APA91bEl7A4NHRHFe05Yla76KAPr04QSMYUgK_yNPTn57WZ6FD87QRXMIWXGDsgA9D-jp1Zz2MfRz90hxXmtjISeFZqNcU3rYKpRafwaFUZh0xVqrzfh4CScVhaJmq5vjThmpUgwRzPA");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);

		String body = "{\"to\":\"cY30fN5CK-M:APA91bFG3X7P4Tgblyf3spemab_TVgHkluSM_gqWS47PBYspCrWwXi3LPUFyi9FgOrwBWhOye0zdhZivM5cDraYSr18aRkCRxtWcmmfJP-W6x0o31p19JHdURbwaHBD-2LOjOw-GbzGM\","
				+ "\"notification\":{\"title\":\"Amarendra Notification\",\"body\":\"Massage PAPA KI PARI\",\"mutable_content\":true,\"sound\":\"Tri-tone\"}}";
		JsonObject json_body = (JsonObject) JsonParser.parseString(body); // Converting string to JSON format

		try {
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(json_body.toString());
			wr.flush();
			System.out.println("Output from Server .... \n");

			result = CommonConstants.SUCCESS;

			System.out.println("Notification is sent successfully. STATUS CODE: " + result);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Notification is sent failed. STATUS CODE: " + result);
			result = CommonConstants.FAILURE;
		}

		System.out.println(conn.getResponseCode());

	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPushNotificationsApplication.class, args);

		try {
			sendPushNotification();

			Object deviceId = "cY30fN5CK-M:APA91bFG3X7P4Tgblyf3spemab_TVgHkluSM_gqWS47PBYspCrWwXi3LPUFyi9FgOrwBWhOye0zdhZivM5cDraYSr18aRkCRxtWcmmfJP-W6x0o31p19JHdURbwaHBD-2LOjOw-GbzGM";
			Object title = "Amarendra";
			Object message = "Cachatto testing message";
			sendPushNotification2(deviceId, title, message);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void sendPushNotification2(Object deviceId, Object title, Object message) {
		// TODO Auto-generated method stub

	}
}
