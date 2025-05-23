package tencent.im.oidb.cmd0x10ae;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class oidb_0x10ae$GetZPlanFriendListRequest extends MessageMicro<oidb_0x10ae$GetZPlanFriendListRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"appid"}, new Object[]{0L}, oidb_0x10ae$GetZPlanFriendListRequest.class);
    public final PBUInt64Field appid = PBField.initUInt64(0);
}
