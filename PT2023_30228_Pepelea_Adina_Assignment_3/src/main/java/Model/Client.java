package Model;

/**
 * Aceasta clasa reprezinta tabelul Client din baza de date cu atributele: id , name, address, email si age.
 */

public class Client {
    private int id;
    private String name;
    private String address;
    private String email;
    private int age;
    /**
     * Constructorul initializeaza obiecte noi.
     * @param id
     * @param name
     * @param address
     * @param email
     * @param age
     */
    public Client(int id, String name, String address, String email, int age) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.age = age;

    }

    /**
     * Metoda de get pentru id.
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Metoda de set pentru id.
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metoda de get pentru name.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Metoda de set pentru name.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metoda de get pentru address.
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * Metoda de set pentru address.
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *  Metoda de get pentru email.
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Metoda de set pentru email.
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Metoda de get pentru age.
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     * Metoda de set pentru age.
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Metoda pentru toString.
     * @return
     */
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
