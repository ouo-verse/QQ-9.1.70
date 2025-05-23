package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class oidb_0xbe8$PopupResult extends MessageMicro<oidb_0xbe8$PopupResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_popup_result", "uint32_popup_fieldid"}, new Object[]{0, 0}, oidb_0xbe8$PopupResult.class);
    public final PBUInt32Field uint32_popup_result = PBField.initUInt32(0);
    public final PBUInt32Field uint32_popup_fieldid = PBField.initUInt32(0);
}
