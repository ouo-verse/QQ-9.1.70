package tencent.im.oidb.cmd0x934;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x934$Item extends MessageMicro<cmd0x934$Item> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 58, 66, 7992, 8000}, new String[]{"off_info", "on_info", "hot", "id", "version", "mark", "setting_url", "desc", "is_set", "is_receive"}, new Object[]{null, null, Boolean.FALSE, 0, 0, 0L, "", "", 0, 0}, cmd0x934$Item.class);
    public cmd0x934$ItemInfo off_info = new cmd0x934$ItemInfo();
    public cmd0x934$ItemInfo on_info = new cmd0x934$ItemInfo();
    public final PBBoolField hot = PBField.initBool(false);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f435981id = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBUInt64Field mark = PBField.initUInt64(0);
    public final PBStringField setting_url = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBUInt32Field is_set = PBField.initUInt32(0);
    public final PBUInt32Field is_receive = PBField.initUInt32(0);
}
