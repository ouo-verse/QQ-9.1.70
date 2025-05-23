package tencent.im.oidb.cmd0x101d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x101d$BotService extends MessageMicro<oidb_0x101d$BotService> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 48, 58, 64, 72}, new String[]{"bot_info", "id", "name", "url", "desc", "status", "available_range_desc", "type", "mark"}, new Object[]{null, 0, "", "", "", 0, "", 0, 0L}, oidb_0x101d$BotService.class);
    public oidb_0x101d$BotInfo bot_info = new oidb_0x101d$BotInfo();

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f435967id = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBStringField available_range_desc = PBField.initString("");
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBUInt64Field mark = PBField.initUInt64(0);
}
