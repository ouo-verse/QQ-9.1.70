package trpc.qq_status_rank.status_rank_mgr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class StatusRankMgr$StatusRankResponse extends MessageMicro<StatusRankMgr$StatusRankResponse> {
    public static final int FAILED = 3;
    public static final int NOT_ALLOWED = 1;
    public static final int NOT_SETTED = 2;
    public static final int SUCCESS = 0;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBEnumField res = PBField.initEnum(0);
    public final PBUInt64Field rank = PBField.initUInt64(0);
    public final PBBoolField first_time = PBField.initBool(false);
    public final PBBoolField in_status = PBField.initBool(false);
    public final PBRepeatMessageField<StatusRankMgr$MapFieldEntry> extra = PBField.initRepeatMessage(StatusRankMgr$MapFieldEntry.class);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"res", "rank", "first_time", "in_status", "extra"}, new Object[]{0, 0L, bool, bool, null}, StatusRankMgr$StatusRankResponse.class);
    }
}
