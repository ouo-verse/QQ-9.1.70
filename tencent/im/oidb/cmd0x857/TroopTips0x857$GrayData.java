package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopTips0x857$GrayData extends MessageMicro<TroopTips0x857$GrayData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"all_read", "feed_id"}, new Object[]{0, ""}, TroopTips0x857$GrayData.class);
    public final PBUInt32Field all_read = PBField.initUInt32(0);
    public final PBStringField feed_id = PBField.initString("");
}
