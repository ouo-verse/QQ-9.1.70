package tencent.im.beancurd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class anniversary$Anniversary extends MessageMicro<anniversary$Anniversary> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_anniversary_info"}, new Object[]{null}, anniversary$Anniversary.class);
    public final PBRepeatMessageField<anniversary$AnniversaryInfo> rpt_anniversary_info = PBField.initRepeatMessage(anniversary$AnniversaryInfo.class);
}
