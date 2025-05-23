package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFriendFeedMomentReader$SsoReadReq extends MessageMicro<QQCircleFriendFeedMomentReader$SsoReadReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"last_uin"}, new Object[]{0L}, QQCircleFriendFeedMomentReader$SsoReadReq.class);
    public final PBUInt64Field last_uin = PBField.initUInt64(0);
}
