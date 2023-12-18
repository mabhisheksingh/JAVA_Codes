package design;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * DesignFoodRatingSystem
 * https://leetcode.com/problems/design-a-food-rating-system/description
 */
class FoodRatings {

    class FoodsRatings {
        public String foods;
        public Integer rating;
        FoodsRatings(String foods, Integer rating) {
            this.foods = foods;
            this.rating = rating;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof FoodsRatings that)) return false;
            return Objects.equals(foods, that.foods) && Objects.equals(rating, that.rating);
        }

        @Override
        public int hashCode() {
            return Objects.hash(foods, rating);
        }
        @Override
        public String toString() {
            return "FoodsRatings{" +
                    "foods='" + foods + '\'' +
                    ", rating=" + rating +
                    '}';
        }
    }



    Map<String, TreeSet<FoodsRatings>> foodRating = new HashMap<>();
    Map<String, String> fc = new HashMap<>();
    Map<String, Integer> fr = new HashMap<>();
    Comparator<FoodsRatings> customComparator = (a, b) -> {
        if (a.rating.equals(b.rating)) {
            return a.foods.compareTo(b.foods);
        } else {
            return b.rating.compareTo(a.rating);
        }
    };

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            foodRating.computeIfAbsent(cuisines[i], r -> new TreeSet<>(customComparator)).add(new FoodsRatings(foods[i], ratings[i]));
            fc.put( foods[i], cuisines[i] );
            fr.put( foods[i], ratings[i] );
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = fc.get( food );
        Integer rating = fr.get( food );
        foodRating.get( cuisine ).remove( new FoodsRatings( food, rating ) );
        foodRating.get( cuisine ).add( new FoodsRatings( food , newRating ));
        fr.put( food, newRating);
    }

    public String highestRated(String cuisine) {
        FoodsRatings foodsRatings = foodRating.get(cuisine).first();
        System.out.println(foodsRatings);
        return foodsRatings.foods;
    }
}

class PG{
    public static void main(String[] args) {
        FoodRatings foodRatings = new FoodRatings(new String[]{"kimchi", "miso", "lzeqwfb", "moussaka", "kjop", "bulgogi"},
                new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"}, new int[]{9, 12, 8, 15, 14, 7} );

        System.out.println(foodRatings.highestRated("korean") ) ; // return "kimchi"
        System.out.println(foodRatings.highestRated("japanese") ) ; // return "ramen"

        int a = 900;
        foodRatings.changeRating("lzeqwfb", a); // "sushi" now has a rating of 16.
        System.out.println(foodRatings.highestRated("japanese") ) ; // return "sushi"
        // "sushi" is the highest rated japanese food with a rating of 16.
        foodRatings.changeRating("kjop", a); // "ramen" now has a rating of 16.
        System.out.println(foodRatings.highestRated("japanese") ); // return "ramen"
        // Both "sushi" and "ramen" have a rating of 16.
        // However, "ramen" is lexicographically smaller than "sushi".
        //

//        FoodRatings foodRatings = new FoodRatings(new String[]{"tjokfmxg","xmiuwozpmj","uqklk","mnij","iwntdyqxi","cduc","cm","mzwfjk"},
//                new String[]{"waxlau","ldpiabqb","ldpiabqb","waxlau","ldpiabqb","waxlau","waxlau","waxlau"},
//                new int[]{9,13,7,16,10,17,16,17} );
//        foodRatings.changeRating("tjokfmxg", 19);
//        System.out.println(foodRatings.highestRated("waxlau") ) ; // return "kimchi"
//        foodRatings.changeRating("uqklk", 7);
//        System.out.println(foodRatings.highestRated("waxlau") ) ; // return "kimchi"
//        System.out.println(foodRatings.highestRated("waxlau") ) ; // return "kimchi"
//
//        foodRatings.changeRating("tjokfmxg", 14); // "sushi" now has a rating of 16.
//        System.out.println(foodRatings.highestRated("waxlau") ) ; // return "sushi"
//        System.out.println(foodRatings.highestRated("waxlau") ) ; // return "sushi"
//        foodRatings.changeRating("tjokfmxg", 4); // "sushi" now has a rating of 16.
//        System.out.println(foodRatings.highestRated("waxlau") ) ; // return "sushi"
//        foodRatings.changeRating("mnij", 18); // "sushi" now has a rating of 16.
//        System.out.println(foodRatings.highestRated("waxlau") ); // return "ramen"
    }
}

//[null,null,"tjokfmxg",null,"tjokfmxg","tjokfmxg",
// null,"cduc","cduc",
// null,"cduc",null,"mnij"]