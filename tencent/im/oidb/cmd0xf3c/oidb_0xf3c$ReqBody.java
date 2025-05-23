package tencent.im.oidb.cmd0xf3c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xf3c$ReqBody extends MessageMicro<oidb_0xf3c$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"group_code", "appid"}, new Object[]{0L, 0}, oidb_0xf3c$ReqBody.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt32Field appid = PBField.initUInt32(0);
}
