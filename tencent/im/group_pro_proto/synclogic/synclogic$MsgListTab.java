package tencent.im.group_pro_proto.synclogic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class synclogic$MsgListTab extends MessageMicro<synclogic$MsgListTab> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"is_in_list", "top_timestamp"}, new Object[]{0, 0L}, synclogic$MsgListTab.class);
    public final PBUInt32Field is_in_list = PBField.initUInt32(0);
    public final PBUInt64Field top_timestamp = PBField.initUInt64(0);
}
