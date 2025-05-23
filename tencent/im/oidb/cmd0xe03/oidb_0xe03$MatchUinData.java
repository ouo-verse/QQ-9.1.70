package tencent.im.oidb.cmd0xe03;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe03$MatchUinData extends MessageMicro<oidb_0xe03$MatchUinData> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_city;
    public final PBBytesField bytes_company;
    public final PBBytesField bytes_constellation;
    public final PBBytesField bytes_declaration;
    public final PBBytesField bytes_long_nick;
    public final PBBytesField bytes_nick;
    public final PBBytesField bytes_school;
    public final PBBytesField bytes_voice_url;
    public oidb_0xe03$LBSInfo msg_lbs_info;
    public final PBRepeatMessageField<oidb_0xe03$schoolInfo> rpt_school_info;
    public final PBRepeatMessageField<oidb_0xe03$ProfileTagInfo> rpt_tag;
    public final PBStringField str_from_city_name;
    public final PBStringField str_to_city_name;
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBUInt32Field uint32_distance;
    public final PBUInt32Field uint32_match_pool;
    public final PBUInt32Field uint32_popularity;
    public final PBUInt32Field uint32_sex;
    public final PBUInt32Field uint32_voice_duration;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 72, 80, 90, 98, 114, 120, 130, 136, 144, 154, 162}, new String[]{"uint32_age", "bytes_constellation", "bytes_city", "bytes_school", "rpt_tag", "bytes_company", "bytes_declaration", "bytes_voice_url", "uint32_voice_duration", "uint32_sex", "bytes_long_nick", "bytes_nick", "rpt_school_info", "uint32_popularity", "msg_lbs_info", "uint32_distance", "uint32_match_pool", "str_from_city_name", "str_to_city_name"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, null, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, null, 0, null, 0, 0, "", ""}, oidb_0xe03$MatchUinData.class);
    }

    public oidb_0xe03$MatchUinData() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_constellation = PBField.initBytes(byteStringMicro);
        this.bytes_city = PBField.initBytes(byteStringMicro);
        this.bytes_school = PBField.initBytes(byteStringMicro);
        this.rpt_tag = PBField.initRepeatMessage(oidb_0xe03$ProfileTagInfo.class);
        this.bytes_company = PBField.initBytes(byteStringMicro);
        this.bytes_declaration = PBField.initBytes(byteStringMicro);
        this.bytes_voice_url = PBField.initBytes(byteStringMicro);
        this.uint32_voice_duration = PBField.initUInt32(0);
        this.uint32_sex = PBField.initUInt32(0);
        this.bytes_long_nick = PBField.initBytes(byteStringMicro);
        this.bytes_nick = PBField.initBytes(byteStringMicro);
        this.rpt_school_info = PBField.initRepeatMessage(oidb_0xe03$schoolInfo.class);
        this.uint32_popularity = PBField.initUInt32(0);
        this.msg_lbs_info = new oidb_0xe03$LBSInfo();
        this.uint32_distance = PBField.initUInt32(0);
        this.uint32_match_pool = PBField.initUInt32(0);
        this.str_from_city_name = PBField.initString("");
        this.str_to_city_name = PBField.initString("");
    }
}
