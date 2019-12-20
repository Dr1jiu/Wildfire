package cn.xxct.oa_element.utils;

import org.springframework.util.ClassUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.util.Arrays;

public class SourceGenerator {

    public static void main(String[] args) throws Exception {
        //测试生成保存sql语句
        //String s = testSave("cn.xxct.oa_element.domain.Dept");
        generService("Delivery", "");
        generQuery("Delivery", "");
        generMapperxml("Delivery", "wlmapper", "cn.xxct.oa_element.domain.Delivery");
        generServiceImpl("Delivery", "");
//        String s = whereParam("cn.xxct.oa_element.domain.Dept");
//        System.out.println(s);
        //updateSql("cn.xxct.oa_element.domain.Admin");
    }

    public static String updateSql(String className) throws ClassNotFoundException {
        Class<?> aClass = Class.forName(className);
        Field[] declaredFields = aClass.getDeclaredFields();
        //拿到类名转小写加上_得到表名
        String simpleName = aClass.getSimpleName();
        String s = simpleName.substring(0, 1).toLowerCase() + simpleName.substring(1, simpleName.length()) + "_";
        System.out.println(s);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("update ");
        //表名
        stringBuilder.append(s + "\n");
        stringBuilder.append("\t\t\t<set>\n");
        if ("serialVersionUID".equals(declaredFields[0].getName())) {
            declaredFields = Arrays.copyOfRange(declaredFields, 1, declaredFields.length);
        }
        for (int i = 0; i < declaredFields.length; i++) {
            if (i == 0) {
                continue;
            }
            //判断如果不是string包下的和不是data包下的就是自己定义的类...
            if ((declaredFields[i].getType().getName().indexOf("java.lang")) == -1 || (declaredFields[i].getType().getName().indexOf("java.util")) == -1) {
                if (declaredFields[i].getType().equals(String.class)) {
                    stringBuilder.append("\t\t\t\t<if test=\"" + declaredFields[i].getName() + "!=null and " + declaredFields[i].getName() + "!=''\">\n");
                } else {
                    stringBuilder.append("\t\t\t\t<if test=\"" + declaredFields[i].getName() + "!=null\">\n");
                }
                stringBuilder.append("\t\t\t\t\t" + declaredFields[i].getName() + "=#{" + declaredFields[i].getName() + "},\n");
                stringBuilder.append("\t\t\t\t</if>\n");
            } else {
                Class<?> aClass1 = Class.forName(declaredFields[i].getType().getName());
                String id = aClass1.getDeclaredFields()[0].getName();
                if (!id.equals("serialVersionUID")) {
                    stringBuilder.append("\t\t\t\t<if test=\"" + declaredFields[i].getName() + "!=null and " + declaredFields[i].getName() + "." + id + "!=null\">\n");
                    stringBuilder.append("\t\t\t\t\t" + declaredFields[i].getName() + "=#{" + declaredFields[i].getName() + "." + id + "},\n");
                } else {
                    stringBuilder.append("\t\t\t\t<if test=\"" + declaredFields[i].getName() + "!=null and " + declaredFields[i].getName() + "." + aClass1.getDeclaredFields()[1].getName() + "!=null\">\n");
                    stringBuilder.append("\t\t\t\t\t" + declaredFields[i].getName() + "=#{" + declaredFields[i].getName() + "." + aClass1.getDeclaredFields()[1].getName() + "},\n");
                }
                stringBuilder.append("\t\t\t\t</if>\n");
            }
        }
        stringBuilder.append("\t\t\t</set>\n");
        Field declaredField = declaredFields[0];
        if (!declaredField.getName().equals("serialVersionUID")) {
            stringBuilder.append("\t\t\twhere " + declaredField.getName() + "=#{" + declaredField.getName() + "}");
        } else {
            stringBuilder.append("\t\t\twhere " + declaredFields[1].getName() + "=#{" + declaredFields[1].getName() + "}");
        }
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public static String testSave(String className) throws ClassNotFoundException {
        Class<?> aClass = Class.forName(className);
        Field[] declaredFields = aClass.getDeclaredFields();
        //拿到类名转小写加上_得到表名
        String simpleName = aClass.getSimpleName();
        String s = simpleName.substring(0, 1).toLowerCase() + simpleName.substring(1, simpleName.length()) + "_";
        System.out.println(s);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("insert into ");

        if ("serialVersionUID".equals(declaredFields[0].getName())) {
            declaredFields = Arrays.copyOfRange(declaredFields, 1, declaredFields.length);
        }
        stringBuilder.append(s).append(" (");
        for (int i = 0; i < declaredFields.length; i++) {
            if (i == 0 && declaredFields[0].getType().equals("java.lang.Long") || declaredFields[0].getType().equals("java.lang.Integer")) {
                continue;
            }
            if (declaredFields.length != i + 1) {
                stringBuilder.append(declaredFields[i].getName()).append(",");
            } else {
                stringBuilder.append(declaredFields[i].getName()).append(") ");
            }
        }

        stringBuilder.append(" values(");

        for (int i = 0; i < declaredFields.length; i++) {
            if (i == 0 && declaredFields[0].getType().equals("java.lang.Long") || declaredFields[0].getType().equals("java.lang.Integer")) {
                stringBuilder.append("null,");
                continue;
            }
            stringBuilder.append("#{");
            if (declaredFields.length != i + 1) {
                if ((declaredFields[i].getType().getName().indexOf("java.lang")) == -1 && (declaredFields[i].getType().getName().indexOf("java.util")) == -1) {
                    Class<?> aClass1 = Class.forName(declaredFields[i].getType().getName());
                    //拿到类里面的类的第一个字段就是这个类的主键 主键必须写在第一行
                    Field declaredField = aClass1.getDeclaredFields()[0];
                    if (!declaredField.getName().equals("serialVersionUID")) {
                        stringBuilder.append(declaredFields[i].getName() + ".").append(declaredField.getName()).append("},");
                    } else {
                        stringBuilder.append(declaredFields[i].getName() + ".").append(aClass1.getDeclaredFields()[1].getName()).append("},");
                    }
                    continue;
                }
                stringBuilder.append(declaredFields[i].getName() + "},");
                continue;
            }
            if ((declaredFields[i].getType().getName().indexOf("java.lang")) == -1 && (declaredFields[i].getType().getName().indexOf("java.util")) == -1) {
                Class<?> aClass1 = Class.forName(declaredFields[i].getType().getName());
                //拿到类里面的类的第一个字段就是这个类的主键 主键必须写在第一行
                Field declaredField = aClass1.getDeclaredFields()[0];
                if (!declaredField.getName().equals("serialVersionUID")) {
                    stringBuilder.append(declaredFields[i].getName() + ".").append(declaredField.getName()).append("}");
                } else {
                    stringBuilder.append(declaredFields[i].getName() + ".").append(aClass1.getDeclaredFields()[1].getName()).append("}");
                }
                continue;
            }
            stringBuilder.append(declaredFields[i].getName() + "}");
        }
        stringBuilder.append(");");
        return stringBuilder.toString();
    }

    //mapper接口类
    public static void generQuery(String className, String prefix) throws Exception {
        String path = ClassUtils.getDefaultClassLoader().getResource("plate/DemoQuery.tlf").getPath();
        BufferedReader br = new BufferedReader(new FileReader(path));
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/cn/xxct/oa_element/" + prefix + "/mapper/" + className + "Mapper.java"));
        String line = null;
        String newLine = null;
        while ((line = br.readLine()) != null) {
            newLine = line.replace("Demo", className).replace("Prefix||", prefix);
            ;
            //写一行
            bw.write(newLine);
            //换新的一行
            bw.newLine();
            //刷新流
            bw.flush();
        }
        bw.close();
        br.close();
    }

    //拿到第一行主键的类型
    public static String primaryType(String ClassName) throws ClassNotFoundException {
        Class<?> aClass = Class.forName(ClassName);
        String Nname = aClass.getDeclaredFields()[0].getName();
        if (!Nname.equals("serialVersionUID")) {
            String name1 = aClass.getDeclaredFields()[0].getType().getName();
            String name = name1.substring((name1.lastIndexOf(".") + 1), name1.length());
            return name;
        } else {
            String name1 = aClass.getDeclaredFields()[1].getType().getName();
            String name = name1.substring((name1.lastIndexOf(".") + 1), name1.length());
            return name;
        }
    }

    //拿到写在第一行的主键
    public static String primaryId(String ClassName) throws ClassNotFoundException {

        Class<?> aClass = Class.forName(ClassName);
        String name = aClass.getDeclaredFields()[0].getName();
        if (!name.equals("serialVersionUID")) {
            return name;
        } else {
            return aClass.getDeclaredFields()[1].getName();
        }
    }

    //mapper文件
    public static void generMapperxml(String className, String prefix, String insertClassName) throws Exception {
        String LowerCase = className.substring(0, 1).toLowerCase() + className.substring(1, className.length());
        String path = ClassUtils.getDefaultClassLoader().getResource("plate/DemoMapperxml.tlf").getPath();
        BufferedReader br = new BufferedReader(new FileReader(path));
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/mybatis/" + prefix + "/" + className + "Mapper.xml"));
        String line = null;
        String newLine = null;
        String updateSql = updateSql(insertClassName);
        String addSql = testSave(insertClassName);

        //分页条件专用
        String ParamSql = whereParamPage(insertClassName);
        //普通条件用
        String whereAram = whereParam(insertClassName);

        //id类型
        String IdType = primaryType(insertClassName);

        //替换主键id
        String primaryId = primaryId(insertClassName);
        while ((line = br.readLine()) != null) {
            newLine = line.replace("Demo", className).replace("demo", LowerCase).replace("InsertSql", addSql)
                    .replace("updateSql", updateSql).replace("whereSql", ParamSql).replace("whereMapper", whereAram).replace("primaryId", primaryId)
                    .replace("IdType", IdType).replace("Prefix||", prefix);
            //写一行
            bw.write(newLine);
            //换新的一行
            bw.newLine();
            //刷新流
            bw.flush();
        }
        bw.close();
        br.close();
    }

    private static String whereParam(String insertClassName) throws ClassNotFoundException {
        Class<?> aClass = Class.forName(insertClassName);
        Field[] declaredFields = aClass.getDeclaredFields();
        StringBuffer sb = new StringBuffer();
        sb.append("<where>\n");
        for (int i = 0; i < declaredFields.length; i++) {
            if ((declaredFields[i].getType().getName().indexOf("java.lang.String")) != -1) {
                sb.append("\t\t<if test=\"").append(declaredFields[i].getName()).append("!=null and ").append(declaredFields[i].getName())
                        .append("!=''").append("\">\n\t\t\t");
                sb.append("and ").append(declaredFields[i].getName()).append(" like \"%\"#{").append(declaredFields[i].getName())
                        .append("}\"%\"\n");
                sb.append("\t\t</if>\n");
            }
        }
        sb.append("\t</where>");
        return sb.toString();
    }

    private static String whereParamPage(String insertClassName) throws ClassNotFoundException {
        Class<?> aClass = Class.forName(insertClassName);
        Field[] declaredFields = aClass.getDeclaredFields();
        StringBuffer sb = new StringBuffer();
        sb.append("<where>\n");
        for (int i = 0; i < declaredFields.length; i++) {
            if ((declaredFields[i].getType().getName().indexOf("java.lang.String")) != -1) {
                sb.append("\t\t<if test=\"param!=null and param.").append(declaredFields[i].getName()).append("!=null and param.").append(declaredFields[i].getName())
                        .append("!=''").append("\">\n\t\t\t");
                sb.append("and ").append(declaredFields[i].getName()).append(" like \"%\"#{").append("param.").append(declaredFields[i].getName())
                        .append("}\"%\"\n");
                sb.append("\t\t</if>\n");
            }
        }

        sb.append("\t</where>");
        return sb.toString();
    }

    //service接口
    public static void generService(String className, String prefix) throws Exception {
        String LowerCase = className.substring(0, 1).toLowerCase() + className.substring(1, className.length());
        String path = ClassUtils.getDefaultClassLoader().getResource("plate/DemoService.tlf").getPath();
        BufferedReader br = new BufferedReader(new FileReader(path));
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/cn/xxct/oa_element/" + prefix + "/service/" + className + "Service.java"));
        String line = null;
        String newLine = null;
        while ((line = br.readLine()) != null) {
            System.out.println("..........servicesssssssssss");
            newLine = line.replace("Demo", className).replace("demo", LowerCase).replace("Prefix||", prefix);
            //写一行
            bw.write(newLine);
            //换新的一行
            bw.newLine();
            //刷新流
            bw.flush();
        }
        bw.close();
        br.close();
    }

    //service实现
    public static void generServiceImpl(String className, String prefix) throws Exception {
        String LowerCase = className.substring(0, 1).toLowerCase() + className.substring(1, className.length());
        String path = ClassUtils.getDefaultClassLoader().getResource("plate/DemoServiceImpl.tlf").getPath();
        BufferedReader br = new BufferedReader(new FileReader(path));
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/cn/xxct/oa_element/" + prefix + "/service/impl/" + className + "ServiceImpl.java"));
        String line = null;
        String newLine = null;
        while ((line = br.readLine()) != null) {
            System.out.println("..........serviceimpl");
            newLine = line.replace("Demo", className).replace("demo", LowerCase).replace("Prefix||", prefix);
            //写一行
            bw.write(newLine);
            //换新的一行
            bw.newLine();
            //刷新流
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
