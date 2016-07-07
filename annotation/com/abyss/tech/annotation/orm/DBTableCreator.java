package com.abyss.tech.annotation.orm;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.abyss.tech.annotation.orm.db.Constraints;
import com.abyss.tech.annotation.orm.db.DBTable;
import com.abyss.tech.annotation.orm.db.SQLInteger;
import com.abyss.tech.annotation.orm.db.SQLString;

public class DBTableCreator
{

    public static void main (String[] args)
    {
        Class<?> clazz = Member.class;
        DBTable dbTable = clazz.getAnnotation(DBTable.class);
        if (dbTable == null)
        {
            System.out.println("No DBTable annotation in class " + clazz.getName());
            System.exit(0);
        }
        String tableName = dbTable.name();

        List<String> columnDefs = new ArrayList<String>();
        for (Field field : clazz.getDeclaredFields())
        {
            String columnName = null;
            Annotation[] anns = field.getDeclaredAnnotations();
            if (anns.length == 0)
                continue;
            if (anns[0] instanceof SQLInteger)
            {
                SQLInteger sqli = (SQLInteger) anns[0];
                columnName = sqli.name();
                if (columnName.length() == 0)
                    columnName = field.getName().toUpperCase();
                columnDefs.add(columnName + " INT " + getConstraints(sqli.constraints()));

            }
            if (anns[0] instanceof SQLString)
            {
                SQLString sqls = (SQLString) anns[0];
                columnName = sqls.name();
                if (columnName.length() == 0)
                    columnName = field.getName().toUpperCase();
                columnDefs.add(columnName + " VARCHAR(" + sqls.length() + ")"
                    + getConstraints(sqls.constraints()));
            }
            StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + "(");
            for (String columnDef : columnDefs)
            {
                createCommand.append("\n    ");
                createCommand.append(columnDef);
                createCommand.append(",");
            }
            System.out.println("Table Creation SQL for " + clazz.getName() + " is:\n "
                + createCommand);

        }
    }

    private static String getConstraints (Constraints constraints)
    {
        StringBuffer sb = new StringBuffer("");
        if (constraints.primaryKey())
            sb.append(" PRIMARY KEY");
        if (constraints.allowNull())
            sb.append(" NOT NULL");
        if (constraints.unique())
            sb.append(" UNIQUE");
        return sb.toString();
    }
}
