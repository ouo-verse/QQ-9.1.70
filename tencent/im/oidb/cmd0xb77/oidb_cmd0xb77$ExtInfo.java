package tencent.im.oidb.cmd0xb77;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xb77$ExtInfo extends MessageMicro<oidb_cmd0xb77$ExtInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField message_ext;
    public final PBBytesField tag_name;
    public final PBRepeatField<Integer> rpt_custom_featureid = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBStringField apns_wording = PBField.initString("");
    public final PBUInt32Field uint32_group_savedb_flag = PBField.initUInt32(0);
    public final PBUInt32Field receiver_appid = PBField.initUInt32(0);
    public final PBUInt64Field msg_seq = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{88, 98, 104, 112, 120, 138, 146}, new String[]{"rpt_custom_featureid", "apns_wording", "uint32_group_savedb_flag", "receiver_appid", "msg_seq", "tag_name", "message_ext"}, new Object[]{0, "", 0, 0, 0L, byteStringMicro, byteStringMicro}, oidb_cmd0xb77$ExtInfo.class);
    }

    public oidb_cmd0xb77$ExtInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.tag_name = PBField.initBytes(byteStringMicro);
        this.message_ext = PBField.initBytes(byteStringMicro);
    }
}
