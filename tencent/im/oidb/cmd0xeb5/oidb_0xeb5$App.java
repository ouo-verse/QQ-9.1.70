package tencent.im.oidb.cmd0xeb5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouchWebviewHandler;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xeb5$App extends MessageMicro<oidb_0xeb5$App> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50, 56, 64, 74, 80, 90, 96}, new String[]{"appid", "type", "name", "icon", "url", "desc", RedTouchWebviewHandler.PLUGIN_NAMESPACE, "playing_num", "labels", "ark", "ark_label", "jump_type"}, new Object[]{"", 0L, "", "", "", "", 0, 0, null, Boolean.FALSE, "", 0}, oidb_0xeb5$App.class);
    public final PBStringField appid = PBField.initString("");
    public final PBUInt64Field type = PBField.initUInt64(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBInt32Field redpoint = PBField.initInt32(0);
    public final PBUInt32Field playing_num = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0xeb5$Label> labels = PBField.initRepeatMessage(oidb_0xeb5$Label.class);
    public final PBBoolField ark = PBField.initBool(false);
    public final PBStringField ark_label = PBField.initString("");
    public final PBUInt32Field jump_type = PBField.initUInt32(0);
}
