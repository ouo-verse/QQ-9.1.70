package tencent.im.oidb.cmd0xd23;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xd23$CacheData extends MessageMicro<Oidb_0xd23$CacheData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_app_info"}, new Object[]{null}, Oidb_0xd23$CacheData.class);
    public final PBRepeatMessageField<Oidb_0xd23$AppInfo> rpt_app_info = PBField.initRepeatMessage(Oidb_0xd23$AppInfo.class);
}
