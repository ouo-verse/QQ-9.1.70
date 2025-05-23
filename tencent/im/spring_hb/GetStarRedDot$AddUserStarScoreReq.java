package tencent.im.spring_hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GetStarRedDot$AddUserStarScoreReq extends MessageMicro<GetStarRedDot$AddUserStarScoreReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"count"}, new Object[]{0}, GetStarRedDot$AddUserStarScoreReq.class);
    public final PBInt32Field count = PBField.initInt32(0);
}
