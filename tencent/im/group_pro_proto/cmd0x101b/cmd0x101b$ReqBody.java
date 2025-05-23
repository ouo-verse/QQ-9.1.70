package tencent.im.group_pro_proto.cmd0x101b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x101b$ReqBody extends MessageMicro<cmd0x101b$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBEnumField business_type;
    public final PBBytesField extend_param;
    public final PBBytesField share_atta_data;
    public final PBRepeatField<Long> target_uins;
    public final PBUInt64Field target_uin = PBField.initUInt64(0);
    public final PBUInt64Field target_gcode = PBField.initUInt64(0);
    public final PBUInt64Field dst_guild_id = PBField.initUInt64(0);
    public final PBUInt64Field dst_channel_id = PBField.initUInt64(0);
    public final PBUInt64Field src_guild_id = PBField.initUInt64(0);
    public final PBUInt64Field src_channel_id = PBField.initUInt64(0);
    public final PBUInt32Field target_type = PBField.initUInt32(0);
    public final PBStringField from = PBField.initString("");
    public final PBStringField biz = PBField.initString("");
    public final PBStringField leave_message = PBField.initString("");

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 66, 74, 82, 90, 96, 104, 114}, new String[]{"target_uin", "target_gcode", "dst_guild_id", "dst_channel_id", "src_guild_id", "src_channel_id", "target_type", "from", "biz", "leave_message", "extend_param", "business_type", "target_uins", "share_atta_data"}, new Object[]{0L, 0L, 0L, 0L, 0L, 0L, 0, "", "", "", byteStringMicro, 0, 0L, byteStringMicro}, cmd0x101b$ReqBody.class);
    }

    public cmd0x101b$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.extend_param = PBField.initBytes(byteStringMicro);
        this.business_type = PBField.initEnum(0);
        this.target_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        this.share_atta_data = PBField.initBytes(byteStringMicro);
    }
}
