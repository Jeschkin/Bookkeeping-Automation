import java.util.*;

public class Year {
    HashMap<Integer, MonthInfo> myMap = new HashMap<>();
    Reader reader = new Reader();

    public void parsing() {
        List<String> stringList = reader.readFileContents("resources/y.2021.csv");

        for (int i = 1; i < stringList.size(); i++) {
            String[] parts = stringList.get(i).split(",");

            Integer month = Integer.parseInt(parts[0]);
            int value = Integer.parseInt(parts[1]);
            boolean isExpense = Boolean.parseBoolean(parts[2]);
            MonthInfo info = myMap.getOrDefault(month, new MonthInfo());
            if (isExpense) {
                info.expense -= value;
            } else {
                info.income += value;
            }
            myMap.put(month, info);
        }

        System.out.println(myMap);
    }

    double getExpensesForMonth(String month) {
        MonthInfo info = myMap.get(Integer.parseInt(month));
        if (info != null) {
            return info.income - info.expense;
        } else {
            return 0; // or throw an exception
        }
    }
}

class MonthInfo {
    int income;
    int expense;

    public String toString() {
        return "MonthInfo{" +
                "income=" + income +
                ", expense=" + expense +
                '}';
    }
}