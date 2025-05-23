package trpc.qq_status_rank.status_rank_mgr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class StatusRankMgr$MapFieldEntry extends MessageMicro<StatusRankMgr$MapFieldEntry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, StatusRankMgr$MapFieldEntry.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
}
