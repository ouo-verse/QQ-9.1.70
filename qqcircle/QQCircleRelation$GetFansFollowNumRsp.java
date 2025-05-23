package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRelation$GetFansFollowNumRsp extends MessageMicro<QQCircleRelation$GetFansFollowNumRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"fansNum", "followNum"}, new Object[]{0L, 0L}, QQCircleRelation$GetFansFollowNumRsp.class);
    public final PBInt64Field fansNum = PBField.initInt64(0);
    public final PBInt64Field followNum = PBField.initInt64(0);
}
