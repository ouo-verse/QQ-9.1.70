package trpc.qq_status_rank.status_rank_mgr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class StatusRankMgr$StatusRankRequest extends MessageMicro<StatusRankMgr$StatusRankRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{ProfileCardDtReportUtil.STATUS_ID, "uin", "genrank"}, new Object[]{0, 0L, Boolean.FALSE}, StatusRankMgr$StatusRankRequest.class);
    public final PBInt32Field status_id = PBField.initInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBBoolField genrank = PBField.initBool(false);
}
