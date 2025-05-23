package tencent.im.oidb.cmd0xd69;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xd69$DoubtInfo extends MessageMicro<oidb_cmd0xd69$DoubtInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_city;
    public final PBBytesField bytes_msg;
    public final PBBytesField bytes_name_more;
    public final PBBytesField bytes_nick;
    public final PBBytesField bytes_reason;
    public final PBBytesField bytes_session_key;
    public final PBBytesField bytes_source;
    public final PBStringField str_entity_category;
    public final PBStringField str_entity_name;
    public final PBStringField str_entity_url;
    public final PBUInt32Field uint32_age;
    public final PBUInt32Field uint32_comm_frd_num;
    public final PBUInt32Field uint32_sex;
    public final PBUInt32Field uint32_source_flag;
    public final PBUInt32Field uint32_time;
    public final PBUInt64Field uint64_group;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 50, 58, 64, 72, 80, 90, 98, 106, 114, 122, 130, 136}, new String[]{"uint64_uin", "bytes_nick", "uint32_age", "uint32_sex", "bytes_msg", "bytes_source", "bytes_reason", "uint32_time", "uint64_group", "uint32_comm_frd_num", "bytes_name_more", "bytes_city", "bytes_session_key", "str_entity_category", "str_entity_name", "str_entity_url", "uint32_source_flag"}, new Object[]{0L, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0L, 0, byteStringMicro, byteStringMicro, byteStringMicro, "", "", "", 0}, oidb_cmd0xd69$DoubtInfo.class);
    }

    public oidb_cmd0xd69$DoubtInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_nick = PBField.initBytes(byteStringMicro);
        this.uint32_age = PBField.initUInt32(0);
        this.uint32_sex = PBField.initUInt32(0);
        this.bytes_msg = PBField.initBytes(byteStringMicro);
        this.bytes_source = PBField.initBytes(byteStringMicro);
        this.bytes_reason = PBField.initBytes(byteStringMicro);
        this.uint32_time = PBField.initUInt32(0);
        this.uint64_group = PBField.initUInt64(0L);
        this.uint32_comm_frd_num = PBField.initUInt32(0);
        this.bytes_name_more = PBField.initBytes(byteStringMicro);
        this.bytes_city = PBField.initBytes(byteStringMicro);
        this.bytes_session_key = PBField.initBytes(byteStringMicro);
        this.str_entity_category = PBField.initString("");
        this.str_entity_name = PBField.initString("");
        this.str_entity_url = PBField.initString("");
        this.uint32_source_flag = PBField.initUInt32(0);
    }
}
