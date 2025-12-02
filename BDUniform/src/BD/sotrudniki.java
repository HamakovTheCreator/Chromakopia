package BD;
public class sotrudniki {
    private int idEmployee;
    private String name;
    private String surname;
    private String patronymic;
    private int heightEmployee;
    private String post;

    public sotrudniki(int idEmployee, String name, String surname, String patronymic, int heightEmployee, String post) {
        this.idEmployee = idEmployee;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.heightEmployee = heightEmployee;
        this.post = post;
    }

 
    public int getIdEmployee() { return idEmployee; }
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getPatronymic() { return patronymic; }
    public int getHeightEmployee() { return heightEmployee; }
    public String getPost() { return post; }
}