package qqwifi.LBS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Location extends JceStruct {
    public String city;
    public String code;
    public String district;
    public String nation;
    public String province;
    public String street;
    public String town;
    public String village;

    public Location() {
        this.nation = "";
        this.province = "";
        this.city = "";
        this.district = "";
        this.code = "";
        this.town = "";
        this.village = "";
        this.street = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.nation = jceInputStream.readString(0, true);
        this.province = jceInputStream.readString(1, true);
        this.city = jceInputStream.readString(2, true);
        this.district = jceInputStream.readString(3, true);
        this.code = jceInputStream.readString(4, true);
        this.town = jceInputStream.readString(5, true);
        this.village = jceInputStream.readString(6, true);
        this.street = jceInputStream.readString(7, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.nation, 0);
        jceOutputStream.write(this.province, 1);
        jceOutputStream.write(this.city, 2);
        jceOutputStream.write(this.district, 3);
        jceOutputStream.write(this.code, 4);
        jceOutputStream.write(this.town, 5);
        jceOutputStream.write(this.village, 6);
        jceOutputStream.write(this.street, 7);
    }

    public Location(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.nation = str;
        this.province = str2;
        this.city = str3;
        this.district = str4;
        this.code = str5;
        this.town = str6;
        this.village = str7;
        this.street = str8;
    }
}
