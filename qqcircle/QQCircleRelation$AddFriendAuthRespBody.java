package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRelation$AddFriendAuthRespBody extends MessageMicro<QQCircleRelation$AddFriendAuthRespBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"sint32_result", "bytes_err_msg"}, new Object[]{0, ""}, QQCircleRelation$AddFriendAuthRespBody.class);
    public final PBSInt32Field sint32_result = PBField.initSInt32(0);
    public final PBStringField bytes_err_msg = PBField.initString("");
}
