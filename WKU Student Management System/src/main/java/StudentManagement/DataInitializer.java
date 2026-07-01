package StudentManagement;

public class DataInitializer {
    public static void loadData() {
        DataStore.undergrad[0] = new Undergraduate(
                "Alice", "Chinese", 109356, 19, 3.5,
                2027, true, "Computer Science", 10,
                false, null, 20, 60
        );
        DataStore.undergradCount++;

        DataStore.undergrad[1] = new Undergraduate(
                "Bob", "Chinese", 120098, 20, 2.0,
                2027, false, "English", 70,
                false, null, 60, 120
        );
        DataStore.undergradCount++;

        DataStore.undergrad[2] = new Undergraduate(
                "Lily", "Spanish", 345679, 21, 1.0,
                2027, false, "Biology", 100,
                false, null, 65, 130
        );
        DataStore.undergradCount++;

        DataStore.grad[0] = new Graduate(
                "Bell", "Italian", 167867, 23, 4.0,
                2026, true, "Mathematics", false,
                null, 30, 95
        );
        DataStore.gradCount++;

        DataStore.grad[1] = new Graduate(
                "Daniel", "Australian", 236564, 26, 3.2,
                2028, false, "Communication", false,
                null, 10, 30
        );
        DataStore.gradCount++;

        DataStore.grad[2] = new Graduate(
                "Jason", "American", 354729, 18, 2.7,
                2029, false, "Global Business", false,
                null, 10, 31
        );
        DataStore.gradCount++;
    }
}
