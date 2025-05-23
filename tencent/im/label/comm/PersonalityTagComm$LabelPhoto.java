package tencent.im.label.comm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class PersonalityTagComm$LabelPhoto extends MessageMicro<PersonalityTagComm$LabelPhoto> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 50, 56, 64}, new String[]{"uint64_file_id", "uint32_url", "uint32_upload_time", "uint64_praise_count", "rpt_msg_praise_rec", "bytes_praise_cookie", "uint32_file_slot", "uint32_praise_flag"}, new Object[]{0L, "", 0, 0L, null, ByteStringMicro.EMPTY, 0, 0}, PersonalityTagComm$LabelPhoto.class);
    public final PBUInt64Field uint64_file_id = PBField.initUInt64(0);
    public final PBStringField uint32_url = PBField.initString("");
    public final PBUInt32Field uint32_upload_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_praise_count = PBField.initUInt64(0);
    public final PBRepeatMessageField<PersonalityTagComm$PraiseRec> rpt_msg_praise_rec = PBField.initRepeatMessage(PersonalityTagComm$PraiseRec.class);
    public final PBBytesField bytes_praise_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_file_slot = PBField.initUInt32(0);
    public final PBUInt32Field uint32_praise_flag = PBField.initUInt32(0);
}
