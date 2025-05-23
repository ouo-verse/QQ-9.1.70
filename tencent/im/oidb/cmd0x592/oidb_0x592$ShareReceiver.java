package tencent.im.oidb.cmd0x592;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.trunk.Qworkflow.Qworkflow$UserSource;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x592$ShareReceiver extends MessageMicro<oidb_0x592$ShareReceiver> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_uin", "msg_source"}, new Object[]{0L, null}, oidb_0x592$ShareReceiver.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public Qworkflow$UserSource msg_source = new Qworkflow$UserSource();
}
