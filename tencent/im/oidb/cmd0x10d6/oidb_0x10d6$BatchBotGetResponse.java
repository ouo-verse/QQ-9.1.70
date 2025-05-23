package tencent.im.oidb.cmd0x10d6;

import com.huawei.hms.common.data.DataBufferUtils;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x10d6$BatchBotGetResponse extends MessageMicro<oidb_0x10d6$BatchBotGetResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bot_features", DataBufferUtils.NEXT_PAGE}, new Object[]{null, 0}, oidb_0x10d6$BatchBotGetResponse.class);
    public final PBRepeatMessageField<oidb_0x10d6$BotFeatures> bot_features = PBField.initRepeatMessage(oidb_0x10d6$BotFeatures.class);
    public final PBInt32Field next_page = PBField.initInt32(0);
}
