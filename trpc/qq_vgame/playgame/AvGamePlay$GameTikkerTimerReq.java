package trpc.qq_vgame.playgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class AvGamePlay$GameTikkerTimerReq extends MessageMicro<AvGamePlay$GameTikkerTimerReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_notify_item"}, new Object[]{null}, AvGamePlay$GameTikkerTimerReq.class);
    public final PBRepeatMessageField<AvGamePlay$NotifyItem> rpt_notify_item = PBField.initRepeatMessage(AvGamePlay$NotifyItem.class);
}
