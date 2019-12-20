package cn.xxct.oa_element.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.crazycake.shiro.AuthCachePrincipal;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Human_resources implements Serializable, AuthCachePrincipal {
    private static final long serialVersionUID = -2999695134329706442L;
//用不到
    private String human_Id;
    private String hr_Name;//	varchar50 姓名
    private String hr_Address;// 	varchar255 住址
    private String hr_Title;//		varchar50 职称
    private String hr_Position_Sort;//	varchar50 职位分类
    private String hr_Position_Name;// varchar50 职位名称
    private String hr_Sex;//		char2  性别
    private String hr_Postcode;//	varchar255 邮编
    private String hr_Phone;//	varchar 50 电话
    private String hr_Age;//		varchar20 年龄
    private String hr_Identity;//	char18	身份证
    private Double hr_Pay;//
    private String hr_Email;//
    private String state;
    private String dateTime;
    private String Auxiliary_Id;

    @Override
    public String getAuthCacheKey() {
        return null;
    }

//    human_Id 	varchar255 主键id
//    hr_Name	varchar50 姓名
//    hr_Address 	varchar255 住址
//    hr_Title		varchar50 职称
//    hr_Position_Sort	varchar50 职位分类
//    hr_Position_Name varchar50 职位名称
//    hr_Sex		char2  性别
//    hr_Postcode	varchar255 邮编
//    hr_Phone	varchar 50 电话
//    hr_Age		varchar20 年龄
//    hr_Identity	char18	身份证
//    hr_Emal		varchar50 薪酬
//    state		char4
//    dateTime	data
//    Auxiliary_Id
}
