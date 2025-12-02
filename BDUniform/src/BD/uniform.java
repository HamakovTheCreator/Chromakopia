package BD;

public class uniform {
    private int idUniform;
    private int setNumber;
    private int size;

    public uniform(int idUniform, int setNumber, int size) {
        this.idUniform = idUniform;
        this.setNumber = setNumber;
        this.size = size;
    }

   
    public int getIdUniform() { return idUniform; }
    public int getSetNumber() { return setNumber; }
    public int getSize() { return size; }
}