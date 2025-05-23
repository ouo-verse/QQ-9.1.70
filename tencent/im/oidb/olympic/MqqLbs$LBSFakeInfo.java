package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MqqLbs$LBSFakeInfo extends MessageMicro<MqqLbs$LBSFakeInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_fake_type", "uint32_fake_times"}, new Object[]{0, 0}, MqqLbs$LBSFakeInfo.class);
    public final PBUInt32Field uint32_fake_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_fake_times = PBField.initUInt32(0);
}
