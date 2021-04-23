package com.xiangpeng.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "new_model",name = "user_self")
public class AppUser implements Serializable {
    @Id
    private Long id;
    private Byte gender;
    private Byte age;
}
