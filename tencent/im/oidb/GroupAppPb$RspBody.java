package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class GroupAppPb$RspBody extends MessageMicro<GroupAppPb$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"full_list", "group_gray_list", "red_point_list", "cache_interval"}, new Object[]{null, null, null, 0}, GroupAppPb$RspBody.class);
    public GroupAppPb$AppList full_list = new GroupAppPb$AppList();
    public GroupAppPb$AppList group_gray_list = new GroupAppPb$AppList();
    public GroupAppPb$AppList red_point_list = new GroupAppPb$AppList();
    public final PBUInt32Field cache_interval = PBField.initUInt32(0);
}
