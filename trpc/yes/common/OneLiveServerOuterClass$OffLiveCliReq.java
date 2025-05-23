package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class OneLiveServerOuterClass$OffLiveCliReq extends MessageMicro<OneLiveServerOuterClass$OffLiveCliReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"RoleInfo", "SwitchOn", "AppID"}, new Object[]{null, Boolean.FALSE, 0L}, OneLiveServerOuterClass$OffLiveCliReq.class);
    public OneLiveServerOuterClass$SGameRoleInfo RoleInfo = new OneLiveServerOuterClass$SGameRoleInfo();
    public final PBBoolField SwitchOn = PBField.initBool(false);
    public final PBUInt64Field AppID = PBField.initUInt64(0);
}
