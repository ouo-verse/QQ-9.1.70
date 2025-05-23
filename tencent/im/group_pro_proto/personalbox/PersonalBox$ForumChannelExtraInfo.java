package tencent.im.group_pro_proto.personalbox;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class PersonalBox$ForumChannelExtraInfo extends MessageMicro<PersonalBox$ForumChannelExtraInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"timestamp"}, new Object[]{0L}, PersonalBox$ForumChannelExtraInfo.class);
    public final PBUInt64Field timestamp = PBField.initUInt64(0);
}
