package cu.cyrbes;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class AppTestSteps {

    private String filepath;

    private VisitRecordService visitRecordService;

    private Set result;

    @Given("^A data file$")
    public void a_file() throws Throwable {
        filepath = String.format("%s/src/test/resources/data.txt", System.getProperty("user.dir"));
        visitRecordService = new VisitRecordService();
    }

    @When("^the city is \"([^\"]*)\"$")
    public void the_city_is(String cityName) throws Throwable {
        result = visitRecordService.answerRequest(filepath, VisitRecordService.CITY_QUERY_TYPE, cityName);
    }


    @Then("^the people are \"([^\"]*)\"$")
    public void the_people_are(String people) throws Throwable {
        Set peopleList = new HashSet();
        String[] ids = people.split(",");
        // Se adicionan al set las personas solamente con el id porque es lo que identifica a la persona
        for (String id: ids) {
            Person person = new Person();
            person.setId(id);
            peopleList.add(person);
        }

        // Hallando la diferencia entre el listado del resultado esperado y el resultado real
        peopleList.removeAll(result);

        Assert.assertTrue(peopleList.isEmpty());
    }

    @When("^The id is (\\w+)$")
    public void the_id_is_L(String id) throws Throwable {
        result = visitRecordService.answerRequest(filepath, VisitRecordService.ID_QUERY_TYPE, id);
    }

    @Then("^the person have been in \"([^\"]*)\"$")
    public void the_person_have_been_in(String cities) throws Throwable {
        Set citiesList = new HashSet(Arrays.asList(cities.split(",")));

        // Hallando la diferencia entre el listado del resultado esperado y el resultado real
        citiesList.removeAll(result);

        Assert.assertTrue(citiesList.isEmpty());
    }
}
