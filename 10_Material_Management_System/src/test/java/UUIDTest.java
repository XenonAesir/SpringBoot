import com.xenon.utils.UUIDUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.Scanner;

public class UUIDTest
{
    public static void main(String[] args)
    {

        // for (int i = 0; i < 5; i++)
        // {
        //     String s1 = UUIDUtils.generateUniqueKeyMD5();
        //     System.out.println(s1);
        // }

        // System.out.println(LocalDateTime.now());

        while(true){
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            Scanner scanner = new Scanner(System.in);
            String rawPassword = scanner.nextLine();
            String encodedPassword = bCryptPasswordEncoder.encode(rawPassword);

            System.out.println("加密密码" + encodedPassword);
        }

    }
}
