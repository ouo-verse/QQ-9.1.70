package tencent.im.oidb.cmd0xf8e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xf8e$UserNode extends MessageMicro<oidb_0xf8e$UserNode> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"group_code", "seq", "status"}, new Object[]{0L, 0L, 0}, oidb_0xf8e$UserNode.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt64Field seq = PBField.initUInt64(0);
    public final PBUInt32Field status = PBField.initUInt32(0);
}
