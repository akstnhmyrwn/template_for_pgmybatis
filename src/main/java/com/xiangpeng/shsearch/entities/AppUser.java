package com.xiangpeng.shsearch.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "data",name = "user_self")
public class AppUser extends BaseEntity implements Serializable {
    @Id
    private Long id;
    private String username;
    private Byte gender;
    private Short age;
}
