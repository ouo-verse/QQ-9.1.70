package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class GroupAppPb$AppList extends MessageMicro<GroupAppPb$AppList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"hash", "infos"}, new Object[]{"", null}, GroupAppPb$AppList.class);
    public final PBStringField hash = PBField.initString("");
    public final PBRepeatMessageField<GroupAppPb$AppInfo> infos = PBField.initRepeatMessage(GroupAppPb$AppInfo.class);
}
