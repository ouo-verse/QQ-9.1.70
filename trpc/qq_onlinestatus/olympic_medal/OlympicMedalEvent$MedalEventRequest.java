package trpc.qq_onlinestatus.olympic_medal;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OlympicMedalEvent$MedalEventRequest extends MessageMicro<OlympicMedalEvent$MedalEventRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"from_aio"}, new Object[]{Boolean.FALSE}, OlympicMedalEvent$MedalEventRequest.class);
    public final PBBoolField from_aio = PBField.initBool(false);
}
