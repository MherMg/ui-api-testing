package testing.am.api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by
 * Mher Petrosyan
 * Email mher13.02.94@gmail.ru
 */
public class ApiTests {

    //we can change date but that time we also should change the checking price
    private static final String URL = "https://travel.yandex.ru/api/hotels/searchHotels?searchText=Космос 3&checkinDate=2020-12-15&checkoutDate=2020-12-25&adults=2";

    @Test
    public void findHotelAndCheckPrice() {

        given().
                when().
                get(URL).
                then().
                assertThat().
                statusCode(200);
        Response response = given().when().get(URL);
        JsonPath jsonPath = new JsonPath(response.getBody().asString());
        String string = jsonPath.getString("data.hotels[0].offers[0].price.value");
        Assert.assertEquals(string, "29120");

    }
}
