package tencent.im.s2c.msgtype0x211.submsgtype0x8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class C2CType0x211_SubC2CType0x8$BusiRespHead extends MessageMicro<C2CType0x211_SubC2CType0x8$BusiRespHead> {
    public static final int INT32_REPLY_CODE_FIELD_NUMBER = 3;
    public static final int INT32_SEQ_FIELD_NUMBER = 2;
    public static final int INT32_VERSION_FIELD_NUMBER = 1;
    public static final int STR_RESULT_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"int32_version", "int32_seq", "int32_reply_code", "str_result"}, new Object[]{0, 0, 0, ""}, C2CType0x211_SubC2CType0x8$BusiRespHead.class);
    public final PBInt32Field int32_version = PBField.initInt32(0);
    public final PBInt32Field int32_seq = PBField.initInt32(0);
    public final PBInt32Field int32_reply_code = PBField.initInt32(0);
    public final PBStringField str_result = PBField.initString("");
}
