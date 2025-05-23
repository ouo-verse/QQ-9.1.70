package tencent.im.s2c.frdsysmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class FrdSysMsg$MsgEncodeFlag extends MessageMicro<FrdSysMsg$MsgEncodeFlag> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_is_utf8"}, new Object[]{0}, FrdSysMsg$MsgEncodeFlag.class);
    public final PBUInt32Field uint32_is_utf8 = PBField.initUInt32(0);
}
