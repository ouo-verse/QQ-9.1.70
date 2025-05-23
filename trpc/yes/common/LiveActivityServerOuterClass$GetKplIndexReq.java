package trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class LiveActivityServerOuterClass$GetKplIndexReq extends MessageMicro<LiveActivityServerOuterClass$GetKplIndexReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{AudienceReportConst.ROOM_ID, "uid", "follow", "skey"}, new Object[]{"", 0L, 0, ""}, LiveActivityServerOuterClass$GetKplIndexReq.class);
    public final PBStringField room_id = PBField.initString("");
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBInt32Field follow = PBField.initInt32(0);
    public final PBStringField skey = PBField.initString("");
}
