package pojos;

public class PojoJsonPlaceHolder {
    /*
                {
                "title","Ahmet",
                "body","Merhaba",
                "userId",10,
                "id",70
                }

        Bir POJO Class olusturmak icin, 5 adima ihtiyacimiz var
            1) Tum variable’lari  "private" olarak olusturalim
            2) Tum variable’lar icin getter() and setter() metodlari olusturalim
            3) Tum parametreleri iceren bir constructor olusturalim
            4) Default constructor (parametresiz) olusturalim
            5) toString() metodu olusturalim
    */

    // 1- Tum variable’lari  "private" olarak olusturalim
    private String title;
    private String body;
    private int userId;
    private int id;

    // 2- Tum variable’lar icin getter() and setter() metodlari olusturalim
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // 3- Tum parametreleri iceren bir constructor olusturalim
    public PojoJsonPlaceHolder(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }

    // 4- Default constructor (parametresiz) olusturalim
    public PojoJsonPlaceHolder() {
    }

    // 5- toString() metodu olusturalim
    @Override
    public String toString() {
        return "PojoJsonPlaceHolder{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}
