package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StUserPushBoxInfo extends MessageMicro<QQCircleFeedBase$StUserPushBoxInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"unopendPushBoxCount"}, new Object[]{0L}, QQCircleFeedBase$StUserPushBoxInfo.class);
    public final PBInt64Field unopendPushBoxCount = PBField.initInt64(0);
}
