package trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class LiveActivityServerOuterClass$SendTaskMsgReq extends MessageMicro<LiveActivityServerOuterClass$SendTaskMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 50, 58, 66}, new String[]{AudienceReportConst.ROOM_ID, "uid", "skey", "task_id", "live_uid", "nick", "head_url", "pskey"}, new Object[]{"", 0L, "", 0, 0L, "", "", null}, LiveActivityServerOuterClass$SendTaskMsgReq.class);
    public final PBStringField room_id = PBField.initString("");
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBStringField skey = PBField.initString("");
    public final PBInt32Field task_id = PBField.initInt32(0);
    public final PBUInt64Field live_uid = PBField.initUInt64(0);
    public final PBStringField nick = PBField.initString("");
    public final PBStringField head_url = PBField.initString("");
    public CommonOuterClass$PSKey pskey = new CommonOuterClass$PSKey();
}
