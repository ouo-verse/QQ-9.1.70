package tencent.im.oidb.cmd0xedb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xedb$ReqBody extends MessageMicro<oidb_0xedb$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"dstUsrType", "dstUsrInfos"}, new Object[]{0, null}, oidb_0xedb$ReqBody.class);
    public final PBUInt32Field dstUsrType = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0xedb$ReqUsrInfo> dstUsrInfos = PBField.initRepeatMessage(oidb_0xedb$ReqUsrInfo.class);
}
