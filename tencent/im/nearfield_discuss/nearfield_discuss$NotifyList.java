package tencent.im.nearfield_discuss;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nearfield_discuss$NotifyList extends MessageMicro<nearfield_discuss$NotifyList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"notify_type", "rpt_msg_update_list", "uint32_session_id"}, new Object[]{0, null, 0}, nearfield_discuss$NotifyList.class);
    public final PBEnumField notify_type = PBField.initEnum(0);
    public final PBRepeatMessageField<nearfield_discuss$UpdateInfo> rpt_msg_update_list = PBField.initRepeatMessage(nearfield_discuss$UpdateInfo.class);
    public final PBUInt32Field uint32_session_id = PBField.initUInt32(0);
}
