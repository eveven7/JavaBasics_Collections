package ClassWork;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionsLecture {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(15, "John", Grade.PRIMARY, 1));
        students.add(new Student(13, "Robertas", Grade.PRIMARY, 2));
        students.add(new Student(30, "Tomas", Grade.UNIVERSITY, 6));
        students.add(new Student(10, "Meile", Grade.PRIMARY, 8));
        students.add(new Student(22, "Narbutas", Grade.UNIVERSITY, 4));
        students.add(new Student(28, "Simon", Grade.UNIVERSITY, 7));

        for (Student student : students) {
            System.out.println(students);
        }
        students.remove(1);
        System.out.println("*******************************************");

        int[] arr = {1, 2, 3, 4, 5};

        List<Integer> list = new ArrayList<>();

        for (int i : arr) {
            list.add(i);
        }

        System.out.println(list);

        System.out.println("*******************************************");
        ArrayList<Student> byAge = new ArrayList<>();

        for (Student student : students) {
            if (student.getAge() >= 25) {
                byAge.add(student);
            }
        }
        students.removeAll(byAge);
        System.out.println(byAge);
        System.out.println(students);
        /**
         *
         * */
        List<Student> studentsToRemove = new ArrayList<>();
        for (Student student : students) {
            if (student.getAge() >= 25) {
                System.out.println(student);
                studentsToRemove.add(student);
            }
        }

        /**
         *Short way
         * */

        students.removeIf(streamStudent -> streamStudent.getAge() > 25);
        System.out.println(students);
        System.out.println(studentsToRemove);
        System.out.println(Arrays.toString(students.toArray()));
        System.out.println("*******************************************");

        Set<Student> uniqueStudents = new HashSet<>(students);
        System.out.println("List size" + students.size());
        System.out.println("List size" + uniqueStudents.size());

        uniqueStudents.removeIf(s -> Grade.PRIMARY.equals(s.getGrade()));
        System.out.println(uniqueStudents);

        System.out.println("*******************************************");

        ArrayList<String> fruits = new ArrayList<>(Arrays.asList("Apple", "Pear", "Banana", "Apple", "Cherry", "Fig", "Orange", "Banana", "Apple"));
        System.out.println("List of fruits " + fruits);
        System.out.println("Size : " + fruits.size());
        HashSet<String> unique = new HashSet<>(fruits);
        System.out.println("Unique list " + "\n" + unique + "\n" + "Size : " + unique.size());

        System.out.println("*******************************************");


        Map<String, Student> keyValuePairs = uniqueStudents.stream().collect(Collectors.toMap(Student::getName, student -> student));
        //unique , because keyset, enforce by the set, asigns the value of itself
        // MAP USED as a key and a value
        // map don't need to loop
        Map<String, Student> studentMap = new HashMap<>(); //key a string and a value of a student
        keyValuePairs.put("Evelina", new Student(26, "Evelina", Grade.UNIVERSITY, 10));//IF KEY exists it will be overwritten
        System.out.println(keyValuePairs.keySet()); // print names
        System.out.println(keyValuePairs.values()); //values

        keyValuePairs.putIfAbsent("John", new Student(22, "John", Grade.UNIVERSITY, 9));
        System.out.println(keyValuePairs.get("Tomas"));//key can be any object
        System.out.println("*******************************************");

        /**Add id to ClassWork.Student class
         Print map.
         Take 4 index ClassWork.Student and change his grade and age.
         Print map key and value
         */
        Map<Integer, Student> studentMap1 = students.stream().collect(Collectors.toMap(Student::getId, student -> student));
        //took a list and collect into a map, id unique and return the same student
        System.out.println(studentMap1);
        //new student , take the same id
        Student modifiedstudent = new Student(19, studentMap1.get(4).getName(), Grade.UNIVERSITY, 8);
        studentMap1.put(4, modifiedstudent);
        System.out.println(studentMap1.keySet());
        System.out.println(studentMap1.values());
        System.out.println("*******************************************");
        students.stream().forEach(s -> System.out.println(s.getName()));
        System.out.println();
        students.sort(Comparator.comparing(Student::getName));
        students.stream().sorted(Comparator.comparing(Student::getName)).forEach(s -> System.out.println(s.getName()));// sortred students and iterating
        students.stream().forEach(s -> System.out.println(s.getName()));

        System.out.println(students);
        //colllect above age of 25, convert into the set


//        Set<Student> names = students.stream().filter(student -> student.getAge() > 25).map(Student::getName).collect(Collectors.toSet());
        //if there is a value - if presents
        /**Optional<Student> optionalStudents = students.stream()
                .filter(student -> student.getGrade().equals((null)))
                .findFirst();
        optionalStudents.ifPresent(s -> System.out.println(s.getName()));*/
        System.out.println("*******************************************");

        //calculate age , start from 0, uuntil added together
        //map changing the type
        Integer sum = students.stream().map(Student::getAge).reduce(0,Integer::sum);
        System.out.println(sum);

    }
}
