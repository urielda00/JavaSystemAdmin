public class EmailApp {
    public static void main(String[] args) {
        Email em1 = new Email("Uriel","Dahan");
        em1.setAlternateEmail("some@test.come");
        System.out.println(em1.getAlternateEmail());
        System.out.println(em1.showInfo());
    }
}
