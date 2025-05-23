package tencent.im.group_pro_proto.personalbox;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class PersonalBox$AddReq extends MessageMicro<PersonalBox$AddReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField biz_data;
    public final PBUInt64Field biz_type = PBField.initUInt64(0);
    public final PBUInt64Field channel_id;
    public final PBUInt64Field from_tinyid;
    public final PBUInt64Field guild_id;
    public final PBRepeatField<Long> to_uins;
    public final PBBytesField unique_key;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 50, 56}, new String[]{"biz_type", "unique_key", "guild_id", "channel_id", "from_tinyid", "biz_data", "to_uins"}, new Object[]{0L, byteStringMicro, 0L, 0L, 0L, byteStringMicro, 0L}, PersonalBox$AddReq.class);
    }

    public PersonalBox$AddReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.unique_key = PBField.initBytes(byteStringMicro);
        this.guild_id = PBField.initUInt64(0L);
        this.channel_id = PBField.initUInt64(0L);
        this.from_tinyid = PBField.initUInt64(0L);
        this.biz_data = PBField.initBytes(byteStringMicro);
        this.to_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    }
}
