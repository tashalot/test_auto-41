import org.junit.Assert;
import org.junit.Test;
import java.lang.String;

public class MainClassTest extends MainClass
{

    @Test
    public void testGetLocalNumber()
    {
        int a = this.getLocalNumber(14);
        if (a == 14) {
            System.out.println("Возвращает число"+ ' '+ a);
        } else {
            System.out.println("Fail! Не вернул 14");
        }

    }
    @Test
    public void testGetClassNumber()
    {
        int b = getClassNumber(45);
        if (b > 45) {
            System.out.println("Passed");
        } else {
            System.out.println("Fail!");
        }
    }
    @Test
    public void testGetClassString()
    {
        String subStr1 = "hello";
        String subStr2 = "Hello";
        String str = getClassString();
        if (str.contains(subStr1)) {
            System.out.println("строка" + str + "есть подстрока" + subStr1);
        } else if (str.contains(subStr2)) {
            System.out.println("строка" + str + "есть подстрока" + subStr2);
        } else {
            Assert.fail("Строка" + str + "нет подстроки" + subStr1 + subStr2);
        }

    }
}