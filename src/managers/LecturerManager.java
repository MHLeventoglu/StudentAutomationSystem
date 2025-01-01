package managers;

import entities.Lecturer;
import managers.abstracts.AbstractBaseManager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LecturerManager  extends AbstractBaseManager<Lecturer> {
    static boolean isSet = false;
    private static List<Lecturer> lecturersList = new ArrayList<>(); // Databasede tutulan öğretim üyesi listesini simüle eder


    public LecturerManager(){
        if(!isSet){
            add(new Lecturer("programlama","programlama","Bilgisayar Müh","programlama.com"));
            add(new Lecturer(new String("matematikçi"),new String("matematikçi"),new String("Bilgisayar Müh"),new String("matematikçi.com")));
            add(new Lecturer(new String("devreler"),new String("devreler"),new String("Elektrik Müh"),new String("fizikçi.com")));
            isSet = true;
        }

    }

    @Override // Öğretim üyesi ekler
    public void add(Lecturer lecturer) {
        lecturersList.add(lecturer);
        generalAdd(lecturer);
        System.out.println("Lecturer added successfully: " + lecturer.getId());

    }

    @Override // Öğretim üyesi çıkarır
    public void delete(long id) {
        boolean removed = lecturersList.removeIf(lecturer -> lecturer.getId() == id);
        if (removed) {
            System.out.println("Lecturer with id \"" + id + "\" is removed.");
        }
        else {

            System.out.println("Lecturer with id " + id + " not found.");
        }
    }

    @Override // Öğretim üyesinin bilgilerini günceller
    public void update(Lecturer updatedLecturer) {
        for (int i = 0; i < lecturersList.size(); i++) {
            if (lecturersList.get(i).getId() == updatedLecturer.getId()) {
                lecturersList.set(i, updatedLecturer);
                System.out.println("The lecturer successfully updated: " + updatedLecturer.getId());
                return;
            }
        }

        System.out.println("The lecturer not found: " + updatedLecturer.getId());
    }

    @Override // Öğretim üyelerinin listesini döndürür
    public List<Lecturer> getAll() {
         return lecturersList;
    }

    @Override // Id'sine göre öğretim üyesi objesi döndürür
    public Lecturer getById(long id) {
        return lecturersList.stream().filter(lecturer -> lecturer.getId() == id)
                .findFirst().orElse(null);

    }

    @Override // Girilen isme sahip öğretim üyelerinin listesini döndürür
    public List<Lecturer> getByName(String name) {
        return lecturersList.stream().filter(lecturer -> lecturer.getName().equalsIgnoreCase(name)).collect(Collectors.toList());

    }
}
