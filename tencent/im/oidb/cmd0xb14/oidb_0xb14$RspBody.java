package tencent.im.oidb.cmd0xb14;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xb14$RspBody extends MessageMicro<oidb_0xb14$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"group_id", "infos", WidgetCacheConstellationData.INTERVAL}, new Object[]{0L, null, 0}, oidb_0xb14$RspBody.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBRepeatMessageField<oidb_0xb14$UserInfo> infos = PBField.initRepeatMessage(oidb_0xb14$UserInfo.class);
    public final PBUInt32Field interval = PBField.initUInt32(0);
}
