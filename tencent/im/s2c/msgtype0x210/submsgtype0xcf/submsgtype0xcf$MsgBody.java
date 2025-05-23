package tencent.im.s2c.msgtype0x210.submsgtype0xcf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xcf$MsgBody extends MessageMicro<submsgtype0xcf$MsgBody> {
    public static final int STRING_RSPBODY_FIELD_NUMBER = 2;
    public static final int UINT32_RSPTYPE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_rsptype", "string_rspbody"}, new Object[]{0, ""}, submsgtype0xcf$MsgBody.class);
    public final PBUInt32Field uint32_rsptype = PBField.initUInt32(0);
    public final PBStringField string_rspbody = PBField.initString("");
}
