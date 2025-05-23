package tencent.im.group_pro_proto.appchannelinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class appchannelinfo$ApplicationChannelInfo extends MessageMicro<appchannelinfo$ApplicationChannelInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"uint64_application_id", "str_app_channel_id", "str_jump_secret", "qyy_flag"}, new Object[]{0L, "", "", 0}, appchannelinfo$ApplicationChannelInfo.class);
    public final PBUInt64Field uint64_application_id = PBField.initUInt64(0);
    public final PBStringField str_app_channel_id = PBField.initString("");
    public final PBStringField str_jump_secret = PBField.initString("");
    public final PBUInt32Field qyy_flag = PBField.initUInt32(0);
}
