package tencent.im.oidb.cmd0xb70;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xb70$ReqBody extends MessageMicro<oidb_0xb70$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"group_id", "appid"}, new Object[]{0L, 0L}, oidb_0xb70$ReqBody.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBUInt64Field appid = PBField.initUInt64(0);
}
