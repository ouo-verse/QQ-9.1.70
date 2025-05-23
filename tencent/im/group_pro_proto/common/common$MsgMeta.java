package tencent.im.group_pro_proto.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class common$MsgMeta extends MessageMicro<common$MsgMeta> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"at_all_seq", "channel_box_seq"}, new Object[]{0L, 0L}, common$MsgMeta.class);
    public final PBUInt64Field at_all_seq = PBField.initUInt64(0);
    public final PBUInt64Field channel_box_seq = PBField.initUInt64(0);
}
