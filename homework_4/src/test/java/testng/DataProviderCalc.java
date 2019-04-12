package testng;
import org.testng.annotations.DataProvider;

public class DataProviderCalc {

    @DataProvider
    public Object [] [] dataProviderInt() {
        return new Object[][]{
                {2,6},
                {3, 4},
                {35, 19},
                {6,9},

        };

    }

    @DataProvider
    public Object [] [] dataProviderDouble() {
        return new Object[][]{
                {13.5,6.99},
                {74.67, 14.01},
                {09.08, 1.55},
                {83.6,92.14},

        };

    }


}
