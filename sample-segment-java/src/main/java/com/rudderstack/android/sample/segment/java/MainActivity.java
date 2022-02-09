package com.rudderstack.android.sample.segment.java;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.rudderstack.android.sdk.core.RudderClient;
import com.rudderstack.android.sdk.core.RudderProperty;
import com.rudderstack.android.sdk.core.RudderTraits;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RudderTraits traits = new RudderTraits();
        traits.putBirthday(new Date());
        traits.putEmail("abc@123.com");
        traits.putFirstName("First");
        traits.putLastName("Last");
        traits.putGender("m");
        traits.putPhone("5555555555");
        RudderTraits.Address address = new RudderTraits.Address();
        address.putCity("City");
        address.putCountry("USA");
        traits.putAddress(address);
        traits.put("boolean", true);
        traits.put("integer", 50);
        traits.put("float", 120.4f);
        traits.put("long", 1234L);
        traits.put("string", "hello");
        traits.put("date", new Date(System.currentTimeMillis()));

        RudderClient.with(this).identify("some_user_id", traits, null);

        String customEvent = "some_custom_event";
        String propertyKey = "some_property_key";
        String propertyValue = "some_property_value";
        RudderClient.with(this).track(customEvent, new RudderProperty().putValue(propertyKey, propertyValue));

        RudderProperty purchaseProperties = new RudderProperty();
        purchaseProperties.put("property_key", "property_value");
        purchaseProperties.putRevenue(10.0);
        purchaseProperties.putCurrency("JPY");
        RudderClient.with(this).track("custom_purchase", purchaseProperties);
        RudderClient.with(this).track("Install Attributed", new RudderProperty()
                .putValue("provider", "Tune/Kochava/Branch")
                .putValue("campaign", new RudderProperty()
                        .putValue("source", "Network/FB/AdWords/MoPub/Source")
                        .putValue("name", "Campaign Name")
                        .putValue("content", "Organic Content Title")
                        .putValue("ad_creative", "Red Hello World Ad")
                        .putValue("ad_group", "Red Ones")));


        val properties = RudderProperty().putValue(mapOf("key_1" to "value_1", "key_2" to "value_2" , "key_3" to "value_3"))
        rudderClient!!.track("Testing Latch Track", properties)

    }
}
