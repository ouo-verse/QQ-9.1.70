package tencent.im.oidb.cmd0xaf4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xaf4$RspBody extends MessageMicro<oidb_0xaf4$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42}, new String[]{"group_id", "infos", "extra_info", "add_limit", "manage_info"}, new Object[]{0L, null, null, 0, null}, oidb_0xaf4$RspBody.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBRepeatMessageField<oidb_0xaf4$AppInfo> infos = PBField.initRepeatMessage(oidb_0xaf4$AppInfo.class);
    public oidb_0xaf4$ExtraInfo extra_info = new MessageMicro<oidb_0xaf4$ExtraInfo>() { // from class: tencent.im.oidb.cmd0xaf4.oidb_0xaf4$ExtraInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"tab_infos"}, new Object[]{null}, oidb_0xaf4$ExtraInfo.class);
        public final PBRepeatMessageField<oidb_0xaf4$TabInfo> tab_infos = PBField.initRepeatMessage(oidb_0xaf4$TabInfo.class);
    };
    public final PBUInt32Field add_limit = PBField.initUInt32(0);
    public oidb_0xaf4$ManageInfo manage_info = new MessageMicro<oidb_0xaf4$ManageInfo>() { // from class: tencent.im.oidb.cmd0xaf4.oidb_0xaf4$ManageInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"label", "url"}, new Object[]{"", ""}, oidb_0xaf4$ManageInfo.class);
        public final PBStringField label = PBField.initString("");
        public final PBStringField url = PBField.initString("");
    };
}
