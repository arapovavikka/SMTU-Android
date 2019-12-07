package com.dreamteamk4240.smtu.data;

import com.dreamteamk4240.smtu.ui.schedule.ScheduleViewModel;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class BigData {
    private ArrayList<SubjectTest> listOfSubject;
    private ArrayList<ScheduleTest> listOfSchedulet;
    private ArrayList<GroupTest> groupTestList;
    private ArrayList<FacultyTest> facultyTestList;

    public BigData() {
        initListOfSubject();
        initGroupList();
        initScheduleList();
        initFacultyList();
    }


    private void initListOfSubject() {
        ArrayList<SubjectTest> subjectTests = new ArrayList<>();
        subjectTests.add(new SubjectTest("Математика", "лекция"));
        subjectTests.add(new SubjectTest("Электротехника", "лекция"));
        subjectTests.add(new SubjectTest("Физика", "практика"));
        subjectTests.add(new SubjectTest("КГ", "практика"));
        subjectTests.add(new SubjectTest("БЖ", "лекция"));
        subjectTests.add(new SubjectTest("Теория связи", "лекция"));
        subjectTests.add(new SubjectTest("Теория Программирование", "практика"));
        subjectTests.add(new SubjectTest("Моб. приложения", "лекция"));
        subjectTests.add(new SubjectTest("Химия", "лекция"));
        subjectTests.add(new SubjectTest("Экология", "практика"));
        subjectTests.add(new SubjectTest("История", "лекция"));
        subjectTests.add(new SubjectTest("Java", "лекция"));
        subjectTests.add(new SubjectTest("C++", "практика"));
        subjectTests.add(new SubjectTest("Python", "лекция"));
        subjectTests.add(new SubjectTest("Perl", "практика"));
        subjectTests.add(new SubjectTest("C#", "лекция"));
        subjectTests.add(new SubjectTest("Выч. модели", "практика"));
        subjectTests.add(new SubjectTest("Философия", "лекция"));
        subjectTests.add(new SubjectTest("Администрирование", "практика"));
        subjectTests.add(new SubjectTest("Проектирование", "лекция"));
        subjectTests.add(new SubjectTest("Инженерная графика", "практика"));
        subjectTests.add(new SubjectTest("Экономика", "лекция"));
        subjectTests.add(new SubjectTest("Макроэкономика", "практика"));
        subjectTests.add(new SubjectTest("Микроэкономика", "лекция"));

        listOfSubject = subjectTests;
    }

    public void initScheduleList() {
        ArrayList<ScheduleTest> scheduleTests = new ArrayList<>();
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.DOWN, "10:30",
                "Игорь Петров", DayOfWeek.Mon, "Б-123", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "17:30",
                "Петр Игорев", DayOfWeek.Mon, "Б-433", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "15:30",
                "Михаил Петров", DayOfWeek.Tue, "Б-403", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "08:30",
                "Игорь Михайлов", DayOfWeek.Mon, "Б-123", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "09:30",
                "Леонид Игорев", DayOfWeek.Mon, "Б-423", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.DOWN, "16:30",
                "Павел Аркадьев", DayOfWeek.Mon, "Б-423", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "14:30",
                "Игорь Григорьев", DayOfWeek.Thu, "Б-443", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "11:30",
                "Алексей Леванов", DayOfWeek.Sat, "Б-423", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.DOWN, "19:30",
                "Кристина Семёнова", DayOfWeek.Wed, "Б-413", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "14:30",
                "Виктория Леванова", DayOfWeek.Mon, "Б-423", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.DOWN, "11:30",
                "Григорий Кузнецов", DayOfWeek.Fri, "Б-413", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "10:30",
                "Михаил Мухин", DayOfWeek.Thu, "Б-493", getRandomSubject(), getRandomGroup()));

        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "10:30",
                "Игорь Петров", DayOfWeek.Mon, "Б-123", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.DOWN, "17:30",
                "Петр Игорев", DayOfWeek.Mon, "Б-433", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "15:30",
                "Михаил Петров", DayOfWeek.Tue, "Б-403", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "08:30",
                "Игорь Михайлов", DayOfWeek.Mon, "Б-123", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "09:30",
                "Леонид Игорев", DayOfWeek.Mon, "Б-423", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "16:30",
                "Павел Аркадьев", DayOfWeek.Mon, "Б-423", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "14:30",
                "Игорь Григорьев", DayOfWeek.Thu, "Б-443", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "11:30",
                "Алексей Леванов", DayOfWeek.Sat, "Б-423", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "19:30",
                "Кристина Семёнова", DayOfWeek.Wed, "Б-413", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "14:30",
                "Виктория Леванова", DayOfWeek.Mon, "Б-423", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.DOWN, "11:30",
                "Григорий Кузнецов", DayOfWeek.Fri, "Б-413", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "10:30",
                "Михаил Мухин", DayOfWeek.Thu, "Б-493", getRandomSubject(), getRandomGroup()));

        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.DOWN, "10:30",
                "Игорь Петров", DayOfWeek.Mon, "Б-123", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.DOWN, "17:30",
                "Петр Игорев", DayOfWeek.Mon, "Б-433", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "15:30",
                "Михаил Петров", DayOfWeek.Tue, "Б-403", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "08:30",
                "Игорь Михайлов", DayOfWeek.Mon, "Б-123", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "09:30",
                "Леонид Игорев", DayOfWeek.Mon, "Б-423", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.DOWN, "16:30",
                "Павел Аркадьев", DayOfWeek.Mon, "Б-423", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "14:30",
                "Игорь Григорьев", DayOfWeek.Thu, "Б-443", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.DOWN, "11:30",
                "Алексей Леванов", DayOfWeek.Sat, "Б-423", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.DOWN, "19:30",
                "Кристина Семёнова", DayOfWeek.Wed, "Б-413", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "14:30",
                "Виктория Леванова", DayOfWeek.Mon, "Б-423", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.DOWN, "11:30",
                "Григорий Кузнецов", DayOfWeek.Fri, "Б-413", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "10:30",
                "Михаил Мухин", DayOfWeek.Thu, "Б-493", getRandomSubject(), getRandomGroup()));

        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "10:30",
                "Игорь Петров", DayOfWeek.Mon, "Б-123", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.DOWN, "17:30",
                "Петр Игорев", DayOfWeek.Mon, "Б-433", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.DOWN, "15:30",
                "Михаил Петров", DayOfWeek.Tue, "Б-403", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "08:30",
                "Игорь Михайлов", DayOfWeek.Mon, "Б-123", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.DOWN, "09:30",
                "Леонид Игорев", DayOfWeek.Mon, "Б-423", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "16:30",
                "Павел Аркадьев", DayOfWeek.Mon, "Б-423", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.DOWN, "14:30",
                "Игорь Григорьев", DayOfWeek.Thu, "Б-443", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "11:30",
                "Алексей Леванов", DayOfWeek.Sat, "Б-423", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "19:30",
                "Кристина Семёнова", DayOfWeek.Wed, "Б-413", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "14:30",
                "Виктория Леванова", DayOfWeek.Mon, "Б-423", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.DOWN, "11:30",
                "Григорий Кузнецов", DayOfWeek.Fri, "Б-413", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "10:30",
                "Михаил Мухин", DayOfWeek.Thu, "Б-493", getRandomSubject(), getRandomGroup()));


        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.DOWN, "10:30",
                "Игорь Петров", DayOfWeek.Mon, "Б-123", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "17:30",
                "Петр Игорев", DayOfWeek.Mon, "Б-433", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "15:30",
                "Михаил Петров", DayOfWeek.Tue, "Б-403", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "08:30",
                "Игорь Михайлов", DayOfWeek.Mon, "Б-123", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.DOWN, "09:30",
                "Леонид Игорев", DayOfWeek.Mon, "Б-423", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "16:30",
                "Павел Аркадьев", DayOfWeek.Mon, "Б-423", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "14:30",
                "Игорь Григорьев", DayOfWeek.Thu, "Б-443", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.DOWN, "11:30",
                "Алексей Леванов", DayOfWeek.Sat, "Б-423", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "19:30",
                "Кристина Семёнова", DayOfWeek.Wed, "Б-413", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.DOWN, "14:30",
                "Виктория Леванова", DayOfWeek.Mon, "Б-423", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.DOWN, "11:30",
                "Григорий Кузнецов", DayOfWeek.Fri, "Б-413", getRandomSubject(), getRandomGroup()));
        scheduleTests.add(new ScheduleTest(ScheduleViewModel.WeekType.UP, "10:30",
                "Михаил Мухин", DayOfWeek.Thu, "Б-493", getRandomSubject(), getRandomGroup()));
        listOfSchedulet = scheduleTests;


    }


    private SubjectTest getRandomSubject() {
        if (listOfSubject != null) {
            return listOfSubject.get(getrandomValue(listOfSubject.size() - 1, 0));
        } else return null;
    }

    private void initFacultyList() {
        ArrayList<FacultyTest> facultyTests = new ArrayList<>();
        facultyTests.add(new FacultyTest("Факультет кораблестроения", getRandomListGroups(), EducationTypeTest.BACHELOR));
        facultyTests.add(new FacultyTest("Факультет ИТ", getRandomListGroups(), EducationTypeTest.BACHELOR));
        facultyTests.add(new FacultyTest("Факультет ИКТ", getRandomListGroups(), EducationTypeTest.BACHELOR));
        facultyTests.add(new FacultyTest("Факультет экономики", getRandomListGroups(), EducationTypeTest.BACHELOR));
        facultyTests.add(new FacultyTest("Факультет Биотохнологий", getRandomListGroups(), EducationTypeTest.BACHELOR));

        facultyTests.add(new FacultyTest("Факультет кораблестроения", getRandomListGroups(), EducationTypeTest.SPECIALITY));
        facultyTests.add(new FacultyTest("Факультет ИТ", getRandomListGroups(), EducationTypeTest.SPECIALITY));
        facultyTests.add(new FacultyTest("Факультет ИКТ", getRandomListGroups(), EducationTypeTest.SPECIALITY));
        facultyTests.add(new FacultyTest("Факультет экономики", getRandomListGroups(), EducationTypeTest.SPECIALITY));
        facultyTests.add(new FacultyTest("Факультет Биотохнологий", getRandomListGroups(), EducationTypeTest.SPECIALITY));
        facultyTests.add(new FacultyTest("Факультет Компьютерных технологий", getRandomListGroups(), EducationTypeTest.SPECIALITY));

        facultyTests.add(new FacultyTest("Факультет кораблестроения", getRandomListGroups(), EducationTypeTest.MASTER));
        facultyTests.add(new FacultyTest("Факультет экономики", getRandomListGroups(), EducationTypeTest.MASTER));
        facultyTests.add(new FacultyTest("Факультет Биотохнологий", getRandomListGroups(), EducationTypeTest.MASTER));
        facultyTests.add(new FacultyTest("Факультет Компьютерных технологий", getRandomListGroups(), EducationTypeTest.MASTER));


        facultyTestList = facultyTests;
    }

    private void initGroupList() {
        ArrayList<GroupTest> scheduleTests = new ArrayList<>();
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));
        scheduleTests.add(new GroupTest(getrandomValue(4, 1), getRandomGroupName()));

        groupTestList = scheduleTests;

    }

    private GroupTest getRandomGroup() {
        if (groupTestList != null) {
            return groupTestList.get(getrandomValue(groupTestList.size() - 1, 0));
        } else return null;
    }


    private ArrayList<GroupTest> getRandomListGroups() {
        ArrayList<GroupTest> list = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            list.add(getRandomGroup());
        }
        return list;

    }

    private ScheduleTest getRandomSchedule() {
        if (listOfSchedulet != null) {
            return listOfSchedulet.get(getrandomValue(listOfSchedulet.size() - 1, 0));
        } else return null;
    }


    private int getrandomValue(int max, int min) {
        return (new Random().nextInt((max - min) + 1) + min);
    }

    public String getRandomGroupName() {
        int number = getrandomValue(999, 100);
        return ("K" + String.valueOf(number));
    }

    public ArrayList<IdAndName> getFacultyByEdType(EducationTypeTest type) {
        ArrayList<IdAndName> list = new ArrayList<>();
        for (FacultyTest item : facultyTestList) {
            if (item.getEducationType().equals(type)) {
                list.add(new IdAndName(item.getFacultyId(),item.getName()));
            }
        }
        return list;

    }

    public GroupTest getRandomGroupTest() {
        return groupTestList.get(getrandomValue(groupTestList.size() - 1, 0));
    }

    public FacultyTest getRandomFaculty() {

        return facultyTestList.get(getrandomValue(facultyTestList.size() - 1, 0));
    }

    public ArrayList<IdAndName> getGroupsByCourseNumber(int number, ArrayList<GroupTest> groupTestList) {
        ArrayList<IdAndName> list = new ArrayList<>();
        for (GroupTest item : groupTestList) {
            if (item.getCourseLevel() == number) {
                list.add(new IdAndName(item.getId(),item.getGroupName()));
            }
        }
        return list;

    }

    public ArrayList<ScheduleTest> getScheduleByWeekType(ScheduleViewModel.WeekType weekType, ArrayList<ScheduleTest> listSch) {
        ArrayList<ScheduleTest> list = new ArrayList<>();
        for (ScheduleTest item : listSch) {
            if (item.getWeekType().equals(weekType)) {
                list.add(item);
            }
        }
        return list;

    }

    public ArrayList<ScheduleTest> getScheduleByGroup(GroupTest groupTest) {
        ArrayList<ScheduleTest> list = new ArrayList<>();
        for (ScheduleTest item : listOfSchedulet) {
            if (item.getGroupTest().equals(groupTest)) {
                list.add(item);
            }
        }
        return list;
    }
    public FacultyTest getFacultyById(UUID id){
        for (FacultyTest test:facultyTestList){
            if(test.getFacultyId().equals(id)) return test;
        }
        return null;
    }
    public GroupTest getGroupById(UUID id){
        for (GroupTest test:groupTestList){
            if(test.getId().equals(id)) return test;
        }
        return null;
    }


}
