package tencent.im.s2c.frdsysmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class FrdSysMsg$TongXunLuNickInfo extends MessageMicro<FrdSysMsg$TongXunLuNickInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint64_fromuin", "uint64_touin", "str_tongxunlu_nickname"}, new Object[]{0L, 0L, ""}, FrdSysMsg$TongXunLuNickInfo.class);
    public final PBUInt64Field uint64_fromuin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_touin = PBField.initUInt64(0);
    public final PBStringField str_tongxunlu_nickname = PBField.initString("");
}
