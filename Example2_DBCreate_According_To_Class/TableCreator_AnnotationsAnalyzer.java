package Annotations_Training.Example2_DBCreate_According_To_Class;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TableCreator_AnnotationsAnalyzer {
    private static String getConstrains(Constraints con) {
        StringBuilder constraints = new StringBuilder();
        if (!con.allowNull())
            constraints.append(" NOT NULL");
        if (con.primaryKey())
            constraints.append(" PRIMARY KEY");
        if (con.unique())
            constraints.append(" UNIQUE");
        return constraints.toString();
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //the program should build a SQL table according to class that passed as "arg" to the program
        if (args.length<1)
        {
            System.out.println("No classes passed - Unable to build SQL table");
            System.exit(0);
        }
        for (String className : args)
        {
            Class<?> cl = Class.forName(className);
            String classSimpleName = cl.getSimpleName();
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if (dbTable == null)
            {
                System.out.println("Class " + className + " not annotated with DBTable and as result SQL table can't be built from it");
                continue;
            }
            String tableName = dbTable.name();
            if (tableName.length()<1)
                tableName = cl.getName().toUpperCase();
            List<String> listOfColumns = new ArrayList<>();
            for (Field field : cl.getDeclaredFields())
            {
                Annotation[] fieldAnnotations = field.getDeclaredAnnotations();
                if (fieldAnnotations.length == 0)
                {
                    System.out.println("Field " + field + " is not an SQL column\n");
                    continue;
                }
                if (fieldAnnotations[0] instanceof SQLString)
                {
                    SQLString sString = (SQLString) fieldAnnotations[0];
                    String columnName = sString.name();
                    if (columnName.length()<1)  //if default applied
                        columnName = field.getName().toUpperCase();
                    String columnDefs = columnName + " VARCHAR(" + sString.value() + ")" + getConstrains(sString.constraints());
                    listOfColumns.add(columnDefs);
                }
                if (fieldAnnotations[0] instanceof SQLInteger)
                {
                    SQLInteger sInteger = (SQLInteger) fieldAnnotations[0];
                    String columnName = sInteger.name();
                    if (columnName.length() < 1)
                        columnName = field.getName().toUpperCase();
                    String columnDefs = columnName + " INT" + getConstrains(sInteger.constraints());
                    listOfColumns.add(columnDefs);
                }
            }

            StringBuilder createTable = new StringBuilder("CREATE TABLE " + tableName + "(\n");
            for (String stringVal : listOfColumns)
            {
                createTable.append("    ").append(stringVal).append(',').append("\n");
            }
            createTable.deleteCharAt(createTable.length()-1); //removing last newLine symbol
            createTable.deleteCharAt(createTable.length()-1); //removing last ',' symbol
            createTable.append(")");
            String tableCreate = "Table Creation SQL for " + classSimpleName + " is :\n" + createTable.toString();
            System.out.println(tableCreate);
        }
    }
}
