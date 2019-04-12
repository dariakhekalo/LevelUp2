package testng;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.qaat.test.Calc;

public class SumSub {

    private Calc calc;

    @BeforeMethod
    public void setUp(){
        calc = new Calc();

    }

    @Test(dataProvider = "dataProviderInt", dataProviderClass = DataProviderCalc.class)
    public void SumIntTest(int a, int b){
        Assert.assertEquals(calc.sum(a,b), a+b );
    }

    @Test(dataProvider = "dataProviderInt", dataProviderClass = DataProviderCalc.class)
    public void SumDoubleTest(double a, double b){
        Assert.assertEquals(calc.sumDouble(a, b),a+b);
    }

    @Test(dataProvider = "dataProviderInt", dataProviderClass = DataProviderCalc.class)
    public void SubIntTest(int a, int b){
        Assert.assertEquals(calc.sub(a,b), a-b );
    }


    @Test(dataProvider = "dataProviderInt", dataProviderClass = DataProviderCalc.class)
    public void SubDoubleTest(double a, double b){
        Assert.assertEquals(calc.subDouble(a, b),a-b);
    }





}
