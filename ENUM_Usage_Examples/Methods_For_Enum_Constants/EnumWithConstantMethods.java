package ENUM_Usage_Examples.Methods_For_Enum_Constants;

import java.text.DateFormat;
import java.util.Date;

public enum EnumWithConstantMethods {
    DAY_TIME{
        //This method will override the default implementation of method with same name
        String getInfo()
        {
            return DateFormat.getDateInstance().format(new Date());
        }
    },
    CLASS_PATH{
        //This method will override the default implementation of method with same name
        String getInfo(){
            return System.getenv("CLASSPATH");
        }
    },
    VERSION{
        //This method will override the default implementation of method with same name
        String getInfo(){
            return System.getProperty("java.version");
        }
    },
    //This enum value doesn't have constant method, so default implementation will be used
    DEFAULT;

    String getInfo(){
        return "Default method implementation";
    }

    public static void main(String[] args) {
        for (EnumWithConstantMethods ewcm : values())
            System.out.println(ewcm.getInfo());
    }
}
