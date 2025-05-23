package tencent.im.oidb.cmd0xedb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xedb$ReqUsrInfo extends MessageMicro<oidb_0xedb$ReqUsrInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"dstUin", "timestamp"}, new Object[]{0L, 0}, oidb_0xedb$ReqUsrInfo.class);
    public final PBUInt64Field dstUin = PBField.initUInt64(0);
    public final PBUInt32Field timestamp = PBField.initUInt32(0);
}
