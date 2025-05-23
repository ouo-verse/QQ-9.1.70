package tencent.kandian.ugc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class topic_info$SyncCookie extends MessageMicro<topic_info$SyncCookie> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48}, new String[]{"start", "is_end", "module_id", "type", "end_rowkey", "end_rowkey_score"}, new Object[]{0L, 0, 0, 0, "", 0L}, topic_info$SyncCookie.class);
    public final PBUInt64Field start = PBField.initUInt64(0);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBUInt32Field module_id = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField end_rowkey = PBField.initString("");
    public final PBUInt64Field end_rowkey_score = PBField.initUInt64(0);
}
