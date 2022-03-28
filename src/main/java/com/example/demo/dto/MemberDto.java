package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter  @Setter
@ToString
// (exclude 뺄것만) of 는 포함할것 toString(of = {"name"})
public class MemberDto {
    private String name;
    private String email;



}
