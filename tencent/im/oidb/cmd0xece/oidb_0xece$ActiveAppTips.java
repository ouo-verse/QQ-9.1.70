package tencent.im.oidb.cmd0xece;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xece$ActiveAppTips extends MessageMicro<oidb_0xece$ActiveAppTips> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"apps"}, new Object[]{null}, oidb_0xece$ActiveAppTips.class);
    public final PBRepeatMessageField<oidb_0xece$App> apps = PBField.initRepeatMessage(oidb_0xece$App.class);
}
