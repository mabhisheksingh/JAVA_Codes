package JAVA8.Stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/*<R> Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper)
Stream.flatMap() helps in converting Stream<Collection<T>> to Stream<T>.
flatMap() = Flattening + map()

*/
public class FlatMap {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(4,5,6);
        List<Integer> list3 = Arrays.asList(7,8,9);

        List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);
        List<Integer> listOfAllIntegers =listOfLists.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
                /*listOfLists.stream()
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());*/

        System.out.println(listOfAllIntegers);
    }
}
