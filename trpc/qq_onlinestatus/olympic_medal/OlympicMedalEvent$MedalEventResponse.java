package trpc.qq_onlinestatus.olympic_medal;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OlympicMedalEvent$MedalEventResponse extends MessageMicro<OlympicMedalEvent$MedalEventResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"event_valid", "pull_interval_seconds", "event"}, new Object[]{Boolean.FALSE, 0, null}, OlympicMedalEvent$MedalEventResponse.class);
    public final PBBoolField event_valid = PBField.initBool(false);
    public final PBUInt32Field pull_interval_seconds = PBField.initUInt32(0);
    public OlympicMedalEvent$MedalEventInfo event = new OlympicMedalEvent$MedalEventInfo();
}
