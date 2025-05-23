package tencent.im.spring_hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GetStarRedDot$AddUserStarScoreRsp extends MessageMicro<GetStarRedDot$AddUserStarScoreRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"add_score", "toast_msg"}, new Object[]{0, ""}, GetStarRedDot$AddUserStarScoreRsp.class);
    public final PBInt32Field add_score = PBField.initInt32(0);
    public final PBStringField toast_msg = PBField.initString("");
}
