package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* loaded from: classes29.dex */
public final class QQCircleCounter$EeveePushExt extends MessageMicro<QQCircleCounter$EeveePushExt> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"pushTime", "recomPushData"}, new Object[]{0L, ByteStringMicro.EMPTY}, QQCircleCounter$EeveePushExt.class);
    public final PBInt64Field pushTime = PBField.initInt64(0);
    public final PBBytesField recomPushData = PBField.initBytes(ByteStringMicro.EMPTY);
}
