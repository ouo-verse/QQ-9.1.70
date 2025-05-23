package tencent.im.oidb.cmd0xe83;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.state.mmkv.SKey;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe83$TabInfo extends MessageMicro<oidb_0xe83$TabInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 58, 64}, new String[]{"type", "name", "desc", "url", WidgetCacheConstellationData.NUM, "appid", "pic", SKey.DetailMe.KEY_TITLE_RED_POINT_SP}, new Object[]{0, "", "", "", 0, 0L, "", 0}, oidb_0xe83$TabInfo.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public final PBStringField pic = PBField.initString("");
    public final PBInt32Field red_point = PBField.initInt32(0);
}
