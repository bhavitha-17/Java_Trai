// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Demo {

    Student[] students = new Student[2];
  int index;
    void addStudent(Student student){
        students[index]=student;
        index++;
    }
    void addstudentstoArray() {
        System.out.println("we add students here");
        addStudent(new Student(1, "yoyo", 3128));
        addStudent(new Student(2, "sisi", 3129));

    }

    void displayAll() {
        System.out.println("In printthearray() Method");
        for (int i = 0; i <index; i++) {
            display(students[i]);
        }
    }
    void display(Student student){
        System.out.println("student Id:" + student.id);
        System.out.println("student name:" + student.name);
        System.out.println("student rollno:" + student.rollno);

    }

    Student searchforstudent(int id) {
        System.out.println("search student by id:");
        for (Student stu : students) {
            if (stu.id == id) {
               return stu;
            }
        }
        return null;

    }

    public static void main(String[] args) {

        Demo demo=new Demo();

        demo.addstudentstoArray();
        demo.displayAll();
        System.out.println("***fetching and displaying student by id 2");
       Student student= demo.searchforstudent(2);
       demo.display(student);
    }
}