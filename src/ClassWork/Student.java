package ClassWork;

import java.util.Objects;

public class Student {

    private int age;
    private String name;
    private Grade grade;
    private int id;

    public Student(int age, String name, Grade grade, int id) {
        this.age = age;
        this.name = name;
        this.grade = grade;
        this.id = id;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Grade getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "ClassWork.Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && id == student.id && Objects.equals(name, student.name) && grade == student.grade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, grade, id);
    }
}
