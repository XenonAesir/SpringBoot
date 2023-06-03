import com.xenon.utils.UUIDUtils;

public class UUIDTest
{
    public static void main(String[] args)
    {

        for (int i = 0; i < 5; i++)
        {
            String s1 = UUIDUtils.generateUniqueKeyMD5();
            System.out.println(s1);
        }
    }
}
