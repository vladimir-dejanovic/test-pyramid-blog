package xyz.itshark.blog.testpyramid;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class StepDefinitions {

    HttpClient client;
    String baseUrl;
    private HttpResponse<String> data;

    public StepDefinitions() {
        client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(20))
//                .authenticator(Authenticator.getDefault())
                .build();
    }

    private HttpResponse<String> hitURL(String urlPath) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlPath))
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    @Given("base url {string}")
    public void base_url(String url) {
        baseUrl = url;
    }
    @When("user hit end point {string}")
    public void user_hit_end_point(String endPoint) {
        try {
            data = hitURL(baseUrl + "/" + endPoint) ;
        } catch (IOException e) {
            data = null;
            e.printStackTrace();
        } catch (InterruptedException e) {
            data = null;
            e.printStackTrace();
        }
    }
    @Then("I expect list of data")
    public void i_expect_list_of_data() {
        if(data == null)
          throw new io.cucumber.java.PendingException();
    }

}
