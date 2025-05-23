package tencent.im.oidb.cmd0xec4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xec4$RspBody extends MessageMicro<oidb_0xec4$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40, 48}, new String[]{"msg_quest", "bool_is_fetch_over", "uint32_total_quest_num", "bytes_cookie", "uint32_ret", "uint32_answered_quest_num"}, new Object[]{null, Boolean.FALSE, 0, ByteStringMicro.EMPTY, 0, 0}, oidb_0xec4$RspBody.class);
    public final PBRepeatMessageField<oidb_0xec4$Quest> msg_quest = PBField.initRepeatMessage(oidb_0xec4$Quest.class);
    public final PBBoolField bool_is_fetch_over = PBField.initBool(false);
    public final PBUInt32Field uint32_total_quest_num = PBField.initUInt32(0);
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_ret = PBField.initUInt32(0);
    public final PBUInt32Field uint32_answered_quest_num = PBField.initUInt32(0);
}
