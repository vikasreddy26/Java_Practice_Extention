import java.util.EnumMap;


public class Main {
    public static void main(String[] args) {

        Season winter = Season.WINTER;
        Season value = Season.valueOf("WINTER");
        String nature = value.nature;
        System.out.println(nature);
        System.out.println("**************************");
        for(Season s:Season.values()){
            System.out.println(s.nature);
        }

        EnumMap<Season,String> enumMap = new EnumMap<>(Season.class);
        enumMap.put(Season.SUMMER,"Summer Season");
        enumMap.put(Season.RAINY,"Rainy Season");
        enumMap.put(Season.WINTER,"Winter Season");
        System.out.println("**************************");
        enumMap.entrySet().stream().forEach(e-> System.out.println(e.getKey().nature + " | "+e.getValue()));
    }
}