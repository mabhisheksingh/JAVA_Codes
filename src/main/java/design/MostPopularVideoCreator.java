package design;

import java.util.*;
import java.util.stream.Collectors;

public class MostPopularVideoCreator {

    class PopularCreator {
        String creator;
        String id;
        Integer view;

        PopularCreator(String creator, String id, int view) {
            this.creator = creator;
            this.id = id;
            this.view = view;
        }

    }

    Comparator<PopularCreator> creatorComparator = (a, b) -> {
        if (b.view.equals(a.view)) {
            return a.id.compareTo(b.id);
        } else {
            return b.view.compareTo(a.view);
        }
    };

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, PriorityQueue<PopularCreator> > creatorMap = new HashMap<>();
        Map<String, Long > crViews = new TreeMap<>();

        for (int i = 0; i < creators.length; i++) {
            crViews.put(creators[i], crViews.getOrDefault(creators[i], 0L) + views[i]);
            creatorMap.computeIfAbsent(creators[i] , key -> new PriorityQueue<>(creatorComparator))
                    .add( new PopularCreator(creators[i], ids[i], views[i]));
        }
        System.out.println(crViews);
        long topCreatorViews= crViews.values().stream().sorted(Collections.reverseOrder())
                .findFirst()
                .get();

        System.out.println(topCreatorViews);
        List<String> listOfTopCreator = crViews.entrySet()
                .stream()
                .filter( view -> topCreatorViews== view.getValue())
                .map(obj -> obj.getKey())
                .collect(Collectors.toList());

        System.out.println(listOfTopCreator);

        List<List<String>> list =  new ArrayList<>();
        for (String cr:listOfTopCreator) {
            PopularCreator tempPopularCreator =  creatorMap.get(cr).peek();
            List<String> tempResult = new ArrayList<>();
            tempResult.add(tempPopularCreator.creator);
            tempResult.add(tempPopularCreator.id);
            list.add(tempResult);
        }
        return list;
    }
}
