package tencent.im.msg.hummer.resv;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ResvAttrForGiftMsg$ActivityGiftInfo extends MessageMicro<ResvAttrForGiftMsg$ActivityGiftInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"is_activity_gift", "text_color", "text", "url"}, new Object[]{0, "", "", ""}, ResvAttrForGiftMsg$ActivityGiftInfo.class);
    public final PBUInt32Field is_activity_gift = PBField.initUInt32(0);
    public final PBStringField text_color = PBField.initString("");
    public final PBStringField text = PBField.initString("");
    public final PBStringField url = PBField.initString("");
}
