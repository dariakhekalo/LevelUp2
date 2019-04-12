package testng;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.qaat.test.Calc;

public class MulDiv {
    private Calc calc;

    @BeforeMethod
    public void setUp() {
        calc = new Calc();
    }

    @Test(dataProvider = "dataProviderInt", dataProviderClass = DataProviderCalc.class)
    public void MulIntTest(int a, int b){
        Assert.assertEquals(calc.mul(a,b), a*b );
    }

    @Test(dataProvider = "dataProviderInt", dataProviderClass = DataProviderCalc.class)
    public void MulDoubleTest(double a, double b){
        Assert.assertEquals(calc.mulDouble(a, b),a*b);
    }

    @Test(dataProvider = "dataProviderInt", dataProviderClass = DataProviderCalc.class)
    public void DivIntTest(int a, int b){
        Assert.assertEquals(calc.div(a,b), a/b );
    }


    @Test(dataProvider = "dataProviderInt", dataProviderClass = DataProviderCalc.class)
    public void DivDoubleTest(double a, double b){
        Assert.assertEquals(calc.divDouble(a, b),a/b);
    }



}
