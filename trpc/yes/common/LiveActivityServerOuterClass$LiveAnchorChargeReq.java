package trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class LiveActivityServerOuterClass$LiveAnchorChargeReq extends MessageMicro<LiveActivityServerOuterClass$LiveAnchorChargeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uid", AudienceReportConst.ROOM_ID, "trace_seq"}, new Object[]{0L, 0L, ""}, LiveActivityServerOuterClass$LiveAnchorChargeReq.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBStringField trace_seq = PBField.initString("");
}
