package tencent.im.s2c.msgtype0x211.submsgtype0x8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class C2CType0x211_SubC2CType0x8$BusiReqHead extends MessageMicro<C2CType0x211_SubC2CType0x8$BusiReqHead> {
    public static final int INT32_SEQ_FIELD_NUMBER = 2;
    public static final int INT32_VERSION_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"int32_version", "int32_seq"}, new Object[]{0, 0}, C2CType0x211_SubC2CType0x8$BusiReqHead.class);
    public final PBInt32Field int32_version = PBField.initInt32(0);
    public final PBInt32Field int32_seq = PBField.initInt32(0);
}
