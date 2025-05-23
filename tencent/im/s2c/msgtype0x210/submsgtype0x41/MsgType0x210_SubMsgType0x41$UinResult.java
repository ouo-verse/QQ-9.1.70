package tencent.im.s2c.msgtype0x210.submsgtype0x41;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MsgType0x210_SubMsgType0x41$UinResult extends MessageMicro<MsgType0x210_SubMsgType0x41$UinResult> {
    public static final int BYTES_NICKNAME_FIELD_NUMBER = 2;
    public static final int STR_SCORE_FIELD_NUMBER = 4;
    public static final int UINT32_GRADE_FIELD_NUMBER = 3;
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"uint64_uin", "bytes_nickname", "uint32_grade", "str_score"}, new Object[]{0L, ByteStringMicro.EMPTY, 0, ""}, MsgType0x210_SubMsgType0x41$UinResult.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBBytesField bytes_nickname = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_grade = PBField.initUInt32(0);
    public final PBStringField str_score = PBField.initString("");
}
