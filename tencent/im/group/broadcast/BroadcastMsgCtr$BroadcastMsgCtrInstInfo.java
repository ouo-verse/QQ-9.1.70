package tencent.im.group.broadcast;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class BroadcastMsgCtr$BroadcastMsgCtrInstInfo extends MessageMicro<BroadcastMsgCtr$BroadcastMsgCtrInstInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_appid", "uint32_inst_id"}, new Object[]{0, 0}, BroadcastMsgCtr$BroadcastMsgCtrInstInfo.class);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_inst_id = PBField.initUInt32(0);
}
