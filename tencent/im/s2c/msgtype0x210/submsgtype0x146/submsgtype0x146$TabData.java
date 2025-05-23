package tencent.im.s2c.msgtype0x210.submsgtype0x146;

import com.qzone.widget.u;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x146$TabData extends MessageMicro<submsgtype0x146$TabData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{u.COLUMN_TAB_ID, "tab_status", "first_show"}, new Object[]{0, 0, Boolean.FALSE}, submsgtype0x146$TabData.class);
    public final PBUInt32Field tab_id = PBField.initUInt32(0);
    public final PBEnumField tab_status = PBField.initEnum(0);
    public final PBBoolField first_show = PBField.initBool(false);
}
