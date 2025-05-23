package tencent.im.oidb.cmd0xe82;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouchWebviewHandler;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xe82$App extends MessageMicro<cmd0xe82$App> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48, 56, 66, 72, 80, 88, 98, 106, 114, 120, 162}, new String[]{"appid", "type", "name", "icon", "url", "removable", "source", "desc", "added", RedTouchWebviewHandler.PLUGIN_NAMESPACE, "add_ts", "icon_simple_day", "icon_simple_night", "cmd_trace", "show_frame", "ad_id"}, new Object[]{0L, 0L, "", "", "", 0, 0, "", 0, 0, 0L, "", "", "", 0, ""}, cmd0xe82$App.class);
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public final PBUInt64Field type = PBField.initUInt64(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field removable = PBField.initUInt32(0);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBStringField desc = PBField.initString("");
    public final PBUInt32Field added = PBField.initUInt32(0);
    public final PBInt32Field redpoint = PBField.initInt32(0);
    public final PBUInt64Field add_ts = PBField.initUInt64(0);
    public final PBStringField icon_simple_day = PBField.initString("");
    public final PBStringField icon_simple_night = PBField.initString("");
    public final PBStringField cmd_trace = PBField.initString("");
    public final PBUInt32Field show_frame = PBField.initUInt32(0);
    public final PBStringField ad_id = PBField.initString("");
}
