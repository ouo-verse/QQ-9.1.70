package tencent.im.oidb.searcher;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_c2c_searcher$MsgKey extends MessageMicro<oidb_c2c_searcher$MsgKey> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"time", "magic", "seq"}, new Object[]{0L, 0, 0}, oidb_c2c_searcher$MsgKey.class);
    public final PBUInt64Field time = PBField.initUInt64(0);
    public final PBUInt32Field magic = PBField.initUInt32(0);
    public final PBUInt32Field seq = PBField.initUInt32(0);
}
