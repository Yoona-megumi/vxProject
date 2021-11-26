package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    private String sno;
    private String tno;
    private String info;
    private int statu;
    private int dangerlevel;

    public Appointment(String sno, String tno, String info, int dangerlevel) {
        this.sno = sno;
        this.tno = tno;
        this.info = info;
        this.dangerlevel = dangerlevel;
    }
}
