package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QQCirclePushbox$UserPushBoxCnt extends MessageMicro<QQCirclePushbox$UserPushBoxCnt> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"un_open_count"}, new Object[]{0L}, QQCirclePushbox$UserPushBoxCnt.class);
    public final PBUInt64Field un_open_count = PBField.initUInt64(0);
}
