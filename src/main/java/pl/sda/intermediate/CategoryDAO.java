package pl.sda.intermediate;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CategoryDAO {

    private static CategoryDAO instance;
    private List<Category> categoryList;

    private CategoryDAO() {
        categoryList = createCategories();

    }

    private List<Category> createCategories() {
        List<String> listOfString = readLinesFromFile();


        List<Category> categories = convertToCategoryList(listOfString);

        Map<Integer, List<Category>> categoriesMAp = categories.stream().collect(Collectors.groupingBy(x -> x.getDeepth()));
        populateParentID(categoriesMAp, 0);
        return categories;
    }

    private void populateParentID(Map<Integer, List<Category>> categoriesMap, int depth) {
        if (!categoriesMap.containsKey(depth)) {

            return;

        }

        List<Category> children = categoriesMap.get(depth);
        List<Category> potentialParent = categoriesMap.get(depth - 1);
        for (Category child : children) {
            if (potentialParent != null) {
                chooseParentId(potentialParent, child);

            }


        }
        populateParentID(categoriesMap, depth + 1);


    }

    private void chooseParentId(List<Category> potentialParent, Category child) {

        //             to samo streamami
//      Integer parentId =  potentialParent.stream()
//                .map(x->x.getId())
//                .filter(x->x< child.getId())
//                .sorted(Comparator.reverseOrder())
//                .findFirst()
//                .get();
//


        int id = 0;
        int pom;
        for (Category category : potentialParent) {
            pom = child.getId() - category.getId();
            if (pom > 0) {
                id = child.getId() - pom;

            } else {
                break;
            }

        }
        child.setParentId(id);


    }


    private List<Category> convertToCategoryList(List<String> lines) {

        List<Category> categories = new ArrayList<>();
        int i = 1;
        for (String line : lines) {
            Category category = Category.builder()
                    .id(i++).name(line.trim()).deepth(calculateDepth(line)).build();
            category.setName(line.replaceAll("\\s", ""));
            categories.add(category);

        }
        return categories;
    }

    private int calculateDepth(String line) {
        if (!line.startsWith(" ")) {
            return 0;
        }
        return line.split("\\S+")[0].length();
    }

    private List<String> readLinesFromFile() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL url = classLoader.getResource("Kategorie.txt");

        try {
            return Files.readAllLines(Paths.get(url.toURI()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public static CategoryDAO getInstance() {
        if (instance == null) {
            synchronized (CategoryDAO.class) {
                if (instance == null) {

                    instance = new CategoryDAO();
                }


            }


        }

        return instance;

    }

    public static void main(String[] args) {
        CategoryDAO.getInstance();
        CategoryDAO categoryDAO = new CategoryDAO();
        System.out.println(categoryDAO.categoryList.toString());
    }


}
