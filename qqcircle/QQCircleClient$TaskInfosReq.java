package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleClient$TaskInfosReq extends MessageMicro<QQCircleClient$TaskInfosReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{VipFunCallConstants.KEY_GROUP}, new Object[]{0}, QQCircleClient$TaskInfosReq.class);
    public final PBUInt32Field group = PBField.initUInt32(0);
}
