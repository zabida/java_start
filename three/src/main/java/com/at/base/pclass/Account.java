package com.at.base.pclass;


import com.at.base.AnnotationTwo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @NonNull
    public Integer money;
    public String aname;

    public static Account getOne(String userName){
        return new Account(100, userName);
    }
}
