import MyArrayList.MyArrayList;

public class Main {


    public static void main(String[] args) {
         MyArrayList <Double> arrayList = new MyArrayList();

        arrayList.add(.1);
        arrayList.add(1.1);
        arrayList.add(2.4);
        arrayList.add(.15);
        arrayList.add(10.1);
        arrayList.add(5.12);
        arrayList.add(2.5);
        arrayList.add(3.2);
        arrayList.add(9.9);
        arrayList.add(1.01);
        MyArrayList <Double> arr = new MyArrayList();
        arr = arrayList.qs(arrayList);
        for (int i = 0;i<arr.getSize();i++){
            System.out.println(arr.get(i));
        }

    }

}
