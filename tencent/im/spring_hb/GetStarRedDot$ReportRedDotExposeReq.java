package tencent.im.spring_hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GetStarRedDot$ReportRedDotExposeReq extends MessageMicro<GetStarRedDot$ReportRedDotExposeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"expose_num"}, new Object[]{0}, GetStarRedDot$ReportRedDotExposeReq.class);
    public final PBUInt32Field expose_num = PBField.initUInt32(0);
}
