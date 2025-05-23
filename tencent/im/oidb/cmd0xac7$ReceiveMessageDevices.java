package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xac7$ReceiveMessageDevices extends MessageMicro<cmd0xac7$ReceiveMessageDevices> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_devices"}, new Object[]{null}, cmd0xac7$ReceiveMessageDevices.class);
    public final PBRepeatMessageField<cmd0xac7$DeviceInfo> rpt_devices = PBField.initRepeatMessage(cmd0xac7$DeviceInfo.class);
}
