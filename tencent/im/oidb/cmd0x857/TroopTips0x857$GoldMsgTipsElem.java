package tencent.im.oidb.cmd0x857;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopTips0x857$GoldMsgTipsElem extends MessageMicro<TroopTips0x857$GoldMsgTipsElem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48, 56, 64, 72}, new String[]{"type", "billno", "result", "amount", "total", WidgetCacheConstellationData.INTERVAL, "finish", "uin", "action"}, new Object[]{0, "", 0, 0, 0, 0, 0, 0L, 0}, TroopTips0x857$GoldMsgTipsElem.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField billno = PBField.initString("");
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBUInt32Field amount = PBField.initUInt32(0);
    public final PBUInt32Field total = PBField.initUInt32(0);
    public final PBUInt32Field interval = PBField.initUInt32(0);
    public final PBUInt32Field finish = PBField.initUInt32(0);
    public final PBRepeatField<Long> uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field action = PBField.initUInt32(0);
}
