package junit;

// TODO не используемые импорты
// TODO Форматирование (CTRL + ALT + L)
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.BeforeMethod;
// TODO А какой именно калюкулятор тестируется?
import ru.levelup.qaat.test.Calc;

public class MulDiv {


    private Calc calc;

    @Before
    public  void setUp(){
     calc = new Calc();
     }
    @Test
    public void mulTest() {

        int result = calc.mul(6, 12);
        assertEquals(72, result);
    }

    @Test
    public void divTest() {

        int result = calc.div(90, 10);
        assertEquals(9, result);
    }

    @Test
    public void divDoubleTest(){
        double result = calc.divDouble(22.2, 11.1);
        Assert.assertEquals(2.0, result,0.1);
    }

    @Test
    public void mulDoubleTest(){
        double result = calc.mulDouble(13.9, 7.1);
        Assert.assertEquals(98.6, result,0.2);
    }
    @After
    public void tearDown() {
        System.out.println("mul, div  works");
        calc = null;
    }


}
