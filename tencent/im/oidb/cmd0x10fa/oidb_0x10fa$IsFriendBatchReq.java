package tencent.im.oidb.cmd0x10fa;

import com.tencent.mobileqq.mini.servlet.GetCMShowInfoServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x10fa$IsFriendBatchReq extends MessageMicro<oidb_0x10fa$IsFriendBatchReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"appid", GetCMShowInfoServlet.EXTRA_OPENID}, new Object[]{0, ""}, oidb_0x10fa$IsFriendBatchReq.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBRepeatField<String> openids = PBField.initRepeat(PBStringField.__repeatHelper__);
}
