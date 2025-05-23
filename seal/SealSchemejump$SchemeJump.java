package seal;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SealSchemejump$SchemeJump extends MessageMicro<SealSchemejump$SchemeJump> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"feed_id", TPReportKeys.LiveExKeys.LIVE_EX_CONTENT_ID, "pageinfo", "page_id"}, new Object[]{"", 0L, "", 0}, SealSchemejump$SchemeJump.class);
    public final PBStringField feed_id = PBField.initString("");
    public final PBUInt64Field contentid = PBField.initUInt64(0);
    public final PBStringField pageinfo = PBField.initString("");
    public final PBUInt32Field page_id = PBField.initUInt32(0);
}
