package BusinessLayer.validators;
import Model.Client;

/**
 * In aceasta clasa se valideaza varsta, astfel incat clientul sa aiba varsta cuprinsa intre un anumit interval
 */
public class ClientAgeValidator implements Validator<Client> {
    private static final int MIN_AGE = 7;
    private static final int MAX_AGE = 30;

    public void validate(Client t) {

        if (t.getAge() < MIN_AGE || t.getAge() > MAX_AGE) {
            throw new IllegalArgumentException("The Client Age limit is not respected!");
        }

    }

}

