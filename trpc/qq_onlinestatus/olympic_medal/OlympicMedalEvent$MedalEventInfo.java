package trpc.qq_onlinestatus.olympic_medal;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OlympicMedalEvent$MedalEventInfo extends MessageMicro<OlympicMedalEvent$MedalEventInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"event_id", "start", "end", "msg"}, new Object[]{0, 0L, 0L, ""}, OlympicMedalEvent$MedalEventInfo.class);
    public final PBUInt32Field event_id = PBField.initUInt32(0);
    public final PBUInt64Field start = PBField.initUInt64(0);
    public final PBUInt64Field end = PBField.initUInt64(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f437236msg = PBField.initString("");
}
