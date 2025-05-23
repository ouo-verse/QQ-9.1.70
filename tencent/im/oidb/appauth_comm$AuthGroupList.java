package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class appauth_comm$AuthGroupList extends MessageMicro<appauth_comm$AuthGroupList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"auth_group_list"}, new Object[]{null}, appauth_comm$AuthGroupList.class);
    public final PBRepeatMessageField<appauth_comm$AuthGroup> auth_group_list = PBField.initRepeatMessage(appauth_comm$AuthGroup.class);
}
