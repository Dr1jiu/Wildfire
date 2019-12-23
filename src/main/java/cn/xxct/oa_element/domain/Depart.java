package cn.xxct.oa_element.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Depart {

    private Integer staff_no;

    private String staff_name;

    private String gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthhday;

    private String phone;

    private String password;

    private Integer dedpart_no;

    private Integer firm_no;

}